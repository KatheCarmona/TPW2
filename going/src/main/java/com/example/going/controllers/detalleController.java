package com.example.going.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.going.helpers.ViewRouteHelper;

@Controller
@RequestMapping("detalle")
public class detalleController {
	@GetMapping("")
	public String detalleLocacion() {
		
			return ViewRouteHelper.DETALLELOC;
		
		
	}

}
