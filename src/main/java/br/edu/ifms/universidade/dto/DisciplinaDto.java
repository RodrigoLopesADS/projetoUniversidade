package br.edu.ifms.universidade.dto;

public class DisciplinaDto {
	
	private Integer id;
	private String nomeDisciplina;
	private String cargaHoraria;
	
	public DisciplinaDto() {
		// TODO Auto-generated constructor stub
	}

	public DisciplinaDto(Integer id, String nomeDisciplina, String cargaHoraria) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
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
