package com.project.soap.services;

public class HelloServiceImpl implements HelloService{

	public String getHelloWorld(String name) {
	
		return "Hi "+ name + ", Welcome to a soap webservice!";
	}

}
