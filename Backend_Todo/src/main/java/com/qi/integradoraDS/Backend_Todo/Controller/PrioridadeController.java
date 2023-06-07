package com.qi.integradoraDS.Backend_Todo.Controller;

import com.qi.integradoraDS.Backend_Todo.Dtos.PrioridadeDto;
import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.repositories.PrioridadeRepository;
import com.qi.integradoraDS.Backend_Todo.services.PrioridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/Prioridades")
public class PrioridadeController{

    @Autowired
    private PrioridadeService PrioServ;

    @GetMapping
    public List<PrioridadeDto> buscaPrioridades(){
        return PrioServ.prioridadesList().stream().map(x-> new PrioridadeDto(x)).toList();
    }
}
