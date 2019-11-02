package pl.javaleader.oauth2sso.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class MyLogoutSuccessHandlerOne implements LogoutSuccessHandler {
	@Override
	public void onLogoutSuccess(HttpServletRequest request,
								HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {


		if(authentication != null) {
			System.out.println(authentication.getName());
		}

		String domain = request.getServerName().replaceAll(".*\\.(?=.*\\.)", "");
		String URL    =  request.getScheme() + "://"  +domain + ":8088/";
		response.setStatus(HttpStatus.OK.value());
		response.sendRedirect(URL);
	}
} 