package com.yiyexiaoyuan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorFilter implements Filter
{
	String encoding = "UTF-8";

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		if (this.encoding != null)
		{
			request.setCharacterEncoding(this.encoding);

			response.setContentType("text/html;charset=" + this.encoding);
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	public void destroy()
	{
		this.encoding = null;
	}
}