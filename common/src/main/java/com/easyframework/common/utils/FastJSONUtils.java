package com.easyframework.common.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * <p>fastJSON工具类</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年12月3日 上午10:13:02 </p>
 * <p></p>
 */
public class FastJSONUtils {

	private static final SerializerFeature[] features = { SerializerFeature.WriteNullListAsEmpty, // list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullNumberAsZero, // 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullStringAsEmpty,// 字符类型字段如果为null，输出为""，而不是null
			SerializerFeature.DisableCircularReferenceDetect // 禁止以引用形式输出
	};

	/**
	 * 获取Json格式化数据
	 * 
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object) {

		return JSON.toJSONString(object, features);
	}

	/**
	 * JSON字符串转换成java对象
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(String jsonString, Class<T> clazz) {

		return JSON.parseObject(jsonString, clazz);
	}

	/**
	 * JSON字符串转换成java对象
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> T toObject(String jsonString, TypeReference<T> clazz) {

		return JSON.parseObject(jsonString, clazz);
	}

	/**
	 * 转换JSON集合
	 * 
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> toArray(String jsonString, Class<T> clazz) {

		return JSON.parseArray(jsonString, clazz);
	}

//	public static void main(String[] args) {
//		List<List<User>> lists = Lists.newArrayList();
//		List<User> users = Lists.newArrayList();
//		for (int i = 0; i < 10; i++) {
//			User user = new User();
//			user.setName("billy");
//			users.add(user);
//		}
//		for (int i = 0; i < 10; i++) {
//			lists.add(users);
//		}
//		String result = FastJSONUtils.toJsonString(lists);
//		System.out.println(result);
//
//	}
}
