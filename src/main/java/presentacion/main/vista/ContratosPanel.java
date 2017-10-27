package presentacion.main.vista;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Rol;
import model.permisos.PermissableField;
import model.permisos.PermissionView;

@SuppressWarnings("serial")
@Singleton
public class ContratosPanel extends JPanel implements PermissionView{
	

	private JTabbedPane tabs;
	
	@PermissableField(roles = {Rol.EMPLEADO, Rol.ADMINISTRADOR})
	private ContratosAlquilerTab contratoAlquiler;

	@Inject
	private ContratosPanel(ContratosAlquilerTab contratoAlquiler,
			ContratosVentaTab contratoVenta) {
		
		this.setLayout(new CardLayout(0, 0));
		tabs = new JTabbedPane(JTabbedPane.TOP);
	    this.add(tabs, "name_1165565257819909");
	    
	    this.contratoAlquiler = contratoAlquiler;
	     
        tabs.addTab("Contratos de alquiler", null, this.contratoAlquiler, null);

        tabs.addTab("Contratos de venta", null, contratoVenta, null);
        
        contratoAlquiler.setVisible(false);
       
        
	        
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

	@Override
	public void ocultarComponente(Object o) {
		
		JComponent component = (JComponent) o;
		
		component.setVisible(false);
		
		tabs.remove(component);
		
	}

}
