package presentacion.main.vista;

import java.awt.CardLayout;
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

@SuppressWarnings("serial")
@Singleton
public class ContratosPanel extends JPanel{
	
	private JTable tablaContratoVenta;
	private JButton btnAgregarContratoVen;
	private JTable tablaContratoAlquiler;
	private JButton btnAgregarContratoAlq;
	private JButton btnRenovar;
	private JButton btnCancelarContrato;
	private JButton btnEditarContrato;
	private JPanel panelFiltroAlq;
	private JButton btnAplicarFiltro;
	private JButton btnRemoverFiltro;

	@Inject
	private ContratosPanel() {
		this.setLayout(new CardLayout(0, 0));
		JTabbedPane PanelTablas = new JTabbedPane(JTabbedPane.TOP);
	    this.add(PanelTablas, "name_1165565257819909");
	     
	    JPanel contratoAlquiler = new JPanel();
        PanelTablas.addTab("Contratos de alquiler", null, contratoAlquiler, null);

        JPanel contratoVenta = new JPanel();
        PanelTablas.addTab("Contratos de venta", null, contratoVenta, null);
        contratoVenta.setLayout(new BoxLayout(contratoVenta, BoxLayout.Y_AXIS));
        
        tablaContratoVenta = new JTable();
        JScrollPane scrollPane_5 = new JScrollPane(tablaContratoVenta);
        contratoVenta.add(scrollPane_5);

        this.btnAgregarContratoVen = new JButton("Agregar contrato de venta");
        btnAgregarContratoVen.setAlignmentX(Component.CENTER_ALIGNMENT);
        contratoVenta.add(btnAgregarContratoVen);
        contratoAlquiler.setLayout(new BoxLayout(contratoAlquiler, BoxLayout.Y_AXIS));
        
        panelFiltroAlq = new JPanel();
        contratoAlquiler.add(panelFiltroAlq);
        panelFiltroAlq.setLayout(new BoxLayout(panelFiltroAlq, BoxLayout.X_AXIS));
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panelFiltroAlq.add(horizontalGlue);
        
        btnAplicarFiltro = new JButton("Aplicar Filtro");
        panelFiltroAlq.add(btnAplicarFiltro);
        
        btnRemoverFiltro = new JButton("Remover Filtro");
        panelFiltroAlq.add(btnRemoverFiltro);
        
        tablaContratoAlquiler = new JTable();
        JScrollPane scrollPane_4 = new JScrollPane(tablaContratoAlquiler);
        contratoAlquiler.add(scrollPane_4);
                
        JPanel panel_2 = new JPanel();
        contratoAlquiler.add(panel_2);

        btnAgregarContratoAlq = new JButton("Agregar contrato");
        panel_2.add(btnAgregarContratoAlq);
        btnAgregarContratoAlq.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnRenovar = new JButton("Renovar contrato");
        panel_2.add(btnRenovar);
        
        btnCancelarContrato = new JButton("Cancelar contrato");
        panel_2.add(btnCancelarContrato);
        btnEditarContrato = new JButton("Editar contrato");
        panel_2.add(btnEditarContrato);
	        
	}

	public JTable getTablaContratoVenta() {
		return tablaContratoVenta;
	}

	public JButton getBtnAgregarContratoVen() {
		return btnAgregarContratoVen;
	}

	public JTable getTablaContratoAlquiler() {
		return tablaContratoAlquiler;
	}

	public JButton getBtnAgregarContratoAlq() {
		return btnAgregarContratoAlq;
	}

	public JButton getBtnRenovar() {
		return btnRenovar;
	}

	public JButton getBtnCancelarContrato() {
		return btnCancelarContrato;
	}

	public JButton getBtnEditarContrato() {
		return btnEditarContrato;
	}

	public JButton getBtnAplicarFiltro() {
		return btnAplicarFiltro;
	}

	public JButton getBtnRemoverFiltro() {
		return btnRemoverFiltro;
	}

}
