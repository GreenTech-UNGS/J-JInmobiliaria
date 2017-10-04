package presentacion.controller;

import java.util.Arrays;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.google.inject.Inject;

import entities.Propiedad;
import entities.Provincia;
import misc.Binder;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.vista.AgregarPropiedad;

public class AddPropiedadesController {
	
	private AgregarPropiedad view;
	private ProvinciaComboBoxModel provCombo;
	
	Binder<Propiedad> binder;
	
	@Inject
	private AddPropiedadesController(AgregarPropiedad view){
		
		this.view = view;
		this.binder = new Binder<>();
		
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
