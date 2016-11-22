package com.yiyexiaoyuan.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yiyexiaoyuan.domain.User;
import com.yiyexiaoyuan.exception.UserExitException;
import com.yiyexiaoyuan.formbean.RegisterForm;
import com.yiyexiaoyuan.service.impl.UserService;
import com.yiyexiaoyuan.utils.WebUtils;

public class RegisterServlet extends HttpServlet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		System.out.println("开始");
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		UserService service = null;
		
		//把request传过来的值封装成formBean
		RegisterForm form = WebUtils.request2Bean(request, RegisterForm.class);
		
		//如果传进来的值是正确的
		if (form != null && form.getMobile() != null && form.getPassWord() != null)
		{
			//拷贝bean
			//RegisterBean to UserBean
			User user = new User();
			WebUtils.copyBean(form, user);
			
			if (user.getMobile() != null && user.getPassWord() != null)
			{
				//开始注册
				try
				{
					service.registerService(user);
				} 
				//注册手机号码已经存在不能注册
				catch (UserExitException e)
				{
					// 处理手机号码已经存在的情况
					e.printStackTrace();
				}
			}
		}
	}	

}
