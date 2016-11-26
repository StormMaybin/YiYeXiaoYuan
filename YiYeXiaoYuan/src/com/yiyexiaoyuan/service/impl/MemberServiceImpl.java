package com.yiyexiaoyuan.service.impl;

import java.util.ArrayList;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.dao.impl.MemberDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.service.MemberService;

public class MemberServiceImpl implements MemberService
{
	/**
	 * 为web层提供取消行程的信息
	 * @author StormMaybin
	 * @param uId
	 * @param iId
	 * @return
	 */
	public boolean removeMemberService (int uId, int iId)
	{
		//创建dao层对象
		MemberDao mdao = new MemberDaoImpl();
		
		//开始调用dao层逻辑
		boolean result = mdao.removeMember(uId, iId);
		
		return result;
	}
	/**
	 * 根据拼车信息id拿到所有的联系方式
	 * @author StormMaybin
	 * @return ArrayList
	 * @param iId
	 */
	public ArrayList<User> queryUserService (int iId)
	{
		
		MemberDao mdao = null;
		//创建dao层对象
		mdao = new MemberDaoImpl();
		
		ArrayList<User> list = null;
		
		list = mdao.queryUser(iId);
		
		return list;
	}
}	
