package com.yiyexiaoyuan.junit.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4jTest
{
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	
	
	public static void main(String[] args)
	{
		PropertyConfigurator.configure("log4j.properties");
		logger.warn("hahhaha");
	}
}
