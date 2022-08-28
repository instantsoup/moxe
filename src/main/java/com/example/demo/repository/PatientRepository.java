package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
