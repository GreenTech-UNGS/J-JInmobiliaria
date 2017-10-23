package presentacion.vista;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;

@SuppressWarnings("serial")
public class HistorialPropiedadView extends JDialog {
	private JTable table;
	private JButton btnAceptar;
	
	@Inject
	private HistorialPropiedadView(){
		
		super();
		setTitle("Historial de propiedad");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(450, 420));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		table.getTableHeader().setReorderingAllowed(false);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
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
