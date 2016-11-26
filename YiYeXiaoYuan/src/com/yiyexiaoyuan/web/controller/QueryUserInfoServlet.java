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

import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.service.UserInfoService;
import com.yiyexiaoyuan.service.impl.UserInfoServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class QueryUserInfoServlet extends HttpServlet
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
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		
		int uId = Integer.parseInt(request.getParameter("uId"));
		
		UserInfoService service = new UserInfoServiceImpl();
		ArrayList<UserInfo> list = null;
		
		list = service.queryUserInfoService(uId);
		if (list != null)
		{
			new JSONArray();
			JSONArray array = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());

			PrintWriter out = response.getWriter();
			out.print(array.toString());
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
