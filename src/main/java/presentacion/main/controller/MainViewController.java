package presentacion.main.controller;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.BackUpService;
import model.LogicaNegocioException;
import model.UsuarioService;
import presentacion.controller.CartelController;
import presentacion.controller.CartelViewController;
import presentacion.controller.ContrasenaController;
import presentacion.controller.GastioFijoViewController;
import presentacion.controller.ProvinciaFormController;
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
    @Inject private BackUpService backup;
    @Inject ProvinciaFormController provinciaController;
    @Inject private MessageShow msgShw;
    
    @Inject private ContrasenaController contrasenaController;
	@Inject private CartelViewController cartelController;
	private JFileChooser fileChooser;
    
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
		
		this.view.getMntmImportar().addActionListener(e -> importar());
		this.view.getMntmExportar().addActionListener(e -> exportar());
		this.view.getMntmValoresDeSellado().addActionListener(e -> editarSellados());
		
		this.fileChooser = new JFileChooser();
		this.fileChooser.setMultiSelectionEnabled(true);
		

	}

	private void exportar() {
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		File f = fileChooser.getCurrentDirectory();
		
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try {
				backup.createBackUp(f);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error");
			}
		}
		
	}

	private void importar() {
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.showOpenDialog(null);
		File f = fileChooser.getSelectedFile();

		if(f!=null) {
			try {
				backup.importBackUp(f);
				msgShw.showInformationMessage("Importacion exitosa. \nel sistema se cerrará para que los cambios tomen efecto", "Exito");
				System.exit(0);
			} catch (LogicaNegocioException e) {
				msgShw.showErrorMessage(e.getMessage(), "Error");
			}
		}
	}
	
	private void editarSellados() {
		
		provinciaController.showView();
	}

	private void administrarCarteles() {
		cartelController.showView();
	
	}
	
	private void administrarGastos() {
		gastosController.showView();
	}

	public void showView(){
		this.view.show();
		this.menuController.cambiaPanelEscritorio();
	}
	
	private void editarUsuario() {
	
		usuarioController.editUsuario(usuarioService.getUsuarioLogeado());
		usuarioController.showView();
	}
	
	private void cambiarContrasena() {
		contrasenaController.showView();
	}
}
