package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.universidade.model.Disciplina;



public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
