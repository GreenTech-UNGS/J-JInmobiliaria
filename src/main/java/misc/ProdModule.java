package misc;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import persistencia.conexion.Conexion;
import persistencia.dao.hibernate.ClienteDaoHibernate;
import persistencia.dao.hibernate.LocalidadDaoHibernate;
import persistencia.dao.hibernate.PersonaDaoHibernate;
import persistencia.dao.hibernate.PropiedadDaoHibernate;
import persistencia.dao.hibernate.PropietarioDaoHibernate;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.LocalidadDao;
import persistencia.dao.iface.PersonaDao;
import persistencia.dao.iface.PropiedadDao;
import persistencia.dao.iface.PropietarioDao;
import presentacion.controller.AddContAlqController;
import presentacion.controller.AddContVenController;
import presentacion.controller.AddPropiedadController;
import presentacion.controller.ElegirPropietarioController;
import presentacion.controller.AddClienteController;
import presentacion.vista.AddContratoAlq;
import presentacion.vista.AgregarCliente;
import presentacion.vista.AgregarPropiedad;
import presentacion.vista.ElegirPropietario;
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
		binder.bind(AddPropiedadController.class).in(Singleton.class);
		binder.bind(AddContAlqController.class).in(Singleton.class);
		binder.bind(AddContVenController.class).in(Singleton.class);
		binder.bind(AddClienteController.class).in(Singleton.class);
		
		binder.bind(Conexion.class).in(Singleton.class);
		binder.bind(ClienteDao.class).to(ClienteDaoHibernate.class).in(Singleton.class);
		binder.bind(PersonaDao.class).to(PersonaDaoHibernate.class).in(Singleton.class);
		binder.bind(PropiedadDao.class).to(PropiedadDaoHibernate.class).in(Singleton.class);
		binder.bind(LocalidadDao.class).to(LocalidadDaoHibernate.class).in(Singleton.class);
		binder.bind(PropietarioDao.class).to(PropietarioDaoHibernate.class).in(Singleton.class);
	}
	

}
