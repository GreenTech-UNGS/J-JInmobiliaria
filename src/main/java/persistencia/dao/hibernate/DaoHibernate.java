package persistencia.dao.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.google.inject.Inject;

import persistencia.conexion.Conexion;
import persistencia.dao.iface.Dao;

public abstract class DaoHibernate<T> implements Dao<T>{
	
	@Inject
	protected Conexion conexion;
	protected SessionFactory sesionFactory;
	protected Session sesion;
	protected Transaction transaction;

	@Inject
	protected DaoHibernate(Conexion conexion){
		this.conexion = conexion;

		sesionFactory = conexion.getSessionFactory();
	}

	@Override
	public void save(T toInsert) {
		
		initTransaction();
		
		sesion.merge(toInsert);
		
		finishTransaction();
		
	}

	@Override
	public void remove(T toDelete) {
		initTransaction();
		
		sesion.delete(toDelete);
		
		finishTransaction();
		
	}

	@Override
	public abstract List<T> getAll();
	
	protected void initTransaction(){
		
		sesion = sesionFactory.openSession();
		transaction = sesion.beginTransaction();
		
	}

	protected void finishTransaction(){
		
		transaction.commit();
		
	}
	

	
	
}
