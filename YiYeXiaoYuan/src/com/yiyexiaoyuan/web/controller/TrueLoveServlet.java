package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.yiyexiaoyuan.dao.impl.UserDaoImpl;
import com.yiyexiaoyuan.domain.UserInfo;
import com.yiyexiaoyuan.formbean.TrueLoveForm;
import com.yiyexiaoyuan.service.UserInfoService;
import com.yiyexiaoyuan.service.impl.UserInfoServiceImpl;
import com.yiyexiaoyuan.utils.WebUtils;

public class TrueLoveServlet extends HttpServlet
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

	/**
	 * 处理Post请求
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// request to formBean
		TrueLoveForm form = null;

		form = WebUtils.request2Bean(request, TrueLoveForm.class);
		// 测试
		// System.out.println(form.toString());

		UserInfo userInfo = new UserInfo();
		// copy bean
		WebUtils.copyBean(form, userInfo);

		// System.out.println(new
		// UserDaoImpl().findByMobile(form.getMobile()).getId());
		userInfo.setId(new UserDaoImpl().findByMobile(form.getMobile()).getId());

		if (userInfo != null)
		{

			System.out.println(userInfo);

			// 开始调用服务添加购票信息
			UserInfoService service = new UserInfoServiceImpl();
			boolean result = service.addService(userInfo);

			if (result)
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", 1);
				response.getWriter().print(json.toString());
				response.getWriter().close();
			} else
			{
				JSONObject json = new JSONObject();
				json.accumulate("status", 0);
				response.getWriter().print(json.toString());
				response.getWriter().close();
			}
		}
	}

}
