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

import br.edu.ifms.universidade.dto.TurmaDto;
import br.edu.ifms.universidade.model.Turma;
import br.edu.ifms.universidade.service.TurmaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turma;

	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> find(@PathVariable Integer id) {		
		Turma obj = turma.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody TurmaDto objDto) {
		Turma obj = turma.fromDto(objDto);
		obj = turma.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody TurmaDto objDto, @PathVariable Integer id) {
		Turma obj = turma.fromDto(objDto);
		obj.setId(id);
		obj = turma.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@RequestBody Turma obj,@PathVariable Integer id){
		turma.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<TurmaDto>> findAll() {		
		List<Turma> list = turma.buscarTodos();
		System.out.println(list);
		List<TurmaDto> listDto = list.stream().map(obj -> new TurmaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
