package br.edu.ifms.universidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.dto.TurmaDto;
import br.edu.ifms.universidade.model.Turma;
import br.edu.ifms.universidade.repository.TurmaRepository;
import br.edu.ifms.universidade.service.exception.ObjectNotFoundException;

@Service
public class TurmaService {

	
	private TurmaRepository turmaRepository;
	
	
	public List<Turma> buscarTodos(){
		return turmaRepository.findAll();
		
	}
	
	public Turma buscarId(Integer id) {
		Optional<Turma> turma = turmaRepository.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Turma.class.getName()));
		
	}
	
	public Turma inserir(Turma turma) {
		turma.setId(null);
		return turmaRepository.save(turma);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		turmaRepository.deleteById(id);
		
	}
	
	public Turma atualizar(Turma turma) {
		Turma turmaNovo = buscarId(turma.getId());
		
		turmaNovo.setNumero_turma(turma.getNumero_turma());
		
		
		return turmaRepository.save(turmaNovo);
		
	}

	public Turma fromDto(TurmaDto turmaDto) {
		return new Turma(turmaDto.getId(), turmaDto.getNumero_turma(), null);
		
	}
	
}
