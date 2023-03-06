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
import org.springframework.web.bind.annotation.ModelAttribute;
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
		

		LocacionModelo locacion = locacionService.traerPorId(id);
		
		
		Set<Fotos> fotos = locacionService.fotosDeLaLocacion(id);
		Set<Comentarios> comentarios = locacionService.comentariosDeLaLocacion(id);
		

		
		

		model.addAttribute("lugar", locacion);
		model.addAttribute("fotos",fotos);
		model.addAttribute("comentarios",comentarios);
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DETALLELOC);
		modelAndView.addObject("locaciones",locacionService.getAll());
		
		return modelAndView;	
	}
	
	
	
	//@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/eliminarLocacion/{id}")
	public ModelAndView  eliminarLocacion(@PathVariable("id")int id, Model model) {	
		
	
		locacionService.remove(id);
		
		ModelAndView mV = new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.ELIMINARlOC);
		mV.addObject("locaciones",locacionService.getAll());
		
	
		
		
		return mV;	
	}
	
	/*
	
	@GetMapping("/editarLoc/{id}")
	public ModelAndView editarLoc(@PathVariable("id")int id, Model model) {	
		
		
		
		LocacionModelo locacion = locacionService.traerPorId(id);
		
		
		Set<Fotos> fotos = locacionService.fotosDeLaLocacion(id);
		

		model.addAttribute("locacion", locacion);
		model.addAttribute("fotos",fotos);

		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORMUEDIT);
		modelAndView.addObject("locaciones",locacionService.getAll());
		
		return modelAndView;
	}
	
	
	
	
	//@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/editarLocacion/{id}")
	public ModelAndView  editarLocacion(@PathVariable("id")int id,@ModelAttribute("locacion")LocacionModelo locacion) {	
			
		LocacionModelo locacionModelo = locacionService.traerPorId(id);

		ModelAndView mV = new ModelAndView();
		
			
			
			if(locacion.getFotos() == null) {
				locacion.setFotos(locacionModelo.getFotos()); //Para que no pierda la imagen si no la edito
			}
			
			
			locacionService.insertOrUpdate(locacion); 
			
			mV.setViewName(ViewRouteHelper.EXPLO);
			mV.addObject("locacion", locacion);
			
			
			mV.addObject("locaciones",locacionService.getAll());
				

		
			
		return mV;
	}

	
	*/
	
	
	
}
