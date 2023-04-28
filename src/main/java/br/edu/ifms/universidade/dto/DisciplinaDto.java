package br.edu.ifms.universidade.dto;

import br.edu.ifms.universidade.model.Disciplina;

public class DisciplinaDto {
	
	private Integer id;
	private String nomeDisciplina;
	private String cargaHoraria;
	
	public DisciplinaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public DisciplinaDto(Disciplina obj) {
		this.id = obj.getId();
		this.nomeDisciplina = obj.getNomeDisciplina();
		this.cargaHoraria = obj.getCargaHoraria();
		
	}
	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	

}
