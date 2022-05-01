package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepo;
	
	public List<Professor> listaTodosProfessores(){
		return professorRepo.findAll();
	}
	
	public Professor buscarPorID(Integer id) throws ObjectNotFoundException{
		Optional<Professor> professor = professorRepo.findById(id);
		return professor.orElseThrow( () -> new ObjectNotFoundException(null,"Professor não encontrado!"));
	}
	
	public Professor salvar(Professor professor) {
		return professorRepo.save(professor);
	}
	
	public void excluir(Integer id) {
		professorRepo.deleteById(id);
	}
	
	public Professor alterar(Professor altProfessor) {
		Professor professor = buscarPorID(altProfessor.getId());
		professor.setNome(altProfessor.getNome());
		return salvar(professor);
	}

}
