package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.InteresadoFiltro;
import presentacion.vista.filtros.InteresadoFiltroView;

@Singleton
public class InteresadoFiltroMapper implements Mapper<InteresadoFiltro>{
	
	InteresadoFiltroView view;
	
	@Inject
	private InteresadoFiltroMapper(InteresadoFiltroView view){
		this.view = view;
	}
	
	@Override
	public void fillBean(InteresadoFiltro t) {
		String nombre = this.view.getTextNombre().getText();
		String apellido = this.view.getTextApellido().getText();
		String credencial = this.view.getTextCredencial().getText();
		TipoCredencial tipoCred = (TipoCredencial) view.getTipoComboBox().getSelectedItem();
		
		t.setNombre(nombre);
		t.setApellido(apellido);
		t.setCredencial(credencial);
		t.setTipoCredencial(tipoCred);
	}

	@Override
	public void fillFields(InteresadoFiltro t) {
		
		String nombre = t.getNombre();
		String apellido = t.getApellido();
		String credencial = t.getCredencial();
		TipoCredencial tipoCred = t.getTipoCredencial();
		
		this.view.getTextNombre().setText(nombre);
		this.view.getTextApellido().setText(apellido);
		this.view.getTextCredencial().setText(credencial);
		this.view.getTipoComboBox().setSelectedItem(tipoCred);
		
	}
}
