package com.zd.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CheckLogininterceptor extends HandlerInterceptorAdapter{
	

	private List<String> notUrl;

	public List<String> getNotUrl() {
		return notUrl;
	}

	public void setNotUrl(List<String> notUrl) {
		this.notUrl = notUrl;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getServletPath();
		if(notUrl.contains(path)) {
			return true;
		}
		Object obj = request.getSession().getAttribute("loginUser");
		if(obj != null) {
			return true;
		}else {
			response.sendRedirect("tologin");
			return false;
		}
	}
}
