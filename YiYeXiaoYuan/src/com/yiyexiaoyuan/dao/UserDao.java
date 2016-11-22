package com.yiyexiaoyuan.dao;

import com.yiyexiaoyuan.domain.User;

public interface UserDao
{
	/**
	 * method 1 添加用户
	 * 
	 * @author StormMaybin
	 * @param u
	 * @return boolean
	 */
	public abstract boolean add(User paramUser);

	/**
	 * method 2 根据用户名查找用户
	 * 
	 * @author StormMaybin
	 * @param userName
	 * @return User
	 */
	public abstract User find(String userName);

	/**
	 * method 3 根据手机号和密码查找用户
	 * 
	 * @author StormMaybin
	 * @param mobile
	 * @param passWord
	 * @return User
	 */
	public abstract User find(String mobile, String passWord);

	/**
	 * method 4 根据手机号查找用户
	 * 
	 * @author StormMaybin
	 * @param mobile
	 * @return User
	 */
	public abstract User findByMobile(String mobile);

	/**
	 * method 5 根据用户信息修改用户名 如果修改成功则返回true 反之返回false
	 * 
	 * @author StormMaybin
	 * @param u
	 * @param newUserName
	 * @return boolean
	 */
	public abstract boolean updateUserName(User u, String newUserName);

	/**
	 * method 6 重置密码
	 * 
	 * @author StormMaybin
	 * @param u
	 * @param newPassWord
	 * @return boolean
	 */
	public abstract boolean resetPassWord(User u, String newPassWord);

	/**
	 * method 7 把用户qq信息添加到数据库中去
	 * 
	 * @author StormMaybin
	 * @return void
	 * @param u
	 */
	public abstract void updateQq(User paramUser);

	/**
	 * method 8 查询是否可以修改用户名
	 * 
	 * @author StormMaybin
	 * @param User
	 * @return boolean
	 */
	public abstract boolean isCanUpdateUserName(User u);
	
	/**
	 * method 9
	 * 根据用户名查找用户的id
	 * @author StormMaybin
	 * @param userName
	 * @return int
	 */
	public abstract int queryUIdByUserName (String userName);
}