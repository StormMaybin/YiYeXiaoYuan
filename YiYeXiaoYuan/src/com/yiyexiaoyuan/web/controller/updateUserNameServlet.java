package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.CannotAlterUserNameException;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.service.impl.UserService;
import com.yiyexiaoyuan.utils.WebUtils;

public class updateUserNameServlet extends HttpServlet
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
		User u = null;
		u = WebUtils.request2Bean(request, User.class);
		
		if (u != null)
		{
			System.out.println(u.getMobile()+"  "+u.getUserName());
			UserService service = new UserService();
			
			try
			{
				boolean result = service.updateUserNameService(u, u.getUserName());
				/**
				 * 返回状态吗码
				 */
				PrintWriter out = response.getWriter();
				// 用户名已存在
				JSONObject json = new JSONObject();
				json.accumulate("status", 1);
				out.print(json.toString());
				out.close();
				
				System.out.println(result);
			} 
			catch (CannotAlterUserNameException e)
			{
				// 处理没有修改权限的情况
				System.out.println("不能修改");
			} 
			catch (UserExitException e)
			{
				PrintWriter out = response.getWriter();
				// 用户名已存在
				JSONObject json = new JSONObject();
				json.accumulate("status", 0);
				out.print(json.toString());
				out.close();
			}
		}
	}
}
