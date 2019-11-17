package tc2r.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tc2r.springframework.services.HelloWorldService;

@Controller
public class GreetingController {

	private HelloWorldService helloWorldService;

	@Autowired
	public synchronized void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	public String sayHello() {
		
		String greeting = helloWorldService.getGreeting();
		System.out.println(greeting);
		return greeting;
				
	}
	
	

	
}
