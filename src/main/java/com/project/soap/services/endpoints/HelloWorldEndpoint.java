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
public class HelloWorldEndpoint {

	private static final String TARGET_NAMESPACE = "http://com/project/soap/webservices/helloservice";

	@Autowired
	private HelloService helloServiceInterfacObj;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	@PayloadRoot(localPart = "HelloWorldRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload HelloWorldResponse getHelloWorld(@RequestPayload HelloWorldRequest request)
	{
		HelloWorldResponse response = new HelloWorldResponse();

		/* call Spring injected service implementation to retrieve account data */
		String message = helloServiceInterfacObj.getHelloWorld(request.getName());
		response.setMessage(message);
		return response;
	}
}
