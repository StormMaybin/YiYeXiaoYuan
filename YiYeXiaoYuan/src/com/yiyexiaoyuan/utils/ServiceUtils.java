package com.yiyexiaoyuan.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import sun.misc.BASE64Encoder;

public class ServiceUtils 
{
	public static String md5 (String passWord)
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte [] md5 = md.digest(passWord.getBytes());
			
			BASE64Encoder encode = new BASE64Encoder();
			
			return encode.encode(md5);
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	private static JsonConfig getJsonConfig()
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
