package misc;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import persistencia.dao.hibernate.ContratoDaoHibernate;
import persistencia.dao.hibernate.CuotaDaoHibernate;
import persistencia.dao.hibernate.PropiedadDaoHibernate;
import persistencia.dao.hibernate.ReservaDaoHibernate;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.PropiedadDao;
import persistencia.dao.iface.ReservaDAO;

public class ActualizadorModule implements Module{

	@Override
	public void configure(Binder b) {
		
		b.bind(CuotaDao.class).to(CuotaDaoHibernate.class).in(Singleton.class);
		b.bind(ContratoDao.class).to(ContratoDaoHibernate.class).in(Singleton.class);
		b.bind(PropiedadDao.class).to(PropiedadDaoHibernate.class).in(Singleton.class);
		b.bind(ReservaDAO.class).to(ReservaDaoHibernate.class).in(Singleton.class);
		
	}

	

}
