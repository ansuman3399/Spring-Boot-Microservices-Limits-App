package com.boot.rest.restwebservices.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.restwebservices.model.HelloWorldBean;

@RestController
@RequestMapping("/rest-web-service")
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
	public String helloWorld() {
		return "Hello world!!";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("/hello-world/user/{name}")
	public HelloWorldBean helloWorlpathVar(@PathVariable String name) {
		return new HelloWorldBean("Hello " + name);
	}

	@GetMapping("/hello-world/user")
	public HelloWorldBean helloWorldRequestParam(
			@RequestParam(name = "name", required = true, defaultValue = "Ansu") String name) {
		return new HelloWorldBean("Hello " + name);
	}

	@GetMapping("/hello-international")
	public String helloWorldInternational(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null,"Good Morning", locale);
	}
}
