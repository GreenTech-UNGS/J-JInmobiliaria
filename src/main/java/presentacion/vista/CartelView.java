package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@Singleton
public class CartelView extends JDialog{
	private JTable table;
	private JButton btnAgregar;
	
	@Inject
	private CartelView() {
		
		setLocationRelativeTo(null);
		setSize(400, 300);
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelTabla = new JPanel();
		getContentPane().add(panelTabla);
		panelTabla.setLayout(new BoxLayout(panelTabla, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_1);
		
		btnAgregar = new JButton("Agregar");
		panelBotones.add(btnAgregar);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue);
		
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

}
