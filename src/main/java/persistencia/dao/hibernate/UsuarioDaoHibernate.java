package persistencia.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Persona;
import entities.Persona.TipoCredencial;
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
	public boolean existeUsuarioCon(String dni, String pswMd5) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(Restrictions.eq("p.tipoCred", TipoCredencial.DNI))
				.add(
						Restrictions.and(Restrictions.eq("p.credencial", dni),
								Restrictions.eq("pswHash", pswMd5))
						);
		
		List<Usuario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet.isEmpty() == false;
	}

	@Override
	public Usuario getUsuarioBy(String dni, String pswMd5) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(Restrictions.eq("p.tipoCred", TipoCredencial.DNI))
				.add(
						Restrictions.and(Restrictions.eq("p.credencial", dni),
								Restrictions.eq("pswHash", pswMd5))
						);
		
		List<Usuario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet.get(0);
	}

	@Override
	public List<Usuario> getAll() {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class);
		
		List<Usuario> toRet = q.list();
		
		finishTransaction();
		
		actualizeList(toRet);
		return toRet;
	}

	@Override
	public boolean existeUsuarioCon(Persona t) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class).
				createAlias("persona", "persona").
				setFetchMode("persona", FetchMode.JOIN).
				add(Restrictions.eq("persona.credencial", t.getCredencial())).
				add(Restrictions.eq("persona.tipoCred", TipoCredencial.DNI));
		
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

	@Override
	public Usuario getUsuarioBy(String email) {
		initTransaction();
		
		Criteria q = sesion.createCriteria(Usuario.class)
				.createAlias("persona", "p")
				.add(Restrictions.eq("p.email", email));
		
		finishTransaction();
		
		return (Usuario) q.list().get(0);
	}
}
