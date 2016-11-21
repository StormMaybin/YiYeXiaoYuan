package com.yiyexiaoyuan.dao;

import java.util.ArrayList;
import java.util.Date;

import com.yiyexiaoyuan.domain.Information;

public interface InformationDao
{
	
	/**
	 * 添加行程
	 * @author StormMaybin
	 * @return void
	 * @param i
	 */
	public abstract void add(Information i);
	
	/**
	 * 根据用户id查找行程信息
	 * @author StormMaybin
	 * @param uid
	 * @return Information
	 */
	public abstract Information findByUid(int uid);
	
	/**
	 * 查询所有的行程信息到集合中去
	 * @author StormMaybin
	 * @param void
	 * @return ArrayList<Information>
	 */
	public abstract ArrayList<Information> queryInformation();
	
	/**
	 * 根据拼车信息id查找行程
	 * @author StormMaybin
	 * @return Information
	 * @param id
	 */
	public abstract Information findById(int id);
	
	/**
	 * 根据发布时间查找拼车信息
	 * @author StormMaybin
	 * @param pubTime
	 * @return ArrayList<Information>
	 */
	public abstract ArrayList<Information> queryByPubTime(Date pubTime);
	
	/**
	 * 查询拼车信息的Id
	 * @author StormMaybin
	 * @param
	 * @return Information
	 */
	public abstract Information findId(Information i);
	/**
	 * 根据拼车信息的id查询到拼车信息对象
	 * @author StormMaybin
	 * @param id
	 * @return Information
	 */
	public abstract Information queryInformationById (int id);
	
}