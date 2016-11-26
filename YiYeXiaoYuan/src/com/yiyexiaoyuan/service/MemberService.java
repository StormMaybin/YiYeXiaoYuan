package com.yiyexiaoyuan.service;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.User;

public interface MemberService
{

	/**
	 * 为web层提供取消行程的信息
	 * @author StormMaybin
	 * @param uId
	 * @param iId
	 * @return
	 */
	public abstract boolean removeMemberService(int uId, int iId);

	/**
	 * 根据拼车信息id拿到所有的联系方式
	 * @author StormMaybin
	 * @return ArrayList
	 * @param iId
	 */
	public abstract ArrayList<User> queryUserService(int iId);

}