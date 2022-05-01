package br.com.senac.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.constantes.Messages;
import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = Messages.SWAGGER_TAG_PROFESSOR)
@RestController
@RequestMapping("/professor")
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;
	
	//@GetMapping
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Professor>> Professores() {
		List<Professor> professores = professorService.listaTodosProfessores();
		return ResponseEntity.ok().body(professores);
	}
	
	@Operation(description = Messages.SWAGGER_GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Professor> buscaPorID(@PathVariable Integer id){
		Professor professor = professorService.buscarPorID(id);
		return ResponseEntity.ok().body(professor);
	}
	
	@Operation(description = Messages.SWAGGER_INSERT)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Professor objProfessor) {
		Professor professor = professorService.salvar(objProfessor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professor.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		professorService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(description = Messages.SWAGGER_UPDATE)
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Professor altProfessor,@PathVariable Integer id) {
		altProfessor.setId(id);
		professorService.alterar(altProfessor);
		return ResponseEntity.noContent().build();
	}
	
}
