package com.yiyexiaoyuan.junit.test;

import org.junit.Test;

import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;

public class UserDaoTest
{
	//添加用户测试
	@Test
	public void add ()
	{
		User user = new User();
		user.setBadApprise(10);
		user.setMobile("18219281111");
		user.setPassWord("StormMaybin@");
		
		UserDao dao = new UserDaoImpl();
		dao.add(user);
	}
	//用户名查找测试
	@Test
	public void findTest ()
	{
		User u = null;
		
		UserDao udao = new UserDaoImpl();

		u = udao.find("18219280000");
		
		System.out.println(u.toString());
	}
	// 根据账号和密码查找用户
	@Test
	public void findTest2()
	{
		User u = null;
		
		UserDao udao = new UserDaoImpl();

		u = udao.find("13688884444", "123456");
		
		if (u != null)
			System.out.println(u.toString());
	}
	//根据手机号码查找用户测试
	@Test
	public void findByMobile ()
	{
		User u = null;
		
		UserDao udao = new UserDaoImpl();
		
		u = udao.findByMobile("18292817803");
		
		if (u != null)
			System.out.println(u.toString());
	}
	//修改用户名测试
	@Test
	public void updateUserNameTest ()
	{
		UserDao udao = new UserDaoImpl();
		
		User u = new User();
		u.setUserName("18288888888");
		u.setMobile("18288888888"); 
		u.setPassWord("123456");
		
		
		if (udao.updateUserName(u, "StormMaybin"))
			System.out.println("用户名修改成功");
	}
	//重置密码测试
	@Test
	public void resetPassWordTest ()
	{
		UserDao udao = new UserDaoImpl();
		
		User u = new User();
		u.setUserName("18292817803");
		u.setMobile("18292817803"); 
		u.setPassWord("654321");
		
		udao.resetPassWord(u, "123456");
	}
	//添加qq测试
	@Test
	public void updateQqTest ()
	{
		UserDao udao = new UserDaoImpl();
		
		User u = new User();
		u.setUserName("StormMa");
		u.setMobile("13628902222"); 
		u.setPassWord("StormMa");
		u.setQq("1325338799");
		
		udao.updateQq(u);
	}
	//查询是否具有修改用户名权限
	@Test
	public void isCanUpdateUserNameTest()
	{
		UserDao udao = new UserDaoImpl();
		
		User u = new User();
		u.setUserName("StormMa");
		u.setMobile("13628902222"); 
		u.setPassWord("StormMa");
		u.setQq("1325338799");
		
		System.out.println(udao.isCanUpdateUserName(u));
	}
	//根据用户名查找用户的id
	@Test
	public void queryUIdByUserNameTest ()
	{
		String userName = "StormMa";
		UserDao udao = new UserDaoImpl();
		int uId = udao.queryUIdByUserName(userName);
		if (uId != 0)
		{
			System.out.println("用户id是: "+uId);
		}
		else
		{
			System.out.println("无此用户名");
		}
	}
}
