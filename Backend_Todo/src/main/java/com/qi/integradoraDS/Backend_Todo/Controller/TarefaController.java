package com.qi.integradoraDS.Backend_Todo.Controller;

import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Tarefas")
public class TarefaController {

    @Autowired
    private TarefaService trfSrc;

    //todo mudar para stream
    @GetMapping
    public List<Tarefa> tarefasFrontend(){
        return trfSrc.serveTodasTarefas();

    }
}
