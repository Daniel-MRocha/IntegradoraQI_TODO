package com.qi.integradoraDS.Backend_Todo.Controller;


import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.services.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/Tarefas")
public class TarefaController {

    @Autowired
    private TarefaService trfSrc;


   @GetMapping
    public List<TarefaDto> tarefasFrontend(){
        return trfSrc.totalTarefas();
    }

    @GetMapping(value = "/{numero}")
    public TarefaDto tarefaUnitaria (@PathVariable Integer numero){
       return trfSrc.tarefaUnitaria(numero).get();
    }


}
