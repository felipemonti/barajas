package cl.novandi.barajas.service;

import cl.novandi.barajas.model.Usuario;

public interface ILoginService {
	
	Usuario verificarEmail(String email) throws Exception;
	int cambiarPassword(String password, String email) throws Exception;
	

}
