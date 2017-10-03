package filtros;

import java.util.function.Supplier;

public class SingleParameterFilter<T> {

	Supplier<T> getter;
	String campo;
	Tipo tipo;
	
	public enum Tipo{
		EQUAL,
		NOTEQUAL,
		GREATERTHAN,
		GREATEREQUALTHAN,
		LOWERTHAN,
		LOWEREQUALTHAN,
		LIKE
	}
	
	public SingleParameterFilter(String campo, Supplier<T> getter, Tipo t) {
		this.campo = campo;
		this.getter = getter;
		this.tipo = t;
	}

	public T getObject() {
		return getter.get();
	}

	public String getCampo() {
		return campo;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
}
