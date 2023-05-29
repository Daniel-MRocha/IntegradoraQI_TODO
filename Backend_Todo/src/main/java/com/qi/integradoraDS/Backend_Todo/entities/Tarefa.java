package com.qi.integradoraDS.Backend_Todo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR", length = 90)
    private String titulo;

    @Column(columnDefinition = "TEXT",length = 300)
    private String tarefa;

    @ManyToOne
    @JoinColumn(name="ID_PRIORIDADE")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "ID_SITUACAO")
    private Situacao situacao;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime inicio;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime deadline;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime concluida;

    @Deprecated
    public Tarefa(){};
    //Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
    public void setConcluida(LocalDateTime concluida) {
        this.concluida = concluida;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getTarefa() {
        return tarefa;
    }
    public Prioridade getPrioridade() {
        return prioridade;
    }
    public Situacao getSituacao() {
        return situacao;
    }
    public LocalDateTime getInicio() {
        return inicio;
    }
    public LocalDateTime getDeadline() {
        return deadline;
    }
    public LocalDateTime getConcluida() {
        return concluida;
    }
}

