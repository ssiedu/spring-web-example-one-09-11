package com.ssi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test")
	public void testingMethod() {
		System.out.println("hello from a handler method for test request ................>>>>>");
	}
	
	@RequestMapping("/demo")
	public void demoMethod() {
		System.out.println("hello from a handler method for demo request ------------------>>>>");
	}
}
