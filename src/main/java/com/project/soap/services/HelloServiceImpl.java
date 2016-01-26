package com.project.soap.services;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

	public String getHelloWorld(String name) {
	
		return "Hi "+ name + ", Welcome to a soap webservice!";
	}
	
	public String getHelloWorldTwo(String name){
		return "Hi "+ name + ", Welcome to a soap webservice operation # 2!";
	}

}
