package com.nxh.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class ClientAuthenticationInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			session.setAttribute("error", "Vui lòng đăng nhập");
			return false;
		}
	
		return true;
	}
}
