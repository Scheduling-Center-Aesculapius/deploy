package br.com.entra21.ASC.main.dtos;

import java.io.Serializable;

import br.com.entra21.ASC.main.model.Admin;

public class AdminDTO implements Serializable {
	private static final long serialVersionUID = 1l;

	private Integer id;

	private String name;

	public AdminDTO() {
		super();
	}

	public AdminDTO(Admin admin) {
		super();
		this.id = admin.getId();
		this.name = admin.getName();
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

}
