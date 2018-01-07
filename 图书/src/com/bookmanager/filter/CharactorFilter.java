package com.bookmanager.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharactorFilter
 */
@WebFilter
(
		urlPatterns= {"/*"},
		filterName="CharactorFilter",
		initParams= {@WebInitParam(name="Encoding",value="utf-8")}
)
public class CharactorFilter implements Filter {
	
	private FilterConfig fConfig;

    /**
     * Default constructor. 
     */
    public CharactorFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding = fConfig.getInitParameter("Encoding");
		HttpServletRequest req =(HttpServletRequest)request;
		String method = req.getMethod();
		if("post".equalsIgnoreCase(method)) {
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fConfig = fConfig;
	}

}
