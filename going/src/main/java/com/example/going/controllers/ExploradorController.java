package com.example.going.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.going.helpers.ViewRouteHelper;


@Controller
@RequestMapping("explorar")
public class ExploradorController {
	
	@PreAuthorize("hasRole('ROLE_2')")
	@GetMapping("")
	public String explorador() {
		
			return ViewRouteHelper.EXPLO;
		
		
	}
}
