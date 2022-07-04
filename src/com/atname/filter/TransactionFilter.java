package com.atname.filter;

import com.atname.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author 1
 * @create 09-30
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
//            JdbcUtils.commitAndClose();
        } catch (Exception e) {
//            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            // 异常抛给tomcat处理
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
