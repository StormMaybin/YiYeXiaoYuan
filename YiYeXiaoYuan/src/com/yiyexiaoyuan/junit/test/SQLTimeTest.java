package com.yiyexiaoyuan.junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class SQLTimeTest
{
	@Test
	public void test()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try
		{
			System.out.println(new java.sql.Time(sdf.parse("10:34").getTime()));
			System.out.println(new java.sql.Time(sdf.parse("10:34").getTime()).toString());
		} catch (ParseException e)
		{

			e.printStackTrace();
		}
	}

}
