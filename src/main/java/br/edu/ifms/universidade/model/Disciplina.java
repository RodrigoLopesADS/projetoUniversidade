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


@Entity
public class Disciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeDisciplina;
	private String cargaHoraria;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<Turma> turmas = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(
			name = "Aluno_Disciplina",
			joinColumns = @JoinColumn(name = "disciplina_id"),
			inverseJoinColumns = @JoinColumn(name = "aluno_id")
			)
	private List<Aluno> alunos = new ArrayList<>();
	
	
	public Disciplina() {
		// TODO Auto-generated constructor stub
	}


	public Disciplina(Integer id, String nomeDisciplina, String cargaHoraria) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
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
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}
	
	


	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


	public List<Turma> getTurmas() {
		return turmas;
	}


	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
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
