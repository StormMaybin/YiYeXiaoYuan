package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.MyInformationService;
import com.yiyexiaoyuan.service.impl.MyInformationServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class MInformationServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(MInformationServlet.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 拿到用户id
		int uid = Integer.parseInt(request.getParameter("id"));

		//创建服务对象
		MyInformationService mservice = null;

		//实例化对象
		mservice = new MyInformationServiceImpl();

		ArrayList<Information> list = null;

		//查询所有的行程
		list = mservice.queryMyInformationService(uid);
		/*
		 * 测试部分
		for (Information i : list)
		{
			System.out.println(i);
		}*/
		
		if (list != null)
		{
			new JSONArray();
			//向前台传送这个list
			JSONArray json = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		}
		else
		{
			//如果没有行程信息，则返回状态码0
			JSONObject json = new JSONObject();
			json.accumulate("status", 0);
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		}
	}

}
