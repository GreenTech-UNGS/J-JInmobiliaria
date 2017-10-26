package presentacion.main.vista;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ContratosAlquilerTab extends JPanel{

	private JButton btnAplicarFiltro;
	private JButton btnRemoverFiltro;
	private JTable tablaContratoAlquiler;
	private JButton btnAgregarContratoAlq;
	private JButton btnRenovar;
	private JButton btnCancelarContrato;
	private JButton btnEditarContrato;

	@Inject
	private ContratosAlquilerTab() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel panelFiltroAlq = new JPanel();
        this.add(panelFiltroAlq);
        panelFiltroAlq.setLayout(new BoxLayout(panelFiltroAlq, BoxLayout.X_AXIS));
        
        Component horizontalGlue = Box.createHorizontalGlue();
        panelFiltroAlq.add(horizontalGlue);
        
        btnAplicarFiltro = new JButton("Aplicar Filtro");
        panelFiltroAlq.add(btnAplicarFiltro);
        
        btnRemoverFiltro = new JButton("Remover Filtro");
        panelFiltroAlq.add(btnRemoverFiltro);
        
        tablaContratoAlquiler = new JTable();
        JScrollPane scrollPane_4 = new JScrollPane(tablaContratoAlquiler);
        this.add(scrollPane_4);
                
        JPanel panel_2 = new JPanel();
        this.add(panel_2);
        
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

	public JButton getBtnAplicarFiltro() {
		return btnAplicarFiltro;
	}

	public JButton getBtnRemoverFiltro() {
		return btnRemoverFiltro;
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


	
}
