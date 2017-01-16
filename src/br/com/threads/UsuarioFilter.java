package br.com.threads;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UsuarioFilter implements Filter {
	
	    public static ThreadLocal<String> usuario = new ThreadLocal<>();
	
	       public void init(FilterConfig filterConfig) throws ServletException{}
	       public void destroy() {}
	
	
	       public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
	        HttpServletRequest request = (HttpServletRequest) req;
	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            usuario.set((String) session.getAttribute("usuario"));
	        }
	          chain.doFilter(request, response);
	       }
	}

