package br.edu.ifms.universidade.dto;

public class CursoDto {
	
	private Integer id;
	private String nome_curso;
	private String área_atuacao;
	
	
	public CursoDto() {
		// TODO Auto-generated constructor stub
	}


	public CursoDto(Integer id, String nome_curso, String área_atuacao) {
		super();
		this.id = id;
		this.nome_curso = nome_curso;
		this.área_atuacao = área_atuacao;
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
