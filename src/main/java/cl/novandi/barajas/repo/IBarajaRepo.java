package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.Baraja;

public interface IBarajaRepo extends JpaRepository<Baraja,Integer> {

}
