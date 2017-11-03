package persistencia.dao.iface;

import java.util.List;

import entities.Cita;
import entities.Usuario;

public interface CitaDao extends Dao<Cita>{

	public List<Cita> getCitasOf(Usuario u);
	public List<Cita> getProximasOf(Usuario u);
	public List<Cita> getProximas();
	
}
