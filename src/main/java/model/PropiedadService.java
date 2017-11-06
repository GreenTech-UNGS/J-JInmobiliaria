package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.FichaPropiedadDTO;
import entities.*;
import filtros.PropiedadFiltro;
import org.joda.time.DateTime;

import persistencia.dao.iface.DAOftp;
import persistencia.dao.iface.PropiedadDao;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class PropiedadService {

	@Inject
	PropiedadDao propiedadDao;
	
	@Inject private DAOftp ftp;
	
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
		
		
		return propiedadDao.existePropiedadConIdentificador(t.getID(), t.getIdentificador());		
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
		toRet.setTipoOfrecimiento(TipoOfrecimiento.Alquiler);
		
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
						.filter(p -> p.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquiler) ||
				p.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquileryventa))
						.collect(Collectors.toList());	

		return toRet;
		
	}
	public List<Propiedad> getVentaBy(EstadoProp... estados){
		List<Propiedad> allProps = getAll();
		
		List<EstadoProp> estadosAFiltrar = Arrays.asList(estados);
		
		List<Propiedad> toRet = allProps.stream().filter(p -> estadosAFiltrar.contains(getCurrentEstado(p))).filter
				(p -> p.getTipoOfrecimiento().equals(TipoOfrecimiento.Venta) || p.getTipoOfrecimiento().equals
						(TipoOfrecimiento.Alquileryventa)).collect(Collectors.toList());
		return toRet;
		
	}
	
	public void actualizarPropiedad(Propiedad propiedadVieja){
		propiedadDao.actualizePropiedad(propiedadVieja);
	}
	
	public void setDisponible(Propiedad p){
		
		HistoriaEstadoProp historia = new HistoriaEstadoProp();
		historia.setEstado(EstadoProp.DISPONIBLE);
		historia.setFecha(DateTime.now());
		
		p.getEstados().add(historia);
		propiedadDao.save(p);	
		}
	
	public List<Propiedad> getEnAlquiler(){
		List<Propiedad> toRet = new ArrayList<Propiedad>();
		for(Propiedad p : this.getAll()){
			if(p.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquiler) || p.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquileryventa)){
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
			if(p.getTipoOfrecimiento().equals(TipoOfrecimiento.Venta) || p.getTipoOfrecimiento().equals(TipoOfrecimiento.Alquileryventa)){
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
	
	public File getPortadaFileOf(Propiedad p) {
		
		Foto portada = null;
		
		for(Foto f: p.getFotos())
			if(f.isPortada())
				portada = f;
		
		File tempFile = null;
		try {
			tempFile = File.createTempFile(portada.getPath(), ".tmp");
		ftp.retrieveFile(portada.getPath(), tempFile.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tempFile;
	}
	
	public List<FichaPropiedadDTO> fichaPropiedadReporteOf(Propiedad propiedad) {

		List<FichaPropiedadDTO> fichas = new ArrayList<FichaPropiedadDTO>();
		FichaPropiedadDTO fichaPropiedad = new FichaPropiedadDTO();

		fichaPropiedad.setTipoPropiedad(propiedad.getTipoOfrecimiento().name().toString());
		String foto = getPortadaFileOf(propiedad).getAbsolutePath();
		fichaPropiedad.setFoto(foto);

		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );

		String dd2dec = df2.format(propiedad.getPrecioTentativo().getMonto());

		fichaPropiedad.setPrecio(dd2dec+" "
				  				+propiedad.getPrecioTentativo().getMoneda());

		fichaPropiedad.setProvincia(propiedad.getLocalidad().getProvincia().name());
		fichaPropiedad.setLocalidad(propiedad.getLocalidad().getNombre());
		fichaPropiedad.setMetrosCuadrados("");
		fichaPropiedad.setOtrosDatos("");
		fichaPropiedad.setCantidadDeAmbientes("");
		if ( propiedad.getOtrosDatos() != null) {
			fichaPropiedad.setMetrosCuadrados(propiedad.getOtrosDatos().getMetrosCuadradosCubiertos() + " m2");
			fichaPropiedad.setCantidadDeAmbientes(propiedad.getOtrosDatos().getCantidadAmbientes() + "");
		}

		fichaPropiedad.setObservaciones(propiedad.getObsPublicas());
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
