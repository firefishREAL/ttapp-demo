package com.zr.ttappdemo.configurer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.base.Predicates;
import com.zr.ttappdemo.commons.exception.ServiceException;
import com.zr.ttappdemo.commons.util.ResultEnum;
import com.zr.ttappdemo.commons.util.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuyi
 * @description spring mvc 配置类
 * @date 22:37 2018/10/26
 */
@Configuration
@Slf4j
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    /**
     * 使用阿里的FastJson工具类作为 JSON  messageConverter
     * @param converters
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义FastJson配置
        FastJsonConfig config = new FastJsonConfig();
        //格式化返回的json数据
        config.setSerializerFeatures(SerializerFeature.PrettyFormat);
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON_UTF8));

        //配置FastJson至Spring boot中去
        //SpringBoot 2.0.1版本中加载WebMvcConfigurer的顺序发生了变动，
        //故需使用converters.add(0, converter);指定FastJsonHttpMessageConverter在converters内的顺序，
        //否则在SpringBoot 2.0.1及之后的版本中将优先使用Jackson处理
        converters.add(0,converter);
    }
    /**
     * 统一的异常处理
     */
    @Override
    protected void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {

                ResultVo result = null;
                if (e instanceof ServiceException) {
                    //业务失败的异常,系统错误
                    result = ResultVo.builder()
                            .code(ResultEnum.SYSTEM_ERROR.getCode())
                            .msg(ResultEnum.SYSTEM_ERROR.getMessage())
                            .build();
                    log.info(e.getMessage());
                } else if (e instanceof ServletException) {
                    result = ResultVo.builder()
                            .code(ResultEnum.SYSTEM_ERROR.getCode())
                            .msg(e.getMessage())
                            .build();
                } else {
                    result = ResultVo.builder()
                            .code(ResultEnum.SYSTEM_ERROR.getCode())
                            .msg("接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员")
                            .build();
                    String message;
                    if (handler instanceof HandlerMethod) {
                        HandlerMethod handlerMethod = (HandlerMethod) handler;
                        message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                                request.getRequestURI(),
                                handlerMethod.getBean().getClass().getName(),
                                handlerMethod.getMethod().getName(),
                                e.getMessage());
                    } else {
                        message = e.getMessage();
                    }
                    log.error(message, e);
                }
                responseResult(response, result);
                return new ModelAndView();
            }
        });
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }


    private void responseResult(HttpServletResponse response, ResultVo result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    // swagger2 相关配置
    @Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // .apis(RequestHandlerSelectors.any())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台对外接口 ")
                .description("1.提供**后台使用的接口 2.提供对其他服务调用的服务")
                .contact(new Contact("余燚","example.com",""))
                .version("1.0")
                .build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        //enabling swagger-ui part for visual documentation
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
