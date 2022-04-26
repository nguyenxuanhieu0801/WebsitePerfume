package com.nxh.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.nxh.shop.domain.User;

@Component
public class AdminAuthenticationInterceptor implements HandlerInterceptor{
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			session.setAttribute("error", "Vui lòng đăng nhập");
			return false;
		}
		
		User user = (User) session.getAttribute("user");
		

		if(user.getRole() == 0) {
			response.sendRedirect(request.getContextPath() + "/404");
			session.setAttribute("error","Bạn không đủ quyền để truy cập");
			return false;
		}
		
		return true;
	}
	
}
