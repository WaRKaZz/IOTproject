package filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

public class UserFilter implements Filter {
    Map<String, Integer> AUTH_MAP = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        AUTH_MAP
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
