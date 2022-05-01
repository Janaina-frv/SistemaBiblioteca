package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepo;
	
	public List<Turma> listaTodasTurmas(){
		return turmaRepo.findAll();
	}
	
	public Turma buscarPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = turmaRepo.findById(id);
		return turma.orElseThrow( () -> new ObjectNotFoundException(null,"Turma não encontrada!"));
	}
	
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public void excluir(Integer id) {
		turmaRepo.deleteById(id);
	}
	
	public Turma alterar(Turma altTurma) {
		Turma turma = buscarPorID(altTurma.getId());
		turma.setNome(altTurma.getNome());
		turma.setAno(altTurma.getAno());
		turma.setCurso(altTurma.getCurso());
		return salvar(turma);
	}


}
