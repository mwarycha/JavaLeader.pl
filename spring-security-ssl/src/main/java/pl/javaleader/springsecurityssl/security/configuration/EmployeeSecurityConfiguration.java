package pl.javaleader.springsecurityssl.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/")

				.permitAll()

				.antMatchers("/security").hasAnyRole("USER")

				.anyRequest().authenticated()

				.and().
					formLogin().loginPage("/login").defaultSuccessUrl("/success", true).permitAll()

				.failureUrl("/login-error")

				.and()
					.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login").permitAll();

		http.csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication().withUser("javaleader").password("{noop}pljavaleader").authorities("ROLE_USER");
	}
}