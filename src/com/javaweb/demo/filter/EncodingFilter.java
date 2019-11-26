package com.javaweb.demo.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public EncodingFilter(){
        System.out.println("过滤器构造");
    }
    @Override
    public void  init(FilterConfig filterConfig) throws ServletException{
        System.out.println("过滤器初始化");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,FilterChain filterChain)throws ServletException, IOException{
        servletRequest.setCharacterEncoding("utf-8"); //将编码改为utf-8
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

}
