package com.qi.integradoraDS.Backend_Todo.Dtos;


import com.qi.integradoraDS.Backend_Todo.entities.Prioridade;
import com.qi.integradoraDS.Backend_Todo.entities.Situacao;



import java.io.Serializable;
import java.time.LocalDateTime;

public class TarefaDto implements Serializable {
    private static final long serialVersionUID= 1L;


    private int id;
    private String titulo;
    private String tarefa;
    /**private Prioridade prioridade;
    private Situacao situacao;
    private LocalDateTime inicio;
    private LocalDateTime deadline;
    private LocalDateTime concluida;
*/
    @Deprecated
    public TarefaDto(){};

    public TarefaDto(int id,String titulo, String tarefa){
        this.id=id;
        this.titulo=titulo;
        this.tarefa=tarefa;
        /**this.prioridade=pri;
        this.situacao=sit;
        this.inicio=ini;
        this.deadline=dline;
        this.concluida=cld;*/
    }

}
