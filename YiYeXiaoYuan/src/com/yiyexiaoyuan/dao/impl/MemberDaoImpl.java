package com.yiyexiaoyuan.dao.impl;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.domain.Member;
import com.yiyexiaoyuan.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDaoImpl implements MemberDao
{
	public boolean addMember(int iId, int uId)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		Member m = null;
		try
		{
			conn = DBUtil.getConnection();
			stat = conn
					.prepareStatement("SELECT * FROM member WHERE main_id = ?");

			//设置参数
			stat.setInt(1, iId);

			//执行操作
			result = stat.executeQuery();
			//封装数据
			while (result.next())
			{
				m = new Member();
				m.setMain_id(iId);
				m.setId1(result.getInt("id1"));
				m.setId2(result.getInt("id2"));
				m.setId3(result.getInt("id3"));
				m.setId4(result.getInt("id4"));
				m.setId5(result.getInt("id5"));
				m.setId6(result.getInt("id6"));
				//测试
//				System.out.println(m.toString());
			}
			if (m.getId2() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id2 = ? WHERE main_id = ?");

				//设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				//返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId3() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id3 = ? WHERE main_id = ?");
				
				//设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				//返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId4() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id4 = ? WHERE main_id = ?");

				//设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				//返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId5() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id5 = ? WHERE main_id = ?");
				
				//设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				//返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId6() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id6 = ? WHERE main_id = ?");
				
				//设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				//返回
				return stat.executeUpdate() == 1;
			}
			//不能添加成员，人已满
			return false;
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
}