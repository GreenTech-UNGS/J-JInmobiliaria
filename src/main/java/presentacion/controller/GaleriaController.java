package presentacion.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.PropiedadService;
import presentacion.vista.GaleriaFotosView;

@Singleton
public class GaleriaController {
	
	private GaleriaFotosView view;
	@Inject private PropiedadService propiedadService;
	
	private int page;
	
	@Inject
	private GaleriaController(GaleriaFotosView view) {
		
		this.view = view;
		
		this.view.getBtnPrev().addActionListener(e -> proxPagina());
		this.view.getBtnProx().addActionListener(e -> prevPagina());
		
	}
	
	private void prevPagina() {
		page --;
		actualizePage();
	}

	private void proxPagina() {
		page++;
		actualizePage();
	}

	public void setNew(){
		page = 0;
	}
	
	public void showView(){
		
		this.view.setVisible(true);
		
	}
	
	private void actualizePage(){
		
		JLabel[] labels = view.getImagesLabels();
		List<byte[]> imagenes = propiedadService.getImagesOf(page);
		
		for(int i = 0; i < 9; i++){
			labels[i].setIcon(new ImageIcon(imagenes.get(i)));
		}
		
		
		this.view.revalidate();
	}

}
