package com.yiyexiaoyuan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class DBUtil 
{
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	public static Logger logger = Logger.getLogger(DBUtil.class);
	//static加载
	static
	{
		try 
		{
//			Properties properties = new Properties();
//			properties.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
//			driver = properties.getProperty("driver");
//			url = properties.getProperty("url");
//			user = properties.getProperty("username");
//			pwd = properties.getProperty("password");
			driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql://localhost:3306/yiyexiaoyuan?useUnicode=true&characterEncoding=utf8";
			user = "root";
			pwd = "root";
//			pwd = "StormMaybin@";
		} 
		catch (Exception e) 
		{
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 获得数据库连接
	 * @author StormMaybin
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection()
	{
		//加载数据库
		try
		{
			Class.forName(driver);
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			logger.error(e);
			throw new RuntimeException(e);
		}
		try
		{
			return DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e)
		{
			logger.error(e);
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * �ر�����
	 * @param conn
	 * @param stm
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement stm, ResultSet rs)
	{
		try 
		{
			if (conn != null)
				conn.close();
			if (stm != null)
				stm.close();
			if (rs != null)
				rs.close();
		} 
		catch (Exception e) 
		{
			logger.error(e);
			e.printStackTrace();
		}
	}
	public static void  closeConnection(Connection conn,Statement stm)
	{
		try 
		{
			if (conn != null)
				conn.close();
			if (stm != null)
				stm.close();
		} 
		catch (Exception e) 
		{
			logger.error(e);
			e.printStackTrace();
		}
	}
}
