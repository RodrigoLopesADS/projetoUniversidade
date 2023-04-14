package br.edu.ifms.universidade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int numero_turma;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	
	@ManyToMany
	@JoinTable(
			name = "Turma_Disciplina",
			joinColumns = @JoinColumn(name = "turma_id"),
			inverseJoinColumns = @JoinColumn(name = "disciplina_id")
			)
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	
	
	public Turma() {
		// TODO Auto-generated constructor stub
	}


	public Turma(Integer id, int numero_turma, Curso curso) {
		super();
		this.curso = curso;
		this.id = id;
		this.numero_turma = numero_turma;
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
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}
	
	
	


	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}


	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}


	public Curso getCurso() {
		return curso;
	}


	public void setCurso(Curso curso) {
		this.curso = curso;
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
