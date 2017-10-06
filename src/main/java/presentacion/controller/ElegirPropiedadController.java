package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Propiedad;
import entities.Propietario;
import model.ClienteService;
import model.PropiedadService;
import model.PropietarioService;
import presentacion.table.ClientesTableModel;
import presentacion.table.PropiedadesTableModel;
import presentacion.table.PropietariosTableModel;
import presentacion.vista.ElegirCliente;
import presentacion.vista.ElegirPropiedadView;
import presentacion.vista.ElegirPropietario;

public class ElegirPropiedadController {
	
	private ElegirPropiedadView view;
	private PropiedadService propiedadService;
	private PropiedadesTableModel tableModelPropiedad;
	
	@Inject
	private ElegirPropiedadController(ElegirPropiedadView view,
			PropiedadService clienteServcie,
			PropiedadesTableModel tableModelPropiedad){
		
		this.view = view;
		this.propiedadService = clienteServcie;
		this.tableModelPropiedad = tableModelPropiedad;
		this.view.getTable().setModel(tableModelPropiedad);
		this.view.getTable().setColumnModel(tableModelPropiedad.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
		fillTableProp();
		
	}
	private void fillTableProp() {
		
		//TODO: parametrizar
		this.tableModelPropiedad.clean();
		tableModelPropiedad.actualizeRows(propiedadService.getDisponiblesAlquiler());
	}
	public void showView(){
		fillTableProp();
		view.setVisible(true);
	}
	
	public Propiedad getPropiedad(){
		
		int selected = view.getTable().getSelectedRow();
		if(selected == -1) return null;
		
		return tableModelPropiedad.getRow(selected);
	}

}
