package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
