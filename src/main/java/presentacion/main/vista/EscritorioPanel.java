package presentacion.main.vista;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
@Singleton
public class EscritorioPanel extends JPanel{
	private JTable tableMisCitas;
	private JTable tableContratos;
	private JTable tableCuotasMes;
	private JTable tableCuotasVencidas;

	@Inject
	public EscritorioPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.add(tabbedPane);
		
		JPanel panelMisCitas = new JPanel();
		tabbedPane.addTab("Mis citas", null, panelMisCitas, null);
		panelMisCitas.setLayout(new BoxLayout(panelMisCitas, BoxLayout.Y_AXIS));
		
		tableMisCitas = new JTable();
//		scrollPane.setColumnHeaderView(tableMisCitas);
		
		JScrollPane scrollPane = new JScrollPane(tableMisCitas);
		panelMisCitas.add(scrollPane);
	
		
		JPanel panelBotonesCitas = new JPanel();
		//panelMisCitas.add(panelBotonesCitas);
		
		JButton btnHolo = new JButton("Holo");
		panelBotonesCitas.add(btnHolo);
		
		JPanel panelCuotas = new JPanel();
		tabbedPane.addTab("Cuotas del mes", null, panelCuotas, null);
		panelCuotas.setLayout(new BoxLayout(panelCuotas, BoxLayout.Y_AXIS));
		
		tableCuotasMes = new JTable();
//		scrollPane_2.setColumnHeaderView(tableCuotasMes);
		
		JScrollPane scrollPane_2 = new JScrollPane(tableCuotasMes);
		panelCuotas.add(scrollPane_2);
		
		
		JPanel panelCuotasVencidas = new JPanel();
		tabbedPane.addTab("Cuotas vencidas", null, panelCuotasVencidas, null);
		panelCuotasVencidas.setLayout(new BoxLayout(panelCuotasVencidas, BoxLayout.Y_AXIS));
		
		tableCuotasVencidas = new JTable();
//		scrollPane_3.setColumnHeaderView(tableCuotasVencidas);
		
		JScrollPane scrollPane_3 = new JScrollPane(tableCuotasVencidas);
		panelCuotasVencidas.add(scrollPane_3);
		
		JPanel panelContratos = new JPanel();
		tabbedPane.addTab("Contratos a vencer", null, panelContratos, null);
		panelContratos.setLayout(new BoxLayout(panelContratos, BoxLayout.Y_AXIS));
		
		tableContratos = new JTable();
//		scrollPane_1.setColumnHeaderView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane(tableContratos);
		panelContratos.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panelContratos.add(panel);
	}

	public JTable getTableMisCitas() {
		return tableMisCitas;
	}

	public JTable getTableContratos() {
		return tableContratos;
	}

	public JTable getTableCuotasMes() {
		return tableCuotasMes;
	}

	public JTable getTableCuotasVencidas() {
		return tableCuotasVencidas;
	}
	
	
	
}