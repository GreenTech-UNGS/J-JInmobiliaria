package persistencia.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CuotaDao;

@Singleton
public class CuotaDaoHibernate extends DaoHibernate<CuotaAlquiler> implements CuotaDao{

	@Inject
	protected CuotaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CuotaAlquiler> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class);
		
		finishTransaction();
		
		return q.list();
	}
	
	@Override
	public List<CuotaAlquiler> getPendientes() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class);
		
		finishTransaction();

		//TODO: FILTRAR DENTRO DE LA QUERY
		
		List<CuotaAlquiler> toReturn = new ArrayList<CuotaAlquiler>();
		for(Object cuota : q.list()){		
			//TODO: ORDENAR ESTADOS POR FECHA
			if(((CuotaAlquiler) cuota).getEstados().get(((CuotaAlquiler) cuota).getEstados().size()-1).equals(EstadoCuota.PENDIENTE)){
				
				toReturn.add((CuotaAlquiler) cuota);
			}			
		}
		
		return toReturn;
	}
	
}
