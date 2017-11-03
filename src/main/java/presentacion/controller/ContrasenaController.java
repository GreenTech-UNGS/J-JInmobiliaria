package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.LogicaNegocioException;
import model.UsuarioService;
import presentacion.validators.MessageShow;
import presentacion.vista.ContrasenaForm;

@Singleton
public class ContrasenaController {
	
	private ContrasenaForm view;
	@Inject UsuarioService usuarioService;
	@Inject private MessageShow msgShw;
	
	@Inject
	private ContrasenaController(ContrasenaForm view){
		this.view = view;
		
		this.view.getBtnCancelar().addActionListener(e -> this.view.setVisible(false));
		this.view.getBtnGuardar().addActionListener(e -> cambiarContrasena());
	}
	
	private void cambiarContrasena() {
		
		String contraActual = view.getTfContActual().getText();
		String contraNueva = view.getTfNuevaCont().getText();
		
		try {
			usuarioService.cambiaContrasenaLogueado(contraActual, contraNueva);
			msgShw.showInformationMessage("Se cambio la contraseña", "Exito");
			this.view.setVisible(false);
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
		}
		
	}

	public void showView() {
		this.view.setVisible(true);
		

	}
	
	public void setModeNew() {

	}
	

}
