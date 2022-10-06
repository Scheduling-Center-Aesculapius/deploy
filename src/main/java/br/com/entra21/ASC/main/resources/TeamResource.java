package br.com.entra21.ASC.main.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.model.TeamDados;
import br.com.entra21.ASC.main.repositories.TeamRepository;
import br.com.entra21.ASC.main.services.exception.ObjectNotFoundException;

@CrossOrigin(origins = "*")
@RestController // VAI PODER RECEBER REQUISIÇÕES DO TIPO HTTP
@RequestMapping(value = "/TeamDados") // SETANDO UM ENDPOINT INICIAL PARA PODERMOS ACESSAR O RECURSO DOS MEDICOS
public class TeamResource {

	
	@Autowired
	private TeamRepository repository;
//	PasswordEncoder encoder,

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<TeamDados> findById(@PathVariable Integer id) {
//		TeamDados objDTO = new TeamDados(service.findById(id));
//		return ResponseEntity.ok().body(objDTO);
//
//	}
	
	public TeamDados findById(Integer id) {
		Optional<TeamDados> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"OBJETO NÃO ENCONTRADO! ID: " + id + ", tipo: " + TeamDados.class.getName()));
	}


	@GetMapping // CASO PESQUISE PELO PARAMENTRO DESSA CLASSE, SEM INSERIR UM VALOR DE ID, VAI
				// SER APLICADO ESSE MÉTODO ONDE VAMOS LISTAR TODOS
	public List<TeamDados> findAll() {
		return repository.findAll();
	}
	
	private TeamDados findByUsername(TeamDados obj) {
		TeamDados objNew = repository.findByUsername(obj.getName());
		if (objNew != null) {
			return objNew;
		}
		return null;
	}
}

//	@PreAuthorize("hasRole('ROLE_TeamDados')") // neste caso, somente TeamDadoss podem acessar o método
//	@PreAuthorize("hasAnyRole('ROLE_TeamDados', 'ROLE_USER')") // neste caso, somente TeamDadoss podem acessar o método

//	@PostMapping("/savePassword")
//	public ResponseEntity<TeamDados> savePassword(@RequestBody TeamDados TeamDados) {
//		TeamDados.setPassword(encoder.encode(TeamDados.getPassword()));
//		return ResponseEntity.ok(repository.save(TeamDados));
//	}

//	validar a senha por username
//	@GetMapping("validatePassword")
//	public ResponseEntity<Boolean> validatePassword(@RequestParam String username, @RequestParam String password) {
//
//		Optional<TeamDados> obj = Optional.of(repository.findByUsername(username));
//		if (obj.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//		}
//		TeamDados TeamDados = obj.get();
//		boolean valid = encoder.matches(password, TeamDados.getPassword());
//
//		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//		return ResponseEntity.status(status).body(valid);
//
//	}
