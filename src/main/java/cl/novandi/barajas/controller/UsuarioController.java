package cl.novandi.barajas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.novandi.barajas.exception.ModeloNotFoundException;
import cl.novandi.barajas.model.Estado;
import cl.novandi.barajas.model.Usuario;
import cl.novandi.barajas.service.IEstadoService;
import cl.novandi.barajas.service.IUsuarioService;
import cl.novandi.barajas.util.ConstantesEstados;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	@Autowired
	private IEstadoService estadoservice;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id){
		
		Usuario usuario = service.leerPorId(id);
		if(usuario.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar (@Valid @RequestBody Usuario usuario){
		Usuario obj = service.registrar(usuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario usuario){
		Usuario obj = service.modificar(usuario);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Usuario> eliminar(@PathVariable("id") Integer id){
		
		Usuario usuario = service.leerPorId(id);
		if(usuario.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		
		Estado estadoInactivo = estadoservice.leerPorId(ConstantesEstados.ESTADO_INACTIVO);
		usuario.setEstado(estadoInactivo);
		
		return this.modificar(usuario);
	}

	
}
