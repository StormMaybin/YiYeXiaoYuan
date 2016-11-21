package com.yiyexiaoyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.utils.DBUtil;
import com.yiyexiaoyuan.utils.ServiceUtils;

public class UserDaoImpl implements UserDao
{
	/**
	 * 添加用户，注册用户时候只有手机号码和密码字段添加
	 * @author StormMaybin
	 * @param u
	 * @return boolean
	 */
	public boolean add(User u)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("INSERT INTO user(passWord, mobile) VALUES (?,?)");
			stat.setString(1, ServiceUtils.md5(u.getPassWord()));
			stat.setString(2, u.getMobile());
			//执行操作
			return stat.execute();
		} 
		catch (Exception e)
		{
			//异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}
	
	/**
	 * 根据用户名查找用户
	 * @author StormMaybin
	 * @param userName
	 * @return User
	 */
	public User find(String userName)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		User user = null;
		ResultSet result = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("SELECT * FROM user WHERE userName = ?");
			
			stat.setString(1, userName);
			//执行操作
			result = stat.executeQuery();
			while (result.next())
			{
				//创建User对象
				user = new User();
				//封装数据到对象
				user.setUserName(userName);
				user.setId(result.getInt("id"));
				user.setQq(result.getString("qq"));
				user.setPassWord(result.getString("passWord"));
				user.setMobile(result.getString("mobile"));
				user.setGoodApprise(result.getInt("goodApprise"));
				user.setBadApprise(result.getInt("badApprise"));
				user.setPassWordCount(result.getInt("passWordCount"));
			}
			return user;
		} 
		catch (Exception e)
		{
			//异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}
	
	/**
	 * 根据账号和密码查找用户
	 * @author StormMaybin
	 * @param userName passWord
	 * @return User
	 */
	public User find(String mobile, String passWord)
	{
		User user = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("SELECT * FROM user WHERE passWord = ? AND mobile = ?");
			
			stat.setString(1, ServiceUtils.md5(passWord));
			stat.setString(2, mobile);
			result = stat.executeQuery();
			while (result.next())
			{
				//创建User对象
				user = new User();
				//封装数据到对象
				user.setId(result.getInt("id"));
				user.setUserName(result.getString("userName"));
				user.setPassWord(result.getString("passWord"));
				user.setMobile(mobile);
				user.setGoodApprise(result.getInt("goodApprise"));
				user.setBadApprise(result.getInt("badApprise"));
				user.setPassWordCount(result.getInt("passWordCount"));
				user.setQq(result.getString("qq"));
			}
			return user;
		} 
		catch (Exception e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}

	/**
	 * 根据手机号查找用户
	 * @author StormMaybin
	 * @param mobile
	 * @return User
	 */
	public User findByMobile (String mobile)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		User user = null;
		ResultSet result = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM user WHERE mobile = ?");
			stat.setString(1, mobile);
			result = stat.executeQuery();
			while (result.next())
			{
				//创建USer对象
				user = new User();
				//封装数据到对象
				user.setId(result.getInt("id"));
				user.setUserName(result.getString("userName"));
				user.setPassWord(result.getString("passWord"));
				user.setMobile(mobile);
				user.setGoodApprise(result.getInt("goodApprise"));
				user.setBadApprise(result.getInt("badApprise"));
				user.setPassWordCount(result.getInt("passWordCount"));
				user.setQq(result.getString("qq"));
			}
			return user;
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}
	/**
	 * 传进来的用户必须具有修改用户名的权限
	 * 根据用户信息修改用户名
	 * 如果修改成功则返回true
	 * 反之返回false
	 * @author StormMaybin
	 * @param u newUserName
	 * @return boolean
	 * @throws CannotAlterUserNameException 
	 */
	public boolean updateUserName (User u, String newUserName)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("UPDATE user SET userName = ? WHERE mobile = ?");
		
			stat.setString(1, newUserName);
			stat.setString(2, u.getMobile());
			
			return stat.executeUpdate() == 1;
		} 
		catch (SQLException e)
		{
			//异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}
	/**
	 * 根据用户设置修改用户名次数
	 * @author StormMaybin
	 * @param u
	 * @return void
	 */
	public void updatePassWordCount (User u)
	{
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("UPDATE user SET passWordCount = ? WHERE mobile = ?");
			
			stat.setInt(1, 1);
			stat.setString(2, u.getMobile());
			//执行操作
			stat.execute();
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}
	/**
	 * 重置密码
	 * @author StormMaybin
	 * @param u
	 * @return void
	 */
	public boolean resetPassWord (User u, String newPassWord)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("UPDATE user SET passWord = ? WHERE mobile = ?");
			
			stat.setString(1, ServiceUtils.md5(newPassWord));
			stat.setString(2, u.getMobile());
			
			//执行操作
			return stat.executeUpdate() == 1;
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		//关闭资源
		finally
		{
			DBUtil.closeConnection(conn, stat);
		}
	}
	/**
	 * 把用户qq信息添加到数据库中去
	 * @author StormMaybin
	 * @return void
	 * @param u
	 */
	public void updateQq (User u)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("UPDATE user SET qq = ? WHERE mobile = ?");
			
			stat.setString(1, u.getQq());
			stat.setString(2, u.getMobile());
			
			//执行数据库操作
			stat.executeUpdate();
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		//关闭资源
		finally 
		{
			DBUtil.closeConnection(conn, stat);
		}
	}
	/**
	 * 查询是否已经修改过用户名
	 * @author StormMaybin
	 * @param User
	 * @return int
	 */
	public int queryPassWordCount (User u)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("SELECT * FROM user WHERE mobile = ?");
			stat.setString(1, u.getMobile());
			
			result = stat.executeQuery();
			while (result.next())
			{
				return result.getInt("passWordCount");
			}
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		//关闭资源
		finally
		{
			DBUtil.closeConnection(conn, stat, result);
		}
		return -1;
	}
}