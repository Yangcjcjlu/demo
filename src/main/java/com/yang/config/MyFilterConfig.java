package com.yang.config;

import com.yang.config.filter.MyFilter;
import com.yang.config.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;

    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> setUpFilter(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setOrder(2);

        filterRegistrationBean.setFilter(myFilter);

        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));

        return filterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean<MyFilter2> setUpFilter2(){
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean();

        filterRegistrationBean.setOrder(1);

        filterRegistrationBean.setFilter(myFilter2);

        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));

        return filterRegistrationBean;
    }


}
