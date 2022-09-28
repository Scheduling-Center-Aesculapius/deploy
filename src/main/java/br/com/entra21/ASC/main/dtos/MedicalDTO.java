package br.com.entra21.ASC.main.dtos;

import java.io.Serializable;

import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.ENUMS.Sex;

public class MedicalDTO implements Serializable{
	private static final long serialVersionUID = 1l;

	private Integer id;
	
	private String name;

	private Sex sex;
	
	private String email;

	private String phone;

	private String city;

	private String state;

	public MedicalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicalDTO(Medical obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.sex = obj.getSex();
		this.email = obj.getEmail();
		this.phone = obj.getPhone();
		this.city = obj.getCity();
		this.state = obj.getState();
		
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

	
	
	
}
