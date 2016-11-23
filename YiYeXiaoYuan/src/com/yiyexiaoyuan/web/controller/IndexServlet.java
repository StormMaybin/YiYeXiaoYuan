package com.yiyexiaoyuan.web.controller;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;
import com.yiyexiaoyuan.utils.ServiceUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class IndexServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("application/json; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
//		System.out.println("进来了");
//		InformationService service = new InformationService();
//
//		ArrayList<Information> list = service.queryInformationService();
//		System.out.println(list.size());
//		HttpSession session = request.getSession();
////		if (session.getAttribute("list") != null)
////		{
////			session.invalidate();
////			request.getSession().setAttribute("list", list);
////		}
////		else
////		{
////			request.getSession().setAttribute("list", list);
////		}
//		session.setAttribute("list", list);
//		return;
		
		
		InformationService service = new InformationService();
		ArrayList<Information> list = service.queryInformationService();
		
		list = service.queryInformationService();
		JSONArray json = new JSONArray().fromObject(list, 
				IndexServlet.getJsonConfig());
		
		response.getWriter().print(json.toString());
		System.out.println(json);
	}

	private static JsonConfig getJsonConfig()
	{
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new JsonValueProcessor()
				{
					private SimpleDateFormat sd = new SimpleDateFormat(
							"yyyy-MM-dd");

					public Object processObjectValue(String key, Object value,
							JsonConfig jsonConfig)
					{
						return value == null ? "" : sd.format(value);
					}

					public Object processArrayValue(Object value,
							JsonConfig jsonConfig)
					{
						return null;
					}
				});
		return jsonConfig;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}