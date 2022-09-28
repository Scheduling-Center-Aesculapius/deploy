package br.com.entra21.ASC.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.entra21.ASC.main.model.ENUMS.Sex;
@Entity
public class Patient extends User implements Serializable{
	private static final long serialVersionUID = 1l;
	private String symptoms;
	@OneToMany(mappedBy = "patient")
	private List<Scheduling> list = new ArrayList<>();

	public Patient() {
		super();
	}

	public Patient(Integer id,String name, String username, String password, Sex sex, String cpf, String email, String phone,
			String street, String numberStreet, String zipCode, String city, String state, String symptoms) {
		super(id, name, username, password, sex, cpf, email, phone, street, numberStreet, zipCode, city, state);
		this.symptoms = symptoms;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public List<Scheduling> getList() {
		return list;
	}

	public void setList(List<Scheduling> list) {
		this.list = list;
	}	
	
}
