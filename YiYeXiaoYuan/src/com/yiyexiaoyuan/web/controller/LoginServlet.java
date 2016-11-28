package com.yiyexiaoyuan.web.controller;

import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.formbean.LoginForm;
import com.yiyexiaoyuan.service.UserService;
import com.yiyexiaoyuan.service.impl.UserServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONObject;

public class LoginServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger logger = Logger.getLogger(LoginServlet.class);
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("application/json; charset=utf-8");

		User user = null;
		LoginForm form = new LoginForm();
		UserService service = new UserServiceImpl();
		PrintWriter out = response.getWriter();
		JSONObject json = new JSONObject();


		form = (LoginForm) WebUtils.request2Bean(request, LoginForm.class);

		user = service.loginService(form.getMobile(), form.getPassWord());

		if (user != null)
		{
			//登录成功的话，设置session域中存储这个user对象
			request.getSession().setAttribute("user", user);
			//向前台返回这个user对象
			json.accumulate("user", user);
			//向前台返返回登录成功的状态码
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
			//向前台返回是否可以修改用户名的权限状态码
			json.accumulate("nameChange", isOk);
			out.print(json.toString());
			out.close();
			return;
		}
		//说明登录失败
		if (user == null)
		{
			//表示由这个手机号，但是密码错误
			if (service.isExitMobile(form.getMobile()))
			{
				System.out.println("0");
				json.accumulate("status", 0);
				out.print(json.toString());
				out.close();
				return;
			}
			else//表示此手机号没有注册
			{
				json.accumulate("status", -1);
				out.print(json.toString());
				out.close();
				return;
			}
		}
	}
}