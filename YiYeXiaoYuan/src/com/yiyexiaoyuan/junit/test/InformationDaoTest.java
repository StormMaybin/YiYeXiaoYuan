package com.yiyexiaoyuan.junit.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.junit.Test;

import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.dao.impl.InformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;

public class InformationDaoTest
{
	//根据
	@Test
	public void FindId() throws ParseException
	{
		InformationDao idao = new InformationDaoImpl();
		
		Information i = new Information();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		i.setUid(1);
		i.setStartDate(sdf.parse("2016-11-08"));
		i.setStartPos("西电南校区");
		i.setArrivePos("火车站");
		i.setStartTime_min_hour(0);
		i.setStartTime_max_min(0);
		i.setStartTime_max_hour(23);
		i.setStartTime_min_min(59);
		i.setMaxMember(6);
		i.setCurtMember(3);
		i.setMessage("我人很准时");
		i.setPubTime(sdf.parse("2016-11-08"));
		Information info = idao.findId(i);
		if (info != null)
		{
			System.out.println(info.getId());
		}
	}
	//添加行程测试
	@Test
	public void addTest () throws ParseException 
	{
		Information i =  new Information();
		InformationDao idao = new InformationDaoImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		i.setUid(3);
		i.setStartDate(sdf.parse("2016-11-13"));
		i.setStartPos("西电北校区");
		i.setArrivePos("西电北校区");
		i.setStartTime_min_hour(18);
		i.setStartTime_min_min(00);
		i.setStartTime_max_hour(19);
		i.setStartTime_max_min(00);
		i.setMaxMember(6);
		i.setCurtMember(4);
		i.setMessage("行李有点多");
		i.setPubTime(sdf.parse("2016-11-13"));
		idao.add(i);
	}
	//根据用户id查找行程
	@Test
	public void findByUidTest()
	{
		InformationDao idao = new InformationDaoImpl();
		Information i = null;
		
		i = idao.findByUid(3);
		if (i != null)
		{
			System.out.println(i.toString());
		}
	}
	//查询所有的拼车信息查询测试
	@Test
	public void queryInformationTest ()
	{
		InformationDao idao = new InformationDaoImpl();
		ArrayList<Information> list = null;
		
		list = idao.queryInformation();
		if (list != null)
		{
			for (Information i : list)
			{
				System.out.println(i.toString());
				System.out.println();
				System.out.println();
			}
		}
	}
	//根据拼车信息id查询测试
	@Test
	public void findByIdTest ()
	{
		InformationDao idao = new InformationDaoImpl();
		Information i = null;
		
		i = idao.queryInformationById(1);
		
		if (i != null)
		{
			System.out.println(i.toString());
		}
	}
	//根据发布日期查询拼车信息测试
	@Test
	public void queryByPubTimeTest () throws ParseException
	{
		InformationDao idao = new InformationDaoImpl();
		ArrayList<Information> list = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		list = idao.queryByPubTime(sdf.parse("2016-11-08"));
		
		if (list != null)
		{
			for (Information i : list)
			{
				System.out.println(i.toString());
				System.out.println();
				System.out.println();
			}
		}
	}
	//查询拼车信息的id
	@Test
	public void findIdTest () throws ParseException
	{
		InformationDao idao = new InformationDaoImpl();
		Information i = new Information();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		i.setUid(1);
		i.setStartDate(sdf.parse("2016-11-08"));
		i.setStartPos("西电南校区");
		i.setArrivePos("火车站");
		i.setStartTime_min_hour(00);
		i.setStartTime_min_min(00);
		i.setStartTime_max_hour(23);
		i.setStartTime_max_min(59);
		i.setMaxMember(6);
		i.setCurtMember(3);
		i.setMessage("我人很准时");
		i.setPubTime(sdf.parse("2016-11-08"));
		
		Information inf = idao.findId(i);
		if (inf != null)
		{
			System.out.println(inf.toString());
		}
	}
	//根据拼车信息的id查询拼车信息
	@Test
	public void queryInformationByIdTest ()
	{
		InformationDao idao = new InformationDaoImpl();
		Information i = null;
		
		i = idao.queryInformationById(1);
		System.out.println(i.toString());
	}
}
