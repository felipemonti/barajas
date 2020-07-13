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
import cl.novandi.barajas.model.Baraja;
import cl.novandi.barajas.service.IBarajaService;

@RestController
@RequestMapping("/barajas")
public class BarajaController {

	@Autowired
	private IBarajaService service;
	
	@GetMapping
	public ResponseEntity<List<Baraja>> listar(){
		List<Baraja> lista = service.listar();
		return new ResponseEntity<List<Baraja>>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Baraja> listarPorId(@PathVariable("id") Integer id){
		
		Baraja baraja = service.leerPorId(id);
		if(baraja.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<Baraja>(baraja, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Baraja> registrar (@Valid @RequestBody Baraja baraja){
		Baraja obj = service.registrar(baraja);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Baraja> modificar(@Valid @RequestBody Baraja baraja){
		Baraja obj = service.modificar(baraja);
		return new ResponseEntity<Baraja>(obj, HttpStatus.OK);
		
	}
	
	// BORRADO FISICO
	@DeleteMapping("{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Baraja baraja = service.leerPorId(id);
		if(baraja.getId() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		
		service.eliminar(id);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
