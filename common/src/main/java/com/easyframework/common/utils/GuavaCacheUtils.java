package com.easyframework.common.utils;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;

/**
 * Guava 本地缓存 工具类
 * 
 * @author zhang longjian 2016年3月14日
 * 
 */
public class GuavaCacheUtils {
	/** 缓存名称 */
	private String name = "api.jcbzw315.com";
	/** 最大缓存数量 */
	private Integer maximumSize;
	/** guava cache客户端 */
	private com.google.common.cache.Cache<Object, Object> guavaCacheClient = null;;

	/**
	 * 创建对象
	 * 
	 * @param expiredDuration
	 *            缓存时长，单位 :秒
	 * @return
	 * @author nibili 2016年3月12日
	 */
	public static GuavaCacheUtils newInstance(int expiredDuration) {
		return new GuavaCacheUtils(expiredDuration);
	}

	/**
	 * 
	 * @param expiredDuration
	 *            缓存时长，单位 :秒
	 */
	public GuavaCacheUtils(int expiredDuration) {
		if (this.guavaCacheClient == null) {
			CacheBuilder<Object, Object> cacheBuilder = CacheBuilder.newBuilder();
			if (this.maximumSize != null) {
				// 最多缓存数量
				cacheBuilder = cacheBuilder.maximumSize(this.maximumSize);
			}
			// // 自首次写入后，默认缓存1小时
			cacheBuilder = cacheBuilder.expireAfterWrite(expiredDuration, TimeUnit.SECONDS);
			this.guavaCacheClient = cacheBuilder.build();
		}
	}

	/**
	 * 放入缓存
	 * 
	 * @param key
	 * @param value
	 * @author nibili 2016年3月12日
	 */
	public void put(Object key, Object value) {
		this.guavaCacheClient.put(getCacheKey(key), value);
	}

	/**
	 * 清除缓存
	 * 
	 * @param key
	 * @author nibili 2016年9月1日
	 */
	public void remove(Object key) {
		this.guavaCacheClient.invalidate(getCacheKey(key));
	}

	/**
	 * 清除所有缓存
	 * 
	 * @author nibili 2016年9月1日
	 */
	public void removeAll() {
		this.guavaCacheClient.invalidateAll();
	}

	/**
	 * 获取缓存
	 * 
	 * @param key
	 * @param type
	 * @return
	 * @author nibili 2016年3月12日
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Object key, Class<T> type) {
		Object value = guavaCacheClient.getIfPresent(getCacheKey(key));
		return (T) value;
	}

	/**
	 * 存入到缓存的key，由缓存的区域+key对象值串接而成
	 * 
	 * @param key
	 *            key对象
	 * @return
	 */
	private String getCacheKey(Object key) {
		return this.name + key.toString();
	}

	public static void main(String[] args) {
		String name = "name";
		GuavaCacheUtils guavaCacheUtils = GuavaCacheUtils.newInstance(1000000);
		guavaCacheUtils.put(name, "1234");
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		System.out.println(guavaCacheUtils.get(name, String.class));
		guavaCacheUtils.remove(name);
		System.out.println(guavaCacheUtils.get(name, String.class));
	}
}
