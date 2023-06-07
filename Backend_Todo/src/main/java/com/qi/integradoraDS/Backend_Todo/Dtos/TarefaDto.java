package com.qi.integradoraDS.Backend_Todo.Dtos;


import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.entities.Situacao;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;


import java.io.Serializable;
import java.time.LocalDateTime;

public class TarefaDto implements Serializable {
    private static final long serialVersionUID= 1L;


    private int id;
    private String titulo;
    private String tarefa;
    private String prioridade;
    private String situacao;
    private LocalDateTime inicio;
    private LocalDateTime deadline;
    private LocalDateTime concluida;

    @Deprecated
    public TarefaDto(){};

    public TarefaDto(TarefaProjection trfPjc){
        titulo=trfPjc.getTITULO();
        tarefa=trfPjc.getTAREFA();
        prioridade=trfPjc.getTIPO();
        situacao=trfPjc.getSTATUS();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getConcluida() {
        return concluida;
    }

    public void setConcluida(LocalDateTime concluida) {
        this.concluida = concluida;
    }
}
