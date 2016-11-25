package com.yiyexiaoyuan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.yiyexiaoyuan.dao.MyInformationDao;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.utils.DBUtil;

public class MyInformationDaoImpl implements MyInformationDao
{
	/**
	 * 按照用户id查找他的所有行程信息
	 * @param id
	 * @return
	 */
	public ArrayList<Information> queryMyInformation (int id)
	{
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet result = null;
		ArrayList<Information> list = null;
		
		try
		{
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement("SELECT * FROM information JOIN member " +
					"ON information.id=member.main_id AND " +
					"information.uid=member.id1 WHERE member.id1 = ? OR member.id2 = ? OR member.id3=?" +
					" OR member.id4=? OR member.id5=? OR member.id6=?");
			
			stat.setInt(1, id);
			stat.setInt(2, id);
			stat.setInt(3, id);
			stat.setInt(4, id);
			stat.setInt(5, id);
			stat.setInt(6, id);
			
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
				i.setStartTime_min_hour(result.getString("startTime_min_hour"));
				i.setStartTime_min_min(result.getString("startTime_min_min"));
				i.setStartTime_max_hour(result.getString("startTime_max_hour"));
				i.setStartTime_max_min(result.getString("startTime_max_min"));
				i.setMaxMember(result.getInt("maxMember"));
				i.setCurtMember(result.getInt("curtMember"));
				i.setMessage(result.getString("message"));
				i.setPubTime(result.getDate("pubTime"));

				//添加到集合中去
				list.add(i);
			}
			//按照发布日期进行排序
			Collections.sort(list);
			//返回
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
}
