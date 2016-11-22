package com.yiyexiaoyuan.junit.test;

import com.yiyexiaoyuan.dao.UserInfoDao;
import com.yiyexiaoyuan.dao.impl.UserInfoDaoImpl;
import com.yiyexiaoyuan.domain.UserInfo;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class UserInfoDaoTest
{
	@Test
	public void userInfoAddTest()
	{
		UserInfo ui = new UserInfo();

		ui.setId(11);
		ui.setName("李四");
		ui.setAddress("竹园四号楼1区402左室");
		ui.setStartDate(new Date());
		ui.setStartTime("12:20:45");
		ui.setAmount(5);
		ui.setArrive("西安火车站");

		UserInfoDao userInfoDao = new UserInfoDaoImpl();
		boolean result = userInfoDao.add(ui);
		System.out.println(result);
	}

	@Test
	public void queryUserInfo()
	{
		ArrayList<UserInfo> list = null;

		UserInfoDao usetInfoDao = new UserInfoDaoImpl();
		list = usetInfoDao.queryUserInfo();

		for (UserInfo ui : list)
		{
			System.out.println(ui);
		}
	}
}