package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.service.exceptions.ObjectNotFoundException;
@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepositorio;

    public Disciplina insert (Disciplina d) {
        d.setIddisciplina(null);
        return disciplinaRepositorio.save(d);
    }

    public Disciplina find(Integer id){
        Optional<Disciplina> disciplina = disciplinaRepositorio.findById(id);
        return disciplina.orElseThrow(() -> new ObjectNotFoundException(
                "Disciplina não encontrada! Id: " +id+ ", Nome do Disciplina: " + Disciplina.class.getName()
        ));
    }

    public List<Disciplina> findAll(){
        return disciplinaRepositorio.findAll();
    }
}
