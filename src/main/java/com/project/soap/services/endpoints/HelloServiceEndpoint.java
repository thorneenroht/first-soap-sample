package com.project.soap.services.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.project.soap.services.HelloService;
import com.project.soap.webservices.helloservice.HelloWorldRequest;
import com.project.soap.webservices.helloservice.HelloWorldResponse;
import com.project.soap.webservices.hellotwoservice.HelloWorldTwoRequest;
import com.project.soap.webservices.hellotwoservice.HelloWorldTwoResponse;

@Endpoint
public class HelloServiceEndpoint
{
	private static final String TARGET_NAMESPACE = "http://com/project/soap/webservices/helloservice";
	
	private static final String TARGET_NAMESPACETWO = "http://com/project/soap/webservices/hellotwoservice";

	@Autowired
	private HelloService helloWorld;

	@PayloadRoot(localPart = "HelloWorldRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload HelloWorldResponse getHelloWorldMessage(@RequestPayload HelloWorldRequest request)
	{
		HelloWorldResponse response = new HelloWorldResponse();

		response.setMessage(helloWorld.getHelloWorld(request.getName()));
		
		return response;
	}

	@PayloadRoot(localPart = "HelloWorldTwoRequest", namespace = TARGET_NAMESPACETWO)
	public @ResponsePayload HelloWorldTwoResponse getHelloWorldTwoMessage(@RequestPayload HelloWorldTwoRequest request)
	{
		HelloWorldTwoResponse response = new HelloWorldTwoResponse();

		response.setMessage(helloWorld.getHelloWorldTwo(request.getName()));
		
		return response;
	}
	
	public void setHelloService(HelloService helloWorld)
	{
		this.helloWorld = helloWorld;
	}
}
