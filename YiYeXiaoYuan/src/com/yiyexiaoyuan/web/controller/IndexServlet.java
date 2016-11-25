package com.yiyexiaoyuan.web.controller;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;
import com.yiyexiaoyuan.utils.WebUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

public class IndexServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println("请求");
		response.setContentType("application/json; charset=utf-8");
		//设置编码格式
		request.setCharacterEncoding("UTF-8");

		//创建服务对象
		InformationService service = new InformationService();
		
		//创建集合对象
		ArrayList<Information> list = service.queryInformationService();
		
		//开始查询
		list = service.queryInformationService();
		new JSONArray();
		
		//创建JSON数组，因为list这个bean中有Date类型数据，必须给一个
		//JsonConfig对象进行转换，不然会抛出异常
		JSONArray json = JSONArray.fromObject(list, 
				WebUtils.getJsonConfig());
		
		PrintWriter out = response.getWriter();
		out.print(json.toString());
		out.close();
		
		System.out.println(json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}