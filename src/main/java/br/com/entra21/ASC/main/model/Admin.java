package br.com.entra21.ASC.main.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Admin implements Serializable {
	private static final long serialVersionUID = 1l;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // geração dessa chave primaira, ficara por conta da base de													// dados, banco que vai criar
	private Integer id;
	@NotEmpty(message = "Field Required")
	@Column(name = "_from")
	private String name;
	@NotEmpty(message = "Field Required")
	private String username;
	@NotEmpty(message = "Field Required")
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) não mostra a senha nas requisições
	private String password;

	public Admin() {
		super();
	}

	public Admin(Integer id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(id, other.id);
	}

}
