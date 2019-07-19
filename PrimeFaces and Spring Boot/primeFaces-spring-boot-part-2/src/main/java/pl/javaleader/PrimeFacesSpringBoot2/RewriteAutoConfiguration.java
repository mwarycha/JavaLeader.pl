package pl.javaleader.PrimeFacesSpringBoot2;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.ocpsoft.rewrite.servlet.impl.RewriteServletContextListener;
import org.ocpsoft.rewrite.servlet.impl.RewriteServletRequestListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

@Configuration
public class RewriteAutoConfiguration {

    @Bean
    public RewriteServletRequestListener rewriteServletRequestListener(){
        return new RewriteServletRequestListener();
    }

    @Bean
    public RewriteServletContextListener rewriteServletContextListener(){
        return new RewriteServletContextListener();
    }

    @Bean
    public FilterRegistrationBean rewriteFilterRegistrationBean() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new RewriteFilter());
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        registration.addUrlPatterns("/*");
        return registration;
    }

}