package com.yiyexiaoyuan.formbean;

public class RegisterForm 
{
	private String mobile;
	private String passWord;
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
	public boolean checked ()
	{
		boolean isOk = true;
		if (mobile.length() != 11)
		{
			return isOk = false;
		}
		if (mobile.equals(""))
		{
			return isOk = false;
		}
		return true;
	}
}
