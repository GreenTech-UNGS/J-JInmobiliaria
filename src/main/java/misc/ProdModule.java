package misc;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import persistencia.conexion.Conexion;
import persistencia.dao.hibernate.ClienteDaoHibernate;
import persistencia.dao.hibernate.DaoHibernate;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.Dao;
import presentacion.controller.AddContAlqController;
import presentacion.controller.AddContVenController;
import presentacion.controller.AddPropiedadesController;
import presentacion.controller.AgregarClienteController;
import presentacion.vista.AddContratoAlq;
import presentacion.vista.AgregarCliente;
import presentacion.vista.AgregarPropiedad;
import presentacion.vista.MainView;

public class ProdModule implements Module{

	@Override
	public void configure(Binder binder) {
		
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(AgregarCliente.class).in(Singleton.class);
		binder.bind(AddContratoAlq.class).in(Singleton.class);
		binder.bind(AgregarPropiedad.class).in(Singleton.class);
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(AddPropiedadesController.class).in(Singleton.class);
		binder.bind(AddContAlqController.class).in(Singleton.class);
		binder.bind(AddContVenController.class).in(Singleton.class);
		binder.bind(AgregarClienteController.class).in(Singleton.class);
		
		binder.bind(Conexion.class).in(Singleton.class);
		binder.bind(ClienteDao.class).to(ClienteDaoHibernate.class).in(Singleton.class);
	}
	

}
