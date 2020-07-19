package cl.novandi.barajas.service.impl;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {
	
	public boolean tieneAcceso(String path) {
		boolean rpta = false;
		String metodoPerfil = "";
		
		switch(path) {
		case "listar":
			metodoPerfil = "ADMIN";
		  break;
		case "listarId":
			metodoPerfil = "USER";
		  break;	
		}
		
		String metodoPerfiles[] = metodoPerfil.split(",");
		
		Authentication usuaroLoguado = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(usuaroLoguado.getName());
		
		for(GrantedAuthority auth: usuaroLoguado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			
			System.out.println(rolUser);
			
			for(String perfilMet: metodoPerfiles) {
				if(rolUser.equalsIgnoreCase(perfilMet)) {
					rpta = true;
				}
			}
		}
		
		return rpta;
	}

}
