package com.yiyexiaoyuan.service;

public interface JoinService
{

	/**
	 * 为web层提供报名服务
	 * @author StormMaybin
	 * @return boolean
	 * @param iId, uId
	 */
	public abstract boolean signUpInformationService(int iId, int uId);

}