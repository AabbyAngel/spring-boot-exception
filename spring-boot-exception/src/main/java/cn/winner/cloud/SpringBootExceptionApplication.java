package cn.winner.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;

@SpringBootApplication(scanBasePackages = {"cn.winner.cloud"})
public class SpringBootExceptionApplication extends SpringBootServletInitializer
        implements EmbeddedServletContainerCustomizer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExceptionApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) { }
}
