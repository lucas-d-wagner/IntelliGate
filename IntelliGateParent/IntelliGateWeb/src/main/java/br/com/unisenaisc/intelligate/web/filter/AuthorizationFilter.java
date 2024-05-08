package br.com.unisenaisc.intelligate.web.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		boolean isLoginPage = isLoginPageRequest(httpServletRequest);
		boolean isUserLogged = isUserLogged(httpServletRequest);
		
		if(!isUserLogged && !isLoginPage) {
			redirectToLogin(httpServletRequest, httpServletResponse);
			return;
		}
		if (isLoginPage && isUserLogged) {
			redirectToIndex(httpServletRequest, httpServletResponse);
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	private boolean isLoginPageRequest(HttpServletRequest httpServletRequest) {
		String requestURI = httpServletRequest.getRequestURI();
		return (requestURI.endsWith("VendaRapidaWeb") ||
				requestURI.endsWith("VendaRapidaWeb/") ||
		        requestURI.endsWith("/login.xhtml"));
	}
	
	private boolean isUserLogged(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession(true);
		return Objects.nonNull(httpSession.getAttribute("token"));
	}
	
	public void redirectToLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		String contextPath = getContextPath(httpServletRequest);
		httpServletResponse.sendRedirect(contextPath + "/login.xhtml");
	}
	
	public void redirectToIndex(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
		String contextPath = getContextPath(httpServletRequest);
		httpServletResponse.sendRedirect(contextPath + "/index.xhtml");
	}
	
	private String getContextPath(HttpServletRequest httpServletRequest) {
		ServletContext servletContext = httpServletRequest.getSession().getServletContext();
		return servletContext.getContextPath();
	}

}
