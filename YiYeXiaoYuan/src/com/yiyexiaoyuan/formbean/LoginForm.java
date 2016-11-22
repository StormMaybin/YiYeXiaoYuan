package com.yiyexiaoyuan.formbean;

/***
 * 为 登录提供一个formBean进行数据封装
 * 
 * @author StormMaybin
 * 
 */
public class LoginForm
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
	@Override
	public String toString()
	{
		return "mobile: " + this.mobile + "---" + "passWord: " + this.passWord;
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
