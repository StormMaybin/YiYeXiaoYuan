package com.yiyexiaoyuan.dao;

import com.yiyexiaoyuan.domain.User;

public interface UserDao
{
	
	/**
	 * 添加用户
	 * @author StormMaybin
	 * @param u
	 * @return boolean
	 */
	public abstract boolean add(User u);
	
	/**
	 * 根据用户名查找用户
	 * @author StormMaybin
	 * @param userName
	 * @return User
	 */
	public abstract User find(String userName);
	
	/**
	 * 根据账号和密码查找用户
	 * @author StormMaybin
	 * @param userName passWord
	 * @return User
	 */
	public abstract User find(String userName, String passWord);
	
	/**
	 * 根据手机号查找用户
	 * @author StormMaybin
	 * @param mobile
	 * @return User
	 */
	public abstract User findByMobile(String mobile);
	/**
	 * 根据用户信息修改用户名
	 * 如果修改成功则返回true
	 * 反之返回false
	 * @author StormMaybin
	 * @param u newUserName
	 * @return boolean
	 */
	public abstract boolean updateUserName (User u, String newUserName);
	/**
	 * 根据用户设置修改用户名次数
	 * @author StormMaybin
	 * @param u
	 * @return void
	 */
	public abstract void updatePassWordCount (User u);
	/**
	 * 重置密码
	 * @author StormMaybin
	 * @param u
	 * @return boolean
	 */
	public abstract boolean resetPassWord (User u, String newPassWord);
	/**
	 * 把用户qq信息添加到数据库中去
	 * @author StormMaybin
	 * @return void
	 * @param u
	 */
	public abstract void updateQq (User u);
	/**
	 * 查询是否已经修改过用户名
	 * @author StormMaybin
	 * @param User
	 * @return int
	 */
	public abstract int queryPassWordCount (User u);
}