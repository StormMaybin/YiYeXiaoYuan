package com.yiyexiaoyuan.formbean;
/***
 * 为 登录提供一个formBean进行数据封装
 * @author StormMaybin
 *
 */
public class LoginForm
{
	private String mobile;
	private String passWord;
	private String checkCode;
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getPassWord()
	{
		return passWord;
	}
	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}
	public String getCheckCode()
	{
		return checkCode;
	}
	public void setCheckCode(String checkCode)
	{
		this.checkCode = checkCode;
	}
}
