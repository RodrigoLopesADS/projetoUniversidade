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

import br.edu.ifms.universidade.dto.CursoDto;
import br.edu.ifms.universidade.model.Curso;
import br.edu.ifms.universidade.service.CursoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/curso")
public class CursoResource {
	
	@Autowired
	private CursoService curso;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> find(@PathVariable Integer id) {		
		Curso obj = curso.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CursoDto objDto) {
		Curso obj = curso.fromDto(objDto);
		obj = curso.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CursoDto objDto, @PathVariable Integer id) {
		Curso obj = curso.fromDto(objDto);
		obj.setId(id);
		obj = curso.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@RequestBody Curso obj,@PathVariable Integer id){
		curso.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<CursoDto>> findAll() {		
		List<Curso> list = curso.buscarTodos();
		List<CursoDto> listDto = list.stream().map(obj -> new CursoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

}
