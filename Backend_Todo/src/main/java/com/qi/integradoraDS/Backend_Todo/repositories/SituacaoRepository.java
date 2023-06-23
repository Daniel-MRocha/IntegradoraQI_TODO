package com.qi.integradoraDS.Backend_Todo.repositories;

import com.qi.integradoraDS.Backend_Todo.entities.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SituacaoRepository extends JpaRepository<Situacao,Integer> {
}
