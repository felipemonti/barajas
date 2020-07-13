package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.Valoracion;

public interface IValoracionRepo extends JpaRepository<Valoracion,Integer> {


}
