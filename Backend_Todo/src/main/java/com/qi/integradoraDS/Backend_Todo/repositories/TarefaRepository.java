package com.qi.integradoraDS.Backend_Todo.repositories;

import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {

    @Query(nativeQuery = true,value = """
            SELECT TAREFA.ID, TAREFA.TITULO, TAREFA.TAREFA,PRIORIDADE.TIPO, SITUACAO.STATUS, 
            TAREFA.INICIO, TAREFA.DEADLINE, TAREFA.CONCLUIDA FROM TAREFA
            INNER JOIN PRIORIDADE ON PRIORIDADE.ID=TAREFA.ID_PRIORIDADE
            INNER JOIN SITUACAO ON SITUACAO.ID=TAREFA.ID_SITUACAO
            WHERE TAREFA.ID = :Id
            ORDER BY TAREFA.TITULO
            """)
    TarefaProjection todasTarefas(Integer Id);

    @Query(nativeQuery = true,value = """
            DELETE FROM TAREFA WHERE TAREFA.ID=:Id
            """)
    TarefaProjection deletaTarefa(Integer Id);

}

