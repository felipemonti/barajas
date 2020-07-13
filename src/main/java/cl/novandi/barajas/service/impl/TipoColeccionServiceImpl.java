package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.TipoColeccion;
import cl.novandi.barajas.repo.ITipoColeccionRepo;
import cl.novandi.barajas.service.ITipoColeccionService;

@Service
public class TipoColeccionServiceImpl implements ITipoColeccionService{
	

	@Autowired	
	private ITipoColeccionRepo repo;
	
	@Override
	public TipoColeccion registrar(TipoColeccion t) {
		return repo.save(t);
	}

	@Override
	public TipoColeccion modificar(TipoColeccion t) {		
		return repo.save(t);
	}

	@Override
	public List<TipoColeccion> listar() {
		return repo.findAll();
	}

	@Override
	public TipoColeccion leerPorId(Integer id) {
		Optional<TipoColeccion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new TipoColeccion();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
