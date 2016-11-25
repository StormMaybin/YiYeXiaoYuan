package com.yiyexiaoyuan.formbean;

public class TrueLoveForm
{
	private String id;
	private String name;
	private String address;
	private String amount;
	private String startDate;
	private String startTime;
	private String arrive;
	private String mobile;
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
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getAmount()
	{
		return amount;
	}
	public void setAmount(String amount)
	{
		this.amount = amount;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
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
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		return "id: "+id +"\r\n"
				+"name: "+name+"\r\n"
				+"address: "+address+"\r\n"
				+"amount: "+amount+"\r\n"
				+"startDate: "+startDate+"\r\n"
				+"startTime: "+startTime+"\r\n"
				+"arrive: "+arrive+"\r\n"
				+"mobile: "+mobile+"\r\n";
	}
	
	
}
