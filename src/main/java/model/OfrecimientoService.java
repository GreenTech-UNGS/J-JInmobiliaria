package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.Precio;
import entities.Propiedad;
import persistencia.dao.iface.ValorDolarDao;

@Singleton
public class OfrecimientoService {
	
	@Inject private ValorDolarDao valorDolarDao;

	public Precio getPrecioParaEntrar(OfrecimientoAlquiler o) throws LogicaNegocioException{
		
		if(!o.isHabilitada())
			throw new LogicaNegocioException("La propiedad no está para alquiler");
		
		Precio pPesos = new Precio(0, Moneda.PESOS);
		
		Precio primerMesPesos = getPrecioInARS(getPrimerMes(o));
		Precio comisionPesos = getPrecioInARS(getComisionOf(o));
		Precio depositoPesos = getPrecioInARS(getDeposito(o));
		Precio certificadosPesos = getPrecioInARS(getOtrosGastos(o));
		Precio selladoPesos = getPrecioInARS(getSelladoPesos(o));
		
		pPesos.setMonto(primerMesPesos.getMonto() +
				comisionPesos.getMonto() +
				depositoPesos.getMonto() +
				certificadosPesos.getMonto() +
				selladoPesos.getMonto());
		
		return pPesos;
		
	}
	
	public Precio getPrimerMes(OfrecimientoAlquiler o){
		
		double monto = o.getPrecio().getMonto();
		Moneda m = o.getPrecio().getMoneda();
		
		return new Precio(monto, m);
	}
	
	public Precio getComisionOf(OfrecimientoAlquiler o){
		double monto = o.getPrecio().getMonto();
		Moneda m = o.getPrecio().getMoneda();
		int cantMeses = o.getCantidadMeses();
		int intervaloActualizacion = o.getIntervaloActualizacion();
		
		double porcentaje = o.getProcentajeActualizacion() / 100.0;
		int cantActualizacones = (cantMeses/intervaloActualizacion) - 1;
		boolean isAcumualtivo = o.isAcumulativo();
		
		if(isAcumualtivo)
			monto = monto + (monto * Math.pow((1 + porcentaje), cantActualizacones));
		else
			monto = monto + (monto * porcentaje * cantActualizacones);
		
		
		return new Precio(monto, m);
	}
	
	public Precio getDeposito(OfrecimientoAlquiler o){
		
		return getComisionOf(o);
	}
	
	public Precio getSelladoPesos(OfrecimientoAlquiler o){
		double valorTotal = getValorTotal(o) * (o.getPorcentajeSellado() / 100.0);
		Moneda m = o.getPrecio().getMoneda();
		
		return getPrecioInARS(valorTotal, m);
	}
	
	private double getValorTotal(OfrecimientoAlquiler o){
		
		double sumaCuotas = 0;
		double monto = o.getPrecio().getMonto();
		double montoInicial = o.getPrecio().getMonto();
		boolean isAcumulativo = o.isAcumulativo();
		double porcentaje = o.getProcentajeActualizacion() / 100.0;
		
		for(int i = 1; i <= o.getCantidadMeses(); i++){
			sumaCuotas += monto;
			
			if(i % o.getIntervaloActualizacion() == 0){
				if(isAcumulativo)
					monto = monto + (monto * porcentaje);
				else
					monto = monto + (montoInicial * porcentaje);
					
			}
		}
		
		return sumaCuotas;
		
	}
	
	public Precio getOtrosGastos(OfrecimientoAlquiler o){

		double monto = o.getOtrosGastos().getMonto();
		Moneda m = o.getOtrosGastos().getMoneda();
		
		return new Precio(monto, m);
	}
	
	private Precio getPrecioInARS(double monto, Moneda moneda) {
		double valorDolar = valorDolarDao.getValorDolar();
		double montoVerdadero = monto;
		
		if(moneda == Moneda.USD) {
			montoVerdadero = montoVerdadero * valorDolar;
		}
		
		return new Precio(montoVerdadero, Moneda.PESOS);
	}
	
	private Precio getPrecioInARS(Precio p) {
		return getPrecioInARS(p.getMonto(), p.getMoneda());
	}
	
}
