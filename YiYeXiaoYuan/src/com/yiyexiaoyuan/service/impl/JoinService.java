package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.dao.impl.MemberDaoImpl;

public class JoinService
{
	public boolean signUpInformationService(int iId, int uId)
	{
		MemberDao mdao = new MemberDaoImpl();
		boolean result = mdao.addMember(iId, uId);

		return result;
	}
}