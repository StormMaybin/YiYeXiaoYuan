package com.yiyexiaoyuan.junit.test;

import com.chuanglan.port.HttpSender;

public class HttpSenderTest
{
	public static void main(String[] args)
	{
		
		String url = "http://sms.253.com/msg/";// 应用地址
		String un = "N2969820";// 账号
		String pw = "XzWglqmbL5e854";// 密码
		String phone = "18811516128";// 手机号码，多个号码使用","分割
		String msg = "【StormMa】我的小天使，晚上记得吃饭打热水。Love You Forever.";// 短信内容
		String rd = 1 + "";// 是否需要状态报告，需要1，不需要0
		String ex = null;// 扩展码
		
		 
		try
		{
			String returnString = HttpSender.batchSend(url, un, pw, phone, msg,
					rd, ex);
			System.out.println(returnString);
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e)
		{
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}