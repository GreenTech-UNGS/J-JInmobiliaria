package presentacion.main.vista;

import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;

@Singleton
public class CitasPanel extends JPanel{
	private JTable table;
	private JButton btnNueva;
	private JButton btnCancelarCita;

	@Inject
	private CitasPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel todasLasCitas = new JPanel();
		tabbedPane.addTab("Todas", null, todasLasCitas, null);
		todasLasCitas.setLayout(new BoxLayout(todasLasCitas, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		todasLasCitas.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelButtons = new JPanel();
		todasLasCitas.add(panelButtons);
		panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelButtons.add(horizontalGlue);
		
		btnNueva = new JButton("Crear cita");
		panelButtons.add(btnNueva);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panelButtons.add(horizontalGlue_2);
		
		btnCancelarCita = new JButton("Cancelar Cita");
		panelButtons.add(btnCancelarCita);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelButtons.add(horizontalGlue_1);
		
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnNueva() {
		return btnNueva;
	}

	public JButton getBtnCancelarCita() {
		return btnCancelarCita;
	}
	
}
