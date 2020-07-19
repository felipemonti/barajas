package cl.novandi.barajas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.novandi.barajas.model.ResetToken;

public interface IResetTokenRepo extends JpaRepository<ResetToken, Integer>{
	
	
	ResetToken findByToken(String token);
	
}
