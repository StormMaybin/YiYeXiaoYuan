package com.yiyexiaoyuan.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
}
