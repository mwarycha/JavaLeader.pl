package pl.javaleader.springsecurityrest.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pl.javaleader.springsecurityrest.components.RestAuthenticationFailureHandler;
import pl.javaleader.springsecurityrest.components.RestAuthenticationSuccessHandler;
import pl.javaleader.springsecurityrest.filter.JsonObjectAuthenticationFilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private RestAuthenticationSuccessHandler authenticationSuccessHandler;
  private RestAuthenticationFailureHandler authenticationFailureHandler;

  public SecurityConfig(RestAuthenticationSuccessHandler authenticationSuccessHandler,
                        RestAuthenticationFailureHandler authenticationFailureHandler) {
    this.authenticationSuccessHandler = authenticationSuccessHandler;
    this.authenticationFailureHandler = authenticationFailureHandler;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
            .exceptionHandling() // 1
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
  }

  @Bean
  public JsonObjectAuthenticationFilter authenticationFilter() throws Exception {
    JsonObjectAuthenticationFilter filter = new JsonObjectAuthenticationFilter();
    filter.setAuthenticationSuccessHandler(authenticationSuccessHandler); // 1
    filter.setAuthenticationFailureHandler(authenticationFailureHandler); // 2
    filter.setAuthenticationManager(super.authenticationManagerBean()); // 3
    return filter;
  }


}