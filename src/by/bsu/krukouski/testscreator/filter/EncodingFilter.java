package by.bsu.krukouski.testscreator.filter;

import by.bsu.krukouski.testscreator.exception.ResourceIOException;
import by.bsu.krukouski.testscreator.exception.ResourceServletException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
@WebFilter(urlPatterns = { "/*" },
    initParams = {
            @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")
    })
public class EncodingFilter implements Filter {
    private String code;
    public void init(FilterConfig filterConfig){
        code = filterConfig.getInitParameter("encoding");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain){
        try {
            String codeRequest = request.getCharacterEncoding();
            //установка кодировки из параметров фильтра, ели кодировка не установлена
            if(code != null && !code.equalsIgnoreCase(codeRequest)){
                request.setCharacterEncoding(code);
                response.setCharacterEncoding(code);
            }
            filterChain.doFilter(request, response);
        }catch (IOException e){
            new ResourceIOException(e);
        }catch (ServletException e){
            new ResourceServletException(e);
        }
    }
    public void destroy(){
        code = null;
    }
}
