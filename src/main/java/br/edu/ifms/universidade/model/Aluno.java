package br.edu.ifms.universidade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;


@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeAluno;
	private int ra;
	
	
	
	@ManyToMany(mappedBy = "alunos")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}


	public Aluno(Integer id, String nomeAluno, int ra) {
		super();
		this.id = id;
		this.nomeAluno = nomeAluno;
		this.ra = ra;
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
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}
	
	


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}
	
	
	
	
	
}
