package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Propietario;
import model.ClienteService;
import model.PropietarioService;
import presentacion.table.ClientesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.ElegirCliente;
import presentacion.vista.ElegirPropietario;

public class ElegirClienteController {
	
	private ElegirCliente view;
	private ClienteService clienteServcie;
	private ClientesTableModel tableModelCliente;
	
	@Inject
	private ElegirClienteController(ElegirCliente view,
			ClienteService clienteServcie){
		
		this.view = view;
		this.clienteServcie = clienteServcie;
		this.tableModelCliente = new ClientesTableModel();
		fillTableProp();
		
	}
	private void fillTableProp() {
		
		this.view.getTable().setModel(tableModelCliente);
		this.view.getTable().setColumnModel(tableModelCliente.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelCliente.clean();
		tableModelCliente.actualizeRows(clienteServcie.getAll());
		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
	}
	public void showView(){
		
		view.setVisible(true);
	}
	
	public Cliente getCliente(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return tableModelCliente.getRow(selected);
	}

}
