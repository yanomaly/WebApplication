package com.example.WebApplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main_unlog");
        registry.addViewController("/ad_feed").setViewName("ad_feed");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/your_adds").setViewName("your_adds");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/ad_feed_unlog").setViewName("ad_feed_unlog");
    }
}
