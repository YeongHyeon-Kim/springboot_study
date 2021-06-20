package com.study.springboot.config;

import com.study.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
	private final LoginUserArgumentResolver loginUserArgumentResolver;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
		argumentResolvers.add(loginUserArgumentResolver);
	}
	//HandlerMethodArgumentResolver는 항상 addArgumentResolvers를 통해서 추가해야한다.
}
