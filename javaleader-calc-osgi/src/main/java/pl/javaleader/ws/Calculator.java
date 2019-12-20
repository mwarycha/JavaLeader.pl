package pl.javaleader.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {
	@WebMethod()
	int add(int a, int b);

	@WebMethod()
	int sub(int a, int b);
}