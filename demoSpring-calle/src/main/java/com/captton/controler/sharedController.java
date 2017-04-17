package com.captton.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class sharedController {
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	
}
