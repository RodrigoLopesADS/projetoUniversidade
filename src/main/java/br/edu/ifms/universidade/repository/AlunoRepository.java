package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.universidade.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
