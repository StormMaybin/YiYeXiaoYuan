package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.service.SendMessageService;
import com.yiyexiaoyuan.service.impl.SendMessageServiceImpl;

public class ValidateServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//得到要发送验证码的手机号码
		String mobile = request.getParameter("mobile");
		PrintWriter out = response.getWriter();
		SendMessageService service = new SendMessageServiceImpl();
		
		String code = null;
		code = service.sendMessage(mobile);
		
		JSONObject json = new JSONObject();
		json.accumulate("checkCode", code);
		out.print(json.toString());
		out.close();
		return ;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}
