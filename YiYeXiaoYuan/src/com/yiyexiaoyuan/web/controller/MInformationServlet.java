package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
//		System.out.println("请求开始");
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		// 拿到用户id
		int uid = Integer.parseInt(request.getParameter("id"));
		System.out.println(uid);

		MyInformationService mservice = null;

		mservice = new MyInformationServiceImpl();

		ArrayList<Information> list = null;

		list = mservice.queryMyInformationService(uid);
		
		for (Information i : list)
		{
			System.out.println(i);
		}
		
		if (list != null)
		{
			new JSONArray();
			JSONArray json = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		}
		else
		{
			JSONObject json = new JSONObject();
			json.accumulate("status", 0);
			
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		}
	}

}
