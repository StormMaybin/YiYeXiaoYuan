package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.UserInfoDao;
import com.yiyexiaoyuan.dao.impl.UserInfoDaoImpl;
import com.yiyexiaoyuan.domain.UserInfo;
import java.util.ArrayList;
/**
 * 购票服务类
 * @author StormMaybin
 *
 */
public class UserInfoService
{
	/**
	 * 为web层添加一条购票信息
	 * @param ui
	 * @return boolean
	 */
	public boolean addService(UserInfo ui)
	{
		//调用dao
		UserInfoDao userInfoDao = new UserInfoDaoImpl();

		//标记结果
		boolean result = userInfoDao.add(ui);
		return result;
	}
	/**
	 * 为web层提供查询所有购票信息的服务
	 * @return ArrayList<UserInfo>
	 */
	public ArrayList<UserInfo> queryUserInfoService()
	{
		ArrayList<UserInfo> list = null;
		UserInfoDao userInfoDao = new UserInfoDaoImpl();

		list = userInfoDao.queryUserInfo();
		return list;
	}
}