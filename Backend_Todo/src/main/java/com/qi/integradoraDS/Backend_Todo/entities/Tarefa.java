package com.qi.integradoraDS.Backend_Todo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties( value={"handler","hibernateLazyInitializer","FieldHandler"})
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar", length = 40)
    private String titulo;

    @Column(columnDefinition = "text", length = 300)
    private String tarefa;

    @ManyToOne
    @JoinColumn(name="ID_PRIORIDADE")
    private Prioridade prioridade;

    @ManyToOne
    @JoinColumn(name = "ID_SITUACAO")
    private Situacao situacao;

    @JsonFormat(pattern="YYYY-MM-DD")
    @Column(columnDefinition = "DATE")
    private LocalDate inicio;

    @Column(columnDefinition = "DATE")
    private LocalDate deadline;

    @Column(columnDefinition = "DATE")
    private LocalDate concluida;


    public Tarefa(){}
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
    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public void setConcluida(LocalDate concluida) {
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
    public LocalDate getInicio() {
        return inicio;
    }
    public LocalDate getDeadline() {
        return deadline;
    }
    public LocalDate getConcluida() {
        return concluida;
    }
}

