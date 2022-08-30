package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Patient;
import com.example.demo.domain.Provider;
import com.example.demo.repository.ProviderRepository;

@RestController
public class ProviderController {
	
	private final ProviderRepository repository;
	
	ProviderController(ProviderRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/providers")
	List<Provider> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/providers/{id}/patients")
	List<Patient> findByPatient(@PathVariable Long id) {
		return repository.findById(id).get().getPatients();
	}

}
