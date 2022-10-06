package br.com.entra21.ASC.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.http.ResponseEntity;

@Entity
public class TeamDados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String image;
	private String name;
	private String github;
		private String linkedin;
	private String portfolio;
	
	public TeamDados(ResponseEntity<TeamDados> responseEntity) {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamDados(Integer id, String image, String name, String github, String linkedin,
			String portfolio) {
		super();
		this.id = id;
		this.image = image;
		this.name = name;
		this.github = github;
		this.linkedin = linkedin;
		this.portfolio = portfolio;
	}
	
	public TeamDados(TeamDados obj) {
		// TODO Auto-generated constructor stub
		this.image = obj.image;
		this.name = obj.name;
		this.github = obj.github;
		this.linkedin = obj.linkedin;
		this.portfolio = obj.portfolio;
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
