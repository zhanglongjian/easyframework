package com.easyframework.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>spring日期工具类</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年12月3日 上午10:16:00 </p>
 * <p></p>
 */
public class SpringDataDateUtils {

	private static Logger logger = LoggerFactory.getLogger(SpringDataDateUtils.class);

	/**
	 * 主要用于jqa查询中，字符串转为时间对象,这个是起始时间
	 * 
	 * @param date
	 *            时间字符串 "2010-10-10"
	 * @return 时间对象
	 */
	public static Date parseDateBetweenStart(String date) {
		return parseDateBetweenStart(date, "yyyy-MM-dd");
	}

	/**
	 * 主要用于jqa查询中，字符串转为时间对象,这个是起始时间
	 * 
	 * @param date
	 *            时间字符串 "20101010",可自定义与format匹配
	 * @param format
	 *            "yyyyMMdd"
	 * @return 时间对象
	 */
	public static Date parseDateBetweenStart(String date, String format) {
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		try {
			Date theDate = formatDate.parse(date);
			return theDate;
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 主要用于jqa查询中，字符串转为时间对象,<br>
	 * 这个是结束时间,时间会加一天
	 * 
	 * @param date
	 *            时间字符串 "2010-10-10"
	 * @return 时间对象
	 */
	public static Date parseDateBetweenEnd(String date) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date theDate = formatDate.parse(date);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(theDate);
			calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			theDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			return theDate;
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 主要用于jqa查询中，字符串转为时间对象,<br>
	 * 这个是结束时间,时间会加一天
	 * 
	 * @param date
	 *            时间字符串 "20101010",可自定义与format匹配
	 * @param format
	 *            "yyyyMMdd"
	 * @return 时间对象
	 */
	public static Date parseDateBetweenEnd(String date, String format) {
		SimpleDateFormat formatDate = new SimpleDateFormat(format);
		try {
			Date theDate = formatDate.parse(date);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(theDate);
			calendar.add(Calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
			theDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
			return theDate;
		} catch (ParseException e) {
			logger.error("", e);
			return null;
		}
	}

	/**
	 * 计算两个日期之间相差的天数<br>
	 * 如果返回负数说明第二个日期比第一个日期大
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date date1, Date date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		date1 = sdf.parse(sdf.format(date1));
		date2 = sdf.parse(sdf.format(date2));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time1 - time2) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
     * 获取给定日的最后一刻。.
     *
     * @param when 给定日
     * @return 最后一刻。例如：2006-4-19 23:59:59.999
     */
    public static Date getDayEnd(Date when) {
        Date date = org.apache.commons.lang3.time.DateUtils.truncate(when, Calendar.DATE);
        date = org.apache.commons.lang3.time.DateUtils.addDays(date, 1);
        date.setTime(date.getTime() - 1);
        return date;
    }
}
