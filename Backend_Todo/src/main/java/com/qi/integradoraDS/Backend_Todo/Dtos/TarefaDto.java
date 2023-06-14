package com.qi.integradoraDS.Backend_Todo.Dtos;


import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.entities.Situacao;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;


import java.io.Serializable;
import java.time.LocalDate;




public class TarefaDto implements Serializable {
    private static final long serialVersionUID= 1L;


    private int id;
    private String titulo;
    private String tarefa;
    private String prioridade;
    private String situacao;
    private String inicio;
    private String deadline;
    private String concluida;


    public TarefaDto(){};

    public TarefaDto(TarefaProjection trfPjc){
        id=trfPjc.getID();
        titulo=trfPjc.getTITULO();
        tarefa=trfPjc.getTAREFA();
        prioridade=trfPjc.getTIPO();
        situacao=trfPjc.getSTATUS();
        inicio=trfPjc.getINICIO();
        deadline=trfPjc.getDEADLINE();
        concluida=trfPjc.getCONCLUIDA();

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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getConcluida() {
        return this.concluida;
    }

    public void setConcluida(String concluida) {
        this.concluida = concluida;
    }
}
