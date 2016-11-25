package com.yiyexiaoyuan.junit.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.junit.Test;

import com.yiyexiaoyuan.domain.Information;
import com.yiyexiaoyuan.service.impl.InformationService;

public class jsonTest
{
	private static final JsonConfig jsonConfig = init();

	@Test
	public void test() throws JSONException
	{
		// InformationService service = new InformationService();

		// ArrayList<Information> list = service.queryInformationService();

		// JSONObject json = new JSONObject();
		// json.accumulate("list", list);
		// JSONArray json = new JSONArray().fromObject(list);
		// System.out.println(json);

//		UserInfoService service = new UserInfoService();
//		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
//
//		list = service.queryUserInfoService();
//		JSONArray json = new JSONArray().fromObject(list,jsonConfig);
//		System.out.println(json);
		
		InformationService service = new InformationService();
		ArrayList<Information> list = service.queryInformationService();
		
		list = service.queryInformationService();
		new JSONArray();
		JSONArray json = JSONArray.fromObject(list, jsonConfig);
		System.out.println(json);
	}

	private static JsonConfig init()
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
}
