package presentacion.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Foto;
import entities.Propiedad;
import model.GaleriaService;
import model.PropiedadService;
import presentacion.vista.GaleriaFotosView;

@Singleton
public class GaleriaController {
	
	private GaleriaFotosView view;
	private JFileChooser fileChooser;
	@Inject private GaleriaService galeriaService;
	@Inject private FotoController fotoController;
	
	private int page;
	private Propiedad currentPropiedad;
	private Map<JLabel, Foto> fotos;
	
	@Inject
	private GaleriaController(GaleriaFotosView view) {
		
		this.view = view;
		this.fotos = new HashMap<>();
		
		this.view.getBtnPrev().addActionListener(e -> prevPagina());
		this.view.getBtnProx().addActionListener(e -> proxPagina());
		
		this.view.getBtnAgregarFoto().addActionListener(e -> agregarFoto());
		
		initLabelsListeners();

		this.fileChooser = new JFileChooser();
		
	}

	private void prevPagina() {
		if(page > 0) {
			page --;
			actualizePage();
		}
	}

	private void proxPagina() {
		if(!galeriaService.isUltimaPagina(page, currentPropiedad)) {
			page++;
			actualizePage();
		}
	}
	
	
	private void agregarFoto() {
		
		fileChooser.showOpenDialog(view);
		
		File f = fileChooser.getSelectedFile();
		
		if(f != null){
			galeriaService.saveFoto(currentPropiedad, f);
		}
		
		actualizePage();
	}

	public void setNew(Propiedad p){
		currentPropiedad = p;
		
		page = 0;
	}
	
	public void setEditMode() {
		
		view.getBtnAgregarFoto().setVisible(true);
		fotoController.setEditMode();
		
	}

	public void setViewMode() {

		view.getBtnAgregarFoto().setVisible(false);
		fotoController.setViewMode();
	}
	
	
	public void showView(){

		actualizePage();
		this.view.setVisible(true);
		
	}
	
	private void initLabelsListeners() {
		JLabel[] labels = view.getImagesLabels();
		Border selectedborder = BorderFactory.createLineBorder(Color.BLUE, 2);
		Border unSelectedborder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);
		
		MouseAdapter adapter = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				((JLabel)e.getSource()).setBorder(selectedborder);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				((JLabel)e.getSource()).setBorder(unSelectedborder);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Foto foto = fotos.get(((JLabel)e.getSource()));
				
				if(foto != null) {
					fotoController.setFoto(foto, currentPropiedad);
					fotoController.showView();
				}
			}
		};
		
		for (JLabel jLabel : labels) {
			jLabel.setBorder(unSelectedborder);
			jLabel.addMouseListener(adapter);
		}
	}
	
	private void actualizePage(){
		
		JLabel[] labels = view.getImagesLabels();
		List<Foto> imagenes = galeriaService.getFotosOf(currentPropiedad, page);
		
		fotos.clear();
		Arrays.asList(labels).forEach(l -> l.setIcon(null));
		
		for(int i = 0; i < imagenes.size(); i++){
			labels[i].setIcon(new ImageIcon(galeriaService.getThumbnail(imagenes.get(i))));
			fotos.put(labels[i], imagenes.get(i));
		}
		
		
		this.view.revalidate();
	}

}
