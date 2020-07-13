package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Coleccion;
import cl.novandi.barajas.repo.IColeccionRepo;
import cl.novandi.barajas.service.IColeccionService;

@Service
public class ColeccionServiceImpl implements IColeccionService{
	

	@Autowired	
	private IColeccionRepo repo;
	
	@Override
	public Coleccion registrar(Coleccion t) {
		return repo.save(t);
	}

	@Override
	public Coleccion modificar(Coleccion t) {		
		return repo.save(t);
	}

	@Override
	public List<Coleccion> listar() {
		return repo.findAll();
	}

	@Override
	public Coleccion leerPorId(Integer id) {
		Optional<Coleccion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Coleccion();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}

}
