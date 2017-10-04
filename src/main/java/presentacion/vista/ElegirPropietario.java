package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ElegirPropietario extends JDialog {
	private JTable table;
	
	private ElegirPropietario() {
		super();
		
		setTitle("ElegirPropietario");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(506, 397));
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		JButton btnAceptar = new JButton("Aceptar");
		panelBotones.add(btnAceptar);
	}

}
