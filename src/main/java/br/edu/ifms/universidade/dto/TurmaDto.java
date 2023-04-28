package br.edu.ifms.universidade.dto;

import br.edu.ifms.universidade.model.Turma;

public class TurmaDto {
	
	private Integer id;
	private int numero_turma;
	
	
	public TurmaDto() {
		// TODO Auto-generated constructor stub
	}

	
	public TurmaDto(Turma obj) {
		this.id = obj.getId();
		this.numero_turma = obj.getNumero_turma();
		
	}

	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public int getNumero_turma() {
		return numero_turma;
	}


	public void setNumero_turma(int numero_turma) {
		this.numero_turma = numero_turma;
	}
	
	
	
	
	
	

}
