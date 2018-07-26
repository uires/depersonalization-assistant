package org.depersonalizationAssistant.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuditionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getRequestURI().endsWith("logar") || request.getRequestURI().endsWith("login")
				|| request.getRequestURI().endsWith("sobre") || request.getRequestURI().contains("resources")) {
			return true;
		}
		if (request.getRequestURI().endsWith("cadastro")) {
			response.sendRedirect("/");
		}
		if ((request.getSession().getAttribute("usuario.logado") != null)
				&& request.getRequestURI().endsWith("login")) {
			response.sendRedirect("/dashboard");
		}
		if (request.getSession().getAttribute("usuario.logado") != null) {
			return true;
		} else {
			response.sendRedirect("paciente/login");

			return false;
		}

	}

}
