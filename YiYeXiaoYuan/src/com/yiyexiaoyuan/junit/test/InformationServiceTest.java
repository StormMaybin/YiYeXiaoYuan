package com.yiyexiaoyuan.junit.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;

public class InformationServiceTest
{
	// 添加行程服务测试
	@Test
	public void addInformationServiceTest() throws ParseException
	{
		Information i = new Information();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 设置属性值
		i.setUid(3);
		i.setStartDate(sdf.parse("2016-11-13"));
		i.setStartPos("钟楼站");
		i.setArrivePos("火车站");
		i.setStartTime_min_hour(13+"");
		i.setStartTime_min_min(30+"");
		i.setStartTime_max_hour(14+"");
		i.setStartTime_max_min(30+"");
		i.setMaxMember(5);
		i.setCurtMember(4);
		i.setMessage("只要妹子哈哈哈 。。。。");
		i.setPubTime(new Date());
		
		InformationService service = new InformationService();
		boolean result = service.addInformationService(i);
		if (result)
		{
			System.out.println("行程添加成功");
		} 
		else
		{
			 System.out.println("行程添加失败");
		}
	}
	//按照发布时间获取拼车信息
	@Test
	public void queryByPubTimeServiceTest () throws ParseException
	{
		ArrayList<Information> list = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		InformationService service = new InformationService();
		
		list = service.queryByPubTimeService(sdf.parse("2016-11-13"));
		
		if (list != null)
		{
			for (Information i : list)
			{
				System.out.println(i.toString());
				System.out.println();
			}
		}
		else 
		{
			System.out.println("没有此时间发布的拼车信息");
		}
	}
	//获取所有的拼车信息
	@Test
	public void queryInformationServiceTest ()
	{
		ArrayList<Information> list = null;
		InformationService service = new InformationService();
		
		list = service.queryInformationService();
		
		if (list != null)
		{
			for (Information i : list)
			{
				System.out.println(i.toString());
				System.out.println();
			}
		}
		else
		{
			System.out.println("没有拼车信息");
		}
	}
}
