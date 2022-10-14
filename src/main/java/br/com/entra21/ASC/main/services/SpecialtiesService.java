package br.com.entra21.ASC.main.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.TeamDados;
import br.com.entra21.ASC.main.repositories.TeamRepository;
import br.com.entra21.ASC.main.services.exception.DataIntregatyViolationException;
import br.com.entra21.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class SpecialtiesService {
	@Autowired
	private Scpe repository;

// PROCURANDO TECNICOS POR ID E REPASSANDO EM DTO COM APENAS INFOMAÇÕES PUBLICAS
	public TeamDados findById(Integer id) {
		Optional<TeamDados> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + TeamDados.class.getName()));
	}

// RETORNANDO UMA LISTA DE ADMINS
	public List<TeamDados> findAll() {
		return repository.findAll();
	}

	public TeamDados create(TeamDados obj) {
		if (findByName(obj) != null) {
			throw new DataIntregatyViolationException("USERNAME já cadastrado na base de dados!");
		}
		TeamDados newObj = new TeamDados(null, obj.getImage(), obj.getName(), obj.getGithub(), obj.getLinkedin(), obj.getPortfolio());
		return repository.save(newObj);
	}

	public TeamDados update(Integer id, @Valid TeamDados obj) {
		TeamDados oldObj = findById(id);

		if (findByName(obj) != null && findByName(obj).getId() != id) {
			throw new DataIntregatyViolationException("Nome já cadastrado na base de dados!");
		}

		oldObj.setName(obj.getName());
		oldObj.setGithub(obj.getGithub());
		oldObj.setImage(obj.getImage());
		oldObj.setLinkedin(obj.getLinkedin());
		oldObj.setPortfolio(obj.getPortfolio());
		return repository.save(oldObj);
	}

	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		return !repository.existsById(id);
	}

	private TeamDados findByName(TeamDados obj) {
		TeamDados objNew = repository.findByName(obj.getName());
		if (objNew != null) {
			return objNew;
		}
		return null;
	}

}
