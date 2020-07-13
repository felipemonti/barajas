package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Estado;
import cl.novandi.barajas.repo.IEstadoRepo;
import cl.novandi.barajas.service.IEstadoService;

@Service
public class EstadoServiceImpl implements IEstadoService{
	

	@Autowired	
	private IEstadoRepo repo;
	
	@Override
	public Estado registrar(Estado t) {
		return repo.save(t);
	}

	@Override
	public Estado modificar(Estado t) {		
		return repo.save(t);
	}

	@Override
	public List<Estado> listar() {
		return repo.findAll();
	}

	@Override
	public Estado leerPorId(Integer id) {
		Optional<Estado> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Estado();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}

}
