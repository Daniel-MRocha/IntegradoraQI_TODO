package com.qi.integradoraDS.Backend_Todo.services;

import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.repositories.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrioridadeService {
    @Autowired
    private PrioridadeRepository priRep;

    public Prioridade buscaPri(int numero) {
        var aux = priRep.findById(numero);
        if (aux.isPresent()) return aux.get();
        return null;
    }
}
