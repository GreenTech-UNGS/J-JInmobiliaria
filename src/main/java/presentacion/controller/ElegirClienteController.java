package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Cliente;
import model.ClienteService;
import presentacion.table.ClientesTableModel;
import presentacion.vista.ElegirClienteView;

public class ElegirClienteController {
	
	private ElegirClienteView view;
	private ClienteService clienteServcie;
	private ClientesTableModel tableModelCliente;
	
	@Inject
	private ElegirClienteController(ElegirClienteView view,
			ClienteService clienteServcie){
		
		this.view = view;
		this.clienteServcie = clienteServcie;
		this.tableModelCliente = new ClientesTableModel();
		fillTableCliente();
		
	}

	private void fillTableCliente() {
		
		this.view.getTable().setModel(tableModelCliente);
		this.view.getTable().setColumnModel(tableModelCliente.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelCliente.clean();
		tableModelCliente.actualizeRows(clienteServcie.getAll());
		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
	}

	public void showView(){
		fillTableCliente();
		view.setVisible(true);
	}
	
	public Cliente getCliente(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return tableModelCliente.getRow(selected);
	}

}
