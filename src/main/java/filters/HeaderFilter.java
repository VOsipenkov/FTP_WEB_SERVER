package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HeaderSetterWrapper customRequest = new HeaderSetterWrapper((HttpServletRequest)servletRequest);
        customRequest.addHeader("app", "FTP_WEB_SERVER");
        filterChain.doFilter(customRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
