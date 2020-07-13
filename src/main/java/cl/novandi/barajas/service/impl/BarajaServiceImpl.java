package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Baraja;
import cl.novandi.barajas.repo.IBarajaRepo;
import cl.novandi.barajas.service.IBarajaService;

@Service
public class BarajaServiceImpl implements IBarajaService{

	@Autowired	
	private IBarajaRepo repo;
	
	@Override
	public Baraja registrar(Baraja t) {
		return repo.save(t);
	}

	@Override
	public Baraja modificar(Baraja t) {		
		return repo.save(t);
	}

	@Override
	public List<Baraja> listar() {
		return repo.findAll();
	}

	@Override
	public Baraja leerPorId(Integer id) {
		Optional<Baraja> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Baraja();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
	
}
