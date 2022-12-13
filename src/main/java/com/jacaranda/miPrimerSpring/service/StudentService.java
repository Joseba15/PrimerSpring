package com.jacaranda.miPrimerSpring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.miPrimerSpring.model.Student;

@Service
public class StudentService {

	private List<Student> lista;

	public StudentService() {
		this.lista = new ArrayList<Student>();
		lista.add(new Student("Joseba","Diaz", 21));
		lista.add(new Student("Pepe","Perez", 45));
		lista.add(new Student("Juan","Garcia", 84));
		lista.add(new Student("Marta","Perea", 18));
	}

	
	
	
	public boolean addStudent(Student e) {
		return lista.add(e);
	}




	public boolean remove(Object o) {
		return lista.remove(o);
	}




	public Student getStudent(String nombre, String apellidos) {
		boolean encontrado = false;
		Student res=null;
		
		Iterator<Student> iterator = this.lista.iterator();
		while(iterator.hasNext() && !encontrado)
				res = iterator.next();
				if (res.getName().equals(nombre) && res.getSurname().equals(apellidos)) {
					encontrado=true;
				}
				
				if (encontrado==true) {
					return res;
				}else {
					return null;
				}
				
	}

//	public Student updateStudent(String nombre, String apellidos) {
//		boolean encontrado = false;
//		Student res=null;
//		
//		Iterator<Student> iterator = this.lista.iterator();
//		while(iterator.hasNext() && !encontrado)
//				res = iterator.next();
//				if (res.getName().equals(nombre) && res.getSurname().equals(apellidos)) {
//					encontrado=true;
//					
//				}
//				
//				
//				
//	}


	public List<Student> getLista() {
		return lista;
	}

	
	
	
}
