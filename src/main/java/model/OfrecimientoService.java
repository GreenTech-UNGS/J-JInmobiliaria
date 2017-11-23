package model;

import com.google.inject.Singleton;

import entities.Moneda;
import entities.OfrecimientoAlquiler;
import entities.Precio;
import entities.Propiedad;

@Singleton
public class OfrecimientoService {
	
	private double valorDolar = 10;

	public Precio getPrecioParaEntrar(OfrecimientoAlquiler o) throws LogicaNegocioException{
		
		if(!o.isHabilitada())
			throw new LogicaNegocioException("La propiedad no está para alquiler");
		
		Precio pPesos = new Precio(0, Moneda.PESOS);
		
		double primerMesPesos = getPrimerMes(o).getMonto();
		double comisionPesos = getComisionOf(o).getMonto();
		double depositoPesos = getDeposito(o).getMonto();
		double certificadosPesos = getOtrosGastos(o).getMonto();
		double selladoPesos = getSelladoPesos(o).getMonto();
		
		pPesos.setMonto(primerMesPesos + comisionPesos + depositoPesos + certificadosPesos + selladoPesos);
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
		
		if(m.equals(Moneda.USD)){
			valorTotal = valorTotal * valorDolar;
		}
		
		return new Precio(valorTotal, Moneda.PESOS);
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
	
}
