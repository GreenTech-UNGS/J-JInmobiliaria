package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.main.vista.LoginView;
import presentacion.main.vista.MainView;

@Singleton
public class LoginController {
	
	private LoginView view;
	@Inject MainViewController mainViewController;
	
	@Inject
	private LoginController(LoginView view) {
		
		this.view = view;
		
		this.view.getBtnLogin().addActionListener(e -> login());
		
	}

	public void showView() {
		this.view.show();
	}
	
	private void login() {
		this.mainViewController.showView();
		this.view.dispose();
	}

}
