package com.jacaranda.miPrimerSpring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.miPrimerSpring.model.Calculator;

@Controller
public class ControladorPrincipal {

	
//	@GetMapping("/bienvenido/")
//	public String wellcome (Model model,@RequestParam(message="mensaje",required=false,defaultValue = "Nada") String mensajeSaludo ) {
//		model.addAttribute("mensaje", mensajeSaludo);
//		
//		return "index";
//	}
	
	
	
	@GetMapping("/suma")
	public String suma (Model model ) {
		Calculator calc = new Calculator();
		
		model.addAttribute("calc",calc);
		return "calculadora";
	}
	
	@PostMapping("/operacionSubmit")
	public String operacionSubmit (Model model , @ModelAttribute("calc") Calculator calculadora) {
		
		
		return "calculadora";
	}
	
	
}
