package presentacion.main.vista;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Rol;
import model.permisos.PermissableField;
import model.permisos.PermissionView;
import presentacion.table.MovimientosCajaTableModel;

@Singleton
public class PagosPanel extends JPanel implements PermissionView{
	
	private JButton btnRegistrarCobro;
	private JTable tableCuotas;
	private JButton btnGenerarReporteCobros;
	private JTable tablePagosPropietarios;
	private JButton btnRegistrarPago;
	private JButton btnGenerarReportePropietarios;
	private JTable tableMovimientosCaja;
	private JButton btnRegistrarIngreso;
	private JButton btnRegistrarEgreso;
    private JButton btnGenerarReporteMovimientos;

	private MovimientosCajaTableModel tableMovimientosModel;
	private JButton btnAplicarFiltroAlq;
	private JButton btnRemoverFiltroAlq;
	
	@PermissableField(roles = { Rol.ADMINISTRADOR })
	private JPanel panelMovimientosDeCaja;
	private JTabbedPane tabbedPane;

	@Inject
	private PagosPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    this.add(tabbedPane);

        JPanel panelPagoAlq = new JPanel();
        tabbedPane.addTab("Cobro de alquileres", null, panelPagoAlq, null);
        panelPagoAlq.setLayout(new BoxLayout(panelPagoAlq, BoxLayout.Y_AXIS));
        
        JPanel panelFiltrosAlq = new JPanel();
        panelPagoAlq.add(panelFiltrosAlq);
        panelFiltrosAlq.setLayout(new BoxLayout(panelFiltrosAlq, BoxLayout.X_AXIS));
        
        Component horizontalGlue_4 = Box.createHorizontalGlue();
        panelFiltrosAlq.add(horizontalGlue_4);
        
        btnAplicarFiltroAlq = new JButton("Aplicar Filtro");
        panelFiltrosAlq.add(btnAplicarFiltroAlq);
        
        btnRemoverFiltroAlq = new JButton("Remover Filtro");
        panelFiltrosAlq.add(btnRemoverFiltroAlq);
        
        tableCuotas = new JTable();
        
        JScrollPane scrollPane_3 = new JScrollPane(tableCuotas);
        panelPagoAlq.add(scrollPane_3);
        
        JPanel botonesAlquiler = new JPanel();
        panelPagoAlq.add(botonesAlquiler);
        botonesAlquiler.setLayout(new BoxLayout(botonesAlquiler, BoxLayout.X_AXIS));
        
        Component horizontalGlue_5 = Box.createHorizontalGlue();
        botonesAlquiler.add(horizontalGlue_5);
        
        btnRegistrarCobro = new JButton("Registrar Cobro");
        botonesAlquiler.add(btnRegistrarCobro);
        
        Component horizontalGlue_2 = Box.createHorizontalGlue();
        botonesAlquiler.add(horizontalGlue_2);
        
        btnGenerarReporteCobros = new JButton("Generar Reporte");
        botonesAlquiler.add(btnGenerarReporteCobros);
        
        Component horizontalGlue_6 = Box.createHorizontalGlue();
        botonesAlquiler.add(horizontalGlue_6);

        JPanel panelPagoProp = new JPanel();
        tabbedPane.addTab("Pagos a propietarios", null, panelPagoProp, null);
        panelPagoProp.setLayout(new BoxLayout(panelPagoProp, BoxLayout.Y_AXIS));
	    
        tablePagosPropietarios = new JTable();
        
        JScrollPane scrollPane_7 = new JScrollPane(tablePagosPropietarios);
        panelPagoProp.add(scrollPane_7);
        
        JPanel bontones = new JPanel();
        panelPagoProp.add(bontones);
        bontones.setLayout(new BoxLayout(bontones, BoxLayout.X_AXIS));
        
        Component glue = Box.createGlue();
        bontones.add(glue);
        
        btnRegistrarPago = new JButton("Registrar Pago");
        bontones.add(btnRegistrarPago);
        
        Component glue_1 = Box.createGlue();
        bontones.add(glue_1);
        
        btnGenerarReportePropietarios = new JButton("Generar Reporte");
        bontones.add(btnGenerarReportePropietarios);
        
        Component glue_2 = Box.createGlue();
        bontones.add(glue_2);
        
        panelMovimientosDeCaja = new JPanel();
        tabbedPane.addTab("Movimientos de caja", null, panelMovimientosDeCaja, null);
        panelMovimientosDeCaja.setLayout(new BoxLayout(panelMovimientosDeCaja, BoxLayout.Y_AXIS));
                
        JScrollPane scrollPane = new JScrollPane();
        panelMovimientosDeCaja.add(scrollPane);
        
        tableMovimientosCaja = new JTable();
        scrollPane.setViewportView(tableMovimientosCaja);
        
        JPanel panelMovimientosButtons = new JPanel();
        panelMovimientosDeCaja.add(panelMovimientosButtons);
        panelMovimientosButtons.setLayout(new BoxLayout(panelMovimientosButtons, BoxLayout.X_AXIS));
        
        Component horizontalGlue_3 = Box.createHorizontalGlue();
        panelMovimientosButtons.add(horizontalGlue_3);
        
        btnRegistrarIngreso = new JButton("Registrar ingreso");
        panelMovimientosButtons.add(btnRegistrarIngreso);
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panelMovimientosButtons.add(horizontalGlue);
        
        btnRegistrarEgreso = new JButton("Registrar egreso");
        panelMovimientosButtons.add(btnRegistrarEgreso);

        Component horizontalGlueRep = Box.createHorizontalGlue();
        panelMovimientosButtons.add(horizontalGlueRep);

        btnGenerarReporteMovimientos = new JButton("Reporte Movimientos");
        panelMovimientosButtons.add(btnGenerarReporteMovimientos);

        Component horizontalGlue_1 = Box.createHorizontalGlue();
        panelMovimientosButtons.add(horizontalGlue_1);
        
        tableMovimientosModel = new MovimientosCajaTableModel();
        tableMovimientosCaja.setModel(tableMovimientosModel);

        
	}

	public JButton getBtnRegistrarCobro() {
		return btnRegistrarCobro;
	}

	public JTable getTableCuotas() {
		return tableCuotas;
	}

	public JButton getBtnGenerarReporteCobros() {
		return btnGenerarReporteCobros;
	}

	public JTable getTablePagosPropietarios() {
		return tablePagosPropietarios;
	}

	public JButton getBtnRegistrarPago() {
		return btnRegistrarPago;
	}

	public JButton getBtnGenerarReportePropietarios() {
		return btnGenerarReportePropietarios;
	}

    public JButton getBtnGenerarReporteMovimientos() {
        return btnGenerarReporteMovimientos;
    }

	public JTable getTableMovimientosCaja() {
		return tableMovimientosCaja;
	}

	public JButton getBtnRegistrarIngreso() {
		return btnRegistrarIngreso;
	}

	public JButton getBtnRegistrarEgreso() {
		return btnRegistrarEgreso;
	}

	public MovimientosCajaTableModel getTableMovimientosModel() {
		return tableMovimientosModel;
	}

	public JButton getBtnAplicarFiltroAlq() {
		return btnAplicarFiltroAlq;
	}

	public JButton getBtnRemoverFiltroAlq() {
		return btnRemoverFiltroAlq;
	}

	@Override
	public void ocultarComponente(Object o) {
		Component componente = (Component) o; 
		
		tabbedPane.remove(componente);
		componente.setVisible(false);
	}

}
