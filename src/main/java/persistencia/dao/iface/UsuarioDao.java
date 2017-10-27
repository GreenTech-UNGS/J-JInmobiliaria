package persistencia.dao.iface;

import entities.Usuario;

public interface UsuarioDao extends Dao<Usuario>{

	
	public boolean existeUsuarioCon(String nombre, String pswMd5);
	public Usuario getUsuarioBy(String nombre, String pswMd5);
	
	
}
