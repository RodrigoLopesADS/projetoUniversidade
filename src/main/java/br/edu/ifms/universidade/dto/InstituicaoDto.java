package br.edu.ifms.universidade.dto;

import java.io.Serializable;

import br.edu.ifms.universidade.model.Instituicao;

public class InstituicaoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String nome_instituicao;
	private String cnpj;
	
	public InstituicaoDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public InstituicaoDto(Instituicao obj) {
		this.id = obj.getId();
		this.nome_instituicao = obj.getNome_instituicao();
		this.cnpj = obj.getCnpj();
		
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_instituicao() {
		return nome_instituicao;
	}

	public void setNome_instituicao(String nome_instituicao) {
		this.nome_instituicao = nome_instituicao;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	

}
