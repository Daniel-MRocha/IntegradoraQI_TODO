package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class TarefaService {

    @Autowired
    private TarefaRepository trfRpy;

    @Transactional(readOnly = true)
    public List<TarefaDto> totalTarefas(){
        List<TarefaDto> lDto = new ArrayList<>();
        var listaTarefas = trfRpy.findAll();
        for (Tarefa t: listaTarefas){
            TarefaProjection tPjt = trfRpy.todasTarefas(t.getId());
            System.out.println(tPjt.getINICIO().getClass());
            lDto.add(new TarefaDto(tPjt));
        }
        return lDto;
    }

    public Optional<TarefaDto> tarefaUnitaria(Integer num){
        var aux = trfRpy.findById(num);
        try{
            TarefaDto tarefaUni = new TarefaDto();
            tarefaUni.setTarefa(aux.get().getTarefa());
            tarefaUni.setTitulo(aux.get().getTitulo());
            tarefaUni.setInicio(aux.get().getInicio().toString());
            tarefaUni.setDeadline(aux.get().getDeadline().toString());
            //tarefaUni.setConcluida(aux.get().getConcluida().toString());
                return Optional.of(tarefaUni);
        }catch (Exception e){
                return Optional.empty();
        }
    }

}
