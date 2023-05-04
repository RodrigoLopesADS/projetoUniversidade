package br.edu.ifms.universidade.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.universidade.dto.AlunoDto;
import br.edu.ifms.universidade.model.Aluno;
import br.edu.ifms.universidade.service.AlunoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoResource {

	@Autowired
	private AlunoService aluno;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {		
		Aluno obj = aluno.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDto objDto) {
		Aluno obj = aluno.fromDto(objDto);
		obj = aluno.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody AlunoDto objDto, @PathVariable Integer id) {
		Aluno obj = aluno.fromDto(objDto);
		obj.setId(id);
		obj = aluno.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@RequestBody Aluno obj, @PathVariable Integer id){
		aluno.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<AlunoDto>> findAll() {		
		List<Aluno> list = aluno.buscarTodos();
		System.out.println(list);
		List<AlunoDto> listDto = list.stream().map(obj -> new AlunoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
}
