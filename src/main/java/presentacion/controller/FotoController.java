package presentacion.controller;

import javax.swing.ImageIcon;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Foto;
import entities.Propiedad;
import model.GaleriaService;
import presentacion.validators.MessageShow;
import presentacion.vista.FotoView;

@Singleton
public class FotoController {

	private FotoView view;
	
	@Inject private GaleriaService galeriaService;
	@Inject private MessageShow messageShow;
	
	private Foto currentFoto;
	private Propiedad currentProp;
	
	@Inject
	private FotoController(FotoView view) {
		
		this.view = view;
		
		this.view.getBtnPortada().addActionListener(e -> setPortada());
		this.view.getBtnBorrarFoto().addActionListener(e -> borrarFoto());
		
	}
	
	private void setPortada() {
		galeriaService.setPortada(currentFoto, currentProp);
		messageShow.showInformationMessage("Se ha definido la foto como portada", "Exito");
	}
	
	public void setFoto(Foto f, Propiedad p) {
		currentFoto = f;
		currentProp = p;
		
		view.getLblFoto().setIcon(new ImageIcon(galeriaService.getImagen(currentFoto)));
		view.ajustarSize();
	}
	
	public void borrarFoto() {
		
		if(messageShow.showYesNoMessage("¿Quiere borrar la foto actual?\nEsta accion no se puede deshacer", "Borrar foto")) {
			galeriaService.borrarFoto(currentProp, currentFoto);
			view.setVisible(false);
		}
		
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public void setEditMode() {
		
		view.getBtnPortada().setVisible(true);
		view.getBtnBorrarFoto().setVisible(true);
		
	}

	public void setViewMode() {

		view.getBtnPortada().setVisible(false);
		view.getBtnBorrarFoto().setVisible(false);
		
	}
	
}
