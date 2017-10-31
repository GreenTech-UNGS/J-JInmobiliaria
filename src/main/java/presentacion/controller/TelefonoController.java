package presentacion.controller;

import java.util.Arrays;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Telefono;
import entities.Telefono.Tipo;
import misc.Binder;
import presentacion.combo.TipoTelefonoComboBoxModel;
import presentacion.validators.MessageShow;
import presentacion.validators.TelefonoFormValidator;
import presentacion.vista.TelefonoForm;

@Singleton
public class TelefonoController {
	
	TelefonoForm view;
	TipoTelefonoComboBoxModel comboModel;
	Telefono currentTelefono;
	MessageShow msgShw;
	
	Binder<Telefono> binder;
	
	@Inject
	private TelefonoFormValidator telefonoValidator;
	
	@Inject
	private TelefonoController(TelefonoForm view,
                                  TipoTelefonoComboBoxModel comboModel,
                                  MessageShow msgShw) {
		
		this.view = view;
		this.comboModel = comboModel;
		this.msgShw = msgShw;
		currentTelefono = null;

		fillCombos();
		
		this.binder = new Binder<>();
		binder.bind("numero", view.getTextTelefono()::getText, s -> view.getTextTelefono().setText(s.toString()));
		binder.bind("tipo", comboModel::getSelected, t -> comboModel.setSelected((Telefono.Tipo)t));
		binder.bind("notas", view.getTextDescr()::getText, s -> view.getTextDescr().setText(s.toString()));
		
		view.getBtnOk().addActionListener(e -> aceptar());
		view.getBtnCancelar().addActionListener(e -> cancelar());

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
		if(telefonoValidator.isValid()){
			binder.fillBean();
			view.setVisible(false);
		}
		else{
			msgShw.showErrorMessage(telefonoValidator.getErrorMessage(), "Error");
		}
	}
	
	private void cancelar() {
		currentTelefono = null;
		view.setVisible(false);
	}
	
}
