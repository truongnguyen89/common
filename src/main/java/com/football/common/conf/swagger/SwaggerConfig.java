package com.football.common.conf.swagger;


import com.football.common.constant.Constant;
import com.football.common.interceptor.AuthenticationIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 07-Jun-18
 * Time: 9:46 AM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    @Autowired
    AuthenticationIntercepter authenticationIntercepter;

    @Bean
    public Docket productApi() {

        List<Parameter> parameters = new ArrayList<>();
//        parameters.add(new ParameterBuilder()
//                .name(Constant.HEADER.AGENT)
//                .defaultValue(Constant.AGENT.ADMIN)
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(true)
//                .build());
//        parameters.add(new ParameterBuilder()
//                .name(Constant.HEADER.PASSWORD)
//                .defaultValue(Constant.HEADER.PASSWORD)
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(true)
//                .build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .globalOperationParameters(parameters)
                .select().apis(RequestHandlerSelectors.basePackage("com.football"))
                .build();
    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("micro-services",
                "WS test",
                "1.0.0",
                null,
                "truongnguyen@gmail.com", "", "");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationIntercepter);
    }

}
