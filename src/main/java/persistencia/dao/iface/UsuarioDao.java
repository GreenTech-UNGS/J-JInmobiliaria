package persistencia.dao.iface;

import entities.Persona;
import entities.Usuario;

public interface UsuarioDao extends Dao<Usuario>{

	boolean existeUsuarioCon(Persona t);
	public boolean existeUsuarioCon(String nombre, String pswMd5);
	public Usuario getUsuarioBy(String nombre, String pswMd5);
	boolean existeUsuarioCon(String email);
	public Usuario getUsuarioBy(String email);
	
	
}
