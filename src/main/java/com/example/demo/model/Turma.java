package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_TURMA")
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="disciplina_id", nullable = false)
    private Disciplina disciplina;

    @Column(name = "nome_turma", nullable = false)
    private String nomeDaturma;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="turma_aluno",
            joinColumns = @JoinColumn(name="turma_id"),
            inverseJoinColumns = @JoinColumn(name="aluno_id"))
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(){}

    public Turma(Integer id, Disciplina disciplina, String nomeDaturma) {
        this.id = id;
        this.disciplina = disciplina;
        this.nomeDaturma = nomeDaturma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getNomeDaturma() {
        return nomeDaturma;
    }

    public void setNomeDaturma(String nomeDaturma) {
        this.nomeDaturma = nomeDaturma;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(id, turma.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
