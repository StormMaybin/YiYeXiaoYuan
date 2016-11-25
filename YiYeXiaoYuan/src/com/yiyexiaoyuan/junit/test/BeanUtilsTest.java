package com.yiyexiaoyuan.junit.test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.yiyexiaoyuan.utils.WebUtils;

public class BeanUtilsTest
{
	@Test
	public void test() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
	{
		UserForm form = new UserForm();
		form.setId("2");
		form.setName("StormMa");
		form.setPass("123456");
		
		User u = new User();
		
		WebUtils.copyBean(form, u);
//		BeanUtils.copyProperties(u, form);
//		PropertyUtils.copyProperties(u, form);
		
		
//		BeanUtils.setProperty(u, "name", "Qiqi");
		System.out.println(form.toString());
		System.out.println(u.toString());
	}
}

