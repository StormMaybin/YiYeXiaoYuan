package com.yiyexiaoyuan.formbean;

public class RegisterForm 
{
	private String mobile;
	private String checkCode;
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getCheckCode()
	{
		return checkCode;
	}
	public void setCheckCode(String checkCode)
	{
		this.checkCode = checkCode;
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
