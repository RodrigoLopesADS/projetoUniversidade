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

import br.edu.ifms.universidade.dto.InstituicaoDto;
import br.edu.ifms.universidade.model.Instituicao;
import br.edu.ifms.universidade.service.InstituicaoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/instituicao")
public class InstituicaoResource {
	
	@Autowired
	private InstituicaoService inst;
	
	@GetMapping("/{id}")
	public ResponseEntity<Instituicao> find(@PathVariable Integer id) {		
		Instituicao obj = inst.buscarId(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody InstituicaoDto objDto) {
		Instituicao obj = inst.fromDto(objDto);
		obj = inst.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody InstituicaoDto objDto, @PathVariable Integer id) {
		Instituicao obj = inst.fromDto(objDto);
		obj.setId(id);
		obj = inst.atualizar(obj);
		return ResponseEntity.noContent().build();
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@RequestBody Instituicao obj,@PathVariable Integer id){
		inst.remover(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<InstituicaoDto>> findAll() {		
		List<Instituicao> list = inst.buscarTodos();
		List<InstituicaoDto> listDto = list.stream().map(obj -> new InstituicaoDto()).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

}
