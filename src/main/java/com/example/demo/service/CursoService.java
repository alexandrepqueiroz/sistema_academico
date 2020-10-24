package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepositorio;

    public Curso insert (Curso c) {
        c.setIdcurso(null);
        return cursoRepositorio.save(c);
    }

    public Curso find(Integer id){
        Optional<Curso> curso = cursoRepositorio.findById(id);
        return curso.orElseThrow(() -> new ObjectNotFoundException(
                "Curso não encontrado! Id: " +id+ ", Nome do Curso: " + Curso.class.getName()
        ));
    }

    public List<Curso> findAll(){
        return cursoRepositorio.findAll();
    }

}
