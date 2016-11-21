package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.BusinessService;

/**
 * 处理index.jsp的请求
 * @author StormMaybin
 *
 */
public class IndexServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		//拿到Web层的服务对象
		BusinessService service = new BusinessService();
		
		//查询所有的拼车信息
		ArrayList<Information> list = service.queryInformationService();
		
		//数据设置到session域中
		request.getSession().setAttribute("list", list);
		
		//带着数据跳转到主页去
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}
