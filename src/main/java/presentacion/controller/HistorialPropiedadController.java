package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;

import entities.Propiedad;
import presentacion.table.HistEstadosPropTableModel;
import presentacion.vista.HistorialPropiedadView;

public class HistorialPropiedadController {
	
	private HistorialPropiedadView view;
	private HistEstadosPropTableModel tableModelHistorial;
	
	@Inject
	public HistorialPropiedadController(HistorialPropiedadView view){
		this.view = view;
		this.tableModelHistorial = new HistEstadosPropTableModel();
	}
	
	private void fillTableHistorial(Propiedad propiedad) {
		view.getTable().setModel(tableModelHistorial);
		this.view.getTable().setColumnModel(tableModelHistorial.getTableColumnModel());
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.tableModelHistorial.clean();
		tableModelHistorial.actualizeRows(propiedad.getEstados());
		view.getBtnAceptar().addActionListener(e -> view.setVisible(false));
	}

	public void showView(Propiedad propiedad){
		
		fillTableHistorial(propiedad);
		view.setVisible(true);
	}

}
