package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import com.example.demo.model.Disciplina;
import com.example.demo.model.Turma;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.DisciplinaRepository;
import com.example.demo.repository.TurmaRepository;

@SpringBootApplication
public class SistemaacademicoApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private TurmaRepository turmaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaacademicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

		Curso c = new Curso(null, "ANÁLISE E DESENVOLVIMENTO DE SISTEMAS");

		Disciplina d = new Disciplina(null, "COMPILADORES");
		Disciplina d1 = new Disciplina(null, "DESENVOLVIMENTO WEB");
		c.setDisciplinas(Arrays.asList(d, d1));

		Aluno a = new Aluno(null, "Joe Biden", sdf.parse("09-07-1945"), sdf.parse("10-02-2019"), "biden@mail.com",
				201910120, 9.9, 8.9, 5);
		Aluno a1 = new Aluno(null, "Donald Trump", sdf.parse("23-12-1987"), sdf.parse("13-02-2019"), "trump@mail.com",
				201910120, 10.0, 6.5, 9);

		Turma t = new Turma(null, d, "C01");
		t.setDisciplina(d);
		t.setAlunos(Arrays.asList(a, a1));

		a.setTurmas(Arrays.asList(t));
		a1.setTurmas(Arrays.asList(t));

		cursoRepository.save(c);
		alunoRepository.saveAll(Arrays.asList(a, a1));
		disciplinaRepository.save(d);
		turmaRepository.save(t);

	}

}
