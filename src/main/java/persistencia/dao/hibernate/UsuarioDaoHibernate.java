package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Persona;
import entities.Usuario;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.UsuarioDao;

@Singleton
public class UsuarioDaoHibernate extends DaoHibernate<Usuario> implements UsuarioDao{

	@Inject
	protected UsuarioDaoHibernate(Conexion conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean existeUsuarioCon(String nombre, String pswMd5) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(
						Restrictions.and(Restrictions.eq("p.email", nombre),
								Restrictions.eq("pswHash", pswMd5))
						);
		
		finishTransaction();
		
		return q.list().isEmpty() == false;
	}

	@Override
	public Usuario getUsuarioBy(String nombre, String pswMd5) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(
						Restrictions.and(Restrictions.eq("p.email", nombre),
								Restrictions.eq("pswHash", pswMd5))
						);
		
		finishTransaction();
		
		return (Usuario) q.list().get(0);
	}

	@Override
	public List<Usuario> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class);
		
		finishTransaction();
		
		return q.list();
	}

	@Override
	public boolean existeClienteCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial()));
		
		finishTransaction();
				
		List<Usuario> res = q.list();
		
		return ! (res.isEmpty());
	}

	@Override
	public boolean existeUsuarioCon(String email) {
initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(Restrictions.eq("p.email", email));
		
		finishTransaction();
		
		return q.list().isEmpty() == false;
	}
}
