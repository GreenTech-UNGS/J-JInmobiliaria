package presentacion.validators;

public interface Validator<T> {

	public boolean isValid(T t);
	
}
