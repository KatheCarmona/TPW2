package com.example.going.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.going.entities.Fotos;
import com.example.going.entities.Locacion;
import com.example.going.entities.Usuario;
import com.example.going.helpers.ViewRouteHelper;
import com.example.going.models.FotosModelo;
import com.example.going.models.LocacionModelo;
import com.example.going.models.PersonaModelo;
import com.example.going.services.IFotosService;
import com.example.going.services.ILocacionService;
import com.example.going.services.IPersonaService;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	@Qualifier("locacionService")
	ILocacionService locacionService;
	
	@Autowired
	@Qualifier("fotosService")
	IFotosService fotosService;
	
	
	
	@GetMapping("")
	public String perfil() {

		return ViewRouteHelper.PERFIL;
		
	}
	
	
	@GetMapping("/formulario")
	public String formu() {

		return ViewRouteHelper.FORMU;

	}
	
	@PostMapping("/agregarLoc")
	public ModelAndView nuevaLocacion(@Valid @ModelAttribute("locacion")LocacionModelo locacion,
			BindingResult b, @RequestParam("file") MultipartFile file) {
		
		
		
		ModelAndView mV = new ModelAndView();
		Fotos fto =new Fotos();
		FotosModelo foto = new FotosModelo();
		Set<Fotos> listafotos = new HashSet<>();
		
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelper.FORMU);
			System.out.println(b.getFieldErrors());
			
		}else {
			
			if(!file.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static/images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = file.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+file.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
					fto.setImagen(file.getOriginalFilename());

					listafotos.add(fto);
					
					
					//locacion.getFotos().setImagen(imagen.getOriginalFilename());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		//	BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			
			//persona.getUsuario().setPassword(pe.encode(persona.getUsuario().getPassword()));
			//persona.getUsuario().setEnabled(true);
			if(listafotos!=null) {
				locacion.setFotos(listafotos);
				System.out.println("lista de fotos no vacía");
			}
			
			locacionService.insertOrUpdate(locacion); 

			 int idLocacion=0;
			
			 for(Locacion item: locacionService.getAll()) {
				 idLocacion = item.getId();
				
			 }
			 
			System.out.println("Locacion agregada nro "+idLocacion);
			//fotosService.setIdLoc(idLocacion);
			
			/*
			for(Fotos item: locacionService.fotosDeLaLocacion(0)) {
				
				//item.setLocacion(locacionService.traerEntidad(idLocacion));
				foto.setId(item.getId());
				foto.setImagen(item.getImagen());
				foto.setLocacion_id(idLocacion);
				foto.setLocacion(locacion);
				fotosService.insertOrUpdate(foto);
			}
			
*/
			
			mV.setViewName(ViewRouteHelper.EXPLO);
			mV.addObject("locacion", locacion);
			
			
			
			mV.addObject("locaciones",locacionService.getAll());
	
				

		}
		//System.out.println(locacionService.getAll());
			
		return mV;
	}
	
	
		

	
}
