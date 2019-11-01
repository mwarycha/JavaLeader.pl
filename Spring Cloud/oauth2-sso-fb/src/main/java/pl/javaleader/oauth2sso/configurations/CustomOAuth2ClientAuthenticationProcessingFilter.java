package pl.javaleader.oauth2sso.configurations;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class CustomOAuth2ClientAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

public CustomOAuth2ClientAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
    super(defaultFilterProcessesUrl);
}

@Override
protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);

        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(new OAuth2Authentication(oAuth2Authentication.getOAuth2Request(), new Authentication() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
            }

            @Override
            public Object getCredentials() {
                return oAuth2Authentication.getCredentials();
            }

            @Override
            public Object getDetails() {
                return oAuth2Authentication.getUserAuthentication().getDetails();
            }

            @Override
            public Object getPrincipal() {
                return oAuth2Authentication.getPrincipal();
            }

            @Override
            public boolean isAuthenticated() {
                return oAuth2Authentication.getUserAuthentication().isAuthenticated();
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return oAuth2Authentication.getName();
            }
        }));
    }
}
