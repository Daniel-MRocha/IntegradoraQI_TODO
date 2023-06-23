package com.qi.integradoraDS.Backend_Todo.teste;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class dummy implements Serializable {
   private static final long serialVersionUID = 1L;


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int num;

   private String nome;

   public Integer getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }
}
