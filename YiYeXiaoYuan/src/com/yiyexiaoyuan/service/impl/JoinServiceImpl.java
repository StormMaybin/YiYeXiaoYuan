package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.dao.impl.MemberDaoImpl;
import com.yiyexiaoyuan.service.JoinService;

public class JoinServiceImpl implements JoinService
{
	/**
	 * 为web层提供报名服务
	 * @author StormMaybin
	 * @return boolean
	 * @param iId, uId
	 */
	public boolean signUpInformationService(int iId, int uId)
	{
		//调用dao层逻辑
		MemberDao mdao = new MemberDaoImpl();
		//是否添加成功
		boolean result = mdao.addMember(iId, uId);

		return result;
	}
}