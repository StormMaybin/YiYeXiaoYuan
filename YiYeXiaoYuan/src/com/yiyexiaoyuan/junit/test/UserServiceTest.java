package com.yiyexiaoyuan.junit.test;

import org.junit.Test;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.service.impl.UserService;

public class UserServiceTest
{
	// 注册服务测试
	@Test
	public void RegisterServiceTest()
	{
		UserService service = new UserService();
		
		User user = new User();
		user.setMobile("13628902222");
		user.setPassWord("StormMa");
		
		try
		{
			service.registerService(user);
			System.out.println("注册成功");
		} catch (UserExitException e)
		{
			// TODO Auto-generated catch block
			System.out.println("用户已经存在");
		}
		
	}
	
	// 登录服务测试
	@Test
	public void loginServiceTest()
	{
		UserService service = new UserService();
		
		User user = null;
		
		user = service.loginService("13628902222", "StormMa");
		
		if (user != null)
		{
			System.out.println("登录成功");
			System.out.println(user.toString());
		} else
		{
			System.out.println("用户名或密码错误");
		}
	}
	
	// 重置密码服务测试
	@Test
	public void resetPassWordServiceTest()
	{
		UserService service = new UserService();
		
		User user = new User();
		user.setMobile("13628902222");
		user.setPassWord("StormMa");
		boolean isSuccess = service.resetPassWordService(user, "StormMa");
		if (isSuccess)
		{
			System.out.println("重置密码成功");
		} else
		{
			System.out.println("重置密码失败，请重新尝试.....");
		}
	}
	
	// 修改用户名服务测试
	@Test
	public void updateUserNameServiceTest()
	{
		UserService service = new UserService();
		
		User user = new User();
		user.setMobile("19988882222");
		user.setPassWord("654321");
		try
		{
			boolean isSuccess = false;
			try
			{
				isSuccess = service.updateUserNameService(user, "Jack");
			} 
			catch (UserExitException e)
			{
				// TODO Auto-generated catch block
				System.out.println("用户名已存在");
			}
			if (isSuccess)
			{
				System.out.println("修改用户名成功");
			} 
		} 
		catch (CannotAlterUserNameException e)
		{
			System.out.println("修改用户名已达上限");
		}
	}
	// 添加qq信息的服务测试
	@Test
	public void updateQqServiceTest()
	{
		UserService service = new UserService();
		
		User user = new User();
		user.setMobile("13628902222");
		user.setPassWord("StormMa");
		user.setUserName("StormMa");
		user.setQq("1325338799");
		//调用服务
		service.updateQqService(user);
	}
}
