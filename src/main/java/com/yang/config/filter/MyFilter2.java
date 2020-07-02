package com.yang.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter2 implements Filter {


    private static final  Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("初始化过滤器2："+filterConfig.getFilterName());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("过滤器2开始对请求进行预处理！");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        System.out.println("请求的接口2为："+url);
        long startTime = System.currentTimeMillis();
        //通过filter方法实现过滤
        filterChain.doFilter(servletRequest,servletResponse);
        //上面的 doFilter 方法执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        System.out.println("该用户的请求已经处理完毕，请求花费的时间为2：" + (endTime - startTime));
    }

    @Override
    public void destroy() {
        System.out.println("销毁容器2");
    }
}
