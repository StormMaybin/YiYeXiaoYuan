package com.yiyexiaoyuan.service.impl;

import java.util.ArrayList;

import javax.sound.midi.MidiDevice.Info;

import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.dao.UserDao;
import com.yiyexiaoyuan.dao.impl.InformationDaoImpl;
import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.utils.ServiceUtils;

public class BusinessService
{
	private UserDao userDao = new UserDaoImpl();
	private InformationDao informationDao = new InformationDaoImpl();
	
	/**
	 * 为Web层提供注册用户服务
	 * @param u
	 * @throws UserExitException
	 */
	public void registerService (User u) throws UserExitException
	{
		//�ж��ֻ���ǲ����Ѿ�ע�����
		if (userDao.findByMobile(u.getMobile()) != null)
		{
			throw new UserExitException();
		}
		else
		{
			//�������
			u.setPassWord(ServiceUtils.md5(u.getPassWord()));
			//��ӵ���ݿ���ȥ
			userDao.add(u);
		}
	}
	/**
	 * Ϊweb���ṩ��¼����
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public User loginService (String mobile, String passWord)
	{
		//��������
		passWord = ServiceUtils.md5(passWord);
		//��ѯ�û���Ϣ
		User u = userDao.find(mobile, passWord);
		return u;
	}
	/**
	 * Ϊweb���ṩ����г���Ϣ����
	 * Servlet�Ȱ��ռ�������ݷ�װ��Information����Ȼ��
	 * ������������������г̣���ݵ�У��Ӧ����Servlet��
	 * @param i
	 * @author StormMaybin
	 */
	public void addInformationService (Information i)
	{
		InformationDao informationDao = new InformationDaoImpl();
		informationDao.add(i);
	}
	/**
	 * Ϊweb���ṩ��ѯ����ƴ����Ϣ�ķ���
	 * @return
	 */
	public ArrayList<Information> queryInformationService ()
	{
		ArrayList<Information> list = null;
		InformationDao informationDao = new InformationDaoImpl();
		
		list = informationDao.queryInformation();
		return list;
	}
}
