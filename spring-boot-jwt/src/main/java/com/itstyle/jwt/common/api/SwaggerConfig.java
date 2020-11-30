package com.itstyle.jwt.common.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig{
	@Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户管理")
                .apiInfo(apiInfo())
                .select()
				.apis(RequestHandlerSelectors.basePackage("com.itstyle.jwt.modules.user"))
                .paths(PathSelectors.any()).build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring 中使用Swagger2构建文档")
                .termsOfServiceUrl("http://www.dongnaoedu.com")
                .contact(new Contact("动脑学院-allen老师 ", "http://www.dongnaoedu.com", "2505507040@qq.com"))
                .version("1.1").build();
    }
}
