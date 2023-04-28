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

import br.edu.ifms.universidade.dto.DisciplinaDto;
import br.edu.ifms.universidade.model.Disciplina;
import br.edu.ifms.universidade.service.DisciplinaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaResource {
	
	@Autowired
	private DisciplinaService disciplina;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> find(@PathVariable Integer id) {		
		Disciplina obj = disciplina.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody DisciplinaDto objDto) {
		Disciplina obj = disciplina.fromDto(objDto);
		obj = disciplina.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody DisciplinaDto objDto, @PathVariable Integer id) {
		Disciplina obj = disciplina.fromDto(objDto);
		obj.setId(id);
		obj = disciplina.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@RequestBody Disciplina obj,@PathVariable Integer id){
		disciplina.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<DisciplinaDto>> findAll() {		
		List<Disciplina> list = disciplina.buscarTodos();
		List<DisciplinaDto> listDto = list.stream().map(obj -> new DisciplinaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	

}
