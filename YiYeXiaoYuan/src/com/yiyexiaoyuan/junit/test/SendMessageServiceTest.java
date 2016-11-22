package com.yiyexiaoyuan.junit.test;

import com.yiyexiaoyuan.service.impl.SendMessageService;
import org.junit.Test;

public class SendMessageServiceTest
{
	@Test
	public void sendMessageTest()
	{
		SendMessageService s = new SendMessageService();
		String code = s.sendMessage("18292817803");
		System.out.println(code);
	}
}