package com.example.going.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.going.helpers.ViewRouteHelper;


@Controller
@RequestMapping("home")
public class HomeControlador {
	
	@GetMapping("explorar")
	public String explorador() {
		
			return ViewRouteHelper.EXPLO;
		
		
	}
	
	@GetMapping("")
	public String inicio() {
		
			return ViewRouteHelper.HOME;
		
		
	}
	
	@GetMapping("adminpage")
	public String admin_page() {
		
			return ViewRouteHelper.ADMINPAGE;
		
		
	}

}
