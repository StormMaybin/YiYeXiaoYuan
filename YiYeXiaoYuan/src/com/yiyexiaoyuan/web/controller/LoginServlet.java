package com.yiyexiaoyuan.web.controller;

import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.formbean.LoginForm;
import com.yiyexiaoyuan.service.impl.UserService;
import com.yiyexiaoyuan.utils.WebUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;

public class LoginServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("application/json; charset=utf-8");

		System.out.println("第一次处理提交");

		User user = null;
		LoginForm form = new LoginForm();
		UserService service = new UserService();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();

		System.out.println(request.getParameter("mobile   "
				+ request.getParameter("passWord")));

		form = (LoginForm) WebUtils.request2Bean(request, LoginForm.class);
		System.out.println(form);

		user = service.loginService(form.getMobile(), form.getPassWord());

		if (user != null)
		{
			request.getSession().setAttribute("user", user);
			System.out.println("登录成功");
			System.out.println(user.toString());
			json.accumulate("user", user);
			json.accumulate("status", 1);
			int isOk;
			if (new UserDaoImpl().isCanUpdateUserName(user))
			{
				isOk = 0;
			}
			else
			{
				isOk = 1;
			}
			json.accumulate("nameChange", isOk);
			System.out.println(isOk);
			out.print(json.toString());
			out.close();
			return;
		}
		if (user == null)
		{
			System.out.println("user为空");
			if (service.isExitMobile(form.getMobile()))
			{
				System.out.println("0");
				json.accumulate("status", 0);
				out.print(json.toString());
				out.close();
				return;
			}

			System.out.println("-1");
			json.accumulate("status", -1);
			out.print(json.toString());
			out.close();
			return;
		}
	}
}