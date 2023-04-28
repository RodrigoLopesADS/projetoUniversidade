package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.universidade.model.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
