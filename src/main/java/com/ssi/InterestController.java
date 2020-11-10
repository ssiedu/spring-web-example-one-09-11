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
		//this method will return the view-name to front-controller
		return "inputpage.jsp";
		
	}
	
	@RequestMapping("computeinterest")
	public void processRequestForInterest(@RequestParam("t1") int amount, @RequestParam("t2") int time, HttpServletResponse response) {
		//this method will be called on submission of inputpage
		//this method will read the request.
		//int amount=Integer.parseInt(request.getParameter("t1"));
		//int time=Integer.parseInt(request.getParameter("t2"));
		//process the request
		
		InterestModel model=service.computeInterest(amount, time);
		
		//provide the response
		try {
			PrintWriter out=response.getWriter();
			out.println("Amount : "+model.getAmount());
			out.println("Time   : "+model.getTime());
			out.println("Intr   : "+model.getInterest());
			out.println("Net    : "+model.getNet());
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
