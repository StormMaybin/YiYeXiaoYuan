package com.yiyexiaoyuan.web.controller;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;
import java.io.IOException;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		System.out.println("进来了");
		InformationService service = new InformationService();

		ArrayList<Information> list = service.queryInformationService();
		System.out.println(list.size());
		HttpSession session = request.getSession();
//		if (session.getAttribute("list") != null)
//		{
//			session.invalidate();
//			request.getSession().setAttribute("list", list);
//		}
//		else
//		{
//			request.getSession().setAttribute("list", list);
//		}
		session.setAttribute("list", list);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}