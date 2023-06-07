package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository trfRpy;

    public List<TarefaDto> totalTarefas(){
        List<TarefaDto> lDto = new ArrayList<>();
        var listaTarefas = trfRpy.findAll();
        for (Tarefa t: listaTarefas){
            TarefaProjection tPjt = trfRpy.todasTarefas(t.getId());
            lDto.add(new TarefaDto(tPjt));
        }
        for(TarefaDto d : lDto){
            System.out.printf(d.toString());
        }
        return lDto;
    }

}
