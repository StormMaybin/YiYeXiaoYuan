package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.UserInfoDao;
import com.yiyexiaoyuan.dao.impl.UserInfoDaoImpl;
import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.service.UserInfoService;

import java.util.ArrayList;
/**
 * 购票服务类
 * @author StormMaybin
 *
 */
public class UserInfoServiceImpl implements UserInfoService
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
	/**
	 * 查询所有的购买大巴信息
	 * @author StormMaybin
	 * @return ArrayList
	 * @param uId
	 */
	public ArrayList<UserInfo> queryUserInfoService (int uId)
	{
		ArrayList<UserInfo> list = null;
		UserInfoDao udao = new UserInfoDaoImpl();
		list = udao.queryUserInfo(uId);
		return list;
	}
}