package persistencia.dao.iface;

import java.util.Collection;
import java.util.List;

public interface Dao<T> {
	
	public void save(T t);
	public void remove (T t);
	public List<T> getAll();
	
	
}
