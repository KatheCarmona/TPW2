package com.example.going.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.entities.Locacion;
import com.example.going.entities.Usuario;
import com.example.going.helpers.ViewRouteHelper;
import com.example.going.models.PersonaModelo;
import com.example.going.services.IPersonaService;

//@Controller
//@RequestMapping("/persona")
//public class NuevaPersonaController {
//	@Autowired
//	@Qualifier("personaService")
//	private IPersonaService personaService;
//	
//	@GetMapping("")
//	public String nuevapersona() {
//		
//			return ViewRouteHelper.NUEVAP;
//		
//		
//	}
	
//	@PreAuthorize("hasRole('ROLE_1')")
//	@PostMapping("")
//	public ModelAndView  detalles(@PathVariable("id")int id, Model model,
//			 @RequestParam("file") MultipartFile imagen) {	
//		
//		
//		
//		PersonaModelo persona = personaService.traerPorId(id);
//		
//		
//		Set<Locacion> locaciones = personaService.locacionesCargadas(id);
//		
//		Usuario usuario = personaService.traerUsuario(id);
//		
//		
//
//		model.addAttribute("persona", persona);
//		model.addAttribute("locaciones",locaciones);
//		model.addAttribute("usuario",usuario);
//
//		
//		
//		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.NUEVAP);
//		modelAndView.addObject("listaDePersonas",personaService.getAll());
//		
//		return modelAndView;	
//	}
//	
	
	
	
//	@PreAuthorize("hasRole('ROLE_1')")
//	@PostMapping("")
//	public ModelAndView  listaDePersonas(@RequestParam("file") MultipartFile imagen) {	
//		
//		
//	
//		ModelAndView mV = new ModelAndView();
//		
//		mV.setViewName(ViewRouteHelper.NUEVAP);
//		mV.addObject("listaDePersonas",personaService.getAll());
//		
//	
//		
//		
//		return mV;	
//	}

	
//}
