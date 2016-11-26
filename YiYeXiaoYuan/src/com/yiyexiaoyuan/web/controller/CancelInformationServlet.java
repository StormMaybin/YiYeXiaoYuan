package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.service.MemberService;
import com.yiyexiaoyuan.service.impl.MemberServiceImpl;

public class CancelInformationServlet extends HttpServlet
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
		System.out.println("请求开始");
		// 设置编码格式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		//拼车信息id
		int iId = Integer.parseInt(request.getParameter("iId"));
		//用户id
		int uId = Integer.parseInt(request.getParameter("uId"));
		
		System.out.println(iId+"  "+uId);
		//创建服务对象
		MemberService mservice = new MemberServiceImpl();
		
		boolean result;
		result = mservice.removeMemberService(uId, iId);
		
		if (result)
		{
			JSONObject json = new JSONObject();
			json.accumulate("status", 1);
			response.getWriter().print(json.toString());
			response.getWriter().close();
			System.out.println("取消成功");
		}
		else
		{
			JSONObject json = new JSONObject();
			json.accumulate("status", 0);
			response.getWriter().print(json.toString());
			response.getWriter().close();
			System.out.println("取消失败");
		}
	}
}
