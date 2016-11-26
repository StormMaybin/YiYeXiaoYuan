package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.dao.InformationDao;
import com.yiyexiaoyuan.dao.impl.InformationDaoImpl;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.JoinService;
import com.yiyexiaoyuan.service.MyInformationService;
import com.yiyexiaoyuan.service.impl.JoinServiceImpl;
import com.yiyexiaoyuan.service.impl.MyInformationServiceImpl;

public class SignUpInformationServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int iId = Integer.parseInt(request.getParameter("iId"));
		int uId = Integer.parseInt(request.getParameter("uId"));

		int isOk = checked(iId, uId);
		//不符合报名，开始向前台返回数据
		if (isOk != 1)
		{
			JSONObject json = new JSONObject();
			json.accumulate("status", isOk);
			response.getWriter().print(json.toString());
			response.getWriter().close();
		}
		else//符合报名，开始报名
		{
			//开始创建服务对象
			JoinService jservice = new JoinServiceImpl();
			boolean result = jservice.signUpInformationService(iId, uId);
			if (result)
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", 1);
				System.out.println("报名成功");
				response.getWriter().print(json.toString());
				response.getWriter().close();
			}
			else
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", -1);
				System.out.println("报名失败");
				response.getWriter().print(json.toString());
				response.getWriter().close();
			}
		}
	}

	/**
	 * 校验数据是否可以正常报名
	 * 
	 * @author StormMaybin
	 * @param iId
	 *            uId
	 * @return boolean
	 */
	public static int checked(int iId, int uId)
	{
		//创建一个查询个人行程的服务
		MyInformationService mservice = new MyInformationServiceImpl();
		ArrayList<Information> list = null;
		//查询出这个用户的所有行程
		list = mservice.queryMyInformationService(uId);
		if (list == null)
		{
			return 1;
		}
		else
		{
			InformationDao idao = new InformationDaoImpl();
			Information i = idao.queryInformationById(iId);
			
			//判断是否已经报名过该行程,如果已报名，那么直接返回-1
			for (Information info : list)
			{
				if (info.getId() == iId)
				{
					System.out.println(info.getId()+"---"+iId);
					//已报名成功
					return -1;
				}
			}
			//开始比较
			Date startDate = i.getStartDate();
			String startPos = i.getStartPos();
			for(Information in : list)
			{
				if (in.getStartDate().compareTo(startDate) == 0)
				{
					if (in.getStartPos().equals(startPos))
					{
						return 0;
					}
				}
			}
			return 1;
		}
	}
}
