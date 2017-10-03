package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Telefono;
import entities.Telefono.Tipo;
import misc.Binder;
import presentacion.combo.TipoTelefonoComboBoxModel;
import presentacion.vista.AgregaTelefonoView;

@Singleton
public class AgregaTelefonoController {
	
	AgregaTelefonoView view;
	TipoTelefonoComboBoxModel comboModel;
	Telefono currentTelefono;
	
	Binder<Telefono> binder;
	
	@Inject
	private AgregaTelefonoController(AgregaTelefonoView view,
			TipoTelefonoComboBoxModel comboModel) {
		
		this.view = view;
		this.comboModel = comboModel;
		currentTelefono = null;

		fillCombos();
		
		this.binder = new Binder<>();
		binder.bind("numero", view.getTextTelefono()::getText, s -> view.getTextTelefono().setText(s.toString()));
		binder.bind("tipo", comboModel::getSelected, t -> comboModel.setSelected((Telefono.Tipo)t));
		binder.bind("notas", view.getTextDescr()::getText, s -> view.getTextDescr().setText(s.toString()));
		
		view.getBtnOk().addActionListener(e -> aceptar());
		view.getBtnCancelar().addActionListener(e -> cancelar());
		view.getComboTipo().addActionListener(e -> cambiaOpcion());
	}
	
	public Telefono getTelefono() {
		return currentTelefono;
	}
	
	public void showView() {
		this.view.setVisible(true);
	}
	
	public void setModeNew() {
		currentTelefono = new Telefono();
		currentTelefono.setTipo(Tipo.CASA);
		currentTelefono.setNotas("");
		currentTelefono.setNumero("");
		binder.setObjective(currentTelefono);
		binder.fillFields();
	}
	
	private void fillCombos(){
		view.getComboTipo().setModel(comboModel);
		Arrays.asList(Telefono.Tipo.values()).forEach(t -> comboModel.agregaElemento(t));
	}
	
	private void aceptar() {
		binder.fillBean();
		view.setVisible(false);
	}
	
	private void cancelar() {
		currentTelefono = null;
		view.setVisible(false);
	}
	
	private void cambiaOpcion() {
		if(comboModel.getSelected().equals(Tipo.OTRO)) {
			view.getLblNotas().setVisible(true);
			view.getTextDescr().setVisible(true);
		}
		else {
			view.getLblNotas().setVisible(false);
			view.getTextDescr().setVisible(false);
			view.getTextDescr().setText("");
		}
	}
	
}
