package com.example.going.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.going.helpers.ViewRouteHelper;


@Controller
@RequestMapping("home")
public class HomeControlador {
	
	
	@GetMapping("")
	public String inicio() {
		
			return ViewRouteHelper.HOME;
		
		
	}
	
	@GetMapping("login")
	public String login(Model model, @RequestParam(name="error",required=false) String error,
	@RequestParam(name="logout",required= false)String logout){
		
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.HOME;
	}
	
	@GetMapping("/loginok")
	public String loginOk() {
	
		return ViewRouteHelper.PERFIL;
//		//return "redirect:/admin/admin";
	}
	
    @RequestMapping(value="/logout", method=RequestMethod.GET)  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return ViewRouteHelper.HOME; 
     }  
    
    @GetMapping("/loginsuccess")
	public String loginCheck() {

    System.out.println("holaaaaaaaa");
    	return  ViewRouteHelper.PERFIL;
    
	}
	

}
