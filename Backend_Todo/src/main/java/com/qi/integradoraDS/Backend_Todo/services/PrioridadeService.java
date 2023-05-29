package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.repositories.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadeService {
    @Autowired
    private PrioridadeRepository priRep;

    public List<Prioridade> prioridadesList(){
        return priRep.findAll();
    }
}
