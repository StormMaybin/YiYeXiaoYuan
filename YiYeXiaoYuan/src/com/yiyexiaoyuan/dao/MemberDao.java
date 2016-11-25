package com.yiyexiaoyuan.dao;

public abstract interface MemberDao
{
	/**
	 * 为iId这个拼车信息添加uId这个用户
	 * @param iId 拼车信息id
	 * @param uId 用户id
	 * @return boolean
	 * 添加成功返回true 反之返回false
	 */
	public abstract boolean addMember(int iId, int uId);
	
	/**
	 * 删除某个拼车信息的某个成员
	 * 
	 * @author StormMaybin
	 * @return
	 * @param uId iId
	 */
	public abstract boolean removeMember(int uId, int iId);
}
