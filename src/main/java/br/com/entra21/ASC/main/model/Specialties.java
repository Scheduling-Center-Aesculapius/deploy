package br.com.entra21.ASC.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Specialties {
	
	@Id
	@NotEmpty
	private String name;
	
	private String description;

	public Specialties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Specialties(@NotEmpty String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	
	
}
