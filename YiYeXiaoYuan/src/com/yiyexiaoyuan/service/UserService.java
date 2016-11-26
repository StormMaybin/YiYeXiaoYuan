package com.yiyexiaoyuan.service;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;

public interface UserService
{

	/**
	 * 为web层提供注册的服务
	 * @author StormMaybin
	 * @param u
	 * @throws UserExitException
	 */
	public abstract boolean registerService(User u) throws UserExitException;

	/**
	 * 为web层提供登录的服务
	 * @author StormMaybin
	 * @param mobile
	 * @param passWord
	 * @return
	 */
	public abstract User loginService(String mobile, String passWord);

	/**
	 * 为web层提供重置密码的服务
	 * @param u
	 * @param newPassWord
	 * @return boolean
	 * 重置成功返回true，反之false
	 */
	public abstract boolean resetPassWordService(User u, String newPassWord);

	/**
	 * 为web层提供修改用户名的服务
	 * @param u
	 * @param newUserName
	 * @return boolean
	 * @throws CannotAlterUserNameException
	 * @throws UserExitException
	 */
	public abstract boolean updateUserNameService(User u, String newUserName)
			throws CannotAlterUserNameException, UserExitException;

	/**
	 * 为web层提供添加qq信息的服务
	 * @param u
	 */
	public abstract boolean updateQqService(User u);

	/**
	 * 判断手机号码是否已存在
	 * @param mobile
	 * @return boolean
	 */
	public abstract boolean isExitMobile(String mobile);

}