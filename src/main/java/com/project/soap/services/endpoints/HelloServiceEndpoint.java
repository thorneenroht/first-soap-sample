package com.project.soap.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.project.soap.services.HelloService;
import com.project.soap.webservices.helloservice.HelloWorldRequest;
import com.project.soap.webservices.helloservice.HelloWorldResponse;

@Endpoint
public class HelloServiceEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/project/soap/webservices/helloservice";

	@Autowired
	private HelloService accountService_i;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	@PayloadRoot(localPart = "HelloWorldRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload HelloWorldResponse getAccountDetails(@RequestPayload HelloWorldRequest request)
	{
		HelloWorldResponse response = new HelloWorldResponse();

		/* call Spring injected service implementation to retrieve account data */
		response.setMessage(accountService_i.getHelloWorld(request.getName()));
		
		return response;
	}

	public void setAccountService(HelloService accountService_p)
	{
		this.accountService_i = accountService_p;
	}
}
