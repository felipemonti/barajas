package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Usuario;
import cl.novandi.barajas.repo.IUsuarioRepo;
import cl.novandi.barajas.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	

	@Autowired	
	private IUsuarioRepo repo;
	
	@Override
	public Usuario registrar(Usuario t) {
		return repo.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {		
		return repo.save(t);
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Usuario leerPorId(Integer id) {
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}

}
