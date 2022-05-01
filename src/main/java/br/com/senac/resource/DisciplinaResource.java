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
import br.com.senac.entity.Disciplina;
import br.com.senac.service.DisciplinaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = Messages.SWAGGER_TAG_DISCIPLINA)
@RestController
@RequestMapping("/disciplina")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService disciplinaService;
	
	//@GetMapping
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> listarDisciplinas() {
		List<Disciplina> alunos = disciplinaService.listaTodasDisciplinas();
		return ResponseEntity.ok().body(alunos);
	}
	
	@Operation(description = Messages.SWAGGER_GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaPorID(@PathVariable Integer id){
		Disciplina disciplina = disciplinaService.buscarPorID(id);
		return ResponseEntity.ok().body(disciplina);
	}
		
	@Operation(description = Messages.SWAGGER_INSERT)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Disciplina objDisciplina) {
		Disciplina disciplina = disciplinaService.salvar(objDisciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(disciplina.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		disciplinaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(description = Messages.SWAGGER_UPDATE)
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Disciplina altDisciplina,@PathVariable Integer id) {
		altDisciplina.setId(id);
		disciplinaService.alterar(altDisciplina);
		return ResponseEntity.noContent().build();
	}
	
}
