package by.krukouski.testscreator.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Krukouski Andrei on 04.04.2016.
 */
@WebFilter( urlPatterns = {"/jsp/*"})
public class SecurityFilter implements Filter {

    private String indexPath;
    public void init(FilterConfig filterConfig) throws ServletException{
        indexPath = "/index.jsp";
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + indexPath);
    }
    public void destroy(){

    }

}
