package com.yiyexiaoyuan.junit.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4jTest
{
	static Logger logger;
	static {
		logger = Logger.getLogger(Log4jTest.class);
		PropertyConfigurator.configure("src/log4j.properties");
	}
	
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("src/log4j.properties");
		logger.info("hahhaha");
		logger.error("数据库错误");
	}
}
