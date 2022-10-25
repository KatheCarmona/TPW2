package com.example.going.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.entities.Usuario;
import com.example.going.helpers.ViewRouteHelper;

@Controller
@RequestMapping("adminpage")
public class AdminController {
	
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("")
	public String admin_page() {
//		Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.print(usuario);
			return ViewRouteHelper.ADMINPAGE;
		
		
	}
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/adminpag")
	public ModelAndView administrador() {
		 
		 try {
	 User usuario = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
		ModelAndView mAv = new ModelAndView(ViewRouteHelper.ADMINPAGE);
		//mAv.addObject("usuario", usuario);
		
		mAv.addObject("usuarios", usuario.getUsername());
			return mAv;
		 }
		 catch (Exception e) {
				ModelAndView mAv = new ModelAndView(ViewRouteHelper.ADMINPAGE);
				return mAv;
		 }
		
		
	}
	
}
