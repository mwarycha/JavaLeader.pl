package pl.javaleader.allegroapi.interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import pl.javaleader.AllegroEnum;
import java.io.IOException;

public class CustomHttpRequestInterceptor implements ClientHttpRequestInterceptor {
   @Override
   public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().add("ACCEPT", AllegroEnum.ACCEPT.acceptHeader);
        return execution.execute(request, body);
    }
}