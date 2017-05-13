package org.heroesunlimited;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.logging.Logger;

@Configuration
public class ApacheCamelConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        LOGGER.fine("Registering servlet");
        ServletRegistrationBean servlet = new ServletRegistrationBean(
                new CamelHttpTransportServlet(), "/api/*");
        servlet.setName("CamelServlet");
        return servlet;
    }
    private static final Logger LOGGER = Logger.getLogger(ApacheCamelConfigurer.class.getName());
}
