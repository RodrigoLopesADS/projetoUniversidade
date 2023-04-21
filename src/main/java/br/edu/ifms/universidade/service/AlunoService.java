package br.edu.ifms.universidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.dto.AlunoDto;
import br.edu.ifms.universidade.model.Aluno;
import br.edu.ifms.universidade.repository.AlunoRepository;
import br.edu.ifms.universidade.service.exception.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	
	public List<Aluno> buscarTodos(){
		return alunoRepository.findAll();
		
	}
	
	public Aluno buscarId(Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
		
	}
	
	public Aluno inserir(Aluno aluno) {
		aluno.setId(null);
		return alunoRepository.save(aluno);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		alunoRepository.deleteById(id);
		
	}
	
	public Aluno atualizar(Aluno aluno) {
		Aluno alunoNovo = buscarId(aluno.getId());
		
		alunoNovo.setNomeAluno(aluno.getNomeAluno());
		alunoNovo.setRa(aluno.getRa());
		
		
		return alunoRepository.save(alunoNovo);
		
	}

	public Aluno fromDto(AlunoDto alunoDto) {
		return new Aluno(alunoDto.getId(), alunoDto.getNomeAluno(), alunoDto.getRa());
		
	}
		
	
	

}
