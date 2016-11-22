package com.yiyexiaoyuan.domain;

public class Member
{
	//拼车信息id
	private int main_id;
	//成员1id
	private int id1;
	//成员2id
	private int id2;
	//成员3id
	private int id3;
	//成员4id
	private int id4;
	//成员5id
	private int id5;
	//成员5id
	private int id6;

	public int getMain_id()
	{
		return this.main_id;
	}

	public void setMain_id(int main_id)
	{
		this.main_id = main_id;
	}

	public int getId1()
	{
		return this.id1;
	}

	public void setId1(int id1)
	{
		this.id1 = id1;
	}

	public int getId2()
	{
		return this.id2;
	}

	public void setId2(int id2)
	{
		this.id2 = id2;
	}

	public int getId3()
	{
		return this.id3;
	}

	public void setId3(int id3)
	{
		this.id3 = id3;
	}

	public int getId4()
	{
		return this.id4;
	}

	public void setId4(int id4)
	{
		this.id4 = id4;
	}

	public int getId5()
	{
		return this.id5;
	}

	public void setId5(int id5)
	{
		this.id5 = id5;
	}

	public int getId6()
	{
		return this.id6;
	}

	public void setId6(int id6)
	{
		this.id6 = id6;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("拼车信息id：" + this.main_id);
		sb.append("  成员1id：" + this.id1);
		sb.append("  成员2id：" + this.id2);
		sb.append("  成员3id：" + this.id3);
		sb.append("  成员4id：" + this.id4);
		sb.append("  成员5id：" + this.id5);
		sb.append("  成员6id：" + this.id6);
		return sb.toString();
	}
}