package com.itstyle.jwt.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 拦截配置--调用链
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// token
//		String[] patterns = new String[] {"/token/login", "/*.html", "/swagger-resources/**"};
//		registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/token/**", "/session/**", "/cookie/**").excludePathPatterns(patterns);
		
		// session
//		String[] patterns = new String[] {"/session/login"};
//		registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/session/**").excludePathPatterns(patterns);
		
		// cookie
		String[] patterns = new String[] {"/cookie/login"};
		registry.addInterceptor(new CookieInterceptor()).addPathPatterns("/cookie/**").excludePathPatterns(patterns);
		super.addInterceptors(registry);
	}

}