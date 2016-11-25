package com.yiyexiaoyuan.junit.test;

import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.service.impl.UserService;
import org.junit.Test;

public class UserServiceTest
{
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
			System.out.println("用户已经存在");
		}
	}

	@Test
	public void loginServiceTest()
	{
		UserService service = new UserService();

		User user = null;

		user = service.loginService("18999229922", "dd");

		if (user != null)
		{
			System.out.println("登录成功");
			System.out.println(user.toString());
		} else
		{
			System.out.println("用户名或密码错误");
		}
	}

	@Test
	public void resetPassWordServiceTest()
	{
		UserService service = new UserService();

		User user = new User();
		user.setMobile("18219281111");
		user.setPassWord("StormMa");
		boolean isSuccess = service.resetPassWordService(user, "123456");
		if (isSuccess)
		{
			System.out.println("重置密码成功");
		} else
			System.out.println("重置密码失败，请重新尝试.....");
	}

	@Test
	public void updateUserNameServiceTest()
	{
		UserService service = new UserService();

		User user = new User();
		user.setMobile("18219281111");
		user.setPassWord("654321");
		try
		{
			boolean isSuccess = false;
			try
			{
				isSuccess = service.updateUserNameService(user, "QinYuQi");
			} catch (UserExitException e)
			{
				System.out.println("用户名已存在");
			}
			if (isSuccess)
			{
				System.out.println("修改用户名成功");
			}
		} catch (CannotAlterUserNameException e)
		{
			System.out.println("不能修改用户名");
		}
	}

	@Test
	public void updateQqServiceTest()
	{
		UserService service = new UserService();

		User user = new User();
		user.setMobile("13628902222");
		user.setPassWord("StormMa");
		user.setUserName("StormMa");
		user.setQq("1325338799");

		service.updateQqService(user);
	}

	@Test
	public void isExitMobileServiceTest()
	{
		UserService service = new UserService();
		boolean isExit = service.isExitMobile("18292817803");
		System.out.println(isExit);
	}

	@Test
	public void isCanUpdateUserNameTest()
	{
		User u = new User();
		u.setMobile("18219281111");
		UserDao udao = new UserDaoImpl();
		boolean isOk = udao.isCanUpdateUserName(u);
		if (isOk)
		{
			System.out.println("可以修改用户名");
		} else
		{
			System.out.println("不可以修改用户名");
		}
	}
}