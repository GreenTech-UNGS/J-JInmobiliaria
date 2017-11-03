package presentacion.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Propiedad;
import model.GaleriaService;
import model.PropiedadService;
import presentacion.vista.GaleriaFotosView;

@Singleton
public class GaleriaController {
	
	private GaleriaFotosView view;
	private JFileChooser fileChooser;
	@Inject private GaleriaService galeriaService;
	
	private int page;
	private Propiedad currentPropiedad;
	
	@Inject
	private GaleriaController(GaleriaFotosView view) {
		
		this.view = view;
		
		this.view.getBtnPrev().addActionListener(e -> proxPagina());
		this.view.getBtnProx().addActionListener(e -> prevPagina());
		
		this.view.getBtnAgregarFoto().addActionListener(e -> agregarFoto());
		

		this.fileChooser = new JFileChooser();
		
	}

	private void prevPagina() {
		page --;
		actualizePage();
	}

	private void proxPagina() {
		page++;
		actualizePage();
	}
	
	
	private void agregarFoto() {
		
		fileChooser.showOpenDialog(view);
		
		File f = fileChooser.getSelectedFile();
		
		if(f != null){
			galeriaService.saveFoto(currentPropiedad, f);
		}
	}

	public void setNew(Propiedad p){
		currentPropiedad = p;
		
		page = 0;
	}
	
	public void showView(){
		
		this.view.setVisible(true);
		
	}
	
	private void actualizePage(){
		
		JLabel[] labels = view.getImagesLabels();
		List<byte[]> imagenes = galeriaService.getImagesOf(currentPropiedad, page);
		
		for(int i = 0; i < 9; i++){
			labels[i].setIcon(new ImageIcon(imagenes.get(i)));
		}
		
		
		this.view.revalidate();
	}

}
