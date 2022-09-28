package br.com.entra21.ASC.main.dtos;

import java.io.Serializable;

import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.model.ENUMS.Sex;

public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1l;
	
	private Integer id;
	private String name;
	private Sex sex;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String symptoms;

	public PatientDTO(){
		super();
	}
	
	public PatientDTO(Patient obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.sex = obj.getSex();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.city = obj.getCity();
		this.state = obj.getState();
		this.symptoms = obj.getSymptoms();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
