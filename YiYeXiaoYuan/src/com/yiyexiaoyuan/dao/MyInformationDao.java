package com.yiyexiaoyuan.dao;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.Information;

public interface MyInformationDao
{

	/**
	 * 按照用户id查找他的所有行程信息
	 * @param id
	 * @return
	 */
	public abstract ArrayList<Information> queryMyInformation(int id);

}