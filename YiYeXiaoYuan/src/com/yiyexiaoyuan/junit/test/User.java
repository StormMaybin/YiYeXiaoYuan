package com.yiyexiaoyuan.junit.test;

public class User 
{
	private String id;
	private String name;
	private String pass;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPass()
	{
		return pass;
	}
	@Override
	public String toString ()
	{
		return id+"---"+name+"---"+pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
}