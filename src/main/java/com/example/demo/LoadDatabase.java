package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.Hospital;
import com.example.demo.domain.Patient;
import com.example.demo.domain.Provider;
import com.example.demo.repository.HospitalRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.ProviderRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
	
	@Bean
	CommandLineRunner initDatabase(HospitalRepository hospitalRepo, ProviderRepository providerRepo, PatientRepository patientRepo) {
		return args -> {
			Hospital hospital = new Hospital("Mass General", "Premier East Coast Care");
			log.info("Preloading " + hospitalRepo.save(hospital));
			Provider provider = new Provider("Doctor Who");
			provider.setHospital(hospital);
			log.info("Preloading " + providerRepo.save(provider));

			hospital = new Hospital("Mad City Hospital", "Genuine Midwest Care");
			log.info("Preloading " + hospitalRepo.save(hospital));
			provider = new Provider("Doctor Why");
			provider.setHospital(hospital);
			log.info("Preloading " + providerRepo.save(provider));
			Patient patient = new Patient("Victim");
			patient.setProvider(provider);
			log.info("Preloading " + patientRepo.save(patient));
		};
	}
}
