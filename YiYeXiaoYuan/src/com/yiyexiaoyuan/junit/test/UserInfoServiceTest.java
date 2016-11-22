package com.yiyexiaoyuan.junit.test;

import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.service.impl.UserInfoService;
import java.util.ArrayList;
import org.junit.Test;

public class UserInfoServiceTest
{
	@Test
	public void addServiceTest()
	{
		UserInfo ui = new UserInfo();

		ui.setId(2);
		ui.setName("张三");
		ui.setAddress("海棠十号楼1区202左室");

		UserInfoService service = new UserInfoService();
		boolean result = service.addService(ui);
		if (result)
		{
			System.out.println("购票成功");
		} 
		else
		{
			System.out.println("购票失败，请重试......");
		}
	}

	@Test
	public void queryUserInfoServiceTest()
	{
		ArrayList<UserInfo> list = null;

		UserInfoService service = new UserInfoService();
		list = service.queryUserInfoService();

		for (UserInfo ui : list)
		{
			System.out.println(ui);
		}
	}
}