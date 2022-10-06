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

import br.com.entra21.ASC.main.dtos.TeamDTO;
import br.com.entra21.ASC.main.model.TeamDados;
import br.com.entra21.ASC.main.services.TeamService;

@CrossOrigin(origins = "*")
@RestController // VAI PODER RECEBER REQUISIÇÕES DO TIPO HTTP
@RequestMapping(value = "/team") // SETANDO UM ENDPOINT INICIAL PARA PODERMOS ACESSAR O RECURSO DOS MEDICOS
public class TeamResource {

	
	@Autowired
	private TeamService service;;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TeamDTO> findById(@PathVariable Integer id) {
		TeamDTO objDTO = new TeamDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping // CASO PESQUISE PELO PARAMENTRO DESSA CLASSE, SEM INSERIR UM VALOR DE ID, VAI
				// SER APLICADO ESSE MÉTODO ONDE VAMOS LISTAR TODOS
	public ResponseEntity<List<TeamDTO>> findAll() {

//		List<Admin> list = service.findAll();
//		List<AdminDTO> listDTO = new ArrayList<>();
//      ESTOU LISTANDO CADA MEDICO QUE EXISTE NA LISTA DE MEDICOS, CHAMANDO ELE DE "OBJ", E ENTÃO ESTAMOS ADICIONANDO ELE NA NOSSA LISTA DTOP PASSANDO COMO PARAMENTRO O OBJ DA LISTA

//		for(Admin obj : list) {
//			listDTO.add(new AdminDTO(obj));
//		}

		// FORMA MAIS MODERNA E LIMPA DE USAR UM FOR EACH
//		list.forEach(obj -> listDTO.add(new AdminDTO(obj)));

		// JEITO MAIS SIMPLIFICADO DE FAZER
		List<TeamDTO> listDTO = service.findAll().stream().map(obj -> new TeamDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')") // neste caso, somente admins podem acessar o método
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") // neste caso, somente admins podem acessar o método
	@PostMapping
	public ResponseEntity<TeamDados> create(@Valid @RequestBody TeamDados obj) {
		TeamDados newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

//	@PostMapping("/savePassword")
//	public ResponseEntity<Admin> savePassword(@RequestBody Admin admin) {
//		admin.setPassword(encoder.encode(admin.getPassword()));
//		return ResponseEntity.ok(repository.save(admin));
//	}

//	validar a senha por username
//	@GetMapping("validatePassword")
//	public ResponseEntity<Boolean> validatePassword(@RequestParam String username, @RequestParam String password) {
//
//		Optional<Admin> obj = Optional.of(repository.findByUsername(username));
//		if (obj.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//		}
//		Admin admin = obj.get();
//		boolean valid = encoder.matches(password, admin.getPassword());
//
//		HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//		return ResponseEntity.status(status).body(valid);
//
//	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<TeamDTO> update(@PathVariable Integer id, @Valid @RequestBody TeamDados obj) {
		TeamDTO newObj = new TeamDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
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
