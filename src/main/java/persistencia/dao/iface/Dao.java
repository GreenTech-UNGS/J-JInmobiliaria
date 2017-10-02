package persistencia.dao.iface;

import java.util.Collection;

public interface Dao<T> {
	
	public void save(T t);
	public void remove (T t);
	public Collection<T> getAll();
	
	
}
