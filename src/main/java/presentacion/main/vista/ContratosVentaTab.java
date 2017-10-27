package presentacion.main.vista;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import model.permisos.PermissionView;

@Singleton
public class ContratosVentaTab extends JPanel{
	
	private JTable tablaContratoVenta;
	private JButton btnAgregarContratoVen;

	@Inject
	private ContratosVentaTab() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	        
        tablaContratoVenta = new JTable();
        JScrollPane scrollPane_5 = new JScrollPane(tablaContratoVenta);
        this.add(scrollPane_5);

        this.btnAgregarContratoVen = new JButton("Agregar contrato de venta");
        btnAgregarContratoVen.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(btnAgregarContratoVen);
	}

	public JTable getTablaContratoVenta() {
		return tablaContratoVenta;
	}

	public JButton getBtnAgregarContratoVen() {
		return btnAgregarContratoVen;
	}

}
