package presentacion.mappers;

public interface Mapper<T> {
	
	public void fillBean(T t);
	public void fillFields(T t);
	
}
