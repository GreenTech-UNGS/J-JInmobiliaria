package persistencia.dao.hibernate;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import entities.Cita;
import entities.Foto;
import org.hibernate.Criteria;
import persistencia.conexion.Conexion;
import persistencia.dao.iface.FotoDao;

import java.util.List;

@Singleton
public class FotoDaoHibernate extends DaoHibernate<Foto> implements FotoDao{


    @Inject
    protected FotoDaoHibernate(Conexion conexion) {
        super(conexion);
    }

    @Override
    public List<Foto> getAll() {
        initTransaction();

        Criteria q = sesion.createCriteria(Foto.class);

        List<Foto> toRet = q.list();

        finishTransaction();

        actualizeList(toRet);
        return toRet;
    }
}
