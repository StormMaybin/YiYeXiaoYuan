package com.yiyexiaoyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.utils.DBUtil;

public class InformationDaoImpl implements InformationDao
{
	
	/**
	 * 添加行程
	 * @author StormMaybin
	 * @return void
	 * @param i
	 */
	public void add (Information i)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		
		try 
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("" +
					"INSERT INTO information" +
					"(uid, startDate, startPos, arrivePos," +
					"startTime_min_hour, startTime_min_min, startTime_max_hour," +
					"startTime_max_min, maxMember, curtMember," +
					"message, pubTime) VALUES(?, ?, ?, ?" +
					",?, ?, ?, ?, ?, ?, ?, ?)"); 
			/**
			 * 设置参数
			 */
			stat.setInt(1, i.getUid());
			stat.setDate(2, new java.sql.Date(i.getStartDate().getTime()));
			stat.setString(3, i.getStartPos());
			stat.setString(4, i.getArrivePos());
			stat.setInt(5, i.getStartTime_min_hour());
			stat.setInt(6, i.getStartTime_min_min()) ;
			stat.setInt(7, i.getStartTime_max_hour());
			stat.setInt(8, i.getStartTime_max_min());
			stat.setInt(9, i.getMaxMember());
			stat.setInt(10, i.getCurtMember());
			stat.setString(11, i.getMessage());
			stat.setDate(12, new java.sql.Date(i.getPubTime().getTime()));
			/*
			 * 执行操作
			 */
			stat.executeUpdate();
		} 
		catch (Exception e) 
		{
			/**
			 * 异常转型
			 */
			throw new RuntimeException(e);
		}
		finally
		{
			//关闭资源
			DBUtil.closeConnection(conn, stat);
		}	
	}

	/**
	 * 根据用户id查找行程信息
	 * @author StormMaybin
	 * @param uid
	 * @return Information
	 */
	public Information findByUid(int uid)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		Information i = null;
		try 
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM information WHERE uid = ?");
			//设置参数
			stat.setInt(1, uid);

			//ִ执行操作
			result = stat.executeQuery();
			
			while (result.next())
			{
				//创建Information对象
				i = new Information();
				
				//封装数据到Information对象
				i.setUid(uid);
				i.setId(result.getInt("id"));
				i.setStartDate(result.getDate("startDate"));
				i.setStartPos(result.getString("startPos"));
				i.setArrivePos(result.getString("arrivePos"));
				i.setStartTime_min_hour(result.getInt("startTime_min_hour"));
				i.setStartTime_min_min(result.getInt("startTime_min_min"));
				i.setStartTime_max_hour(result.getInt("startTime_max_hour"));
				i.setStartTime_max_min(result.getInt("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));
			}
			//返回对象
			return i;
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
	 * 查询所有的行程信息到集合中去
	 * @author StormMaybin
	 * @param void
	 * @return ArrayList<Information>
	 */
	public ArrayList<Information> queryInformation ()
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ArrayList<Information> list = null;
		ResultSet result  = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM information");
			result  = stat.executeQuery();
			list = new ArrayList<Information>();
			
			while (result.next())
			{
				//创建Information对象
				Information i = new Information();
				//封装数据到Information中
				i.setId(result.getInt("id"));
				i.setUid(result.getInt("uid"));
				i.setStartDate(result.getDate("startDate"));
				i.setStartPos(result.getString("startPos"));
				i.setArrivePos(result.getString("arrivePos"));
				i.setStartTime_min_hour(result.getInt("startTime_min_hour"));
				i.setStartTime_min_min(result.getInt("startTime_min_min"));
				i.setStartTime_max_hour(result.getInt("startTime_max_hour"));
				i.setStartTime_max_min(result.getInt("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));
				//添加到集合中
				list.add(i);
			}
			//按照发布日期进行排序
			Collections.sort(list);
			//返回集合
			return list;
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
	}
	/**
	 * 根据拼车信息id查找行程
	 * @author StormMaybin
	 * @return Information
	 * @param id
	 */
	public Information findById (int id)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		Information i = null;
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("SELECT * FROM information WHERE id = ?");
			stat.setInt(1, id);
			
			//执行操作
			result = stat.executeQuery();
			
			while (result.next())
			{
				//创建对象
				i = new Information();
				
				//封装数据
				i.setId(id);
				i.setUid(result.getInt("uid"));
				i.setStartDate(result.getDate("startDate"));
				i.setStartPos(result.getString("startPos"));
				i.setArrivePos(result.getString("arrivePos"));
				i.setStartTime_min_hour(result.getInt("startTime_min_hour"));
				i.setStartTime_min_min(result.getInt("startTime_min_min"));
				i.setStartTime_max_hour(result.getInt("startTime_max_hour"));
				i.setStartTime_max_min(result.getInt("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));
			}
			return i;
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
	}
	/**
	 * 根据发布时间查找拼车信息
	 * @author StormMaybin
	 * @param pubTime
	 * @return ArrayList<Information>
	 */
	public ArrayList<Information> queryByPubTime (Date pubTime)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		ArrayList<Information> list = null;
		
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("SELECT * FROM information WHERE pubTime = ?");
			stat.setDate(1, new java.sql.Date(pubTime.getTime()));
			result = stat.executeQuery();
			list = new ArrayList<Information>();
			while (result.next())
			{
				//创建对象
				Information i = new Information();
				//封装数据
				i.setId(result.getInt("id"));
				i.setUid(result.getInt("uid"));
				i.setStartDate(result.getDate("startDate"));
				i.setStartPos(result.getString("startPos"));
				i.setArrivePos(result.getString("arrivePos"));
				i.setStartTime_min_hour(result.getInt("startTime_min_hour"));
				i.setStartTime_min_min(result.getInt("startTime_min_min"));
				i.setStartTime_max_hour(result.getInt("startTime_max_hour"));
				i.setStartTime_max_min(result.getInt("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));

				//添加到集合中去
				list.add(i);
			}
			//返回集合
			return list;
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
	 * 查询拼车信息的Id
	 * @author StormMaybin
	 * @param
	 * @return Information
	 */
	public Information findId (Information i)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM information WHERE"
					+" uid = ? AND startDate = ? AND startPos = ?"
					+" AND arrivePos = ? AND startTime_min_hour = ?"
					+" AND startTime_min_min = ? AND startTime_max_hour = ?"
					+" AND startTime_max_min = ? AND maxMember = ?"
					+" AND curtMember = ? AND message = ?"
					+" AND pubTime = ?");
			
			stat.setInt(1, i.getUid());
			stat.setDate(2, new java.sql.Date(i.getStartDate().getTime()));
			stat.setString(3, i.getStartPos());
			stat.setString(4, i.getArrivePos());
			stat.setInt(5, i.getStartTime_min_hour());
			stat.setInt(6, i.getStartTime_min_min());
			stat.setInt(7, i.getStartTime_max_hour());
			stat.setInt(8, i.getStartTime_max_min());
			stat.setInt(9, i.getMaxMember());
			stat.setInt(10, i.getCurtMember());
			stat.setString(11, i.getMessage());
			stat.setDate(12, new java.sql.Date(i.getPubTime().getTime()));
			
			result = stat.executeQuery();
			while (result.next())
			{
				i.setId(result.getInt("id"));
			}
			//返回Information对象
			return i;
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
	}
	/**
	 * 根据拼车信息的id查询到拼车信息对象
	 * @author StormMaybin
	 * @param id
	 * @return Information
	 */
	public Information queryInformationById (int id)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		Information i = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM information WHERE id = ?");
			//设置参数
			stat.setInt(1, id);
			//查询返回结果集
			result = stat.executeQuery();
			//查询到数据
			while (result.next())
			{
				//创建对象
				i = new Information();
				//封装数据
				i.setId(id);
				i.setUid(result.getInt("uid"));
				i.setStartDate(result.getDate("startDate"));
				i.setStartPos(result.getString("startPos"));
				i.setArrivePos(result.getString("arrivePos"));
				i.setStartTime_min_hour(result.getInt("startTime_min_hour"));
				i.setStartTime_min_min(result.getInt("startTime_min_min"));
				i.setStartTime_max_hour(result.getInt("startTime_max_hour"));
				i.setStartTime_max_min(result.getInt("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));
			}
			return i;
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		}
	}
}
