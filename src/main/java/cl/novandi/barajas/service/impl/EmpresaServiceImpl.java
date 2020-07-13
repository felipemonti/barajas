package cl.novandi.barajas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Empresa;
import cl.novandi.barajas.repo.IEmpresaRepo;
import cl.novandi.barajas.service.IEmpresaService;

@Service
public class EmpresaServiceImpl implements IEmpresaService{
	

	@Autowired	
	private IEmpresaRepo repo;
	
	@Override
	public Empresa registrar(Empresa t) {
		return repo.save(t);
	}

	@Override
	public Empresa modificar(Empresa t) {		
		return repo.save(t);
	}

	@Override
	public List<Empresa> listar() {
		return repo.findAll();
	}

	@Override
	public Empresa leerPorId(Integer id) {
		Optional<Empresa> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Empresa();
	}

	@Override
	public boolean eliminar(Integer id) {		
		repo.deleteById(id);
		return true;
	}
}
