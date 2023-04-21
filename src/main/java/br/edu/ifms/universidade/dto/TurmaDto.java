package br.edu.ifms.universidade.dto;

public class TurmaDto {
	
	private Integer id;
	private int numero_turma;
	
	
	public TurmaDto() {
		// TODO Auto-generated constructor stub
	}


	public TurmaDto(Integer id, int numero_turma) {
		super();
		this.id = id;
		this.numero_turma = numero_turma;
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
