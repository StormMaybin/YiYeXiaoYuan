package com.yiyexiaoyuan.service;

import java.util.ArrayList;
import java.util.Date;

import com.yiyexiaoyuan.domain.Information;

public interface InformationService
{

	/**
	 * 为Web层提供添加行程的服务
	 * 
	 * @author StormMaybin
	 * @return void
	 * @param i
	 */
	public abstract boolean addInformationService(Information i);

	/**
	 * 为Web层提供查询所有拼车信息的服务
	 * 
	 * @author StormMaybin
	 * @param void
	 * @return ArrayList
	 */
	public abstract ArrayList<Information> queryInformationService();

	/**
	 * 为Web层提供按照发布日期查询所有拼车信息的服务
	 * @author StormMaybin
	 * @param Date
	 * @return ArrayList
	 */
	public abstract ArrayList<Information> queryByPubTimeService(Date pubTime);
	
	/**
	 * 为Web层提供按照开始日期查询所有拼车信息的服务
	 * @author StormMaybin
	 * @param Date
	 * @return ArrayList
	 */
	public abstract ArrayList<Information> queryByStartDateService(Date startDate);

}