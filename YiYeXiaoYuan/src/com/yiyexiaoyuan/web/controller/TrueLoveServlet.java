package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.formbean.TrueLoveForm;
import com.yiyexiaoyuan.service.impl.UserInfoService;
import com.yiyexiaoyuan.utils.WebUtils;

public class TrueLoveServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//request to formBean
		TrueLoveForm form = null;
		
		form = WebUtils.request2Bean(request, TrueLoveForm.class);
		
		UserInfo userInfo = null;
		//copy bean
		WebUtils.copyBean(form, userInfo);
		userInfo.setId(new UserDaoImpl().findByMobile(form.getMobile()).getId());
		
		if (userInfo != null)
		{
			/**
			 * 测试
			 * 
			 */
			System.out.println(userInfo);
			//开始调用服务添加购票信息
			UserInfoService service = new UserInfoService();
			boolean result = service.addService(userInfo);
			System.out.println(result == true ? "购票成功" : "购票失败");
		}
	}

}
