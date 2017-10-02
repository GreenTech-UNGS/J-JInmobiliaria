package presentacion.controller;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Persona.TipoCredencial;
import misc.Binder;
import model.ClienteService;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.vista.AgregarCliente;

public class AgregarClienteController {

	private AgregarCliente view;
	
	private ClienteService clienteService;
	
	private TipoCredencialComboBoxModel tipoCredencialModel;
	
	private Cliente currentCliente;
	private Binder<Cliente> binder;
	
	@Inject
	private AgregarClienteController(AgregarCliente view,
			ClienteService clienteService){
		this.view = view;
		this.clienteService = clienteService;
		
		this.tipoCredencialModel = new TipoCredencialComboBoxModel();
		
		view.getBtnGuardar().addActionListener(e -> saveCurrentCliente());
		
		this.binder = new Binder<Cliente>();
		
		binder.bind("persona.nombre", view.getTextNombre());
		binder.bind("persona.apellido", view.getTextApellido());
		binder.bind("persona.credencial", view.getTextCredencial());
		binder.bind("persona.email", view.getTextMail());
		binder.bind("persona.tipoCred", () -> TipoCredencial.valueOf(tipoCredencialModel.getSelected().toString()),
				t -> tipoCredencialModel.setSelected(TipoCredencial.valueOf((String)t)));
		
		fillCombos();
		
	}
	
	public void setModeNew() {
		currentCliente = clienteService.getEmptyCliente();
		binder.setObjective(currentCliente);
	}
	
	private void fillCombos() {
		tipoCredencialModel.addElement(TipoCredencial.DNI.toString());
		tipoCredencialModel.addElement(TipoCredencial.CUIT.toString());
		view.getComboCredencial().setModel(tipoCredencialModel);
	}
	
	private void saveCurrentCliente() {
		binder.fillBean();
		clienteService.saveCliente(currentCliente);
	}
	
	public void showView(){
			
			view.setVisible(true);
	}
	
	

}
