package com.yiyexiaoyuan.junit.test;

import java.util.ArrayList;

import org.junit.Test;

import com.yiyexiaoyuan.dao.MyInformationDao;
import com.yiyexiaoyuan.dao.impl.MyInformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;

public class MyInformationDaoTest
{
	@Test
	public void queryMyInformationTest()
	{
		MyInformationDao dao = new MyInformationDaoImpl();
		
		ArrayList<Information> list = null;
		
		list = dao.queryMyInformation(1);
		
		for (Information i : list)
		{
			System.out.println(i);
		}
	}
}
