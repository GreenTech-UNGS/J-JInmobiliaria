package presentacion.vista;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@SuppressWarnings("serial")
@Singleton
public class ElegirAsistenteView extends JDialog{
	private JTable tablePersonas;
	private JButton btnSeleccionar;
	private JButton btnNuevo;
	
	@Inject
	private ElegirAsistenteView() {
		setTitle("Buscar Asistente");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setModal(true);
		
		setMinimumSize(new Dimension(450, 300));
		setResizable(false);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		tablePersonas = new JTable();
		scrollPane.setViewportView(tablePersonas);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		btnSeleccionar = new JButton("Seleccionar");
		panel.add(btnSeleccionar);
		
		btnNuevo = new JButton("Crear Nuevo");
		panel.add(btnNuevo);
	}
	public JTable getTablePersonas() {
		return tablePersonas;
	}
	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}
	public JButton getBtnNuevo() {
		return btnNuevo;
	}
	
	

}
