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

import br.com.entra21.ASC.main.dtos.AdminDTO;
import br.com.entra21.ASC.main.model.Admin;
import br.com.entra21.ASC.main.services.AdminService;

@CrossOrigin(origins = "*")
@RestController // VAI PODER RECEBER REQUISIÇÕES DO TIPO HTTP
@RequestMapping(value = "/admins") // SETANDO UM ENDPOINT INICIAL PARA PODERMOS ACESSAR O RECURSO DOS MEDICOS
public class AdminResource {

	@Autowired
	private AdminService service;
//	PasswordEncoder encoder,

	@GetMapping(value = "/{id}")
	public ResponseEntity<AdminDTO> findById(@PathVariable Integer id) {
		AdminDTO objDTO = new AdminDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}
	
	@PostMapping(value = "/login")
	public AdminDTO login(@Valid @RequestBody Admin obj){
		AdminDTO logado = new AdminDTO(service.login(obj));
		if(logado != null) {
			return logado;
		}
		return null;
	}

	@GetMapping // CASO PESQUISE PELO PARAMENTRO DESSA CLASSE, SEM INSERIR UM VALOR DE ID, VAI
				// SER APLICADO ESSE MÉTODO ONDE VAMOS LISTAR TODOS
	public ResponseEntity<List<AdminDTO>> findAll() {

//		List<Admin> list = service.findAll();
//		List<AdminDTO> listDTO = new ArrayList<>();
//      ESTOU LISTANDO CADA MEDICO QUE EXISTE NA LISTA DE MEDICOS, CHAMANDO ELE DE "OBJ", E ENTÃO ESTAMOS ADICIONANDO ELE NA NOSSA LISTA DTOP PASSANDO COMO PARAMENTRO O OBJ DA LISTA

//		for(Admin obj : list) {
//			listDTO.add(new AdminDTO(obj));
//		}

		// FORMA MAIS MODERNA E LIMPA DE USAR UM FOR EACH
//		list.forEach(obj -> listDTO.add(new AdminDTO(obj)));

		// JEITO MAIS SIMPLIFICADO DE FAZER
		List<AdminDTO> listDTO = service.findAll().stream().map(obj -> new AdminDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')") // neste caso, somente admins podem acessar o método
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')") // neste caso, somente admins podem acessar o método
	@PostMapping
	public ResponseEntity<Admin> create(@Valid @RequestBody Admin obj) {
		Admin newObj = service.create(obj);
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
	public ResponseEntity<AdminDTO> update(@PathVariable Integer id, @Valid @RequestBody Admin obj) {
		AdminDTO newObj = new AdminDTO(service.update(id, obj));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
