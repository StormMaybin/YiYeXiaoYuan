package com.yiyexiaoyuan.domain;

public class User 
{
	//用户id
	private int id;
	//用户qq
	private String qq;
	//用户用户名
	private String userName;
	//用户密码
	private String passWord;
	//用户手机号  账号
	private String mobile;
	//获得的好评数
	private int goodApprise;
	//获得的差评数
	private int badApprise;
	//修改用户名次数
	private int passWordCount;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassWord() 
	{
		return passWord;
	}
	public void setPassWord(String passWord) 
	{
		this.passWord = passWord;
	}
	public String getMobile() 
	{
		return mobile;
	}
	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}
	public int getGoodApprise() {
		return goodApprise;
	}
	public void setGoodApprise(int goodApprise)
	{
		this.goodApprise = goodApprise;
	}
	public int getBadApprise() 
	{
		return badApprise;
	}
	public void setBadApprise(int badApprise) 
	{
		this.badApprise = badApprise;
	}
	public int getPassWordCount()
	{
		return passWordCount;
	}
	public void setPassWordCount(int passWordCount)
	{
		this.passWordCount = passWordCount;
	}
	
	@Override
	public String toString() 
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("用户id："+id);
		stringBuilder.append("\r\n");	
		stringBuilder.append("用户名："+userName);
		stringBuilder.append("\r\n");
		stringBuilder.append("密码："+passWord);
		stringBuilder.append("\r\n");
		stringBuilder.append("是否还可以修改用户名："+passWordCount);
		stringBuilder.append("\r\n");
		stringBuilder.append("goodApprise："+goodApprise);
		stringBuilder.append("\r\n");
		stringBuilder.append("badApprise："+badApprise);
		stringBuilder.append("\r\n");
		stringBuilder.append("qq："+qq);
		stringBuilder.append("\r\n");
		return stringBuilder.toString();
	}
}
