package presentacion.controller;

import java.util.List;
import com.google.inject.Inject;

import entities.Propiedad;
import model.PropiedadService;
import presentacion.table.PropiedadesTableModel;
import presentacion.vista.MainView;

public class MainViewController {
	
	private MainView view;
	
	private PropiedadesTableModel tableModel;
	private List<Propiedad> TablaPropiedades; 
	
	AddPropiedadesController propiedadesController;
	AddContAlqController contratoAlqController;
	AddContVenController contratoVenController;
	AddClienteController clienteController;	
	
	PropiedadService propiedadService;
	
	@Inject
	private MainViewController(MainView view, AddPropiedadesController propiedadesController,
			AddContAlqController contratoAlqController, AddContVenController contratoVenController,
			AddClienteController clienteController,
			PropiedadService propiedadService){
		
		this.view = view;
		this.tableModel = new PropiedadesTableModel();
		this.propiedadesController = propiedadesController;
		this.contratoAlqController = contratoAlqController;
		this.contratoVenController = contratoVenController;
		this.clienteController = clienteController;
		this.propiedadService = propiedadService;
		
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnContratoAlq().addActionListener(e -> agregarContratoAlq());
		this.view.getBtnContratoVen().addActionListener(e -> agregarContratoVen());
		this.view.getBtnAgregarCliente().addActionListener(e -> agregarCliente());
		
		fillTable();
	}


	private void fillTable() {
		
		this.view.getTablePropiedades().setModel(tableModel);
		tableModel.actualizeRows(propiedadService.getAll());
		
		this.view.getTablePropiedades().setColumnModel(tableModel.getTableColumnModel());
		this.view.getTablePropiedades().getTableHeader().setReorderingAllowed(false);
		
	}


	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.propiedadesController.showView();
	}
	
	private void agregarContratoAlq() {
		this.contratoAlqController.showView();
	}
	
	private void agregarContratoVen() {
		this.contratoVenController.showView();
	}
	
	private void agregarCliente() {
		this.clienteController.setModeNew();
		this.clienteController.showView();
	}

}
