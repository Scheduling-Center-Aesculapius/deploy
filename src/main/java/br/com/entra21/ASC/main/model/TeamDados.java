package br.com.entra21.ASC.main.model;

import java.util.ArrayList;

public class TeamDados {
	
	private ArrayList<String> dados = new ArrayList<>();
	private String image;
	private String name;
	private String github;
	private String linkedin;
	private String portfolio;
	public TeamDados() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamDados(ArrayList<String> dados, String image, String name, String github, String linkedin,
			String portfolio) {
		super();
		this.dados = dados;
		this.image = image;
		this.name = name;
		this.github = github;
		this.linkedin = linkedin;
		this.portfolio = portfolio;
	}
	public ArrayList<String> getDados() {
		return dados;
	}
	public void setDados(ArrayList<String> dados) {
		this.dados = dados;
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
	
	
	
	
	
}
