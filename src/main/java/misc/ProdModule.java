package misc;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import model.PagosCobrosService;
import persistencia.conexion.Conexion;
import persistencia.dao.hibernate.ClienteDaoHibernate;
import persistencia.dao.hibernate.ContratoDaoHibernate;
import persistencia.dao.hibernate.CuotaDaoHibernate;
import persistencia.dao.hibernate.EgresoDaoHibernate;
import persistencia.dao.hibernate.IngresoDaoHibernate;
import persistencia.dao.hibernate.InmobiliariaDaoHibernate;
import persistencia.dao.hibernate.LocalidadDaoHibernate;
import persistencia.dao.hibernate.PersonaDaoHibernate;
import persistencia.dao.hibernate.PropiedadDaoHibernate;
import persistencia.dao.hibernate.PropietarioDaoHibernate;
import persistencia.dao.hibernate.ReservaDaoHibernate;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.EgresoDao;
import persistencia.dao.iface.IngresoDao;
import persistencia.dao.iface.InmobiliariaDao;
import persistencia.dao.iface.LocalidadDao;
import persistencia.dao.iface.LocalizationDao;
import persistencia.dao.iface.PersonaDao;
import persistencia.dao.iface.PropiedadDao;
import persistencia.dao.iface.PropietarioDao;
import persistencia.dao.iface.ReservaDAO;
import persistencia.dao.mapas.LocalizationDaoGoogleMaps;
import presentacion.controller.ClienteController;
import presentacion.controller.ContratoAlquilerController;
import presentacion.controller.ContratoVentaController;
import presentacion.controller.InmobiliariaController;
import presentacion.controller.PropiedadController;
import presentacion.controller.PropietarioController;
import presentacion.main.vista.MainView;
import presentacion.vista.ClienteForm;
import presentacion.vista.ContratoAlquilerForm;
import presentacion.vista.InmobiliariaForm;
import presentacion.vista.PropiedadForm;
import presentacion.vista.PropietarioForm;

public class ProdModule implements Module{

	@Override
	public void configure(Binder binder) {
		
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(ClienteForm.class).in(Singleton.class);
		binder.bind(PropietarioForm.class).in(Singleton.class);
		binder.bind(ContratoAlquilerForm.class).in(Singleton.class);
		binder.bind(PropiedadForm.class).in(Singleton.class);
		binder.bind(InmobiliariaForm.class).in(Singleton.class);
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(MainView.class).in(Singleton.class);
		binder.bind(PropiedadController.class).in(Singleton.class);
		binder.bind(ContratoAlquilerController.class).in(Singleton.class);
		binder.bind(ContratoVentaController.class).in(Singleton.class);
		binder.bind(ClienteController.class).in(Singleton.class);
		binder.bind(PropietarioController.class).in(Singleton.class);
		binder.bind(InmobiliariaController.class).in(Singleton.class);
		binder.bind(PagosCobrosService.class).in(Singleton.class);
		
		binder.bind(Conexion.class).in(Singleton.class);
		binder.bind(ClienteDao.class).to(ClienteDaoHibernate.class).in(Singleton.class);
		binder.bind(PersonaDao.class).to(PersonaDaoHibernate.class).in(Singleton.class);
		binder.bind(PropiedadDao.class).to(PropiedadDaoHibernate.class).in(Singleton.class);
		binder.bind(LocalidadDao.class).to(LocalidadDaoHibernate.class).in(Singleton.class);
		binder.bind(PropietarioDao.class).to(PropietarioDaoHibernate.class).in(Singleton.class);
		binder.bind(ContratoDao.class).to(ContratoDaoHibernate.class).in(Singleton.class);
		binder.bind(CuotaDao.class).to(CuotaDaoHibernate.class).in(Singleton.class);
		binder.bind(InmobiliariaDao.class).to(InmobiliariaDaoHibernate.class).in(Singleton.class);
		binder.bind(ReservaDAO.class).to(ReservaDaoHibernate.class).in(Singleton.class);
		binder.bind(IngresoDao.class).to(IngresoDaoHibernate.class).in(Singleton.class);
		binder.bind(EgresoDao.class).to(EgresoDaoHibernate.class).in(Singleton.class);

		binder.bind(LocalizationDao.class).to(LocalizationDaoGoogleMaps.class).in(Singleton.class);
		
	}
	

}
