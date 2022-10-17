package br.com.entra21.ASC.main.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.entra21.ASC.main.dtos.MedicalDTO;
import br.com.entra21.ASC.main.dtos.PatientDTO;
import br.com.entra21.ASC.main.model.Medical;
import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.services.MedicalService;
@CrossOrigin(origins = "*")
@RestController // VAI PODER RECEBER REQUISIÇÕES DO TIPO HTTP
@RequestMapping(value = "/medicals") // SETANDO UM ENDPOINT INICIAL PARA PODERMOS ACESSAR O RECURSO DOS MEDICOS
public class MedicalResource {

	@Autowired
	private MedicalService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicalDTO> findById(@PathVariable Integer id) {
		MedicalDTO objDTO = new MedicalDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@PostMapping(value = "/login")
	public MedicalDTO login(@Valid @RequestBody Medical obj){
		MedicalDTO logado = new MedicalDTO(service.login(obj));
		if(logado != null) {
			return logado;
		}
		return null;
	}
	
	@GetMapping // CASO PESQUISE PELO PARAMENTRO DESSA CLASSE, SEM INSERIR UM VALOR DE ID, VAI
				// SER APLICADO ESSE MÉTODO ONDE VAMOS LISTAR TODOS
	public ResponseEntity<List<MedicalDTO>> findAll() {


		List<MedicalDTO> listDTO = service.findAll().stream().map(obj -> new MedicalDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<Medical> create(@Valid @RequestBody Medical obj) {
		Medical newObj = service.create(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<MedicalDTO> update(@PathVariable Integer id, @Valid @RequestBody Medical obj) {
		MedicalDTO newObj = new MedicalDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
