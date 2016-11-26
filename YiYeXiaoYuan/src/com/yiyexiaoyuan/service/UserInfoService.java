package com.yiyexiaoyuan.service;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.UserInfo;

public interface UserInfoService
{

	/**
	 * 为web层添加一条购票信息
	 * @param ui
	 * @return boolean
	 */
	public abstract boolean addService(UserInfo ui);

	/**
	 * 为web层提供查询所有购票信息的服务
	 * @return ArrayList<UserInfo>
	 */
	public abstract ArrayList<UserInfo> queryUserInfoService();

	/**
	 * 查询所有的购买大巴信息
	 * @author StormMaybin
	 * @return ArrayList
	 * @param uId
	 */
	public abstract ArrayList<UserInfo> queryUserInfoService(int uId);

}