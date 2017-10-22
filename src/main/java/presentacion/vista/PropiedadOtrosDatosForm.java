package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;

@Singleton
public class PropiedadOtrosDatosForm extends JDialog{
	private JTable table;

	@Inject
	private PropiedadOtrosDatosForm() {
		setLayout(null);
		setModal(true);
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(27, 92, 46, 14);
		add(lblTipo);
		
		JLabel lblAmbientes = new JLabel("Ambientes: ");
		lblAmbientes.setBounds(27, 142, 65, 14);
		add(lblAmbientes);
		
		JLabel lblMcubiertos = new JLabel("M\u00B2 cubiertos: ");
		lblMcubiertos.setBounds(272, 139, 78, 14);
		add(lblMcubiertos);
		
		JLabel lblMLote = new JLabel("M\u00B2 Lote: ");
		lblMLote.setBounds(27, 184, 46, 14);
		add(lblMLote);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 264, 430, 2);
		add(separator);
		
		JLabel lblHabitacionesYOtros = new JLabel("Habitaciones y otros");
		lblHabitacionesYOtros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHabitacionesYOtros.setBounds(27, 239, 155, 14);
		add(lblHabitacionesYOtros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 293, 394, 92);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAgergar = new JButton("Agergar");
		btnAgergar.setBounds(37, 396, 89, 23);
		add(btnAgergar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(299, 396, 89, 23);
		add(btnBorrar);
		
		JComboBox comboBoxTipoProp = new JComboBox();
		comboBoxTipoProp.setBounds(64, 89, 102, 20);
		add(comboBoxTipoProp);
		
		JSpinner spinnerAmbientes = new JSpinner();
		spinnerAmbientes.setBounds(97, 139, 46, 20);
		add(spinnerAmbientes);
		
		JSpinner spinnerCubiertos = new JSpinner();
		spinnerCubiertos.setBounds(342, 136, 46, 20);
		add(spinnerCubiertos);
		
		JSpinner spinnerLote = new JSpinner();
		spinnerLote.setBounds(97, 184, 46, 20);
		add(spinnerLote);
		
		JCheckBox chckbxAptoACredito = new JCheckBox("Apto a credito");
		chckbxAptoACredito.setBounds(291, 88, 111, 23);
		add(chckbxAptoACredito);
		
		JLabel lblDatosDeEspacio = new JLabel("Datos de espacio");
		lblDatosDeEspacio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDeEspacio.setBounds(27, 32, 129, 14);
		add(lblDatosDeEspacio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 430, 2);
		add(separator_1);
		
	}
}
