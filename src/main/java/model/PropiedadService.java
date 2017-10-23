package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Contrato;
import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Moneda;
import entities.Precio;
import entities.Propiedad;
import entities.Propietario;
import entities.TipoOfrecimiento;
import filtros.PropiedadFiltro;
import filtros.PropietarioFiltro;
import persistencia.dao.iface.PropiedadDao;

@Singleton
public class PropiedadService {

	@Inject
	PropiedadDao propiedadDao;
	
	@Inject
	private PropiedadService() {
		
	}
	
	public List<Propiedad> getAll(){
		return propiedadDao.getAll();
	}
	
	public boolean existePropiedadConIdentificador(Propiedad t) {
		
		return propiedadDao.existePropiedadConIdentificador(t.getIdentificador());		
	}
	
	public void savePropiedad(Propiedad p) throws LogicaNegocioException {
		
		//if(existePropiedadConIdentificador(p))
			//throw new LogicaNegocioException("Ya existe una propiedad con el identificador ingresado");
		
		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.DISPONIBLE);
		historia.setFecha(DateTime.now());
		
		p.getEstados().add(historia);
		propiedadDao.save(p);
	}
	
	public void savePropiedadBorrador(Propiedad p) throws LogicaNegocioException {
		
		//if(existePropiedadConIdentificador(p))
			//throw new LogicaNegocioException("Ya existe una propiedad con el identificador ingresado");
		
		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.BORRADOR);
		historia.setFecha(DateTime.now());
		
		p.getEstados().add(historia);
		propiedadDao.save(p);
	}
	
	
	
	public Propiedad getEmptyPropiedad() {
		Propiedad toRet = new Propiedad();
		
		toRet.setPrecioTentativo(new Precio(0, Moneda.PESOS));
		toRet.setTipoOfrecimiento(TipoOfrecimiento.ALQUILER);
		
		return toRet;
		
	}
	
	public EstadoProp getCurrentEstado(Propiedad p) {
		
		p.getEstados().sort((h1, h2) -> h2.getFecha().compareTo(h1.getFecha()));	
		return p.getEstados().get(0).getEstado();
		
	}

	public List<Propiedad> getAlquilerBy(EstadoProp... estados) {
		
		List<Propiedad> allProps = getAll();

		List<EstadoProp> estadosAFiltrar = Arrays.asList(estados);

		
		List<Propiedad> toRet = allProps.stream().filter(p -> estadosAFiltrar.contains(getCurrentEstado(p)))
						.filter(p -> p.getTipoOfrecimiento().equals(TipoOfrecimiento.ALQUILER) ||
				p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA_Y_ALQUILER))
						.collect(Collectors.toList());	

		return toRet;
		
	}
	public List<Propiedad> getVentaBy(EstadoProp... estados){
		List<Propiedad> allProps = getAll();
		
		List<EstadoProp> estadosAFiltrar = Arrays.asList(estados);
		
		List<Propiedad> toRet = allProps.stream().filter(p -> estadosAFiltrar.contains(getCurrentEstado(p))).filter
				(p -> p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA) || p.getTipoOfrecimiento().equals
						(TipoOfrecimiento.VENTA_Y_ALQUILER)).collect(Collectors.toList());
		return toRet;
		
	}
	
	public void actualizarPropiedad(Propiedad propiedadVieja){
		propiedadDao.actualizePropiedad(propiedadVieja);
	}
	
	public List<Propiedad> getEnAlquiler(){
		List<Propiedad> toRet = new ArrayList<Propiedad>();
		for(Propiedad p : this.getAll()){
			if(p.getTipoOfrecimiento().equals(TipoOfrecimiento.ALQUILER) || p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA_Y_ALQUILER)){
				if(this.getCurrentEstado(p).equals(EstadoProp.DISPONIBLE)){
					toRet.add(p);
				}
			}
		}
		return toRet;
	}
	
	public List<Propiedad> getEnVenta(){
		List<Propiedad> toRet = new ArrayList<Propiedad>();
		for(Propiedad p : this.getAll()){
			if(p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA) || p.getTipoOfrecimiento().equals(TipoOfrecimiento.VENTA_Y_ALQUILER)){
				if(this.getCurrentEstado(p).equals(EstadoProp.DISPONIBLE)){
					toRet.add(p);
				}
			}
		}
		return toRet;
	}
	
	public List<Propiedad> getAlquiladas(){
		List<Propiedad> toRet = new ArrayList<Propiedad>();
		for(Propiedad p : this.getAll()){
			if(this.getCurrentEstado(p).equals(EstadoProp.ALQUILADA)){
				toRet.add(p);
			}
		}
		return toRet;
	}
	
	public List<Propiedad> getVendidas(){
		List<Propiedad> toRet = new ArrayList<Propiedad>();
		for(Propiedad p : this.getAll()){
			if(this.getCurrentEstado(p).equals(EstadoProp.VENDIDA)){
				toRet.add(p);
			}
		}
		return toRet;
	}
	
	public List<Propiedad> getAllByFiltro(PropiedadFiltro filtro){
		
		return propiedadDao.getAllByFiltro(filtro);
		
	}
	
}
