package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Hospital;
import com.example.demo.domain.Provider;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.ProviderRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(HospitalRepository hospitalRepo, ProviderRepository providerRepo) {
		return args -> {
			Hospital hospital = new Hospital("Mass General", "Premier East Coast Care");
			hospitalRepo.save(hospital);
			log.info("Preloading " + hospital);
			
			Provider provider = new Provider("Doctor");
			provider.setHospital(hospital);
			log.info("Preloading " + providerRepo.save(provider));
		};
	}
}
