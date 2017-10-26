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
	

	private JTabbedPane tabs;

	@Inject
	private ContratosPanel(ContratosAlquilerTab contratoAlquiler,
			ContratosVentaTab contratoVenta) {
		
		this.setLayout(new CardLayout(0, 0));
		tabs = new JTabbedPane(JTabbedPane.TOP);
	    this.add(tabs, "name_1165565257819909");
	     
        tabs.addTab("Contratos de alquiler", null, contratoAlquiler, null);

        tabs.addTab("Contratos de venta", null, contratoVenta, null);
       
        
	        
	}

	public JTabbedPane getTabs() {
		return tabs;
	}

}
