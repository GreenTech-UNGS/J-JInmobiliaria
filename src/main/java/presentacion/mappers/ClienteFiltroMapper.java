package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona.TipoCredencial;
import filtros.ClienteFiltro;
import presentacion.vista.filtros.ClienteFiltroView;

@Singleton
public class ClienteFiltroMapper implements Mapper<ClienteFiltro>{
	
	private ClienteFiltroView view;

	@Inject
	private ClienteFiltroMapper(ClienteFiltroView view) {
		this.view = view;
	}

	@Override
	public void fillBean(ClienteFiltro t) {
		String nombre = getStringOf(view.getTextNombre().getText());
		String apellido = getStringOf(view.getTextApellido().getText());
		String credencial = getStringOf(view.getTextCredencial().getText());
		
		TipoCredencial tipoCredencial = view.getTipoComboBox().getSelected();
		
		t.setApellido(apellido);
		t.setNombre(nombre);
		t.setCredencial(credencial);
		t.setTipoCredencial(tipoCredencial);
		
	}

	@Override
	public void fillFields(ClienteFiltro t) {
		String nombre = getStringOf(t.getNombre());
		String apellido = getStringOf(t.getApellido());
		String credencial = getStringOf(t.getCredencial());
		
		TipoCredencial tipoCredencial = t.getTipoCredencial();
		
		view.getTextNombre().setText(nombre);
		view.getTextApellido().setText(apellido);
		view.getTextCredencial().setText(credencial);
		view.getTipoComboBox().setSelected(tipoCredencial);;
	}
	
	private String getStringOf(String s){
		return s == null? "": s;
	}
	
	
}
