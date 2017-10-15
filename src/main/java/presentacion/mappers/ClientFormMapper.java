package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Persona;
import entities.Persona.TipoCredencial;
import presentacion.vista.ClienteForm;

@Singleton
public class ClientFormMapper implements Mapper<Cliente>{

	ClienteForm view;
	
	@Inject
	private ClientFormMapper(ClienteForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(Cliente c) {
		
		String credencial = view.getTextCredencial().getText();
		TipoCredencial tipoCred = TipoCredencial.valueOf((String)view.getComboCredencial().getSelectedItem());
		String nombre = view.getTextNombre().getText();
		String apellido = view.getTextApellido().getText();
		String email = view.getTextMail().getText();
		boolean isHabilitado = true; //TODO: cambiar
		
		c.setHabilitado(isHabilitado);
		c.getPersona().setApellido(apellido);
		c.getPersona().setCredencial(credencial);
		c.getPersona().setTipoCred(tipoCred);
		c.getPersona().setEmail(email);
		c.getPersona().setNombre(nombre);
		
	}

}
