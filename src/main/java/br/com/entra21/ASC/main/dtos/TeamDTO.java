package br.com.entra21.ASC.main.dtos;

import java.io.Serializable;

import br.com.entra21.ASC.main.model.TeamDados;

public class TeamDTO implements Serializable {
	private static final long serialVersionUID = 1l;

	private Integer id;
	private String image;
	private String name;
	private String github;
	private String linkedin;
	private String portfolio;

	
	public TeamDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamDTO(TeamDados obj) {
		// TODO Auto-generated constructor stub
		this.id = obj.getId();
		this.image = obj.getImage();
		this.name = obj.getName();
		this.github = obj.getGithub();
		this.linkedin = obj.getLinkedin();
		this.portfolio = obj.getPortfolio();
	}
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGithub() {
		return github;
	}


	public void setGithub(String github) {
		this.github = github;
	}


	public String getLinkedin() {
		return linkedin;
	}


	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}


	public String getPortfolio() {
		return portfolio;
	}


	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
