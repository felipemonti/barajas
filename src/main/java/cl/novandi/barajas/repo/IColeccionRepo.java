package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.Coleccion;

public interface IColeccionRepo extends JpaRepository<Coleccion,Integer> {


}
