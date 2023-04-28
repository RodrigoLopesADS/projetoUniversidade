package br.edu.ifms.universidade.dto;

import br.edu.ifms.universidade.model.Curso;

public class CursoDto {
	
	private Integer id;
	private String nome_curso;
	private String área_atuacao;
	
	
	public CursoDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CursoDto(Curso obj) {
		
		this.id = obj.getId();
		this.nome_curso = obj.getNome_curso();
		this.área_atuacao = obj.getÁrea_atuacao();
		
	}


	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome_curso() {
		return nome_curso;
	}


	public void setNome_curso(String nome_curso) {
		this.nome_curso = nome_curso;
	}


	public String getÁrea_atuacao() {
		return área_atuacao;
	}


	public void setÁrea_atuacao(String área_atuacao) {
		this.área_atuacao = área_atuacao;
	}
	
	
	

}
