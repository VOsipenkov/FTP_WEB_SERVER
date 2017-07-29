package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RemoteAddressFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HeaderSetterWrapper headerSetterWrapper =  new HeaderSetterWrapper((HttpServletRequest)request);
       headerSetterWrapper.addHeader("ip_client", request.getRemoteAddr());

       chain.doFilter(headerSetterWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
