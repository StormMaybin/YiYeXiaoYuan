package com.yiyexiaoyuan.dao.impl;

import com.yiyexiaoyuan.dao.MemberDao;
import com.yiyexiaoyuan.domain.Member;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDaoImpl implements MemberDao
{
	/**
	 * 添加成员
	 * 
	 * @author StormMaybin
	 * @param iId
	 *            uId
	 * @return boolean
	 */
	public boolean addMember(int iId, int uId)
	{
		Connection conn = null;
		PreparedStatement stat1 = null;
		PreparedStatement stat2 = null;
		Member m = null;

		// 查询出这个拼车信息id对应所有成员的id
		m = new MemberDaoImpl().queryByMainId(iId);
		if (m != null)
		{
			// 如果id2为0的话
			if (m.getId2() == 0)
			{
				try
				{
					conn = DBUtil.getConnection();
					// 开启一个事务
					conn.setAutoCommit(false);
					stat1 = conn
							.prepareStatement("UPDATE member SET id2 = ? WHERE main_id = ?");
					// 设置参数
					stat1.setInt(1, uId);
					stat1.setInt(2, iId);

					//
					stat1.executeUpdate();

					stat2 = conn
							.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

					stat2.setInt(1, new InformationDaoImpl().findById(iId)
							.getCurtMember() + 1);
					stat2.setInt(2, iId);

					stat2.executeUpdate();

					// 提交事务
					conn.commit();
					return true;
				} catch (SQLException e)
				{
					// 回滚事务
					try
					{
						conn.rollback();
						// log4j添加此
						System.out.println("事务异常，开始回滚");
					} catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						throw new RuntimeException(e1);
					}
					// 异常转型
					throw new RuntimeException(e);
				} finally
				{
					// 关闭资源
					DBUtil.closeConnection(conn, stat1);

				}
			}
			// 如果id3为0的话
			if (m.getId3() == 0)
			{
				try
				{
					conn = DBUtil.getConnection();
					// 开启一个事务
					conn.setAutoCommit(false);
					stat1 = conn
							.prepareStatement("UPDATE member SET id3 = ? WHERE main_id = ?");
					// 设置参数
					stat1.setInt(1, uId);
					stat1.setInt(2, iId);

					//
					stat1.executeUpdate();

					stat2 = conn
							.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

					stat2.setInt(1, new InformationDaoImpl().findById(iId)
							.getCurtMember() + 1);
					stat2.setInt(2, iId);

					stat2.executeUpdate();

					// 提交事务
					conn.commit();
					return true;
				} catch (SQLException e)
				{
					// 回滚事务
					try
					{
						conn.rollback();
						// log4j添加此
						System.out.println("事务异常，开始回滚");
					} catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						throw new RuntimeException(e1);
					}
					// 异常转型
					throw new RuntimeException(e);
				} finally
				{
					// 关闭资源
					DBUtil.closeConnection(conn, stat1);

				}
			}
			// 如果id4为0的话
			if (m.getId4() == 0)
			{
				try
				{
					conn = DBUtil.getConnection();
					// 开启一个事务
					conn.setAutoCommit(false);
					stat1 = conn
							.prepareStatement("UPDATE member SET id4 = ? WHERE main_id = ?");
					// 设置参数
					stat1.setInt(1, uId);
					stat1.setInt(2, iId);

					//
					stat1.executeUpdate();

					stat2 = conn
							.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

					stat2.setInt(1, new InformationDaoImpl().findById(iId)
							.getCurtMember() + 1);
					stat2.setInt(2, iId);

					stat2.executeUpdate();

					// 提交事务
					conn.commit();
					return true;
				} catch (SQLException e)
				{
					// 回滚事务
					try
					{
						conn.rollback();
						// log4j添加此
						System.out.println("事务异常，开始回滚");
					} catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						throw new RuntimeException(e1);
					}
					// 异常转型
					throw new RuntimeException(e);
				} finally
				{
					// 关闭资源
					DBUtil.closeConnection(conn, stat1);

				}
			}
			// 如果id5为0的话
			if (m.getId5() == 0)
			{
				try
				{
					conn = DBUtil.getConnection();
					// 开启一个事务
					conn.setAutoCommit(false);
					stat1 = conn
							.prepareStatement("UPDATE member SET id5 = ? WHERE main_id = ?");
					// 设置参数
					stat1.setInt(1, uId);
					stat1.setInt(2, iId);

					//
					stat1.executeUpdate();

					stat2 = conn
							.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

					stat2.setInt(1, new InformationDaoImpl().findById(iId)
							.getCurtMember() + 1);
					stat2.setInt(2, iId);

					stat2.executeUpdate();

					// 提交事务
					conn.commit();
					return true;
				} catch (SQLException e)
				{
					// 回滚事务
					try
					{
						conn.rollback();
						// log4j添加此
						System.out.println("事务异常，开始回滚");
					} catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						throw new RuntimeException(e1);
					}
					// 异常转型
					throw new RuntimeException(e);
				} finally
				{
					// 关闭资源
					DBUtil.closeConnection(conn, stat1);

				}
			}
			// 如果id6为0的话
			if (m.getId6() == 0)
			{
				try
				{
					conn = DBUtil.getConnection();
					// 开启一个事务
					conn.setAutoCommit(false);
					stat1 = conn
							.prepareStatement("UPDATE member SET id6 = ? WHERE main_id = ?");
					// 设置参数
					stat1.setInt(1, uId);
					stat1.setInt(2, iId);

					//
					stat1.executeUpdate();

					stat2 = conn
							.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");

					stat2.setInt(1, new InformationDaoImpl().findById(iId)
							.getCurtMember() + 1);
					stat2.setInt(2, iId);

					stat2.executeUpdate();

					// 提交事务
					conn.commit();
					return true;
				} catch (SQLException e)
				{
					// 回滚事务
					try
					{
						conn.rollback();
						// log4j添加此
						System.out.println("事务异常，开始回滚");
					} catch (SQLException e1)
					{
						// TODO Auto-generated catch block
						throw new RuntimeException(e1);
					}
					// 异常转型
					throw new RuntimeException(e);
				} finally
				{
					// 关闭资源
					DBUtil.closeConnection(conn, stat1);
				}
			}
		}
		return false;
	}

	/**
	 * 删除某个拼车信息的某个成员
	 * 
	 * @author StormMaybin
	 * @return
	 * @param uId
	 *            iId
	 */
	public boolean removeMember(int uId, int iId)
	{
		Connection conn = null;
		PreparedStatement stat1 = null;
		PreparedStatement stat2 = null;
		Member m = null;

		// 查询对应拼车信息的所有成员id
		m = new MemberDaoImpl().queryByMainId(iId);

		// 如果只有id1这个成员，他取消的话，直接删除整个member记录，并且删除对应的行程信息
		if ((m.getId1() == uId) && (m.getId2() == 0) && (m.getId3() == 0)
				&& (m.getId4() == 0) && (m.getId5() == 0) && (m.getId6() == 0))
		{
			// log4j部分
			// System.out.println("进来了");

			try
			{

				// 获得数据库一个连接
				conn = DBUtil.getConnection();
				// 开启一个事务
				conn.setAutoCommit(false);
				stat1 = conn
						.prepareStatement("DELETE FROM member WHERE main_id = ?");

				// 删除member 信息
				stat1.setInt(1, iId);
				stat1.executeUpdate();

				// 紧接着删除行程信息

				stat2 = conn
						.prepareStatement("DELETE FROM information WHERE id = ?");
				stat2.setInt(1, iId);
				// 删除行程信息

				stat2.executeUpdate();
				// 开始提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}

		// 删除成员2
		if (m.getId2() == uId)
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			try
			{
				// 开始一个事务
				conn.setAutoCommit(false);
				// 语句1 ，删除成员id2
				stat1 = conn
						.prepareStatement("UPDATE member SET id2 = 0 WHERE main_id = ?");
				stat1.setInt(1, iId);

				stat1.executeUpdate();

				// 语句2 将拼车信息的已有人数减少1
				stat2 = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				stat2.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);

				stat2.setInt(2, iId);

				stat2.executeUpdate();
				// 提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}
		// 删除成员3
		if (m.getId3() == uId)
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			try
			{
				// 开始一个事务
				conn.setAutoCommit(false);
				// 语句1 ，删除成员id2
				stat1 = conn
						.prepareStatement("UPDATE member SET id3 = 0 WHERE main_id = ?");
				stat1.setInt(1, iId);

				stat1.executeUpdate();

				// 语句2 将拼车信息的已有人数减少1
				stat2 = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				stat2.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);

				stat2.setInt(2, iId);

				stat2.executeUpdate();
				// 提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}
		// 删除成员4
		if (m.getId4() == uId)
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			try
			{
				// 开始一个事务
				conn.setAutoCommit(false);
				// 语句1 ，删除成员id2
				stat1 = conn
						.prepareStatement("UPDATE member SET id4 = 0 WHERE main_id = ?");
				stat1.setInt(1, iId);

				stat1.executeUpdate();

				// 语句2 将拼车信息的已有人数减少1
				stat2 = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				stat2.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);

				stat2.setInt(2, iId);

				stat2.executeUpdate();
				// 提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}
		// 删除成员5
		if (m.getId5() == uId)
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			try
			{
				// 开始一个事务
				conn.setAutoCommit(false);
				// 语句1 ，删除成员id2
				stat1 = conn
						.prepareStatement("UPDATE member SET id5 = 0 WHERE main_id = ?");
				stat1.setInt(1, iId);

				stat1.executeUpdate();

				// 语句2 将拼车信息的已有人数减少1
				stat2 = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				stat2.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);

				stat2.setInt(2, iId);

				stat2.executeUpdate();
				// 提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}
		// 删除成员6
		if (m.getId6() == uId)
		{
			// 获得数据库连接
			conn = DBUtil.getConnection();
			try
			{
				// 开始一个事务
				conn.setAutoCommit(false);
				// 语句1 ，删除成员id2
				stat1 = conn
						.prepareStatement("UPDATE member SET id6 = 0 WHERE main_id = ?");
				stat1.setInt(1, iId);

				stat1.executeUpdate();

				// 语句2 将拼车信息的已有人数减少1
				stat2 = conn
						.prepareStatement("UPDATE information SET curtMember = ? WHERE id = ?");
				stat2.setInt(1, new InformationDaoImpl().findById(iId)
						.getCurtMember() - 1);

				stat2.setInt(2, iId);

				stat2.executeUpdate();
				// 提交事务
				conn.commit();
				return true;
			} catch (SQLException e)
			{
				try
				{
					// 回滚事务
					conn.rollback();
				} catch (SQLException e1)
				{
					// 异常转型
					throw new RuntimeException(e1);
				}
				// 异常转型
				throw new RuntimeException(e);
			} finally
			{
				// 关闭资源
				DBUtil.closeConnection(conn, stat1);
				DBUtil.closeConnection(conn, stat2);
			}
		}
		return false;
	}

	/**
	 * 根据拼车信息Id查找联系人信息
	 * 
	 * @author StormMaybin
	 * @param iId
	 * @return
	 */
	public ArrayList<User> queryUser(int iId)
	{
		Member m = null;
		ArrayList<User> list = null;

		// 查询出这个拼车信息的所有成员id，然后开始遍历
		m = new MemberDaoImpl().queryByMainId(iId);
		if (m != null)
		{
			list = new ArrayList<User>();
			if (m.getId1() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId1()));
			}
			if (m.getId2() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId2()));
			}
			if (m.getId3() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId3()));
			}
			if (m.getId4() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId4()));
			}
			if (m.getId5() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId5()));
			}
			if (m.getId6() != 0)
			{
				list.add(new UserDaoImpl().findById(m.getId6()));
			}
		}
		return list;
	}

	/**
	 * 根据拼车信息id，查出拼车信息的成员
	 * 
	 * @author StormMaybin
	 * @param iId
	 * @return
	 */
	public Member queryByMainId(int iId)
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
			}
			return m;
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
}