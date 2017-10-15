package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Cliente;
import entities.Persona;
import entities.Persona.TipoCredencial;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.table.TelefonoTableModel;
import presentacion.vista.ClienteForm;

@Singleton
public class ClienteFormMapper implements Mapper<Cliente>{

	ClienteForm view;
	
	@Inject
	private ClienteFormMapper(ClienteForm view) {
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

	@Override
	public void fillFields(Cliente c) {
		
		String credencial = c.getPersona().getCredencial();
		TipoCredencial tipoCred = c.getPersona().getTipoCred(); 
		String nombre = c.getPersona().getNombre();
		String apellido = c.getPersona().getApellido();
		String email = c.getPersona().getEmail();
		boolean isHabilitado = c.isHabilitado();
		
		view.getTextCredencial().setText(credencial);
		view.getTextApellido().setText(apellido);
		view.getTextMail().setText(email);
		view.getTextNombre().setText(nombre);
		//Lo hace el controlador
		//((TipoCredencialComboBoxModel)view.getComboCredencial().getModel()).setSelected(tipoCred);
		//((TelefonoTableModel)view.getTableTelefono().getModel()).addRows(c.getPersona().getTelefonos());
		
		
	}

}
