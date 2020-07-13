package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Perfil;
import cl.novandi.barajas.repo.IPerfilRepo;
import cl.novandi.barajas.service.IPerfilService;

@Service
public class PerfilServiceImpl implements IPerfilService{
	

	@Autowired	
	private IPerfilRepo repo;
	
	@Override
	public Perfil registrar(Perfil t) {
		return repo.save(t);
	}

	@Override
	public Perfil modificar(Perfil t) {		
		return repo.save(t);
	}

	@Override
	public List<Perfil> listar() {
		return repo.findAll();
	}

	@Override
	public Perfil leerPorId(Integer id) {
		Optional<Perfil> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Perfil();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
