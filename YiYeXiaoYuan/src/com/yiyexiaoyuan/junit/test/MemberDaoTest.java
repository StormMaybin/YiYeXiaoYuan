package com.yiyexiaoyuan.junit.test;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.dao.impl.MemberDaoImpl;
import org.junit.Test;

public class MemberDaoTest
{
	@Test
	public void addMemberTest()
	{
		MemberDao mdao = new MemberDaoImpl();
		boolean result = mdao.addMember(12, 13);
		if (result)
		{
			System.out.println("添加成员成功");
		} else
		{
			System.out.println("添加成员失败");
		}
	}
	@Test
	public void removeMemberTest ()
	{
		MemberDao mdao = new MemberDaoImpl();
		
		boolean result = mdao.removeMember(11, 15);
		
		if (result)
		{
			System.out.println("取消行程成功");
		}
		else
		{
			System.out.println("取消不成功");
		}
	}
}