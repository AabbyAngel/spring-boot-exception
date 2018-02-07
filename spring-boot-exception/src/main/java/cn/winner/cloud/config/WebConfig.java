package cn.winner.cloud.config;

import cn.winner.cloud.web.SystemHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    /**
     * 设置系统级别的转换器,统一转成json格式
     *
     * @return 返回自定义的转换器
     */
    @Bean
    public SystemHttpMessageConverter httpMessageConverter() {
        return new SystemHttpMessageConverter();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(httpMessageConverter());
    }
}
