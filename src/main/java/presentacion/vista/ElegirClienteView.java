package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

import com.google.inject.Inject;
import java.awt.Component;
import javax.swing.Box;

@SuppressWarnings("serial")
public class ElegirClienteView extends JDialog {
	private JTable table;
	private JButton btnAceptar;
	private JButton btnAgregarOtro;
	
	@Inject
	private ElegirClienteView() {
		super();
		
		setTitle("Elegir Cliente");
		
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
		
		btnAgregarOtro = new JButton("Agregar otro");
		panelBotones.add(btnAgregarOtro);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_1);
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

	public JButton getBtnAgregarOtro() {
		return btnAgregarOtro;
	}
	
	
	
	

}
