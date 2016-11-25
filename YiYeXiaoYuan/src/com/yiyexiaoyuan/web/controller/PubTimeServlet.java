package com.yiyexiaoyuan.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;
import com.yiyexiaoyuan.utils.WebUtils;

public class PubTimeServlet extends HttpServlet
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
		response.setContentType("application/json; charset=utf-8");
		//设置编码格式
		request.setCharacterEncoding("UTF-8");
		
		String pubTime = request.getParameter("pubTime");

		System.out.println("pubTime:"+pubTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		InformationService service = new InformationService();

		ArrayList<Information> list = null;
		try
		{
			list = service.queryByPubTimeService(sdf.parse(pubTime));

			JSONArray json = JSONArray.fromObject(list,
					WebUtils.getJsonConfig());

			PrintWriter out = response.getWriter();
			out.print(json.toString());
			out.close();
			System.out.println(json);
		} 
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
