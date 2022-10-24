package com.example.going.controllers;

import org.apache.catalina.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	
	//@PreAuthorize("hasRole('ROLE_1')")
//	@GetMapping("")
//	public String admin_page() {
//		
//			return ViewRouteHelper.ADMINPAGE;
//		
//		
//	}
	//@PreAuthorize("hasRole('Role_1')")
	@GetMapping("")
	public ModelAndView administrador(Model model) {
	 Usuario usuario = (Usuario)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView mAv = new ModelAndView(ViewRouteHelper.ADMINPAGE);
		mAv.addObject("usuario", usuario);
			return mAv;
		
		
	}
	
}
