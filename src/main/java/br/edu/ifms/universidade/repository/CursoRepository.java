package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.universidade.model.Curso;


@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
