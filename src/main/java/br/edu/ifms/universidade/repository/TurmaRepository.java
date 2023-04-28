package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.universidade.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
