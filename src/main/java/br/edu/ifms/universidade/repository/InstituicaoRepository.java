package br.edu.ifms.universidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.universidade.model.Instituicao;


public interface InstituicaoRepository extends JpaRepository<Instituicao, Integer> {

}
