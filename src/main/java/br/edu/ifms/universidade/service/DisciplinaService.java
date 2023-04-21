package br.edu.ifms.universidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.dto.DisciplinaDto;
import br.edu.ifms.universidade.model.Disciplina;
import br.edu.ifms.universidade.repository.DisciplinaRepository;
import br.edu.ifms.universidade.service.exception.ObjectNotFoundException;

@Service
public class DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	public List<Disciplina> buscarTodos(){
		return disciplinaRepository.findAll();
		
	}
	
	public Disciplina buscarId(Integer id) {
		Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
		return disciplina.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
		
	}
	
	public Disciplina inserir(Disciplina disciplina) {
		disciplina.setId(null);
		return disciplinaRepository.save(disciplina);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		disciplinaRepository.deleteById(id);
		
	}
	
	public Disciplina atualizar(Disciplina disciplina) {
		Disciplina disciplinaNovo = buscarId(disciplina.getId());
		
		disciplinaNovo.setNomeDisciplina(disciplina.getNomeDisciplina());
		disciplinaNovo.setCargaHoraria(disciplina.getCargaHoraria());
		
		
		return disciplinaRepository.save(disciplinaNovo);
		
	}

	public Disciplina fromDto(DisciplinaDto disciplinaDto) {
		return new Disciplina(disciplinaDto.getId(), disciplinaDto.getNomeDisciplina(), disciplinaDto.getCargaHoraria());
		
	}
	
	

}
