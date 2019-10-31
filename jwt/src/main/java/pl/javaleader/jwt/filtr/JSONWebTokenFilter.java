package pl.javaleader.jwt.filtr;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.vavr.Tuple;
import io.vavr.Tuple3;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;

public class JSONWebTokenFilter extends BasicAuthenticationFilter {

    public JSONWebTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = getHeaderFromRequest(request);
        UsernamePasswordAuthenticationToken authResult = getAuthenticationByToken(header);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationByToken(String header) {

        final String BEARER       = "Bearer ";
        final String EMPTY_STRING = "";
        final byte[] KEY          = "1a2b3c".getBytes();

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(header.replace(BEARER,EMPTY_STRING));
        Tuple3 getAllClaims   = getClaimsJws(claimsJws);

        String username = getAllClaims._1.toString();
        String password = getAllClaims._2.toString();
        String role     = getAllClaims._3.toString();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password, getAllAuthorities(role));
        return usernamePasswordAuthenticationToken;
    }

    private String getHeaderFromRequest(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    private Tuple3<String, String, String> getClaimsJws(Jws<Claims> claimsJws) {
        String username = claimsJws.getBody().get("username").toString();
        String password = claimsJws.getBody().get("password").toString();
        String role     = claimsJws.getBody().get("role").toString();
        return Tuple.of(username, password, role);
    }

    private Set<SimpleGrantedAuthority> getAllAuthorities(String role) {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

}