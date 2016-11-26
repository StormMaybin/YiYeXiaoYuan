package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.service.MemberService;
import com.yiyexiaoyuan.service.impl.MemberServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class QueryUserServlet extends HttpServlet
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
		int iId = Integer.parseInt(request.getParameter("iId"));

		System.out.println(iId);
		MemberService mservice = new MemberServiceImpl();

		ArrayList<User> list = null;

		list = mservice.queryUserService(iId);

		if (list != null)
		{
			new JSONArray();
			JSONArray array = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());

			PrintWriter out = response.getWriter();
			out.print(array.toString());
			out.close();
		}
	}
}
