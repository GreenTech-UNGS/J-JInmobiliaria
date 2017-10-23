package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.EstadoProp;
import entities.Propiedad;
import model.PropiedadService;
import presentacion.table.PropiedadesTableModel;
import presentacion.vista.ElegirPropiedadView;

public class ElegirPropiedadController {
	
	private ElegirPropiedadView view;
	private PropiedadService propiedadService;
	private PropiedadesTableModel tableModelPropiedad;
	
	@Inject
	private ElegirPropiedadController(ElegirPropiedadView view,
			PropiedadService clienteServcie,
			PropiedadesTableModel tableModelPropiedad, PropiedadesTableModel tableModelPropiedad2){
		
		this.view = view;
		this.propiedadService = clienteServcie;
		this.tableModelPropiedad = tableModelPropiedad;
		this.view.getTable().setModel(tableModelPropiedad);
		this.view.getTable().setColumnModel(tableModelPropiedad.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
		fillTableProp();
		fillTablePropVenta();
		
	}
	
	private void fillTablePropAll() {
		
		this.tableModelPropiedad.clean();
		tableModelPropiedad.actualizeRows(propiedadService.getAlquilerBy(EstadoProp.values()));
	}
	
	private void fillTableProp() {
		
		this.tableModelPropiedad.clean();
		tableModelPropiedad.actualizeRows(propiedadService.getAlquilerBy(EstadoProp.DISPONIBLE));
	}
	
	private void fillTablePropVenta(){
		this.tableModelPropiedad.clean();
		tableModelPropiedad.actualizeRows(propiedadService.getVentaBy(EstadoProp.DISPONIBLE));
	}
	
	public void showViewAll() {

		fillTablePropAll();
		view.setVisible(true);
	}

	public void showViewVenta(){
		fillTablePropVenta();
		view.setVisible(true);
	}

	public void showViewProp(){
		fillTableProp();
		view.setVisible(true);
	}
	
	public Propiedad getPropiedad(){
		
		int selected = view.getTable().getSelectedRow();
		if(selected == -1) return null;
		
		return tableModelPropiedad.getRow(selected);
	}

}
