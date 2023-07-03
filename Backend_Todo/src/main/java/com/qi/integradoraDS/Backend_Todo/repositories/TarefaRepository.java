package com.qi.integradoraDS.Backend_Todo.repositories;

import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {

    @Query(nativeQuery = true,value = """
            SELECT tarefa.id, tarefa.titulo, tarefa.tarefa,prioridade.tipo, situacao.status, 
            tarefa.inicio, tarefa.deadline, tarefa.concluida FROM tarefa
            INNER JOIN prioridade ON prioridade.id=tarefa.prioridade
            INNER JOIN situacao ON situacao.id=tarefa.situacao
            WHERE tarefa.id = :Id
            ORDER BY tarefa.titulo
            """)
    TarefaProjection todasTarefas(Integer Id);

    @Query(nativeQuery = true,value = """
            DELETE FROM tarefa WHERE tarefa.id = :Id
            """)
    TarefaProjection deletaTarefa(Integer Id);


}

