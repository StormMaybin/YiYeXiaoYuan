package com.yiyexiaoyuan.domain;

import java.util.Date;


public class UserInfo
{
	//用户id
	private int id;
	//用户姓名
	private String name;
	//用户地址
	private String address;
	//用户购买票数
	private int amount;
	//出发日期
	private java.util.Date startDate;
	//出发时间
	private String startTime;
	//到达目的地
	private String arrive;
	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return this.address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}
	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public java.util.Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(java.util.Date startDate)
	{
		this.startDate = startDate;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	
	public String getArrive()
	{
		return arrive;
	}

	public void setArrive(String arrive)
	{
		this.arrive = arrive;
	}

	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		string.append("id: "+id);
		string.append("\r\n");
		string.append("name: "+name);
		string.append("\r\n");
		string.append("address: "+address);
		string.append("\r\n");
		string.append("amount: "+amount);
		string.append("\r\n");
		string.append("startDate: "+startDate);
		string.append("\r\n");
		string.append("startTime: "+startTime);
		string.append("\r\n");
		string.append("arrive: "+arrive);
		string.append("\r\n");
		return string.toString();
	}
}