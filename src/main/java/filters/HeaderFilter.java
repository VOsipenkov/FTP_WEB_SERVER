package filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by vlos0217 on 22.06.2017.
 */

public class HeaderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //todo add some headers
        int i = 1;
    }

    @Override
    public void destroy() {

    }
}
