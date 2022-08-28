package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Hospital;
import com.example.demo.domain.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

	List<Provider> findByHospital(Hospital hospital);
}
