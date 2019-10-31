package pl.javaleader.jwt.filtr;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request,
						 ServletResponse response,
						 FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req  = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println("Request URI is: "          + req.getRequestURI());
		System.out.println("Response Status Code is: " + res.getStatus());

		chain.doFilter(request, response);
	}
}