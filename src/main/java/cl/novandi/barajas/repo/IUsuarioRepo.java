package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer> {

	Usuario findOneByEmail(String email);
	
}
