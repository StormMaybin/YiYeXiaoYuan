package com.yiyexiaoyuan.service.impl;

import java.util.ArrayList;

import com.yiyexiaoyuan.dao.MyInformationDao;
import com.yiyexiaoyuan.dao.impl.MyInformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.MyInformationService;

/**
 * 为web层提供查询该用户所有的行程信息的服务
 * 
 * @author StormMaybin
 */
public class MyInformationServiceImpl implements MyInformationService
{

	/**
	 * 查询用户id对应的所有行程
	 * @author StormMaybin
	 * @return ArrayList
	 * @param id
	 */
	public ArrayList<Information> queryMyInformationService(int id)
	{
		MyInformationDao mdao = null;
		//创建服务
		mdao = new MyInformationDaoImpl();

		ArrayList<Information> list = null;

		list = mdao.queryMyInformation(id);
		return list;
	}
}
