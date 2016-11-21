package com.yiyexiaoyuan.utils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.sun.org.apache.commons.beanutils.Converter;

public class WebUtils 
{
	public static <T> T request2Bean (HttpServletRequest request, Class<T> beanClass)
	{
		//创建要封装的bean
		T bean = null;
		try
		{
			bean = beanClass.newInstance();
			//request数据封装到bean
			Enumeration e = request.getParameterNames();
			while (e.hasMoreElements())
			{
				String name = (String) e.nextElement();
				String value = request.getParameter(name);
				try
				{
					BeanUtils.setProperty(bean, name, value);
				} 
				catch (InvocationTargetException e1)
				{
					// TODO Auto-generated catch block
					throw new RuntimeException(e1);
				}
			}
		} 
		catch (InstantiationException e)
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
	public static void copyBean (Object src, Object dest)
	{
		//注册转换器
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
				try
				{
					return sdf.parse(string);
				} catch (ParseException e)
				{
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}, Date.class);
		try
		{
			BeanUtils.copyProperties(dest, src);
		}
		catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} catch (InvocationTargetException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
