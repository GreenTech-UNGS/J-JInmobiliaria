package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Localidad;
import filtros.InmobiliariaFiltro;
import presentacion.vista.filtros.InmobiliariaFiltroView;

@Singleton
public class InmobiliariaFiltroMapper implements Mapper<InmobiliariaFiltro>{
	
	private InmobiliariaFiltroView view;
	
	@Inject
	private InmobiliariaFiltroMapper(InmobiliariaFiltroView view){
		this.view = view;
	}

	@Override
	public void fillBean(InmobiliariaFiltro t) {
		String cuit = view.getTfCuit().getText();
		String nombre = view.getTfNombre().getText();
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		t.setCuit(cuit);
		t.setNombre(nombre);
		t.setLocalidad(localidad);
	}

	@Override
	public void fillFields(InmobiliariaFiltro t) {
		
		String nombre = t.getNombre();
		String cuit = t.getNombre();
		
		view.getTfCuit().setText(cuit);
		view.getTfNombre().setText(nombre);
		
		view.getComboModelLocalidad().setSelected(t.getLocalidad());
		if(t.getLocalidad() != null)
			view.getComboModelProvincia().setSelected(t.getLocalidad().getProvincia());
		
	}


}
