package com.jacaranda.miPrimerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("lista", repositorio.getLista() );
		return "listStudent";
	}
	
	
	
	
	//BORRAR ESTUDIANTE 
	@GetMapping("delStudent")
	public String delStudent(Model model,@RequestParam(name="name") String name,
							@RequestParam(name="surname") String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("estudiante",estudiante);
		
		return "delStudent";
	}
	
	@PostMapping("/delStudent/submit")
	public String delSubmitStudent ( @ModelAttribute("estudiante") Student pepito) {
		repositorio.remove(pepito);
		
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
		
		return "redirect:/listStudent";
	}
	
	
	//EDITAR ESTUDIANTE 
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam(name="name", required=false, defaultValue="")String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/Submit")
	public String listStudentseditMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.updateStudent(student.getName(), student.getSurname(), student.getAge());
			
		return "redirect:/listStudents";
	}
	
}
