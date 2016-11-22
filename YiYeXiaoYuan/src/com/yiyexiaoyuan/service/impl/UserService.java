package com.yiyexiaoyuan.service.impl;

import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;
/**
 * 为web层提供一系列的服务
 * @author StormMaybin
 */
public class UserService
{
	//申明业务逻辑层的对象
	private UserDao userDao = new UserDaoImpl();

	/**
	 * 为web层提供注册的服务
	 * @author StormMaybin
	 * @param u
	 * @throws UserExitException
	 */
	public boolean registerService(User u) throws UserExitException
	{
		//如果这个 手机号码已经注册就不能继续注册
		if (userDao.findByMobile(u.getMobile()) != null)
		{
			//抛出用户已存在异常
			throw new UserExitException();
		}
		//添加用户
		return userDao.add(u);
	}
	/**
	 * 为web层提供登录的服务
	 * @author StormMaybin
	 * @param mobile
	 * @param passWord
	 * @return
	 */
	public User loginService(String mobile, String passWord)
	{
		//调用dao层处理
		User u = this.userDao.find(mobile, passWord);
		//返回
		//通过判断u是否为空确定登录成功与否
		return u;
	}
	/**
	 * 为web层提供重置密码的服务
	 * @param u
	 * @param newPassWord
	 * @return boolean
	 * 重置成功返回true，反之false
	 */
	public boolean resetPassWordService(User u, String newPassWord)
	{
		//调用dao层进行处理
		boolean isSuccess = this.userDao.resetPassWord(u, newPassWord);
		//返回结果
		return isSuccess;
	}
	/**
	 * 为web层提供修改用户名的服务
	 * @param u
	 * @param newUserName
	 * @return boolean
	 * @throws CannotAlterUserNameException
	 * @throws UserExitException
	 */
	public boolean updateUserNameService(User u, String newUserName)
			throws CannotAlterUserNameException, UserExitException
	{
		//判断是否有修改用户名的权限
		if (!this.userDao.isCanUpdateUserName(u))
		{
			//抛出不可以修改用户名异常
			throw new CannotAlterUserNameException();
		}
		//如果要修改的用户名已存在
		if (this.userDao.find(newUserName) != null)
		{
			//抛出用户名已存在异常
			throw new UserExitException("用户名已存在");
		}
		//标记修改结果
		boolean isSuccess = this.userDao.updateUserName(u, newUserName);
		//返回操作结果
		return isSuccess;
	}
	/**
	 * 为web层提供添加qq信息的服务
	 * @param u
	 */
	public boolean updateQqService(User u)
	{
		//调用dao层实现
		return this.userDao.updateQq(u);
	}
	/**
	 * 判断手机号码是否已存在
	 * @param mobile
	 * @return boolean
	 */
	public boolean isExitMobile(String mobile)
	{
		
		//UserDao udao = new UserDaoImpl();

		if (userDao.findByMobile(mobile) != null)
		{
			return true;
		}

		return false;
	}
}