package by.krukouski.testscreator.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
@WebFilter(urlPatterns = { "/*" },
    initParams = {
            @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")
    })
public class EncodingFilter implements Filter {

    static Logger logger = Logger.getLogger(EncodingFilter.class);

    private String code;
    public void init(FilterConfig filterConfig){
        code = filterConfig.getInitParameter("encoding");
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        String codeRequest = request.getCharacterEncoding();
        //setting the encoding parameters of the filter, if the encoding is not installed
        if(code != null && !code.equalsIgnoreCase(codeRequest)){
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
        }
        filterChain.doFilter(request, response);
    }
    public void destroy(){
        code = null;
    }
}
