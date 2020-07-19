package cl.novandi.barajas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.novandi.barajas.exception.ModeloNotFoundException;
import cl.novandi.barajas.model.Coleccion;
import cl.novandi.barajas.service.IColeccionService;

@RestController
@RequestMapping("/colecciones")
public class ColeccionController {
	

	@Autowired
	private IColeccionService service;
	
	@GetMapping
	public ResponseEntity<List<Coleccion>> listar(){
		List<Coleccion> lista = service.listar();
		return new ResponseEntity<List<Coleccion>>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Coleccion> listarPorId(@PathVariable("id") Integer id){
		
		Coleccion coleccion = service.leerPorId(id);
		if(coleccion.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<Coleccion>(coleccion, HttpStatus.OK);
		
	}
	
	/*
	@PostMapping
	public ResponseEntity<Coleccion> registrar (@Valid @RequestBody Coleccion coleccion){
		Coleccion obj = service.registrar(coleccion);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Coleccion> modificar(@Valid @RequestBody Coleccion coleccion){
		Coleccion obj = service.modificar(coleccion);
		return new ResponseEntity<Coleccion>(obj, HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		
		Coleccion coleccion = service.leerPorId(id);
		if(coleccion.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		
		service.eliminar(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
	*/

}
