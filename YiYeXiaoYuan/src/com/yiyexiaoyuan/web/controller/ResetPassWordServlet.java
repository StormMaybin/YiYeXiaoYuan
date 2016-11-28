package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.service.UserService;
import com.yiyexiaoyuan.service.impl.UserServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class ResetPassWordServlet extends HttpServlet
{

	/**
	 * 
	 */
	public static Logger logger = Logger.getLogger(ResetPassWordServlet.class);
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//创建User对象 
		User u = null;
		//创建服务对象
		UserService service = null;
		
		u = WebUtils.request2Bean(request, User.class);
		
		if (u != null)
		{
			service = new UserServiceImpl();
			//开始重置密码
			boolean result = service.resetPassWordService(u, u.getPassWord());
			if (result)
			{
				JSONObject json = new JSONObject();
				json.accumulate("type", 3);
				PrintWriter out = response.getWriter();
				out.print(json.toString());
				out.close();
				return;
			}
			else//重置失败
			{
				logger.error("重置密码失败");
			}
		}
	}
}
