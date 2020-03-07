package pl.javaleader.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Calculator {

	@WebMethod(action = "addidtion")
	int addidtion(int a, int b);

	@WebMethod(action = "subtraction")
	int subtraction(int a, int b);
}