package presentacion.controller;

import java.util.Arrays;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Provincia;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	private AgregarPropiedad view;
	private ProvinciaComboBoxModel provCombo;
	
	@Inject
	private AddPropiedadesController(AgregarPropiedad view){
		
		this.view = view;
		
		this.provCombo = new ProvinciaComboBoxModel();
		
		fillCombos();
	}
	
	
	private void fillCombos() {
		
		this.view.getComboProvincia().setModel(provCombo);
		provCombo.actualize(Arrays.asList(Provincia.values()));
		AutoCompleteDecorator.decorate(view.getComboProvincia());
		
	}


	public void showView(){
			
			view.setVisible(true);
	}

}
