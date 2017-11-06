package persistencia.dao.iface;

import java.util.List;

import entities.Cliente;
import entities.Persona;
import entities.Usuario;
import filtros.ClienteFiltro;
import filtros.UsuarioFiltro;

public interface UsuarioDao extends Dao<Usuario>{

	boolean existeUsuarioCon(Persona t);
	public boolean existeUsuarioCon(String nombre, String pswMd5);
	public Usuario getUsuarioBy(String nombre, String pswMd5);
	boolean existeUsuarioCon(String email);
	public Usuario getUsuarioBy(String email);
	public List<Usuario> getAllByFiltro(UsuarioFiltro filtro);
	
	
}
