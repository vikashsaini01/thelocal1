package com.locals.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.locals.entity.Greeting;

@RestController
public class HomeController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	static Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	

}
