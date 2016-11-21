package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;

public class UserService
{
	// 申明业务逻辑层对象
	private UserDao userDao = new UserDaoImpl();
	
	/**
	 * 为Web层提供注册用户的服务
	 * 
	 * @author StormMaybin
	 * @param u
	 * @throws UserExitException
	 */
	public void registerService(User u) throws UserExitException
	{
		// 如果用户的手机号已经注册过，向上抛出异常
		if (userDao.findByMobile(u.getMobile()) != null)
		{
			throw new UserExitException();
		} 
		else
		{
			// 添加用户到数据库
			userDao.add(u);
		}
	}
	/**
	 * 为Web层提供登录服务
	 * @author StormMaybin
	 * @param userName
	 * @param passWord
	 * @return User
	 * 如果对象不为空，那么登录成功
	 */
	public User loginService (String mobile, String passWord)
	{
		//调用dao层向数据库中查询是否存在这个用户
		User u = userDao.find(mobile, passWord);
		return u;
	}
	/**
	 * 为web层提供重置密码服务
	 * @param u
	 * @param passWord
	 * @return boolean
	 * 如果重置成功则返回true
	 * 如果失败则返回false
	 */
	public boolean resetPassWordService (User u, String newPassWord)
	{
		//调用dao层的重置密码逻辑
		boolean isSuccess = userDao.resetPassWord(u, newPassWord);
		return isSuccess;
	}
	/**
	 * 为Web层提供修改用户名的服务
	 * @author StormMaybin
	 * @param
	 * @return boolean
	 * @throws CannotAlterUserNameException 
	 * @throws UserExitException 
	 */
	public boolean updateUserNameService (User u, String newUserName) throws CannotAlterUserNameException, UserExitException
	{
		//如果已经修改过用户名，那么没有修改用户名的权限
		if (userDao.queryPassWordCount(u) == 1)
		{
			u.setPassWordCount(1);
			throw new CannotAlterUserNameException();
		}
		else //具备修改权限
		{
			//如果用户名已经存在
			if (userDao.find(newUserName) != null)
			{
				throw new UserExitException("用户名已存在");
			}
			//设置修改次数已经用完
			userDao.updatePassWordCount(u);
			//调用dao层的修改用户名逻辑
			boolean isSuccess = userDao.updateUserName(u, newUserName);
			//如果修改成功，那么将不再具备修改用户名的权限
			if (isSuccess)
			{
				u.setPassWordCount(1);
			}
			return isSuccess;
		}
	}
	/**
	 * 为Web层提供添加qq信息的服务
	 * @author StormMaybin
	 * @param u
	 * @return
	 */
	public void updateQqService (User u)
	{
		//前提校验数据
		//调用dao层的业务逻辑
		userDao.updateQq(u);
	}
}
