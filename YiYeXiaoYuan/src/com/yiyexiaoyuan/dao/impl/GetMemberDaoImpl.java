package com.yiyexiaoyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yiyexiaoyuan.dao.GetMemberDao;
import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.utils.DBUtil;

public class GetMemberDaoImpl implements GetMemberDao
{
	/**
	 * 根据拼车信息id获得除过uId所有成员的信息
	 * @author StormMaybin
	 * @param iId拼车信息id
	 * @param uId用户id
	 * @return
	 */
	public ArrayList<User> getMember (int iId, int uId)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ArrayList<User> list = null;
		ResultSet result  = null;
		
		//先查出来拼车信息的全部成员存储到一个数组中
		int [] member = null;
		
		conn = DBUtil.getConnection();
		try
		{
			stat = conn.prepareStatement("SELECT * FROM member WHERE main_id = ?");
			//设置参数
			stat.setInt(1, iId);
			//执行结果
			result = stat.executeQuery();
			
			while (result.next())
			{
				member = new int [6];
				for (int i = 1; i <= 6; i++)
				{
					member[i-1] = result.getInt("id"+i);
				}
			}
			//如果查询出来成员之后
			if (member != null)
			{
				UserDao udao = new UserDaoImpl();
				list = new ArrayList<User>();
				for (int i = 0; i < member.length; i++)
				{
					if (member[i] != uId)
					{
						User u = null;
						u = udao.findById(member[i]);
						if (u != null)
						{
							list.add(u);
						}
					}
				}
				return list;
			}
			else
			{
				return null;
			}
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
}
