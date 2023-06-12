package com.qi.integradoraDS.Backend_Todo.Projection;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;


public interface TarefaProjection {
        String getTITULO();
        String getTAREFA();
        String getTIPO();
        String getSTATUS();
        String getINICIO();
        String getDEADLINE();
        String getCONCLUIDA();
}
