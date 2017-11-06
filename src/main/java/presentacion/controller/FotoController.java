package presentacion.controller;

import javax.swing.ImageIcon;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Foto;
import entities.Propiedad;
import model.GaleriaService;
import presentacion.vista.FotoView;

@Singleton
public class FotoController {

	private FotoView view;
	
	@Inject private GaleriaService galeriaService;
	
	private Foto currentFoto;
	private Propiedad currentProp;
	
	@Inject
	private FotoController(FotoView view) {
		
		this.view = view;
		
		this.view.getBtnPortada().addActionListener(e -> setPortada());
		
	}
	
	private void setPortada() {
		galeriaService.setPortada(currentFoto, currentProp);
	}
	
	public void setFoto(Foto f, Propiedad p) {
		currentFoto = f;
		currentProp = p;
		
		view.getLblFoto().setIcon(new ImageIcon(galeriaService.getImagen(currentFoto)));
	}
	
	public void showView() {
		view.setVisible(true);
	}
	
	public void setEditMode() {
		
		view.getBtnPortada().setVisible(true);
		
	}

	public void setViewMode() {

		view.getBtnPortada().setVisible(false);
		
	}
	
}
