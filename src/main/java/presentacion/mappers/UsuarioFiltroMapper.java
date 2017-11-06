package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.UsuarioFiltro;
import presentacion.vista.filtros.UsuarioFiltroView;

@Singleton
public class UsuarioFiltroMapper implements Mapper<UsuarioFiltro>{
	
	UsuarioFiltroView view;
	
	@Inject
	UsuarioFiltroMapper(UsuarioFiltroView view){
		this.view = view;
	}

	@Override
	public void fillBean(UsuarioFiltro t) {
		String nombre = this.view.getTfNombre().getText();
		String apellido = this.view.getTfApellido().getText();
		String credencial = this.view.getTfCredencial().getText();
		TipoCredencial tipoCred = (TipoCredencial) view.getTipoComboBox().getSelectedItem();
		
		t.setNombre(nombre);
		t.setApellido(apellido);
		t.setCredencial(credencial);
		t.setTipoCredencial(tipoCred);
	}

	@Override
	public void fillFields(UsuarioFiltro t) {
		
		String nombre = t.getNombre();
		String apellido = t.getApellido();
		String credencial = t.getCredencial();
		TipoCredencial tipoCred = t.getTipoCredencial();
		
		this.view.getTfNombre().setText(nombre);
		this.view.getTfApellido().setText(apellido);
		this.view.getTfCredencial().setText(credencial);
		this.view.getTipoComboBox().setSelectedItem(tipoCred);
		
	}
}
