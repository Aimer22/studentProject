package com.cn.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



public class CharsetFilter implements Filter {
    private String filterName;
    private String charset;
    public void destroy() {
        System.out.println("过滤器已销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(filterName+"doFilter()");
        HttpServletRequest request = (HttpServletRequest)req;

        String uri = request.getRequestURI();
        if (uri.contains(".css") || uri.contains(".js") || uri.contains(".png")|| uri.contains(".jpg")){
            chain.doFilter(req,resp);
        }else {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {
        /*
        * 初始化方法 接受一个FilterConfig类型的参数 该参数是对Filter的一些配置
        * */
        filterName = config.getFilterName();
        charset = config.getInitParameter("charset");

        System.out.println("过滤器名称"+filterName);
        System.out.println("字符编码集"+charset);
    }

}
