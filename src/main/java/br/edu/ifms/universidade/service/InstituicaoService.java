package br.edu.ifms.universidade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ifms.universidade.dto.InstituicaoDto;
import br.edu.ifms.universidade.model.Instituicao;
import br.edu.ifms.universidade.repository.InstituicaoRepository;
import br.edu.ifms.universidade.service.exception.ObjectNotFoundException;

@Service
public class InstituicaoService {
	
	
	private InstituicaoRepository instituicaoRepository;
	
	
	
	public List<Instituicao> buscarTodos(){
		return instituicaoRepository.findAll();
		
	}
	
	public Instituicao buscarId(Integer id) {
		Optional<Instituicao> inst = instituicaoRepository.findById(id);
		return inst.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));
		
	}
	
	public Instituicao inserir(Instituicao inst) {
		inst.setId(null);
		return instituicaoRepository.save(inst);
		
	}
	
	public void remover(Integer id) {
		buscarId(id);
		instituicaoRepository.deleteById(id);
		
	}
	
	public Instituicao atualizar(Instituicao inst) {
		Instituicao instNovo = buscarId(inst.getId());
		
		instNovo.setNome_instituicao(inst.getNome_instituicao());
		instNovo.setCnpj(inst.getCnpj());
		
		
		return instituicaoRepository.save(instNovo);
		
	}

	public Instituicao fromDto(InstituicaoDto instDto) {
		return new Instituicao(instDto.getId(), instDto.getNome_instituicao(), instDto.getCnpj());
		
	}

}
