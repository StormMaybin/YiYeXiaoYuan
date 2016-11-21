package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		//对表单提交的数据进行合法性校验
		
		//如果校验失败，跳转表单页，回显错误信息，错误封装到一个对象中
		
		//如果校验成功，调用服务进行注册
		
		//
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
	}	

}
