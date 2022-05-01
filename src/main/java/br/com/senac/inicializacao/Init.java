package br.com.senac.inicializacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoDisciplina;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Disciplina;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.repository.DisciplinaRepository;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
import br.com.senac.service.AvaliacaoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@Autowired
	ProfessorRepository professorRepo;
	
	@Autowired
	TurmaRepository turmaRepo;
	
	@Autowired
	DisciplinaRepository disciplinaRepo;
	
	@Autowired
	AvaliacaoService avaliacaoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		
		Professor professor1 = new Professor();
		professor1.setNome("Gabi");
		professorRepo.save(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNome("Priscila");
		professorRepo.save(professor2);
		
		Professor professor3 = new Professor();
		professor3.setNome("Johnny");
		professorRepo.save(professor3);
		
		Professor professor4 = new Professor();
		professor4.setNome("Estruc");
		professorRepo.save(professor4);
		
		Turma turma1 = new Turma();
		turma1.setAno("2021.1");
		turma1.setCurso("ADS");
		turma1.setNome("Turma ADS I");
		turmaRepo.save(turma1);
		
		Turma turma2 = new Turma();
		turma2.setAno("2021.2");
		turma2.setCurso("Redes");
		turma2.setNome("Turma Rede I");
		turmaRepo.save(turma2);
		
		Disciplina disciplina1 = new Disciplina();
		disciplina1.setNome("Prog Web");
		disciplinaRepo.save(disciplina1);
		
		Disciplina disciplina2 = new Disciplina();
		disciplina2.setNome("Java");
		disciplinaRepo.save(disciplina2);
		
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		aluno1.setTurma(turma1);
		aluno1.setDisciplinas(Arrays.asList(disciplina1,disciplina2));
		alunoRepo.save(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Mateus");
		aluno2.setTurma(turma2);
		aluno2.setDisciplinas(Arrays.asList(disciplina2));
		alunoRepo.save(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Luiza");
		aluno3.setTurma(turma1);
		aluno3.setDisciplinas(Arrays.asList(disciplina1));
		alunoRepo.save(aluno3);
		
		Aluno aluno4 = new Aluno();
		aluno4.setNome("Lissa");
		aluno4.setTurma(turma2);
		aluno4.setDisciplinas(Arrays.asList(disciplina2,disciplina1));
		alunoRepo.save(aluno4);
				
		AlunoDisciplina alunoDisciplina1 = new AlunoDisciplina();
		alunoDisciplina1.setAluno(aluno1);
		alunoDisciplina1.setDisciplina(disciplina1);
		
		Avaliacao avaliacao1 = new Avaliacao();
		avaliacao1.setAlunoDisciplina(alunoDisciplina1);
		avaliacao1.setConceito("A");
		avaliacaoService.save(avaliacao1);
		
		AlunoDisciplina alunoDisciplina2 = new AlunoDisciplina();
		alunoDisciplina2.setAluno(aluno2);
		alunoDisciplina2.setDisciplina(disciplina2);
		
		Avaliacao avaliacao2 = new Avaliacao();
		avaliacao2.setAlunoDisciplina(alunoDisciplina2);
		avaliacao2.setConceito("B");
		avaliacaoService.save(avaliacao2);
		
	}

}
