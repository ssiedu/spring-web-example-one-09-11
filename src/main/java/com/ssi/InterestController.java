package com.ssi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InterestController {
	
	@Autowired
	private InterestService service;
		
	@RequestMapping("input")	
	public String showInputPage() {
		//this method will return the view-name to front-controller (DispacherServlet)
		return "inputpage.jsp";
		
	}
	
	@RequestMapping("computeinterest")
	public String processRequestForInterest(@RequestParam("t1") int amount, @RequestParam("t2") int time, HttpServletRequest request) {
			
		InterestModel model=service.computeInterest(amount, time);
		
		//controller stores the process data in scope objects (request/session) so that view can access that from scope object
		
		request.setAttribute("data", model);
		
		return "result.jsp";
		
	}
	
}
