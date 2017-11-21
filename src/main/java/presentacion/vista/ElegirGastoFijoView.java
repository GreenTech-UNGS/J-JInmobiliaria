package presentacion.vista;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;

public class ElegirGastoFijoView extends JDialog{
	
	private JTable table;
	private JButton btnAceptar;
	
	@Inject
	private ElegirGastoFijoView() {
		super();
		
		setTitle("Elegir Gasto Fijo");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(490, 400));
		setResizable(false);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setLocationRelativeTo(null);
		
		table = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(table);
		getContentPane().add(scrollPane);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue);
		
		btnAceptar = new JButton("Aceptar");
		panelBotones.add(btnAceptar);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_2);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

}
