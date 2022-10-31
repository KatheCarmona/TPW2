package com.example.going.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.entities.Comentarios;
import com.example.going.entities.Fotos;
import com.example.going.entities.Locacion;
import com.example.going.entities.Usuario;
import com.example.going.helpers.ViewRouteHelper;
import com.example.going.models.LocacionModelo;
import com.example.going.models.PersonaModelo;
import com.example.going.services.ILocacionService;
import com.example.going.services.IPersonaService;
import com.example.going.services.implementation.UserService;


@Controller
@RequestMapping("explorar")
public class ExploradorController {
	
	@Autowired
	@Qualifier("locacionService")
	private ILocacionService locacionService;
	
	
	@PreAuthorize("hasRole('ROLE_2')")
	@GetMapping("")
	public ModelAndView  explorador() {
		 User usuario = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		ModelAndView mV = new ModelAndView();
		mV.setViewName(ViewRouteHelper.EXPLO);
		mV.addObject("locaciones",locacionService.getAll());
		mV.addObject("usuarios", usuario.getUsername());
		
			return mV;
		
		
	}
	
	
	
	//@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/detalleLocacion/{id}")
	public ModelAndView  detalles(@PathVariable("id")int id, Model model) {	
		
		
		
		//PersonaModelo persona = personaService.traerPorId(id);
		LocacionModelo locacion = locacionService.traerPorId(id);
		
		
		Set<Fotos> fotos = locacionService.fotosDeLaLocacion(id);
		Set<Comentarios> comentarios = locacionService.comentariosDeLaLocacion(id);
		
		//Usuario usuario = personaService.traerUsuario(id);
		
		

		model.addAttribute("lugar", locacion);
		model.addAttribute("fotos",fotos);
		model.addAttribute("comentarios",comentarios);

		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DETALLELOC);
		modelAndView.addObject("lugares",locacionService.getAll());
		
		return modelAndView;	
	}
	
}
