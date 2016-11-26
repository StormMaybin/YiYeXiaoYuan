package com.yiyexiaoyuan.service;

public interface SendMessageService
{

	/**
	 * 为web层提供发送短信验证码的服务
	 * @param mobile
	 * @return code
	 */
	public abstract String sendMessage(String mobile);

}