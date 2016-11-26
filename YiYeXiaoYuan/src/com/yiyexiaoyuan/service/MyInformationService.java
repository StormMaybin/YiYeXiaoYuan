package com.yiyexiaoyuan.service;

import java.util.ArrayList;

import com.yiyexiaoyuan.domain.Information;

public interface MyInformationService
{
	/**
	 * 查询用户id对应的所有行程
	 * @author StormMaybin
	 * @return ArrayList
	 * @param id
	 */
	public abstract ArrayList<Information> queryMyInformationService(int id);

}