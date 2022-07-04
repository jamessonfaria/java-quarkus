package br.com.jamesson;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Fruta extends PanacheEntity {

    public String nome;
    public int qtd;

}
