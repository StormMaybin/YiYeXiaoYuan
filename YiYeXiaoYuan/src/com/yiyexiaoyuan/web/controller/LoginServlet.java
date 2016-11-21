package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 处理登录请求的
 * @author StormMaybin
 */
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
		//创建web层的用户登录服务
		//获取表单数据通过request域
		//用户的手机号码
		String mobile = request.getParameter("mobile");
		//用户的密码
		String passWord = request.getParameter("passWord");
		//用户填写的验证码
		String checkCode = request.getParameter("checkCode");
	}
	
}
