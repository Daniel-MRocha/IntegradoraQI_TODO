package com.qi.integradoraDS.Backend_Todo.Dtos;

import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;

public class PrioridadeDto {

    private int id;
    private String tipo;

    //Construtores
    public PrioridadeDto(){}
    public PrioridadeDto(Prioridade entity){
        this.id = entity.getId();
        this.tipo=entity.getTipo();
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
}
