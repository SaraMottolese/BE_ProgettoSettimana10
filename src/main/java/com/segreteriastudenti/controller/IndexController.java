package com.segreteriastudenti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/universitaroma/index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

}
