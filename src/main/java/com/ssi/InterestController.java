package com.ssi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView processRequestForInterest(@ModelAttribute("data") InterestModel model) {
		
		service.computeInterest(model);
		
		ModelAndView mv=new ModelAndView("result.jsp");
		mv.addObject("author", "manoj");
		
		return mv;
	}
	
}
