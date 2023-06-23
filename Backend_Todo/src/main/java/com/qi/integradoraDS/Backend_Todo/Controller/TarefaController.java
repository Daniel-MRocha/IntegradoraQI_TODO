package com.qi.integradoraDS.Backend_Todo.Controller;


import com.qi.integradoraDS.Backend_Todo.Dtos.TarefaDto;
import com.qi.integradoraDS.Backend_Todo.Projection.TarefaProjection;
import com.qi.integradoraDS.Backend_Todo.entities.Tarefa;
import com.qi.integradoraDS.Backend_Todo.services.PrioridadeService;
import com.qi.integradoraDS.Backend_Todo.services.SituacaoService;
import com.qi.integradoraDS.Backend_Todo.services.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value="/Tarefas")
public class TarefaController {

    @Autowired
    private TarefaService trfSrc;

    @Autowired
    private PrioridadeService priSrc;

    @Autowired
    private SituacaoService sitSrv;


    @GetMapping
    public List<TarefaDto> tarefasFrontend() {
        return trfSrc.totalTarefas();
    }

    @GetMapping(value = "/{numero}")
    public TarefaDto tarefaUnitaria(@PathVariable int numero) {
        return trfSrc.buscaTarefaUnitaria(numero);
    }

    @GetMapping(value = "/del/{numero}")
    public void deletaTarefaUnitaria(@PathVariable int numero) {
        trfSrc.deletaTarefaUnitaria(numero);
    }

    @PostMapping
    public String salvaTarefa(@RequestParam String titulo,
                              @RequestParam String tarefa,
                              @RequestParam int prioridade,
                              @RequestParam int situacao,
                              @RequestParam String inicio,
                              @RequestParam String deadline,
                              @RequestParam String concluida) {
        Tarefa trf_s = new Tarefa();
        trf_s.setTitulo(titulo);
        trf_s.setTarefa(tarefa);
        trf_s.setPrioridade(priSrc.buscaPri(prioridade));
        trf_s.setSituacao(sitSrv.buscaSit(situacao));
        trf_s.setInicio(LocalDate.parse(inicio));
        trf_s.setDeadline(LocalDate.parse(deadline));
        trf_s.setConcluida(LocalDate.parse(concluida));

        trfSrc.grava(trf_s);
        return "ok";
    }
}

