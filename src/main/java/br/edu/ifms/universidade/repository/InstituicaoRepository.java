package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.universidade.model.Instituicao;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

}
