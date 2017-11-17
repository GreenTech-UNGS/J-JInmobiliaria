package presentacion.main.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.SwingWorker;

import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.Singleton;

import model.LogicaNegocioException;
import model.MailSenderService;
import model.UsuarioService;
import presentacion.main.vista.LoginView;
import presentacion.main.vista.MainView;
import presentacion.validators.MessageShow;
import presentacion.validators.Regex;

@Singleton
public class LoginController {
	
	private LoginView view;
	@Inject MainViewController mainViewController;
	@Inject UsuarioService userService;
	@Inject MessageShow msgShw;
	
	private List<Runnable> loginListeners;
	
	@Inject
	private LoginController(LoginView view) {
		
		this.view = view;
		this.loginListeners = new ArrayList<>();
		
		ActionListener enter = (e -> login());
		
//		this.view.getBtnLogin().addActionListener(e -> login());
		this.view.getBtnLogin().addActionListener(e -> this.mainViewController.showView());
		this.view.getBtnRecuperarContrasea().addActionListener(e -> recuperarContrasena());
		this.view.getTextPass().addActionListener(enter);
		this.view.getTextUsuario().addActionListener(enter);
		
	}

	public void addLoginListener(Runnable r) {
		this.loginListeners.add(r);
	}
	
	public void showView() {
		this.view.show();
	}
	
	private void login() {
		
		String nombre = view.getTextUsuario().getText();
		String password = view.getTextPass().getText();
		
		try {
			userService.logearUsuario(nombre, password);

			this.loginListeners.forEach(l -> l.run());
			
			this.mainViewController.showView();		
			this.view.dispose();
		} catch (LogicaNegocioException e) {
			msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
		}
	}
	
	private void recuperarContrasena(){
		
		String email = msgShw.showInputMessage("Ingrese su email", "Recuperar contraseña");
		
		if(email == null)
			return;
		
		if(!email.matches(Regex.email()))
			msgShw.showErrorMessage("Email invalido", "Error");
		
		//TODO: pasar a un thread D:
		else{
			try {
				userService.actualizarContrasenaOf(email);
				msgShw.showInformationMessage("ContraseÃ±a actualizada.\n"
						+ "Chequee su casilla de email", "Exito");
				
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error de negocio");
			}
		}
		
	}

}
