package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.universidade.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
