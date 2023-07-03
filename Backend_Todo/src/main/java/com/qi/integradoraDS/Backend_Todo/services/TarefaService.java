package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Situacao;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.repositories.TarefaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            lDto.add(new TarefaDto(tPjt));
        }
        return lDto;
    }

    //verifica se o registro existe,caso exita, envia a TarefaDto
    @Transactional(readOnly = true)
    public TarefaDto buscaTarefaUnitaria(Integer num) {
        var aux = trfRpy.findById(num);
            if(aux.isPresent()){
                TarefaProjection tprju = trfRpy.todasTarefas(aux.get().getId());
                TarefaDto tDto = new TarefaDto(tprju);
                return tDto;
            }else {
                return null;
            }
    }

    public void deletaTarefaUnitaria(Integer num){
         var aux = trfRpy.findById(num);
            aux.ifPresent(trf -> trfRpy.delete(trf));
    }

    public void grava(Tarefa t){
        trfRpy.save(t);
    }

    public void tarefaConcluida(Integer num){
        Tarefa trf = trfRpy.getReferenceById(num);
        trf.setConcluida(LocalDate.now());
        trfRpy.save(trf);
}
    public Tarefa updateTarefa(Integer num){
        return trfRpy.getReferenceById(num);
    }

   /** @PostConstruct
    public void  lista_UpdateSituacao(){
        LocalDate hoje = LocalDate.now();
        var lista_tarefas = trfRpy.findAll();

        for(Tarefa t: lista_tarefas){
            if((t.getDeadline().isAfter(hoje) && t.getConcluida()==null)){
                Situacao sit = new Situacao();
                sit.setId(2);
                sit.setStatus("Expirada");
                t.setSituacao(sit);
                trfRpy.save(t);
            } else if (t.getDeadline().isAfter(hoje) && t.getConcluida()!=null){
                Situacao sit = new Situacao();
                sit.setId(3);
                sit.setStatus("Concluida");
                t.setSituacao(sit);
                trfRpy.save(t);
            }
        }
    }*/
}


