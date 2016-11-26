package com.yiyexiaoyuan.service.impl;

import java.util.ArrayList;
import java.util.Date;

import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.dao.impl.InformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.InformationService;

public class InformationServiceImpl implements InformationService
{
	/**
	 * 为Web层提供添加行程的服务
	 * 
	 * @author StormMaybin
	 * @return void
	 * @param i
	 */
	public boolean addInformationService(Information i)
	{
		InformationDao informationDao = new InformationDaoImpl();
		// 保存校验错误消息
		// Map<String, String> errors = null;

		// 数据不用校验
		return informationDao.add(i);
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
	
	/**
	 * 为Web层提供按照开始日期查询所有拼车信息的服务
	 * @author StormMaybin
	 * @param Date
	 * @return ArrayList
	 */
	public ArrayList<Information> queryByStartDateService(Date startDate)
	{
		// 创建集合
		ArrayList<Information> list = null;
		// 创建业务逻辑对象
		InformationDao informationDao = new InformationDaoImpl();

		// 调用业务逻辑层的方法
		list = informationDao.queryByStartDate(startDate);

		return list;
	}
}
