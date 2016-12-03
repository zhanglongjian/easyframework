
package com.easyframework.common.utils;

import org.springframework.context.MessageSource;


/**
 * <p>消息工具</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年10月11日 上午9:58:50 </p>
 * <p></p>
 */
public class MessageUtils {

    private static MessageSource messageSource;

    /**
     * 根据消息键和参数 获取消息
     * 委托给spring messageSource
     *
     * @param code 消息键
     * @param args 参数
     * @return
     */
    public static String message(String code, Object... args) {
        if (messageSource == null) {
            messageSource = SpringUtils.getBean(MessageSource.class);
        }
        return messageSource.getMessage(code, args, null);
    }

}
