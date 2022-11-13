package com.example.going.controllers;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.validation.Valid;

//import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.entities.Locacion;
import com.example.going.entities.Usuario;
import com.example.going.helpers.ViewRouteHelper;
import com.example.going.models.PersonaModelo;
import com.example.going.models.UsuarioModelo;
import com.example.going.models.UsuarioRolModelo;
import com.example.going.services.IPersonaService;

@Controller
@RequestMapping("/adminpage")
public class AdminController {
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("")
	public ModelAndView  listaDePersonas(Model model) {	
		
		model.addAttribute("persona", new PersonaModelo());
		model.addAttribute("usuario", new UsuarioModelo());
		model.addAttribute("user_role", new UsuarioRolModelo());//para crear personas
	
		ModelAndView mV = new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.ADMINPAGE);
		mV.addObject("listaDePersonas",personaService.getAll());
		
	
		
		
		return mV;	
	}
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/detalles/{id}")
	public ModelAndView  detalles(@PathVariable("id")int id, Model model) {	
		
		
		
		PersonaModelo persona = personaService.traerPorId(id);
		
		
		Set<Locacion> locaciones = personaService.locacionesCargadas(id);
		
		Usuario usuario = personaService.traerUsuario(id);
		
		

		model.addAttribute("persona", persona);
		model.addAttribute("locaciones",locaciones);
		model.addAttribute("usuario",usuario);

		
		
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.DETALLEUSER);
		modelAndView.addObject("listaDePersonas",personaService.getAll());
		
		return modelAndView;	
	}
	
	
	
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/editarUsuario/{id}")
	public ModelAndView  editarPersona(@PathVariable("id")int id,@ModelAttribute("persona")PersonaModelo persona) {	
			
		PersonaModelo p = personaService.traerPorId(id);

		ModelAndView mV = new ModelAndView();
		
			
			//BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			//persona.getUsuario().setPassword(pe.encode(persona.getUsuario().getPassword()));
			//p.getUsuario().setPassword(persona.getUsuario().getPassword());
			
			//persona.getUsuario().setEnabled(true);
		
			
			if(persona.getAvatar().getImagen()== "") {
				persona.getAvatar().setImagen(p.getAvatar().getImagen()); //Para que no pierda la imagen si no la edito
			}
			
			personaService.insertOrUpdate(persona); 
			
			mV.setViewName(ViewRouteHelper.NUEVAP);
			mV.addObject("persona", persona);
			
			
			mV.addObject("listaDePersonas",personaService.getAll());
				

		
			
		return mV;
	}

	
	
	
	@PreAuthorize("hasRole('ROLE_1')")
	@PostMapping("/agregar")
	public ModelAndView nuevaPersona(@Valid @ModelAttribute("persona")PersonaModelo persona,
			BindingResult b, @RequestParam("file") MultipartFile imagen) {
		
		
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.ADMINPAGE);
			System.out.println(b.getFieldErrors());
			
		}else {
			
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					persona.getAvatar().setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			persona.getUsuario().setPassword(pe.encode(persona.getUsuario().getPassword()));
			persona.getUsuario().setEnabled(true);
			personaService.insertOrUpdate(persona); 
			
			mV.setViewName(ViewRouteHelper.NUEVAP);
			mV.addObject("persona", persona);
			
			
			mV.addObject("listaDePersonas",personaService.getAll());
				

		}
			
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_1')")
	@GetMapping("/eliminarPersona/{id}")
	public ModelAndView  eliminarPersona(@PathVariable("id")int id, Model model) {	
		
	
		personaService.remove(id);
		
		ModelAndView mV = new ModelAndView();
		
		mV.setViewName(ViewRouteHelper.NUEVAP);
		mV.addObject("listaDePersonas",personaService.getAll());
		
	
		
		
		return mV;	
	}
	

	
}
