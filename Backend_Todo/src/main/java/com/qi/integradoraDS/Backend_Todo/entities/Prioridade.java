package com.qi.integradoraDS.Backend_Todo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="PRIORIDADE")
public class Prioridade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    private String tipo;

    @OneToMany(mappedBy = "prioridade")
    private List<Tarefa>  pri_tarefa;

    //Construtores, com e sem argumentos,sem argumentos é
    //uma boa pratica quando se trabalha com hibernate
    @Deprecated
    public Prioridade(){};
    public Prioridade(int id, String tipo){
        super();
        this.id = id;
        this.tipo=tipo;
    }

    //Métodos acessores
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
