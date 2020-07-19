package cl.novandi.barajas.service;

import cl.novandi.barajas.model.ResetToken;

public interface IResetTokenService {

	ResetToken findByToken(String token);
	void guardar(ResetToken token);
	void eliminar(ResetToken token);
	
}
