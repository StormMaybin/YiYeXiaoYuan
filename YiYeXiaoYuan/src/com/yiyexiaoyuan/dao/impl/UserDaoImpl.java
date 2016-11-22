package com.yiyexiaoyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.utils.DBUtil;
import com.yiyexiaoyuan.utils.ServiceUtils;

public class UserDaoImpl implements UserDao
{
	/**
	 * method 1 添加用户
	 * 
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
			// 执行操作
			return stat.execute();
		} catch (Exception e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}

	/**
	 * method 2 根据用户名查找用户
	 * 
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
			// 执行操作
			result = stat.executeQuery();
			while (result.next())
			{
				// 创建User对象
				user = new User();
				// 封装数据到对象
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
		} catch (Exception e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}

	/**
	 * method 3 根据手机号和密码查找用户
	 * 
	 * @author StormMaybin
	 * @param mobile
	 * @param passWord
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
				// 创建User对象
				user = new User();
				// 封装数据到对象
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
		} catch (Exception e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}

	/**
	 * method 4 根据手机号查找用户
	 * 
	 * @author StormMaybin
	 * @param mobile
	 * @return User
	 */
	public User findByMobile(String mobile)
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
				// 创建USer对象
				user = new User();
				// 封装数据到对象
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
		} catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}

	/**
	 * method 5 根据用户信息修改用户名 如果修改成功则返回true 反之返回false
	 * 
	 * @author StormMaybin
	 * @param u
	 * @param newUserName
	 * @return boolean
	 */
	public boolean updateUserName(User u, String newUserName)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("UPDATE user SET userName = ? WHERE mobile = ?");

			stat.setString(1, newUserName);
			stat.setString(2, u.getMobile());

			return stat.executeUpdate() == 1;
		} catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}

	/**
	 * method 6 重置密码
	 * 
	 * @author StormMaybin
	 * @param u
	 * @param newPassWord
	 * @return boolean
	 */
	public boolean resetPassWord(User u, String newPassWord)
	{
		Connection conn = null;
		PreparedStatement stat = null;

		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("UPDATE user SET passWord = ? WHERE mobile = ?");

			stat.setString(1, ServiceUtils.md5(newPassWord));
			stat.setString(2, u.getMobile());

			// 执行操作
			return stat.executeUpdate() == 1;
		} catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		// 关闭资源
		finally
		{
			DBUtil.closeConnection(conn, stat);
		}
	}

	/**
	 * method 7 把用户qq信息添加到数据库中去
	 * 
	 * @author StormMaybin
	 * @return void
	 * @param u
	 */
	public void updateQq(User u)
	{
		Connection conn = null;
		PreparedStatement stat = null;

		conn = DBUtil.getConnection();
		try
		{
			stat = conn
					.prepareStatement("UPDATE user SET qq = ? WHERE mobile = ?");

			stat.setString(1, u.getQq());
			stat.setString(2, u.getMobile());

			// 执行数据库操作
			stat.executeUpdate();
		} catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
		// 关闭资源
		finally
		{
			DBUtil.closeConnection(conn, stat);
		}
	}

	/**
	 * method 8 查询是否可以修改用户名
	 * 
	 * @author StormMaybin
	 * @param User
	 * @return boolean
	 */
	public boolean isCanUpdateUserName(User u)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;

		try
		{
			//获得数据库连接
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("SELECT passWordCount FROM user WHERE mobile = ?");
			//设置参数
			stat.setString(1, u.getMobile());

			//查询
			result = stat.executeQuery();
			if (result.next())
			{
				//如果没有修改过则可以修改反之不可以
				return result.getInt("passWordCount") == 0;
			}

		} 
		catch (SQLException e)
		{
			//异常转型
			throw new RuntimeException(e);
		} 
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
		return false;
	}
}