package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository trfRpy;

    public List<Tarefa> serveTodasTarefas(){
        return trfRpy.findAll();

    }
}
