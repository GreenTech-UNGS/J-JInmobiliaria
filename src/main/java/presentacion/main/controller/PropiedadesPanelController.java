package presentacion.main.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.joda.time.DateTime;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.EstadoProp;
import entities.HistoriaEstadoProp;
import entities.Propiedad;
import entities.Reserva;
import model.PropiedadService;
import model.ReservaService;
import presentacion.controller.PropiedadController;
import presentacion.controller.ReservarPropiedadController;
import presentacion.main.vista.PropiedadesPanel;
import presentacion.table.PropiedadesTableModel;
import presentacion.table.ReservaTableModel;

@Singleton
public class PropiedadesPanelController {

	private PropiedadesPanel view;
	
	@Inject private PropiedadController propiedadController;
	@Inject private ReservarPropiedadController reservaController;
	
	@Inject private PropiedadService propiedadService;
	@Inject private ReservaService reservaService;
	
	@Inject private PropiedadesTableModel tableModelProp;
	@Inject private ReservaTableModel reservaTable;
	@Inject private PropiedadesTableModel tableEnAlquiler;
	@Inject private PropiedadesTableModel tableEnVenta;
	@Inject private PropiedadesTableModel tableAlquiladas;
	@Inject private PropiedadesTableModel tableVendidas;
	
	@Inject
	PropiedadesPanelController(PropiedadesPanel view) {

		this.view = view;
		
		this.view.getBtnAgregarPropiedad().addActionListener(e -> agregarPropiedad());
		this.view.getBtnReservarPropiedad().addActionListener(e -> agregarReserva());
		this.view.getBtnDesreservar().addActionListener(e -> borrarReserva());
		this.view.getBtnEditarPropiedad().addActionListener(e -> editarPropiedad());
	
	
		selectDetalleProp();
	}
		
	private void agregarPropiedad(){
		this.propiedadController.setModeNew();
		this.propiedadController.showView();
		fillAllTables();
	}
	
	private void fillAllTables() {
		fillTableProp();
		fillTableReservas();
		fillTableEnAlquiler();
		fillTableEnVenta();
		fillTableAlquiladas();
		fillTableVendidas();
	}
	
	private void agregarReserva(){
			this.reservaController.setModeNew();
			this.reservaController.showView();
			this.fillTableProp();
			this.fillTableReservas();
		}

	private void borrarReserva(){
		if(this.view.getTablaReservas().getSelectedRow()!=-1){
			Reserva seleccion = reservaTable.getRow(this.view.getTablaReservas().getSelectedRow());
			
			
			HistoriaEstadoProp estado = new HistoriaEstadoProp();
    		estado.setEstado(EstadoProp.DISPONIBLE);
    		estado.setFecha(DateTime.now());
    		
    		Propiedad propiedad = seleccion.getPropiedad();
    		
    		propiedad.getEstados().add(estado);
    		propiedadService.actualizarPropiedad(propiedad);
    		
    		reservaService.remove(seleccion);
    		
			fillTableReservas();
			fillTableProp();
		}
	}	
	
	private void editarPropiedad() {
		int select = this.view.getTablePropiedades().getSelectedRow();

		if (select!=-1){
			propiedadController.editPropiedad(this.tableModelProp.getRow(select));
			propiedadController.showView();
			this.fillTableProp();
		}
	}	
	
	private void viewPropiedad(){
		Propiedad seleccionada;
		int propRow = view.getTablePropiedades().getSelectedRow();
		boolean isPropSelected =  propRow >= 0;
		if (isPropSelected) {
			seleccionada = tableModelProp.getRow(propRow);
			this.propiedadController.setModeView(seleccionada);
			this.propiedadController.setEnabled(false);
			this.propiedadController.showView();
			this.propiedadController.setEnabled(true);
		}
	}
	
	private void selectDetalleProp(){
		this.view.getTablePropiedades().addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				if (me.getClickCount() ==2){
					int selected = view.getTablePropiedades().getSelectedRow();
					if(selected == -1) return;
					viewPropiedad();
				}
			}
		});
	}
	
	private void fillTableProp(){
		this.tableModelProp.clean();
		this.view.getTablePropiedades().setModel(tableModelProp);
		propiedadService.getAll().forEach(p -> tableModelProp.addRow(p));
		this.view.getTablePropiedades().setColumnModel(tableModelProp.getTableColumnModel());
		this.view.getTablePropiedades().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableEnAlquiler(){
		this.tableEnAlquiler.clean();
		this.view.getTableEnAlquiler().setModel(tableEnAlquiler);
		
		propiedadService.getEnAlquiler().forEach(e -> tableEnAlquiler.addRow(e));
		this.view.getTableEnAlquiler().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableEnVenta(){
		this.tableEnVenta.clean();
		this.view.getTableEnVenta().setModel(tableEnVenta);
		
		propiedadService.getEnVenta().forEach(e -> tableEnVenta.addRow(e));
		this.view.getTableEnVenta().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableAlquiladas(){
		this.tableAlquiladas.clean();
		this.view.getTableAlquiladas().setModel(tableAlquiladas);
		
		propiedadService.getAlquiladas().forEach(e -> tableAlquiladas.addRow(e));
		this.view.getTableAlquiladas().getTableHeader().setReorderingAllowed(false);
	}
	
	private void fillTableVendidas(){
		this.tableVendidas.clean();
		this.view.getTableVendidas().setModel(tableVendidas);
		
		propiedadService.getVendidas().forEach(e -> tableVendidas.addRow(e));
		this.view.getTableVendidas().getTableHeader().setReorderingAllowed(false);
	}
	
	
	private void fillTableReservas() {
		this.reservaTable.clean();
		this.view.getTablaReservas().setModel(reservaTable);
		reservaTable.actualizeRows(reservaService.getAll());
		
		this.view.getTablaReservas().setColumnModel(reservaTable.getTableColumnModel());
		this.view.getTablaReservas().getTableHeader().setReorderingAllowed(false);	
	}

	public void hideView() {
		
		this.view.setVisible(false);
		
	}

	public void showView() {
		
		this.view.setVisible(true);
		
	}

	public void actualize() {
		fillAllTables();
		
	}
}	
