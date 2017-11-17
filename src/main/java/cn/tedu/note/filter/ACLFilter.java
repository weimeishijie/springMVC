package cn.tedu.note.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mj on 2017/11/17.
 *
 */
public class ACLFilter implements Filter {

    FilterConfig filterConfig;

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String URL = request.getRequestURL().toString();
        System.out.println("URL: "+URL);

        int status = response.getStatus();
        System.out.println("response: "+status);

        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {
        filterConfig = null;
    }
}
