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
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

@Singleton
public class CartelView extends JDialog{
	private JButton btnAgregar;
	private JTable table;
	
	@Inject
	private CartelView() {
		
		setLocationRelativeTo(null);
		setSize(400, 300);
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panelTabla = new JPanel();
		getContentPane().add(panelTabla);
		panelTabla.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 394, 248);
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
