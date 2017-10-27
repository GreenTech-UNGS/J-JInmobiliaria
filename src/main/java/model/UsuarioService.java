package model;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Rol;
import entities.Usuario;

@Singleton
public class UsuarioService {

	@Inject
	private UsuarioService() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario getUsuarioLogeado() {

		//throw new RuntimeException("No implementado");
		
		Usuario n = new Usuario();
		
		n.getRoles().add(Rol.ADMINISTRADOR);
		
		return n;
	}
	
	public void logearUsuario(String nombre, String password) throws LogicaNegocioException {

		//throw new RuntimeException("No implementado");
	}
	
	public boolean tieneRolElLogeado(Rol... r) {
		
		Usuario u = getUsuarioLogeado();
		
		for (Rol rol: r) {
			
			if(u.getRoles().contains(rol))
				return true;
			
		}
		
		return false;
		
	}
	
}
