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

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.service.AlunoService;
import br.com.senac.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import br.com.senac.constantes.Messages;

@Tag(name = Messages.SWAGGER_TAG_TURMA)
@RestController
@RequestMapping("/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turmaService;
	
	//@GetMapping
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Turma>> listarTurmas() {
		List<Turma> turmas = turmaService.listaTodasTurmas();
		return ResponseEntity.ok().body(turmas);
	}
	
	@Operation(description = Messages.SWAGGER_GET)
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Turma> buscaPorID(@PathVariable Integer id){
		Turma turmas = turmaService.buscarPorID(id);
		return ResponseEntity.ok().body(turmas);
	}
	
	@Operation(description = Messages.SWAGGER_INSERT)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Turma objTurma) {
		Turma turma = turmaService.salvar(objTurma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@Operation(description = Messages.SWAGGER_DELETE)
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		turmaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@Operation(description = Messages.SWAGGER_UPDATE)
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> alterar(@RequestBody Turma altTurma,@PathVariable Integer id) {
		altTurma.setId(id);
		turmaService.alterar(altTurma);
		return ResponseEntity.noContent().build();
	}

}
