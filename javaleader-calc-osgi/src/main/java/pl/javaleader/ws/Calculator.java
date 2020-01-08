package pl.javaleader.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

	@WebMethod
	int addidtion(int a, int b);

	@WebMethod
	int subtraction(int a, int b);
}