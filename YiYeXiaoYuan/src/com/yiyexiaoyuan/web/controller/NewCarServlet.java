package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.formbean.InformationForm;
import com.yiyexiaoyuan.service.InformationService;
import com.yiyexiaoyuan.service.impl.InformationServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class NewCarServlet extends HttpServlet
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
		InformationForm form = null;
		
		form = WebUtils.request2Bean(request, InformationForm.class);
		System.out.println(form.getMessage());
		System.out.println(form.toString());
		System.out.println("saggaggd"+form.getPubTime());
		if (form != null)
		{
			//设置uid
			form.setUid(new UserDaoImpl().find(form.getUserName()).getId()+"");
			System.out.println("__________________");
			System.out.println(form.toString());
			System.out.println("__________________");
			Information i = new Information();
	
		
			WebUtils.copyBean(form, i);
			
			System.out.println(i.getStartDate());
			
//			System.out.println(i);
			System.out.println("哈哈哈");
			System.out.println(i);
			if (i != null)
			{
				InformationService service = new InformationServiceImpl();
				
				//开始添加行程
				System.out.println("开始添加");
				boolean result = service.addInformationService(i);
				
				if (result)
				{
					JSONObject json = new JSONObject();
					json.accumulate("status", 1);
					response.getWriter().print(json.toString());
					response.getWriter().close();
					System.out.println("发布新拼车成功");
				}
				else
				{
					JSONObject json = new JSONObject();
					json.accumulate("status", 0);
					response.getWriter().print(json.toString());
					response.getWriter().close();
					System.out.println("发起新拼车失败");
				}
			}
		}
	}
}
