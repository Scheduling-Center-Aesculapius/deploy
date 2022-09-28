package br.com.entra21.ASC.main.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.entra21.ASC.main.dtos.SchedulingDTO;
import br.com.entra21.ASC.main.services.SchedulingServices;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="/scheduling")
public class SchedulingResource {
	
	@Autowired
	private SchedulingServices services;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SchedulingDTO> findById(@PathVariable Integer id){
		SchedulingDTO obj = new SchedulingDTO(services.findById(id));
		
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping
	public ResponseEntity<List<SchedulingDTO>> findAll(){
		List<SchedulingDTO> list = services.findAll().stream().map(obj -> new SchedulingDTO(obj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<SchedulingDTO> create(@Valid @RequestBody SchedulingDTO obj){
		obj = new SchedulingDTO(services.create(obj));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PutMapping
	public ResponseEntity<SchedulingDTO> update(@Valid @RequestBody SchedulingDTO obj){
		obj = new SchedulingDTO(services.update(obj));
		return ResponseEntity.ok().body(obj);
		
	}

}
