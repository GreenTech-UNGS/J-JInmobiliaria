package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Usuario;
import entities.Rol;
import presentacion.vista.UsuarioForm;

@Singleton
public class UsuarioFormMapper implements Mapper<Usuario> {
	
	UsuarioForm view;
	
	@Inject
	private UsuarioFormMapper(UsuarioForm view){
		this.view = view;
	}

	@Override
	public void fillBean(Usuario t) {
		String nombre = view.getTfNombre().getText();
		String apellido = view.getTfApellido().getText();
		String email = view.getTfEmail().getText();
		String dni = view.getTfDni().getText();
		Rol rol = view.getComboModel().getSelected();
		
		t.getPersona().setNombre(nombre);
		t.getPersona().setApellido(apellido);
		t.getPersona().setEmail(email);
		t.getRoles().add(rol);
		t.getPersona().setCredencial(dni);
	}

	@Override
	public void fillFields(Usuario t) {
		
		String nombre = t.getPersona().getNombre();
		String apellido = t.getPersona().getApellido();
		String email = t.getPersona().getEmail();
		//Rol rol = t.getRoles().get(0);
		Rol rol = null;
		String Dni = t.getPersona().getCredencial();
		
		view.getTfNombre().setText(nombre);
		view.getTfApellido().setText(apellido);
		view.getTfEmail().setText(email);
		view.getComboModel().setSelected(rol);
		view.getTfDni().setText(Dni);
	}

}
