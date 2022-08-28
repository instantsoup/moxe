package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Patient;
import com.example.demo.repository.PatientRepository;

@RestController
public class PatientController {
	
	private final PatientRepository repository;
	
	PatientController(PatientRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/patients")
	List<Patient> findAll() {
		return repository.findAll();
	}
	
	@PostMapping("/patients")
	Patient newPatient(@RequestBody Patient newPatient) {
		return repository.save(newPatient);
	}

}
