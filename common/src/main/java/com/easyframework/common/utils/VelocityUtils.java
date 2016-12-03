package com.easyframework.common.utils;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;


/**
 * <p>Velocity模板工具类</p>
 * <p> @author zhang longjian</p>
 * <p> @createTime 2016年12月3日 上午10:16:37 </p>
 * <p></p>
 */
public abstract class VelocityUtils {

	static {
		Velocity.init();
	}

	/**
	 * 渲染模板内容.
	 * 
	 * @param templateContent
	 *            模板内容.
	 * @param context
	 *            变量Map.
	 * @return the string
	 */
	public static String renderTemplateContent(String templateContent, Map<String, ?> context) {
		VelocityContext velocityContext = new VelocityContext(context);
		StringWriter result = new StringWriter();
		Velocity.evaluate(velocityContext, result, "", templateContent);
		return result.toString();
	}

	/**
	 * 渲染模板文件.
	 * 
	 * @param templateFilePName
	 *            the template file p name
	 * @param velocityEngine
	 *            velocityEngine, 需经过VelocityEngineFactory处理,
	 *            绑定Spring的ResourceLoader.
	 * @param encoding
	 *            the encoding
	 * @param context
	 *            变量Map.
	 * @return the string
	 */
	public static String renderFile(String templateFilePName, VelocityEngine velocityEngine, String encoding, Map<String, ?> context) {
		VelocityContext velocityContext = new VelocityContext(context);

		StringWriter result = new StringWriter();
		velocityEngine.mergeTemplate(templateFilePName, encoding, velocityContext, result);
		return result.toString();
	}
}
