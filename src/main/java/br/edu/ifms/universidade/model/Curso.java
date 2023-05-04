package br.edu.ifms.universidade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome_curso;
	private String área_atuacao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_instituicao")
	private Instituicao instituicao;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Turma> turma = new ArrayList<>();
	
	public Curso() {
		
	}
	
	

	public Curso(Integer id, String nome_curso, String área_atuacao, Instituicao instituicao) {
		super();
		this.instituicao = instituicao;
		this.id = id;
		this.nome_curso = nome_curso;
		this.área_atuacao = área_atuacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
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
