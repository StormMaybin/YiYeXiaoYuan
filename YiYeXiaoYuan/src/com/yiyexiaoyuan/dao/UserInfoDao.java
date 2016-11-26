package com.yiyexiaoyuan.dao;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.UserInfo;

public interface UserInfoDao
{

	/**
	 * 添加购票信息
	 * @author StormMaybin
	 * @param ui
	 * @return boolean
	 * 添加成功为true 反之为false
	 */
	public abstract boolean add(UserInfo ui);

	/**
	 * 查询所有的购票信息
	 * @author StormMaybin
	 * @param
	 * @return ArrayList
	 */
	public abstract ArrayList<UserInfo> queryUserInfo();
	
	/**
	 * 根据用户id查找购票信息
	 * @author StormMaybin
	 * @param iId
	 * @return
	 */
	public abstract ArrayList<UserInfo> queryUserInfo (int uId);

}