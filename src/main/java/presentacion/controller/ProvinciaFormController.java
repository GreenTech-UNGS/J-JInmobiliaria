package presentacion.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Provincia;
import model.LocalidadService;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.validators.MessageShow;
import presentacion.vista.ProvinciaForm;

@Singleton
public class ProvinciaFormController {

	private ProvinciaForm view;
	private ProvinciaComboBoxModel comboModel;
	@Inject private LocalidadService localidadService;
	@Inject private MessageShow msgShw;
	
	private Map<String, Float> provincias;
	
	
	@Inject
	public ProvinciaFormController(ProvinciaForm view) {
		
		this.view = view;
		provincias = new HashMap<>();
		comboModel = new ProvinciaComboBoxModel();
		this.view.getProvinciaCombo().setModel(comboModel);
		this.view.getProvinciaCombo().addItemListener(e -> guardaActualiza(e));
		this.view.getBtnGuardar().addActionListener(e -> guarda());
		
	}
	
	private void guardaActualiza(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.DESELECTED) {
			String selected = (String)e.getItem();
			if(selected != null)provincias.put(selected, (float)view.getValorSpinner().getValue());
		}		
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			String selected = (String)e.getItem();

			if(selected != null)view.getValorSpinner().setValue(provincias.get(selected));
		}
	}
	
	private void guarda() {

		Provincia selected = comboModel.getSelected();

		if(selected != null)provincias.put(selected.getNombre(), (float)view.getValorSpinner().getValue());
		
		for(String s: provincias.keySet()) {
			
			Provincia p = comboModel.getPorNombre(s);
			localidadService.saveSelladoProvincia(p, provincias.get(s));
		}
		
		msgShw.showInformationMessage("Se guardaron los valores de sellado", "Exito");
		this.view.setVisible(false);
	}

	public void showView() {
		fillCombo();
		this.view.setVisible(true);
	}
	
	private void fillCombo() {
		List<Provincia> provs = localidadService.getProvincias();
		provincias.clear();
		for (Provincia provincia : provs) {
			provincias.put(provincia.getNombre(), provincia.getImpuesto());
		}
		this.comboModel.clearAndActualize(provs);
		this.comboModel.setSelected(provs.get(0));
	}
	
	
}
