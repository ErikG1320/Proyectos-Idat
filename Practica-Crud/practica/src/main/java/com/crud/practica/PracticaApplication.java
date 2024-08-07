package com.crud.practica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.crud.practica.Repositorio.EstudianteRepositorio;
@SpringBootApplication
public class PracticaApplication{
	// implements CommandLineRunner
	public static void main(String[] args){
		SpringApplication.run(PracticaApplication.class, args);
	}
	@Autowired
	private EstudianteRepositorio repo;
	// @Override
	// public void run(String... args) throws Exception {
	// 	// Estudiante estudiante1 = new Estudiante("Juan Perez", 18, 99999999, "juan@example.com", "5to prima");
	// 	// Estudiante estudiante2 = new Estudiante("Maria Garcia", 20, 88888888, "maria@example.com", "1ro secun");
	// 	// repo.save(estudiante1);
	// 	// repo.save(estudiante2);
	// 	throw new UnsupportedOperationException("Unimplemented method 'run'");
	// }
}
