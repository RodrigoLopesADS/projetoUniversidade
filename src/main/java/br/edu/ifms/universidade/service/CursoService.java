package br.edu.ifms.universidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.dto.CursoDto;
import br.edu.ifms.universidade.model.Curso;
import br.edu.ifms.universidade.repository.CursoRepository;
import br.edu.ifms.universidade.service.exception.ObjectNotFoundException;

@Service
public class CursoService {
	
	
	@Autowired
	private CursoRepository cursoRepository;
	
	
	public List<Curso> buscarTodos(){
		return cursoRepository.findAll();
		
	}
	
	public Curso buscarId(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Curso.class.getName()));
		
	}
	
	public Curso inserir(Curso curso) {
		curso.setId(null);
		return cursoRepository.save(curso);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		cursoRepository.deleteById(id);
		
	}
	
	public Curso atualizar(Curso curso) {
		Curso cursoNovo = buscarId(curso.getId());
		
		cursoNovo.setNome_curso(curso.getNome_curso());
		cursoNovo.setÁrea_atuacao(curso.getÁrea_atuacao());
		
		
		return cursoRepository.save(cursoNovo);
		
	}

	public Curso fromDto(CursoDto cursoDto) {
		return new Curso(cursoDto.getId(), cursoDto.getNome_curso(), cursoDto.getÁrea_atuacao(), null);
		
	}

}
