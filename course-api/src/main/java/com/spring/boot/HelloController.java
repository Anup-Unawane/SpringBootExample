package com.spring.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController 
{
	@RequestMapping("/")
	public String greetMessage()
	{
		return "Hello World Using Spring Boot";
	}
}
