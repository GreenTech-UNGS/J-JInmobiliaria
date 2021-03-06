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
		sesion = conexion.getSession();
		//sesionFactory = conexion.getSessionFactory();
	}

	@Override
	public void save(T toInsert) {
		
		initTransaction();
		
		sesion.saveOrUpdate(toInsert);
		
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
	
	protected synchronized void initTransaction(){
		
		sesion = conexion.getSession();
		
		transaction = sesion.getTransaction();
		
		transaction.begin();
		
	}
	
	protected synchronized void finishTransaction(){
		
		transaction.commit();
		
	}
	
	
	protected void actualizeList(Collection<?> c){
		c.forEach(i -> actualize(i));
	}
	
	protected void actualize(Object o){
		sesion.refresh(o);
	}

	
	
}
