package com.qi.integradoraDS.Backend_Todo.Projection;

import org.springframework.context.annotation.Bean;


public interface TarefaProjection {
        String getTITULO();
        String getTAREFA();
        String getTIPO();
        String getSTATUS();
}
