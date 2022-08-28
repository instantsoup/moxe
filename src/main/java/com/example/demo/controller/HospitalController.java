package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Hospital;
import com.example.demo.domain.Provider;
import com.example.demo.repository.HospitalRepository;

@RestController
public class HospitalController {
	
	private final HospitalRepository repository;
	
	HospitalController(HospitalRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/hospitals")
	List<Hospital> findAll() {
		return repository.findAll();
	}
	
	@GetMapping("/hospitals/{id}/providers")
	List<Provider> findByHospital(@PathVariable Long id) {
		return repository.findById(id).get().getProviders();
	}

}
