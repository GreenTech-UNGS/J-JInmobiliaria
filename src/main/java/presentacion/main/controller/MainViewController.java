package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.UsuarioService;
import presentacion.controller.CartelController;
import presentacion.controller.CartelViewController;
import presentacion.controller.ContrasenaController;
import presentacion.controller.GastioFijoViewController;
import presentacion.controller.UsuarioController;
import presentacion.main.vista.MainView;
import presentacion.validators.MessageShow;

@Singleton
public class MainViewController {
	
	private MainView view;
	private MenuPanelController menuController;
	@Inject private UsuarioController usuarioController;
    @Inject private UsuarioService usuarioService;
    @Inject private GastioFijoViewController gastosController;
    @Inject MessageShow msgShw;
    
    @Inject ContrasenaController contrasenaController;
	@Inject CartelViewController cartelController;
    
	@Inject
	private MainViewController(MainView view,
			MenuPanelController menuController){
		
		this.view = view;
		this.menuController = menuController;
		
		this.menuController.showView();
		this.menuController.actualizeAll();
		
		this.view.getMntmMiCuenta().addActionListener(e -> editarUsuario());
		this.view.getMntmCambiarContrasea().addActionListener(e -> cambiarContrasena());
		
		this.view.getMntmCarteles().addActionListener(e -> administrarCarteles());
		this.view.getMntmGastosFijos().addActionListener(e -> administrarGastos());
		
		this.view.getMntmImportar().addActionListener(e -> System.out.println("importar"));
		this.view.getMntmExportar().addActionListener(e -> System.out.println("exportar"));

	}

	private void administrarCarteles() {
		cartelController.showView();
	
	}
	
	private void administrarGastos() {
		gastosController.showView();
	}

	public void showView(){
		this.view.show();
	}
	
	private void editarUsuario() {
	
		usuarioController.editUsuario(usuarioService.getUsuarioLogeado());
		usuarioController.showView();
	}
	
	private void cambiarContrasena() {
		contrasenaController.showView();
	}
}
