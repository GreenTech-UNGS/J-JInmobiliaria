package entities;

public class Precio {
	
	private int ID;
	private float monto;
	private Moneda moneda;
	
	private Precio() {
		
	}
	
	public Precio(float monto, Moneda moneda) {
		super();
		this.monto = monto;
		this.moneda = moneda;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
	
	
	
}
