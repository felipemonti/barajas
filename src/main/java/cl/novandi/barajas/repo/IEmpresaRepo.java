package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.Empresa;

public interface IEmpresaRepo extends JpaRepository<Empresa,Integer> {


}
