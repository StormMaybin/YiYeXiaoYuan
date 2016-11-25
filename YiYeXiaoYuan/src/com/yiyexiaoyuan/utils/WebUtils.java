package com.yiyexiaoyuan.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;


public class WebUtils
{
	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass)
	{

		T bean = null;
		try
		{
			Enumeration e = request.getParameterNames();
			// 创建要封装的bean
			bean = beanClass.newInstance();
			while (e.hasMoreElements())
			{
				System.out.println("循环");
				// request数据封装到bean
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				try
				{
					BeanUtils.setProperty(bean, name, value);
				} catch (InvocationTargetException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
			}
		} catch (InstantiationException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} catch (IllegalAccessException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		return bean;
	}

	/**
	 * 拷贝bean
	 * 
	 * @author StormMaybin
	 * @param src
	 * @param dest
	 */
	public static void copyBean(Object src, Object dest)
	{
		try
		{
			// 注册转换器
			ConvertUtils.register(new Converter()
			{

				public Object convert(Class type, Object value)
				{
					if (value == null)
					{
						return null;
					}
					String string = (String) value;
					if (string.trim().equals(""))
					{
						return null;
					}

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					System.out.println("kdddjdj");
					try
					{
						return sdf.parse(string);
					} 
					catch (ParseException e)
					{
						// TODO Auto-generated catch block
						System.out.println("转换异常");
					}
					return null;
				}
			}, java.util.Date.class);
			BeanUtils.copyProperties(dest, src);
		} 
		
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获得JsonConfig对象
	 * 
	 * @author StormMaybin
	 * @param
	 * @return
	 */
	public static JsonConfig getJsonConfig()
	{
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new JsonValueProcessor()
				{
					private SimpleDateFormat sd = new SimpleDateFormat(
							"yyyy-MM-dd");

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig)
					{
						return value == null ? "" : sd.format(value);
					}

					public Object processArrayValue(Object value,
							JsonConfig jsonConfig)
					{
						return null;
					}
				});
		return jsonConfig;
	}

}