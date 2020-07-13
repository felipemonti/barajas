package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Valoracion;
import cl.novandi.barajas.repo.IValoracionRepo;
import cl.novandi.barajas.service.IValoracionService;

@Service
public class ValoracionServiceImpl implements IValoracionService{
	

	@Autowired	
	private IValoracionRepo repo;
	
	@Override
	public Valoracion registrar(Valoracion t) {
		return repo.save(t);
	}

	@Override
	public Valoracion modificar(Valoracion t) {		
		return repo.save(t);
	}

	@Override
	public List<Valoracion> listar() {
		return repo.findAll();
	}

	@Override
	public Valoracion leerPorId(Integer id) {
		Optional<Valoracion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Valoracion();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}

}
