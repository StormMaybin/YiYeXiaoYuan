package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.formbean.RegisterForm;
import com.yiyexiaoyuan.service.impl.UserService;
import com.yiyexiaoyuan.utils.WebUtils;

public class RegisterServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("开始");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println(request.getParameter("type"));
		if (request.getParameter("type").equals((2 + "")))
		{
			System.out.println("type 2");
			request.getRequestDispatcher("AlterPassWordServlet").forward(request, response);
		} 
		else if (request.getParameter("type").equals((3 + "")))
		{
			System.out.println("type 3");
			request.getRequestDispatcher("ResetPassWordServlet").forward(request, response);
		} 
		else
		{
			System.out.println("type 1");
			request.setCharacterEncoding("UTF-8");
			UserService service = null;

			// 把request传过来的值封装成formBean
			RegisterForm form = WebUtils.request2Bean(request,
					RegisterForm.class);
			System.out.println(form.getMobile() + " " + form.getPassWord());
			// 如果传进来的值是正确的
			if (form != null && form.getMobile() != null
					&& form.getPassWord() != null)
			{
				// 拷贝bean
				// RegisterBean to UserBean
				User user = new User();
				WebUtils.copyBean(form, user);

				if (user.getMobile() != null && user.getPassWord() != null)
				{
					// 开始注册
					try
					{
						service = new UserService();
						// 调用注册服务
						boolean result = service.registerService(user);
						if (result)
						{
							JSONObject json = new JSONObject();
							json.accumulate("type", 1);
							json.accumulate("status", 1);
							PrintWriter out = response.getWriter();
							out.print(json.toString());
							out.close();
						} 
						else
						{
							JSONObject json = new JSONObject();
							json.accumulate("type", 1);
							json.accumulate("status", 0);
							PrintWriter out = response.getWriter();
							out.print(json.toString());
							out.close();
						}
					}
					// 注册手机号码已经存在不能注册
					catch (UserExitException e)
					{
						// 处理手机号码已经存在的情况
						JSONObject json = new JSONObject();
						json.accumulate("status", 0);
						PrintWriter out = response.getWriter();
						out.print(json.toString());
						out.close();
						return;
					}
				}
			}
		}

	}

}
