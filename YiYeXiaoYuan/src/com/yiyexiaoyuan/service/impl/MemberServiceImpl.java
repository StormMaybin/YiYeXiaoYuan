package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.dao.impl.MemberDaoImpl;

public class MemberServiceImpl
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
}	
