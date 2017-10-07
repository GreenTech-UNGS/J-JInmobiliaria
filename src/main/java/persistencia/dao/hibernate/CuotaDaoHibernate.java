package persistencia.dao.hibernate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Criteria;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;
import entities.EstadoCuota;
import entities.HistoriaEstadoCuota;
import entities.InteresPunitorioCuota;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.CuotaDao;

@Singleton
public class CuotaDaoHibernate extends DaoHibernate<CuotaAlquiler> implements CuotaDao{

	@Inject
	protected CuotaDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CuotaAlquiler> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public List<CuotaAlquiler> getAllOfThisMonth() {
		throw new RuntimeException("NO implementado");
	}

	@Override
	public InteresPunitorioCuota getInteresOf(CuotaAlquiler c) {
		throw new RuntimeException("NO implementado");
	}
	
	@Override
	public List<CuotaAlquiler> getPendientes() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(CuotaAlquiler.class);
		
		finishTransaction();
		
		List<CuotaAlquiler> toReturn = new ArrayList<CuotaAlquiler>();
		for(Object cuota : q.list()){		
			
			Comparator<HistoriaEstadoCuota> comparator = new Comparator<HistoriaEstadoCuota>() {
				@Override
				public int compare(HistoriaEstadoCuota o1, HistoriaEstadoCuota o2) {
					return Integer.valueOf(o1.getFecha().toString()).compareTo(Integer.valueOf(o2.getFecha().toString()));
				}
			};			
			((CuotaAlquiler) cuota).getEstados().sort(comparator);
			
			if(((CuotaAlquiler) cuota).getEstados().get(((CuotaAlquiler) cuota).getEstados().size()-1).equals(EstadoCuota.PENDIENTE)){
				
				toReturn.add((CuotaAlquiler) cuota);
			}			
		}
		
		return toReturn;
	}
	
}
