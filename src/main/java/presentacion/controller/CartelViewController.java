package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dto.CartelDTO;
import model.CartelService;
import presentacion.reportes.ReporteCarteles;
import presentacion.table.CartelesTableModel;
import presentacion.vista.CartelView;

import javax.swing.*;
import java.util.List;

@Singleton
public class CartelViewController {

	private CartelView view;
	
	@Inject CartelService cartelService;
	@Inject CartelController cartelcontroller;
	@Inject CartelService cartelServiceReport;

	private CartelesTableModel tableModel;
	
	@Inject
	private CartelViewController(CartelView view) {
		this.view = view;
		this.view.getBtnAgregar().addActionListener(e -> agregarCartel());
		
		this.tableModel = new CartelesTableModel();
			
		view.getTable().setModel(tableModel);
		view.getTable().getTableHeader().setReorderingAllowed(false);
		view.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	private void agregarCartel() {
		cartelcontroller.setModeNew();
		cartelcontroller.showView();
		fillTables();
		
	}

	public void showView() {
		fillTables();
		
		this.view.setVisible(true);
	
	}
	
	private void fillTables() {
		this.tableModel.clean();
		this.tableModel.actualizeRows(cartelService.getAll());
	}

	private void generaReporteCartel() {
		List<CartelDTO> dtos = cartelServiceReport.fichaPropiedadReporteOf(cartelService.getAll());
		ReporteCarteles reporte = new ReporteCarteles(dtos);
		reporte.mostrar();
	}

}
