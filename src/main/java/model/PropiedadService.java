package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.FichaPropiedadDTO;
import entities.*;
import filtros.PropiedadFiltro;
import org.joda.time.DateTime;
import persistencia.dao.iface.PropiedadDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<TipoHabitacion> getAllTipoHabitacion(){
		System.out.println(propiedadDao.getAllTipoHabitacion().size());
		return propiedadDao.getAllTipoHabitacion();
	}
	
	public boolean existePropiedadConIdentificador(Propiedad t) {
		
		return propiedadDao.existePropiedadConIdentificador(t.getIdentificador());		
	}
	
	public void savePropiedad(Propiedad p) throws LogicaNegocioException {
		
		if(existePropiedadConIdentificador(p))
			throw new LogicaNegocioException("Ya existe una propiedad con el identificador ingresado");


		if(p.getPropietario() == null)
			throw new LogicaNegocioException("La propiedad debe tener un propietario");

		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.DISPONIBLE);
		historia.setFecha(DateTime.now());
		
		p.getEstados().add(historia);
		propiedadDao.save(p);
	}
	
	public void savePropiedadNoDisp(Propiedad p) throws LogicaNegocioException {
		
		//if(existePropiedadConIdentificador(p))
			//throw new LogicaNegocioException("Ya existe una propiedad con el identificador ingresado");
		
		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.NODISPONIBLE);
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

	/*
	* String TipoPropiedad;
    * String Foto;
    * String Precio;
    * String Provincia;
    **** String Localidad;
    * String MetrosCuadrados;
    * String CantidadDeAmbientes;
    * String OtrosDatos;
    * String Observaciones;
    * String Calle;
    * String Direccion;
    * String Piso;
    * String Departamento;
    Double Lat;
    Double Long;


	 */
	public List<FichaPropiedadDTO> fichaPropiedadReporteOf(Propiedad propiedad) {

		List<FichaPropiedadDTO> fichas = null;
		FichaPropiedadDTO fichaPropiedad = new FichaPropiedadDTO();
	//
	// Aca poner una foto que es la por default si no tiene foto y sino tomar la de portada
	//
		fichaPropiedad.setTipoPropiedad(propiedad.getTipoOfrecimiento().name().toString());
		String foto = "resources/cityscape.png";//propiedad.getFotos();
		fichaPropiedad.setFoto(foto);
		fichaPropiedad.setPrecio(propiedad.getPrecioTentativo().toString());

		fichaPropiedad.setProvincia("BuenosAres");
		fichaPropiedad.setLocalidad(propiedad.getLocalidad().toString());
		fichaPropiedad.setMetrosCuadrados("20 m2");
//		fichaPropiedad.setMetrosCuadrados(propiedad.getOtrosDatos().getMetrosCuadradosCubiertos()+"");
//		fichaPropiedad.setCantidadDeAmbientes(propiedad.getOtrosDatos().getCantidadAmbientes()+"");
		fichaPropiedad.setObservaciones(propiedad.getObsPublicas());
//		fichaPropiedad.setOtrosDatos(propiedad.getOtrosDatos().toString());
		fichaPropiedad.setOtrosDatos("Ootros datos ver como hacer para que traiga un to string digno");
		fichaPropiedad.setCalle(propiedad.getCalle().toString());
		fichaPropiedad.setDireccion(propiedad.getCalle()+""+propiedad.getAltura());
		fichaPropiedad.setPiso(propiedad.getPiso().toString());
		fichaPropiedad.setDepartamento(propiedad.getDpto().toString());
		fichaPropiedad.setLat(propiedad.getLat());
		fichaPropiedad.setLong(propiedad.getLon());
		fichas.add(fichaPropiedad);

		return fichas;
	}



}
