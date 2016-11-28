package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import net.sf.json.JSONArray;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.InformationService;
import com.yiyexiaoyuan.service.impl.InformationServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class StartDateServlet extends HttpServlet
{

	/**
	 * 
	 */
	public static Logger logger = Logger.getLogger(StartDateServlet.class);
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("application/json; charset=utf-8");
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		
		String startDate = request.getParameter("startDate");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		InformationService service = new InformationServiceImpl();

		ArrayList<Information> list = null;
		try
		{
			list = service.queryByStartDateService(sdf.parse(startDate));

			JSONArray json = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());

			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
		} 
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			logger.error(e);
			throw new RuntimeException(e);
		}
	}
}
