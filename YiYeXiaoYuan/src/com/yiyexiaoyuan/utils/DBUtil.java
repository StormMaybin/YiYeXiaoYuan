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
			throw new RuntimeException("��ȡ��ݿ������ļ������쳣", e);
		}
	}
	
	/**
	 * ��ȡ����ݿ������
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection()
	{
		//����mysql��
		try
		{
			Class.forName(driver);
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException("������ݿ�������쳣", e);
		}
		try
		{
			return DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException("������ݿ�����쳣", e);
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
