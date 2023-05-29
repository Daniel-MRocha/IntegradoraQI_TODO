package com.qi.integradoraDS.Backend_Todo.repositories;

import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {
}
