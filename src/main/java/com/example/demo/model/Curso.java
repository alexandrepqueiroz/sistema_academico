package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_CURSO")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcurso;

    @Column(name="nome_curso", nullable = false)
    private String nomeCurso;

    @JsonIgnore
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name="curso_disciplina",
            joinColumns = @JoinColumn(name="curso_id"),
            inverseJoinColumns = @JoinColumn(name="disciplina_id"))
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(){}

    public Curso(Integer idcurso, String nome_curso) {
        this.idcurso = idcurso;
        this.nomeCurso = nome_curso;
    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNome_curso() {
        return nomeCurso;
    }

    public void setNome_curso(String nome_curso) {
        this.nomeCurso = nome_curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(idcurso, curso.idcurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcurso);
    }
}


