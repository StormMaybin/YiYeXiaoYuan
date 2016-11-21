package com.yiyexiaoyuan.domain;

public class Member
{
	//发起人的Id
	private int main_id;
	//成员1的id
	private int id1;
	//成员2的id
	private int id2;
	//成员3的id
	private int id3;
	//成员4的id
	private int id4;
	//成员5的id
	private int id5;
	public int getMain_id()
	{
		return main_id;
	}
	public void setMain_id(int main_id)
	{
		this.main_id = main_id;
	}
	public int getId1()
	{
		return id1;
	}
	public void setId1(int id1)
	{
		this.id1 = id1;
	}
	public int getId2()
	{
		return id2;
	}
	public void setId2(int id2)
	{
		this.id2 = id2;
	}
	public int getId3()
	{
		return id3;
	}
	public void setId3(int id3)
	{
		this.id3 = id3;
	}
	public int getId4()
	{
		return id4;
	}
	public void setId4(int id4)
	{
		this.id4 = id4;
	}
	public int getId5()
	{
		return id5;
	}
	public void setId5(int id5)
	{
		this.id5 = id5;
	}
	@Override
	public String toString()
	{
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("发起人id："+main_id);
		sb.append("  成员1id："+id1);
		sb.append("  成员2id："+id2);
		sb.append("  成员3id："+id3);
		sb.append("  成员4id："+id4);
		sb.append("  成员5id："+id5);
		return sb.toString();
	}
}
