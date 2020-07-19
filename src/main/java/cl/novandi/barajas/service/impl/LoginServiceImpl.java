package cl.novandi.barajas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.novandi.barajas.model.Usuario;
import cl.novandi.barajas.repo.ILoginRepo;
import cl.novandi.barajas.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	 	
 	@Autowired
 	private ILoginRepo repo;
 	

 	@Override
 	public Usuario verificarEmail(String email) throws Exception{
 		
 		Usuario us = null;
 		
 		try {
 			us = repo.verificarEmail(email);
 			us = us !=null ? us : new Usuario();
 		} catch (Exception e) {
 			us = new Usuario();
 		}
 		
 		return us;	
 	}
 	

 	@Override
	public int cambiarPassword(String password, String email) throws Exception{
 		
 		int rpta = 1;
 		
 		try {
 			repo.cambiarPassword(password, email);
 		} catch (Exception e) {
 			rpta = 0;
 		}
 		return rpta;
 	}
 	
 

}
