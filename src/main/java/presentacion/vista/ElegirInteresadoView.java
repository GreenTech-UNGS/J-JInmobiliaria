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

@SuppressWarnings("serial")
public class ElegirInteresadoView extends JDialog{
	private JTable table;
	private JButton btnAceptar;
	private JButton btnAgregarOtro;
	
	@Inject
	private ElegirInteresadoView() {
		super();
		
		setTitle("Elegir Interesado");
		
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
		
		Component glue_2 = Box.createGlue();
		panelBotones.add(glue_2);
		
		btnAceptar = new JButton("Aceptar");
		panelBotones.add(btnAceptar);
		
		Component glue = Box.createGlue();
		panelBotones.add(glue);
		
		btnAgregarOtro = new JButton("Agregar otro");
		panelBotones.add(btnAgregarOtro);
		
		Component glue_1 = Box.createGlue();
		panelBotones.add(glue_1);
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

	public void setBtnAgregarOtro(JButton btnAgregarOtro) {
		this.btnAgregarOtro = btnAgregarOtro;
	}
}
