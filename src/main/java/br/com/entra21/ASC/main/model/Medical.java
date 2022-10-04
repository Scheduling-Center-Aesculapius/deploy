package br.com.entra21.ASC.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.entra21.ASC.main.model.ENUMS.Sex;
@Entity
public class Medical extends User implements Serializable{
	private static final long serialVersionUID = 1l;
	private String specialty;
	@JsonIgnore
	@OneToMany(mappedBy = "medical") // um para muitos
	private List<Scheduling> list = new ArrayList<>();
	
	public List<Scheduling> getList() {
		return list;
	}

	public void setList(List<Scheduling> list) {
		this.list = list;
	}

	public Medical() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Medical(String specialty, List<Scheduling> list) {
		super();
		this.specialty = specialty;
	}

	public Medical(Integer id, String name, String username, String password, Sex sex, String cpf, String email,
			String phone, String street, String numberStreet, String zipCode, String city, String state,
			String nameMother, String nameFather,String specialty) {
		super(id, name, username, password, sex, cpf, email, phone, street, numberStreet, zipCode, city, state, nameMother,
				nameFather);
		// TODO Auto-generated constructor stub
		this.specialty = specialty;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	
	
	
}
