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

import com.example.demo.model.Turma;
import com.example.demo.service.TurmaService;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaResource {

    @Autowired
    private TurmaService turmaService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Turma> find(@PathVariable Integer id) {
        Turma turma = turmaService.find(id);
        return ResponseEntity.ok().body(turma);
    }


    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert (@RequestBody Turma t) {

        Turma turma = turmaService.insert(t);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(turma.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update (@RequestBody Turma t, @PathVariable Integer id) {
        t.setId(id);
        t = turmaService.update(t);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Turma>> findAll() {
        List<Turma> list = turmaService.findAll();
        list.stream()
                .map(obj -> new Turma())
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }
}
