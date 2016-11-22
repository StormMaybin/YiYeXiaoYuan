package com.yiyexiaoyuan.junit.test;


import java.util.ArrayList;

import org.junit.Test;

import com.yiyexiaoyuan.dao.GetMemberDao;
import com.yiyexiaoyuan.dao.impl.GetMemberDaoImpl;
import com.yiyexiaoyuan.domain.User;

public class GetMemberDaoTest
{
	//查询行程的成员信息，除过当前操作用户的信息
	@Test
	public void getMemberTest ()
	{
		GetMemberDao gdao = new GetMemberDaoImpl();
		
		ArrayList<User> list = null;
		list = gdao.getMember(15, 1);
		
		if (list != null)
		{
			for (User u : list)
			{
				System.out.println(u);
			}
		}
		else
		{
			System.out.println("查询失败");
		}
	}
}
