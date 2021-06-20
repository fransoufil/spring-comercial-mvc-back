package com.fransoufil.comercial.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Cidade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //dependendo do BD é outro GenerationType
    private Integer id;
    private String nome;

    @JsonManagedReference
    //no lado que tem muitos, no exemplo, muitas cidades para um estado voce faz o abaixo
    @ManyToOne
    @JoinColumn(name = "estado_id")
    //acima na tabela cidade vair ter um campo, chamado estado_id que deve ser igual a estado_id em tabela de estados
    private Estado estado;

    public Cidade() {
    }

    public Cidade(Integer id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;

        Cidade cidade = (Cidade) o;

        return getId().equals(cidade.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

}
