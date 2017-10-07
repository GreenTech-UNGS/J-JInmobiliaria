package misc;
import java.util.List;

import persistencia.dao.hibernate.CuotaDaoHibernate;
import persistencia.dao.iface.CuotaDao;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import entities.CuotaAlquiler;

public class ActualizadorModule implements Module{

	@Override
	public void configure(Binder b) {
		
		b.bind(CuotaDao.class).to(CuotaDaoHibernate.class).in(Singleton.class);
		
		
	}

	

}
