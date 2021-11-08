package alura.com.br.Avaliacao2.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import alura.com.br.Avaliacao2.StateF.StateFr;
import alura.com.br.Avaliacao2.controller.dto.StateDto;
import alura.com.br.Avaliacao2.modelo.States;
import alura.com.br.Avaliacao2.repository.Repository;



	@RestController
	@RequestMapping("/api/states")
	
public class Controller {
		
		@Autowired
		private Repository repository;
		@GetMapping
		public List<StateDto> lista(String region,int populacion, int area) {
			if (region != null) {
				List<States> state = repository.cargarPorRegion(region);
				return StateDto.converter(state);
			}
			if (populacion != 0){
				List<States> state = repository.cargarPorPopulacion();
				return StateDto.converter(state);
			}
			if (area != 0){
				List<States> state = repository.cargarPorArea();
				return StateDto.converter(state);
			}
			else{
				List<States> state = repository.findAll();
				return StateDto.converter(state);
			}
		}

		@PostMapping
		public ResponseEntity<StateDto> cadastrar(@RequestBody @Valid StateFr form, UriComponentsBuilder uriBuilder) {
			States state = form.converter();
			repository.save(state);
			
			URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri(); 
			return ResponseEntity.created(uri).body(new StateDto(state));		
		}
		
		@GetMapping("/{id}")
		public StateDto detalhar(@PathVariable Long id){
			States state = repository.getOne(id);
			return new StateDto(state);
		}
		
		@PutMapping("/{id}")
		@Transactional
		public ResponseEntity<StateDto> atualizar(@PathVariable Long id,@RequestBody StateFr form){
			States states = form.atualizar(id, repository);
	        return ResponseEntity.ok(new StateDto(states));
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> remover(@PathVariable Long id){
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
	}

