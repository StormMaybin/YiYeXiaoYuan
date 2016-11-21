package com.yiyexiaoyuan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil 
{
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	//static语句块初始化字段信息
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
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("读取数据库配置文件出现异常", e);
		}
	}
	
	/**
	 * 获取与数据库的连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection()
	{
		//加载mysql驱动
		try
		{
			Class.forName(driver);
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException("加载数据库驱动出现异常", e);
		}
		try
		{
			return DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException("连接数据库出现异常", e);
		}
	}
	/**
	 * 关闭连接
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
			e.printStackTrace();
		}
	}
}
