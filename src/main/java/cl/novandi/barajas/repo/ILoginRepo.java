package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import cl.novandi.barajas.model.Usuario;

public interface ILoginRepo extends JpaRepository<Usuario, Integer>{
	
	@Query("From Usuario where email = :email")
	Usuario verificarEmail(@Param("email") String email);

	@Transactional
	@Modifying 
	@Query("UPDATE Usuario u SET u.password = :password WHERE u.email = :email")
	void cambiarPassword(@Param("password") String password, @Param("email") String email) throws Exception;
	
	
}
