package com.locals.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.locals.controller.LoginController;

@Component
public class SessionValidator extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (!(((HandlerMethod) handler).getBean() instanceof LoginController)) {

			if (session == null || session.getAttribute("UserInfo") == null) {
				response.sendRedirect("/login");
				return false;
			}
		}
		return true;
	}
}
