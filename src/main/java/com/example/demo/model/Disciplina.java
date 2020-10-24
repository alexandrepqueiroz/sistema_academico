package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_DISCIPLINA")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddisciplina;

    @Column(name = "nome_disciplina", nullable = false)
    private String nomeDisciplina;

    @JsonIgnore
    @ManyToMany(mappedBy = "disciplinas", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Curso> cursos = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "disciplina", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private List<Turma> turmas = new ArrayList<>();


    public Disciplina (){}

    public Disciplina(Integer iddisciplina, String nome_disciplina) {
        this.iddisciplina = iddisciplina;
        this.nomeDisciplina = nome_disciplina;
    }

    public Integer getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(Integer iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getNome_disciplina() {
        return nomeDisciplina;
    }

    public void setNome_disciplina(String nome_disciplina) {
        this.nomeDisciplina = nome_disciplina;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(iddisciplina, that.iddisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iddisciplina);
    }
}