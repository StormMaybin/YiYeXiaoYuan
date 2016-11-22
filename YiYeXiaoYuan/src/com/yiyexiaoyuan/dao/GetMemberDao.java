package com.yiyexiaoyuan.dao;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.User;

public interface GetMemberDao
{

	/**
	 * 根据拼车信息id获得除过uId所有成员的信息
	 * @author StormMaybin
	 * @param iId拼车信息id
	 * @param uId用户id
	 * @return
	 */
	public abstract ArrayList<User> getMember(int iId, int uId);

}