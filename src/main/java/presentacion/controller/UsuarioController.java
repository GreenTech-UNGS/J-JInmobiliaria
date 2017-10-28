package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Usuario;
import entities.Rol;
import model.LogicaNegocioException;
import model.UsuarioService;
import presentacion.combo.RolComboBoxModel;
import presentacion.mappers.UsuarioFormMapper;
import presentacion.validators.MessageShow;
import presentacion.validators.UsuarioFormValidator;
import presentacion.vista.UsuarioForm;

@Singleton
public class UsuarioController {
	
	private UsuarioForm view;
	private UsuarioService usuarioService;
	private Usuario currentUsuario;
	
	@Inject private UsuarioFormValidator usuarioValidator;
	@Inject private MessageShow msgShw;
	@Inject private UsuarioFormMapper usuarioMapper;
	
	@Inject
	private UsuarioController(UsuarioForm view, UsuarioService usuarioService){
		
		this.view = view;
		this.usuarioService = usuarioService;
		
		view.getBtnAceptar().addActionListener(e -> saveCurrentUsuario());
		view.getBtnCancelar().addActionListener(e -> view.setVisible(false));
	}
	
	public void setModeNew() {
		currentUsuario = usuarioService.getNuevoUsuario();
		usuarioMapper.fillFields(currentUsuario);
		fillCombos();
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	private void saveCurrentUsuario() {
		
		if(usuarioValidator.isValid()) {
			try {
				usuarioMapper.fillBean(currentUsuario);
				usuarioService.saveUsuario(currentUsuario);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
				view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(usuarioValidator.getErrorMessage(), "Error");
		}
	}
	
	private void fillCombos() {
		view.getComboModel().clearAndActualize(Arrays.asList(Rol.values()));
		view.getComboModel().setSelected(Rol.EMPLEADO);
	}

}
