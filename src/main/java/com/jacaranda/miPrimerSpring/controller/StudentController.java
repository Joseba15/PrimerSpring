package com.jacaranda.miPrimerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jacaranda.miPrimerSpring.model.Calculator;
import com.jacaranda.miPrimerSpring.model.Student;
import com.jacaranda.miPrimerSpring.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService repositorio;
	
	//LISTAR ESTUDIANTES
	@GetMapping("listStudent")
	public String listStudent(Model model) {
		model.addAttribute("lista", repositorio.getLista());
		return "listStudent";
	}
	
	
	
	
	//BORRAR ESTUDIANTE 
	@GetMapping("delStudent")
	public String delStudent(Model model,@ModelAttribute("student") Student pepito) {
		
		//model.addAttribute("estudiante",student);
		
		return "addStudent";
	}
	
	@PostMapping("/delStudent/submit")
	public String delSubmitStudent ( @ModelAttribute("estudiante") Student pepito) {
		repositorio.addStudent(pepito);
		
		//model.addAttribute("calc",calc);
		return "redirect:/listStudent";
	}
	
	
	
	
	
	//AÑADIR ESTUDIANTE 
	@GetMapping("addStudent")
	public String addStudent(Model model) {
		
		Student student = new Student();
		model.addAttribute("estudiante",student);
		
		return "addStudent";
	}
	

	@PostMapping("/addStudent/submit")
	public String addSubmitSubmit	 ( @ModelAttribute("estudiante") Student pepito) {
		repositorio.addStudent(pepito);
		
		//model.addAttribute("calc",calc);
		return "redirect:/listStudent";
	}
	
}
