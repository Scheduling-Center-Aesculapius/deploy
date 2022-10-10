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

import br.com.entra21.ASC.main.dtos.PatientDTO;
import br.com.entra21.ASC.main.model.Patient;
import br.com.entra21.ASC.main.services.PatientService;
import br.com.entra21.ASC.main.services.exception.DataIntregatyViolationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/patients")
public class PatientResource {

	@Autowired
	private PatientService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PatientDTO> findById(@PathVariable Integer id) {
		PatientDTO objDTO = new PatientDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	@PostMapping(value = "/login")
	public PatientDTO login(@Valid @RequestBody Patient obj){
		PatientDTO logado = new PatientDTO(service.login(obj));
		if(logado != null) {
			return logado;
		}
		return null;
	}

	@PostMapping
	public ResponseEntity<Patient> create(@Valid @RequestBody Patient obj) {
		Patient newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<PatientDTO>> findAll() {
		List<PatientDTO> listDTO = service.findAll().stream().map(obj -> new PatientDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<PatientDTO> update(@PathVariable Integer id, @Valid @RequestBody Patient obj) {
		PatientDTO newObj = new PatientDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
