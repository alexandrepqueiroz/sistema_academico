package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.service.exceptions.DataIntegrityException;
import com.example.demo.service.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepositorio;

    public Aluno find(Integer id) {
        Optional<Aluno> obj = alunoRepositorio.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
    }

    public Aluno insert (Aluno a){
        a.setIdaluno(null);
        return alunoRepositorio.save(a);

    }

    public Aluno update (Aluno a) {
        Aluno newAluno = find(a.getIdaluno());
        updateData(newAluno, a);
        return alunoRepositorio.save(newAluno);

    }

    public void delete (Integer id) {
        try {
            alunoRepositorio.deleteById(id);
        }
        catch (DataIntegrityException e){
            throw new DataIntegrityException("não é possível excluir um aluno inexistente");
        }
    }

    public List<Aluno> findAll() {
        return alunoRepositorio.findAll();
    }

    public void updateData(Aluno newAluno, Aluno a){
        newAluno.setNomeAluno(a.getNomeAluno());
    }




}
