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
		binder.bind("persona.tipoCred",
				tipoCredencialModel::getSelected,
				t -> tipoCredencialModel.setSelected((TipoCredencial)t));
		
		fillCombos();
		
	}
	
	public void setModeNew() {
		currentCliente = clienteService.getEmptyCliente();
		binder.setObjective(currentCliente);
	}
	
	private void fillCombos() {
		tipoCredencialModel.agregaElemento(TipoCredencial.DNI);
		tipoCredencialModel.agregaElemento(TipoCredencial.CUIT);
		tipoCredencialModel.setSelected(TipoCredencial.DNI);
		view.getComboCredencial().setModel(tipoCredencialModel);
	}
	
	private void saveCurrentCliente() {
		binder.fillBean();
		System.out.println(currentCliente.getPersona().getTipoCred());
		System.out.println(tipoCredencialModel.getSelected());
		clienteService.saveCliente(currentCliente);
	}
	
	public void showView(){
			
			view.setVisible(true);
	}
	
	

}
