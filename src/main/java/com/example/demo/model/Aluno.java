package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_ALUNO")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idaluno;

    @Column(name = "nome_aluno", nullable = false)
    private String nomeAluno;

    @Temporal(TemporalType.DATE)
    private Date dtnasc;

    @Temporal(TemporalType.DATE)
    private Date dtmatricula;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "numero_matricula", nullable = false)
    private Integer numeroMatricula;

    @Column(name = "n1")
    private Double n1;

    @Column(name = "n2")
    private Double n2;

    @Column(name = "faltas")
    private Integer faltas;

    @JsonIgnore
    @ManyToMany(mappedBy = "alunos", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }
    )
    private List<Turma> turmas = new ArrayList<>();

    public Aluno(){}

    public Aluno(Integer idaluno, String nomeAluno, Date dtnasc, Date dtmatricula, String email, Integer numeroMatricula, Double n1, Double n2, Integer faltas) {
        this.idaluno = idaluno;
        this.nomeAluno = nomeAluno;
        this.dtnasc = dtnasc;
        this.dtmatricula = dtmatricula;
        this.email = email;
        this.numeroMatricula = numeroMatricula;
        this.n1 = n1;
        this.n2 = n2;
        this.faltas = faltas;
    }


    public Integer getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(Integer idaluno) {
        this.idaluno = idaluno;
    }

    public Date getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(Date dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Date getDtmatricula() {
        return dtmatricula;
    }

    public void setDtmatricula(Date dtmatricula) {
        this.dtmatricula = dtmatricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(idaluno, aluno.idaluno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaluno);
    }
}

