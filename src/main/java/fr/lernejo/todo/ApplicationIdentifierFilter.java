package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class ApplicationIdentifierFilter implements javax.servlet.Filter {
    private String uuid;

    public ApplicationIdentifierFilter() {
        this.uuid = String.valueOf(UUID.randomUUID());
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse wResponse = (HttpServletResponse) servletResponse;

        wResponse.addHeader("Instance-Id", uuid);
        filterChain.doFilter(servletRequest, wResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
