package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

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
	public static Logger logger = Logger.getLogger(NewCarServlet.class);
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
		if (form != null)
		{
			//设置uid
			form.setUid(new UserDaoImpl().find(form.getUserName()).getId()+"");

			//创建information对象
			Information i = new Information();
	
			//拷贝bean
			WebUtils.copyBean(form, i);
			//如果拷贝成功的话
			if (i != null)
			{
				InformationService service = new InformationServiceImpl();
				
				//开始添加行程
			
				boolean result = service.addInformationService(i);
				
				if (result)
				{
					JSONObject json = new JSONObject();
					json.accumulate("status", 1);
					response.getWriter().print(json.toString());
					response.getWriter().close();
					logger.info("发布新拼车成功");
				}
				else
				{
					JSONObject json = new JSONObject();
					json.accumulate("status", 0);
					response.getWriter().print(json.toString());
					response.getWriter().close();
					logger.info("发布新拼车失败");
				}
			}
		}
	}
}
