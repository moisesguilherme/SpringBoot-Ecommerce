package org.una.sdm.aula09.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

    @Entity
    public class Banda implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private int anoDeFormacao;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeFormacao() {
        return anoDeFormacao;
    }

    public void setAnoDeFormacao(int anoDeFormacao) {
        this.anoDeFormacao = anoDeFormacao;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banda banda = (Banda) o;
        return id == banda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Banda{" +
                "nome='" + nome + '\'' +
                ", anoDeFormacao=" + anoDeFormacao +
                ", id=" + id +
                '}';
    }
}