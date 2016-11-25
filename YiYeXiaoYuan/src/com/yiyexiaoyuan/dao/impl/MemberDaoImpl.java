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
	/**
	 * 添加成员
	 * @author StormMaybin
	 * @param iId uId
	 * @return boolean
	 */
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

			// 设置参数
			stat.setInt(1, iId);

			// 执行操作
			result = stat.executeQuery();
			// 封装数据
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
				// 测试
				// System.out.println(m.toString());
			}
			if (m.getId2() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id2 = ? WHERE main_id = ?");
				// conn.commit();
				// 设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				// 返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId3() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id3 = ? WHERE main_id = ?");

				// 设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				// 返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId4() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id4 = ? WHERE main_id = ?");

				// 设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				// 返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId5() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id5 = ? WHERE main_id = ?");

				// 设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				// 返回
				return stat.executeUpdate() == 1;
			}

			if (m.getId6() == 0)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id6 = ? WHERE main_id = ?");

				// 设置参数
				stat.setInt(1, uId);
				stat.setInt(2, iId);
				// 返回
				return stat.executeUpdate() == 1;
			}
			// 不能添加成员，人已满
			return false;
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

	/**
	 * 删除某个拼车信息的某个成员
	 * 
	 * @author StormMaybin
	 * @return
	 * @param uId iId
	 */
	public boolean removeMember(int uId, int iId)
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

			stat.setInt(1, iId);

			result = stat.executeQuery();
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
				
//				System.out.println(m);
			}
			System.out.println("dddhhdhdhd");
			// 只有成员1的情况，所以删除整个行程信息和成员信息
			if (m.getId1() == uId && m.getId2() != 0 && m.getId3() != 0
					&& m.getId4() != 0 && m.getId5() != 0 && m.getId6() != 0)
			{
				System.out.println("进来了");
				stat = conn
						.prepareStatement("DELETE FROM member WHERE main_id = ?");

				// 删除member 信息
				stat.setInt(1, iId);

				// 执行删除动作
				stat.executeUpdate();
				// 紧接着删除行程信息

				stat = conn
						.prepareStatement("DELETE FROM information WHERE id = ?");
				stat.setInt(1, iId);
				// 删除行程信息
				return stat.executeUpdate() == 1;
			}
			// 删除成员2
			else if (m.getId2() == uId)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id2 = 0 WHERE main_id = ?");
				stat.setInt(1, iId);
				// 保存执行状态
				boolean result1 = stat.executeUpdate() == 1;

				stat = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

				stat.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);
				stat.setInt(2, iId);

				boolean result2 = stat.executeUpdate() == 1;

				return result1 && result2;
			}
			// 删除成员3
			else if (m.getId3() == uId)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id3 = 0 WHERE main_id = ?");
				stat.setInt(1, iId);
				// 保存执行状态
				boolean result1 = stat.executeUpdate() == 1;

				stat = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

				stat.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);
				stat.setInt(2, iId);

				boolean result2 = stat.executeUpdate() == 1;

				return result1 && result2;
			}
			// 删除成员4
			else if (m.getId4() == uId)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id4 = 0 WHERE main_id = ?");
				stat.setInt(1, iId);
				//保存执行状态
				boolean result1 = stat.executeUpdate() == 1;
				
				stat = conn.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				
				stat.setInt(1, new InformationDaoImpl().findById(iId).getCurtMember() - 1);
				stat.setInt(2, iId);
				
				boolean result2 = stat.executeUpdate() == 1;
				
				return result1 && result2;
			}
			// 删除成员5
			else if (m.getId5() == uId)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id5 = 0 WHERE main_id = ?");
				stat.setInt(1, iId);
				//保存执行状态
				boolean result1 = stat.executeUpdate() == 1;
				
				stat = conn.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				
				stat.setInt(1, new InformationDaoImpl().findById(iId).getCurtMember() - 1);
				stat.setInt(2, iId);
				
				boolean result2 = stat.executeUpdate() == 1;
				
				return result1 && result2;
			}
			// 删除成员6
			else if (m.getId6() == uId)
			{
				stat = conn
						.prepareStatement("UPDATE member SET id6 = 0 WHERE main_id = ?");
				stat.setInt(1, iId);
				//保存执行状态
				boolean result1 = stat.executeUpdate() == 1;
				
				stat = conn.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				
				stat.setInt(1, new InformationDaoImpl().findById(iId).getCurtMember() - 1);
				stat.setInt(2, iId);
				
				boolean result2 = stat.executeUpdate() == 1;
				
				return result1 && result2;
			}
		} 
		catch (SQLException e)
		{
			// 异常转型
			throw new RuntimeException(e);
		} 
		finally
		{
			// 关闭资源
			DBUtil.closeConnection(conn, stat);
		}
		return true;
	}
}