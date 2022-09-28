package br.com.entra21.ASC.main.services;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.repositories.AdminRepository;
import br.com.entra21.ASC.main.services.exception.DataIntregatyViolationException;
import br.com.entra21.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class AdminService {
	@Autowired
	private AdminRepository repository;

// PROCURANDO TECNICOS POR ID E REPASSANDO EM DTO COM APENAS INFOMAÇÕES PUBLICAS
	public Admin findById(Integer id) {
		Optional<Admin> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + Admin.class.getName()));
	}

// RETORNANDO UMA LISTA DE ADMINS
	public List<Admin> findAll() {
		return repository.findAll();
	}

	public Admin create(Admin Obj) {
		if (findByUsername(Obj) != null) {
			throw new DataIntregatyViolationException("USERNAME já cadastrado na base de dados!");
		}
		Admin newObj = new Admin(null, Obj.getName(), Obj.getUsername(), Obj.getPassword());
		return repository.save(newObj);
	}

	public Admin update(Integer id, @Valid Admin obj) {
		Admin oldObj = findById(id);

		if (findByUsername(obj) != null && findByUsername(obj).getId() != id) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}

		oldObj.setName(obj.getName());
		oldObj.setUsername(obj.getUsername());
		return repository.save(oldObj);
	}

	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		return !repository.existsById(id);
	}

	private Admin findByUsername(Admin obj) {
		Admin objNew = repository.findByUsername(obj.getUsername());
		if (objNew != null) {
			return objNew;
		}
		return null;
	}

}
