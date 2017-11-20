package presentacion.controller;

import com.google.inject.Inject;
import entities.Interesado;
import entities.Propiedad;
import model.InteresadoService;
import presentacion.table.InteresadosTableModel;
import presentacion.vista.ElegirInteresadoView;

import javax.swing.*;

public class ElegirInteresadoController{
	
	private ElegirInteresadoView view;
	private InteresadoService interesadoService;
	private InteresadosTableModel tableModelInteresado;


	InteresadoController interesadoController;
	
	@Inject
	private ElegirInteresadoController(ElegirInteresadoView view,
										InteresadoService interesadoService,
										InteresadoController interesadoController){
		
		this.view = view;
		this.interesadoService = interesadoService;
		this.tableModelInteresado = new InteresadosTableModel();
		this.interesadoController = interesadoController;
		fillTableInteresado();
		
		this.view.getBtnAgregarOtro().addActionListener(e -> agregarOtroInteresado());

		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
	}
	private void agregarOtroInteresado() {
		interesadoController.setModeNew();
		interesadoController.showView();
		fillTableInteresado();
	}
	private void fillTableInteresado() {
		
		this.view.getTable().setModel(tableModelInteresado);
		this.view.getTable().setColumnModel(tableModelInteresado.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelInteresado.clean();
		tableModelInteresado.actualizeRows(interesadoService.getAll());
	}
	private void fillTableInteresadoPropiedad(Propiedad propiedad) {
		
		this.view.getTable().setModel(tableModelInteresado);
		this.view.getTable().setColumnModel(tableModelInteresado.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelInteresado.clean();
		tableModelInteresado.actualizeRows(interesadoService.getAllByPropiedad(propiedad));
	}
	public void showView(){
		fillTableInteresado();
		view.setVisible(true);
	}
	
	public void showViewPropiedad(Propiedad propiedad){
		fillTableInteresadoPropiedad(propiedad);
		view.setVisible(true);
	}

	public Interesado getInteresado(){
		
		int selected = view.getTable().getSelectedRow();
		
		if(selected == -1) return null;
		
		return tableModelInteresado.getRow(selected);
	}

}
