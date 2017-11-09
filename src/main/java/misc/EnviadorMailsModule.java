package misc;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;

import persistencia.conexion.Conexion;
import persistencia.dao.ftp.DAOFTPFileZilla;
import persistencia.dao.hibernate.CitaDaoHibernate;
import persistencia.dao.hibernate.ClienteDaoHibernate;
import persistencia.dao.hibernate.ContratoDaoHibernate;
import persistencia.dao.hibernate.CuotaDaoHibernate;
import persistencia.dao.hibernate.EgresoDaoHibernate;
import persistencia.dao.hibernate.IngresoDaoHibernate;
import persistencia.dao.hibernate.InmobiliariaDaoHibernate;
import persistencia.dao.hibernate.InteresadoDaoHibernate;
import persistencia.dao.hibernate.LocalidadDaoHibernate;
import persistencia.dao.hibernate.NotificacionDaoHibernate;
import persistencia.dao.hibernate.PersonaDaoHibernate;
import persistencia.dao.hibernate.PropiedadDaoHibernate;
import persistencia.dao.hibernate.PropietarioDaoHibernate;
import persistencia.dao.hibernate.ReservaDaoHibernate;
import persistencia.dao.hibernate.UsuarioDaoHibernate;
import persistencia.dao.iface.CitaDao;
import persistencia.dao.iface.ClienteDao;
import persistencia.dao.iface.ContratoDao;
import persistencia.dao.iface.CuotaDao;
import persistencia.dao.iface.DAOftp;
import persistencia.dao.iface.EgresoDao;
import persistencia.dao.iface.IngresoDao;
import persistencia.dao.iface.InmobiliariaDao;
import persistencia.dao.iface.InteresadoDao;
import persistencia.dao.iface.LocalidadDao;
import persistencia.dao.iface.NotificacionDao;
import persistencia.dao.iface.PersonaDao;
import persistencia.dao.iface.PropiedadDao;
import persistencia.dao.iface.PropietarioDao;
import persistencia.dao.iface.ReservaDAO;
import persistencia.dao.iface.UsuarioDao;

public class EnviadorMailsModule implements Module{

	@Override
	public void configure(Binder binder) {
		
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
		binder.bind(UsuarioDao.class).to(UsuarioDaoHibernate.class).in(Singleton.class);
		binder.bind(CitaDao.class).to(CitaDaoHibernate.class).in(Singleton.class);
		binder.bind(InteresadoDao.class).to(InteresadoDaoHibernate.class).in(Singleton.class);
		binder.bind(DAOftp.class).to(DAOFTPFileZilla.class).in(Singleton.class);

		binder.bind(NotificacionDao.class).to(NotificacionDaoHibernate.class).in(Singleton.class);

		
	}

}
