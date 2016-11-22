package com.yiyexiaoyuan.dao.impl;

import com.yiyexiaoyuan.dao.UserInfoDao;
import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UserInfoDaoImpl implements UserInfoDao
{
	/**
	 * 添加购票信息
	 * 
	 * @author StormMaybin
	 * @param ui
	 * @return boolean 添加成功为true 反之为false
	 */
	public boolean add(UserInfo ui)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		SimpleDateFormat sdf;
		try
		{
			sdf = new SimpleDateFormat("HH:mm");
			// 获得数据库连接
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("INSERT INTO user_info(id, name, address, amount, startDate, startTime, arrive) VALUES (?, ?, ?, ?, ?, ?, ?)");
			// 设置参数
			stat.setInt(1, ui.getId());
			stat.setString(2, ui.getName());
			stat.setString(3, ui.getAddress());
			stat.setInt(4, ui.getAmount());
			stat.setDate(5, new java.sql.Date(ui.getStartDate().getTime()));
			stat.setTime(6, new java.sql.Time(sdf.parse(ui.getStartTime())
					.getTime()));
			stat.setString(7, ui.getArrive());
			// 执行查询并且返回
			return stat.executeUpdate() == 1;
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} 
		catch (ParseException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} 
		finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat);
		}
	}

	/**
	 * 查询所有的购票信息
	 * 
	 * @author StormMaybin
	 * @param
	 * @return ArrayList
	 */
	public ArrayList<UserInfo> queryUserInfo()
	{
		ArrayList<UserInfo> list = null;
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;

		try
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			// 创建集合
			list = new ArrayList<UserInfo>();
			// 查询
			stat = conn.prepareStatement("SELECT * FROM user_info");
			// 执行
			result = stat.executeQuery();
			// 封装对象
			while (result.next())
			{
				UserInfo ui = new UserInfo();
				ui.setId(result.getInt("id"));
				ui.setName(result.getString("name"));
				ui.setAddress(result.getString("address"));
				ui.setAmount(result.getInt("amount"));
				ui.setStartDate(result.getDate("startDate"));
				ui.setStartTime(result.getTime("startTime").toString());
				ui.setArrive(result.getString("arrive"));
				list.add(ui);
			}
			// 返回
			return list;
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} 
		finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat, result);
		}
	}
}