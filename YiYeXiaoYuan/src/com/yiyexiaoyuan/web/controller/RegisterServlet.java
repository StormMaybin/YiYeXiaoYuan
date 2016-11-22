package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiyexiaoyuan.formbean.RegisterForm;
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
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		//对表单提交的数据进行合法性校验
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		//如果校验失败，跳转表单页，回显错误信息，错误封装到一个对象中
		
		//如果校验成功，调用服务进行注册
		
		//
	}	

}
