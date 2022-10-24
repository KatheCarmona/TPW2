package com.example.going.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.going.helpers.ViewRouteHelper;


@Controller
@RequestMapping("explorar")
public class ExploradorController {
	
	@GetMapping("")
	public String explorador() {
		
			return ViewRouteHelper.EXPLO;
		
		
	}
}
