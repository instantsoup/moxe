package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	private @Id @GeneratedValue Long id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "hospital")
	List<Provider> providers;

	Hospital() {
	};

	public Hospital(String name, String description) {
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	void setProviders(List<Provider> providers) {
		this.providers = providers;
	}
}
