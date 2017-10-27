package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.LogicaNegocioException;
import model.UsuarioService;
import presentacion.main.vista.LoginView;
import presentacion.main.vista.MainView;
import presentacion.validators.MessageShow;

@Singleton
public class LoginController {
	
	private LoginView view;
	@Inject MainViewController mainViewController;
	@Inject UsuarioService userService;
	@Inject MessageShow msgShw;
	
	@Inject
	private LoginController(LoginView view) {
		
		this.view = view;
		
		this.view.getBtnLogin().addActionListener(e -> login());
		
	}

	public void showView() {
		this.view.show();
	}
	
	private void login() {
		
		String nombre = view.getTextUsuario().getText();
		String password = view.getTextUsuario().getText();
		
		try {
			userService.logearUsuario(nombre, password);

			this.mainViewController.showView();
			
			this.view.dispose();
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
		}
		
	}

}
