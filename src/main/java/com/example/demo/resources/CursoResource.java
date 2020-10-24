package com.example.demo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {

        @Autowired
        private CursoService cursoService;

    @RequestMapping(method= RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Curso c) {

        Curso curso  = cursoService.insert(c);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(curso.getIdcurso())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Curso> find(@PathVariable Integer id) {
        Curso curso = cursoService.find(id);
        return ResponseEntity.ok().body(curso);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Curso>> findAll() {
        List<Curso> list = cursoService.findAll();
        list.stream()
                .map(obj -> new Curso())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

}