package com.yiyexiaoyuan.service.impl;

import com.chuanglan.port.HttpSender;
import com.yiyexiaoyuan.service.SendMessageService;

import java.util.Random;
/**
 * 发送短信验证码服务
 * @author StormMaybin
 */
public class SendMessageServiceImpl implements SendMessageService
{
	/**
	 * 为web层提供发送短信验证码的服务
	 * @param mobile
	 * @return code
	 */
	public String sendMessage(String mobile)
	{
		//随机生成验证码
		String code = getRandNum(6);
		String url = "http://sms.253.com/msg/";
		String un = "N2969820";
		String pw = "XzWglqmbL5e854";
		String phone = mobile;
		String msg = "【StormMa】您的验证码是：" + code + "，打死也不告诉别人哦！";
		String rd = "1";
		String ex = null;
		try
		{
			String returnString = HttpSender.batchSend(url, un, pw, phone, msg,
					rd, ex);
			System.out.println(returnString);
//			String[] str;
//			str = returnString.split(",");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(code);
		return code;
	}

	public static String getRandNum(int charCount)
	{
		String charValue = "";
		for (int i = 0; i < charCount; i++)
		{
			char c = (char) (randomInt(0, 10) + 48);
			charValue = charValue + String.valueOf(c);
		}
		return charValue;
	}

	public static int randomInt(int from, int to)
	{
		Random r = new Random();
		return from + r.nextInt(to - from);
	}
}