package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.service.impl.UserService;
import com.yiyexiaoyuan.utils.WebUtils;

public class SetQQServlet extends HttpServlet
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
		//创建服务对象
		UserService service = new UserService();
		
		User user = null;
		user = WebUtils.request2Bean(request, User.class);
		if (user != null)
		{
			boolean result = service.updateQqService(user);
			if (result)
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", 1);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.close();
				return;
			}
			else
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", 0);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.close();
				return;
			}
		}
		else
		{
			JSONObject json = new JSONObject();
			json.accumulate("status", 0);
			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
			return;
		}
	}

}
