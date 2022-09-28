package br.com.entra21.ASC.main.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.User;
import br.com.entra21.ASC.main.repositories.MedicalRepository;
import br.com.entra21.ASC.main.repositories.UserRepository;
import br.com.entra21.ASC.main.services.exception.DataIntregatyViolationException;
import br.com.entra21.ASC.main.services.exception.ObjectNotFoundException;

@Service
public class MedicalService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MedicalRepository repository;
// PROCURANDO TECNICOS POR ID E REPASSANDO EM DTO COM APENAS INFOMAÇÕES PUBLICAS
	public Medical findById(Integer id) {
		Optional<Medical> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + Medical.class.getName()));
	}
// RETORNANDO UMA LISTA DE MEDICOS
	public List<Medical> findAll() {
		return repository.findAll();
	}
	
	public Medical create(Medical Obj) {
		if(findByCpf(Obj) != null) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}
		Medical newObj = new Medical(null, Obj.getName(), Obj.getUsername(), Obj.getPassword(), Obj.getSex(), Obj.getCpf(),Obj.getEmail(),Obj.getPhone(),Obj.getStreet(),Obj.getNumberStreet(),Obj.getZipCode(),Obj.getCity(),Obj.getState(),Obj.getSpecialty());
		return repository.save(newObj);
	}
	
	public Medical update(Integer id, @Valid Medical obj) {
		Medical oldObj = findById(id);
		
		if(findByCpf(obj)!= null && findByCpf(obj).getId() != id) {
			throw new DataIntregatyViolationException("CPF já cadastrado na base de dados!");
		}
		
		oldObj.setName(obj.getName());
		oldObj.setUsername(obj.getUsername());
		oldObj.setCpf(obj.getCpf());
		oldObj.setEmail(obj.getEmail());
		oldObj.setPassword(obj.getPassword());
		oldObj.setCity(obj.getCity());
		oldObj.setList(obj.getList());
		oldObj.setNumberStreet(obj.getNumberStreet());
		oldObj.setPhone(obj.getPhone());
		oldObj.setSex(obj.getSex());
		oldObj.setSpecialty(obj.getSpecialty());
		oldObj.setState(obj.getState());
		oldObj.setStreet(obj.getStreet());
		oldObj.setZipCode(obj.getZipCode());
		return repository.save(oldObj);
	}
	
//	public void delete(Integer id) {
//		repository.deleteById(id);
//	}
	
	public @ResponseBody boolean delete(@PathVariable("id") int id) {
		Medical obj = findById(id);
		if(obj.getList().size() > 0) {
			throw new DataIntregatyViolationException("Medico possui Agendamentos, não pode ser DELETADO!!");

		}
		repository.deleteById(id);
		return !repository.existsById(id);
	}
	
	
	private User findByCpf(Medical obj) {
		User objNew = userRepository.findByCPF(obj.getCpf());
		
		if(objNew != null) {
			return objNew;
		}
		return null;
	}
	
	
}
