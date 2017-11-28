package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Singleton;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
@Singleton
public class CuotasDeContratoView extends JDialog {
	private JTable tableCuotas;
	
	
	public CuotasDeContratoView(){
		
		super();
		setTitle("Cuotas del contrato");
		getContentPane().setLayout(null);
		setModal(true);
		setSize(560, 317);
		setResizable(false);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		tableCuotas = new JTable();
		
		JScrollPane scrollPane = new JScrollPane(tableCuotas);
		getContentPane().add(scrollPane);
	}


	public JTable getTableCuotas() {
		return tableCuotas;
	}
}
