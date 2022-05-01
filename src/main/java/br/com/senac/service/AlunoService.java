package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	public List<Aluno> listaTodosAlunos(){
		return alunoRepo.findAll();
	}
	
	public Aluno buscarPorID(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepo.findById(id);
		return aluno.orElseThrow( () -> new ObjectNotFoundException(null,"Aluno não encontrado!"));
	}
	
	public Aluno salvar(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public void excluir(Integer id) {
		alunoRepo.deleteById(id);
	}
	
	public Aluno alterar(Aluno altAluno) {
		Aluno aluno = buscarPorID(altAluno.getId());
		aluno.setNome(altAluno.getNome());
		aluno.setTurma(altAluno.getTurma());
		aluno.setDisciplinas(altAluno.getDisciplinas());
		return salvar(aluno);
	}

}
