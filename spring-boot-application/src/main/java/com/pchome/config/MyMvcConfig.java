package com.pchome.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//import com.pchome.component.LoginHandlerInterceptor;
import com.pchome.component.MyLocaleResolver;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	
	//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/atguigu").setViewName("success");
//	}
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdatper() {
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("index");
			
			}
//
//			@Override
//			public void addInterceptors(InterceptorRegistry registry) {
//				//super.addInterceptors(registry);
//				//靜態資源, *.css, *.js
//				//springBoot 已經做好了靜態資源映射
//				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//				.excludePathPatterns("/index.html","/","/user/login");
//			}
			
			
		};
		return adapter;
	}
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
}
