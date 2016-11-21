package com.yiyexiaoyuan.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.dao.impl.InformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;

public class InformationService
{
	/**
	 * 为Web层提供添加行程的服务
	 * 
	 * @author StormMaybin
	 * @return void
	 * @param i
	 */
	public Map<String, String> addInformationService(Information i)
	{
		InformationDao informationDao = new InformationDaoImpl();
		// 保存校验错误消息
		Map<String, String> errors = null;
		// 校验数据
		boolean isOk = true;
		// 开始地点和到达地点不能相同
		if (i.getStartPos() == i.getArrivePos())
		{
			errors = new LinkedHashMap<String, String>();
			isOk = false;
			errors.put("pos", "开始地点和到达地点不能相同");
			return errors;
		}
		if (i.getStartTime_max_hour() < i.getStartTime_min_hour())
		{
			errors = new LinkedHashMap<String, String>();
			isOk = false;
			errors.put("startTime", "上限时间不能小于下限时间");
			return errors;
		}
		if (i.getStartTime_max_hour() == i.getStartTime_min_hour())
		{
			if (i.getStartTime_max_min() < i.getStartTime_min_min())
			{
				errors = new LinkedHashMap<String, String>();
				isOk = false;
				errors.put("startTime", "上限时间不能小于下限时间");
				return errors;
			}
		}
		if (i.getMaxMember() > 6 || i.getMaxMember() <= 0)
		{
			errors = new LinkedHashMap<String, String>();
			isOk = false;
			errors.put("maxMember", "最大人数不能大于6人，并且不能少于1人");
			return errors;
		}
		if (i.getCurtMember() > 6 || i.getCurtMember() <= 0)
		{
			errors = new LinkedHashMap<String, String>();
			isOk = false;
			errors.put("curtMember", "已有人数不能大于6人，并且不能少于1人");
			return errors;
		}
		if (isOk)
		{
			informationDao.add(i);
		}
		return errors;
	}
	
	/**
	 * 为Web层提供查询所有拼车信息的服务
	 * 
	 * @author StormMaybin
	 * @param void
	 * @return ArrayList
	 */
	public ArrayList<Information> queryInformationService()
	{
		// 创建集合
		ArrayList<Information> list = null;
		// 创建业务逻辑对象
		InformationDao informationDao = new InformationDaoImpl();
		// 调用业务逻辑层的方法
		list = informationDao.queryInformation();
		return list;
	}
	
	/**
	 * 为Web层提供按照发布日期查询所有拼车信息的服务
	 * @author StormMaybin
	 * @param Date
	 * @return ArrayList
	 */
	public ArrayList<Information> queryByPubTimeService(Date pubTime)
	{
		// 创建集合
		ArrayList<Information> list = null;
		// 创建业务逻辑对象
		InformationDao informationDao = new InformationDaoImpl();
		
		// 调用业务逻辑层的方法
		list = informationDao.queryByPubTime(pubTime);
		
		return list;
	}
}
