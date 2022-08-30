package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Provider {
	
	private @Id @GeneratedValue Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "hospital_id")
	@JsonIgnore
	private Hospital hospital;

	@OneToMany(mappedBy = "provider")
	private List<Patient> patients;
	
	Provider() {};
	
	public Provider(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
}
