package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer>{
	
	//select* from disciplina where nome = ? and tipo = ?
	//List<Disciplina> findByNomeAndTipo(String nome, String tipo);
	
//	select * from disciplina where nome like '%nome%'
//	List<Disciplina> findByNome(String nome);

}
