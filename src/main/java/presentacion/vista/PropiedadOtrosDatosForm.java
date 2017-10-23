package presentacion.vista;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.TipoPropiedadComboBoxModel;
import presentacion.table.HabitacionTableModel;

@Singleton
public class PropiedadOtrosDatosForm extends JDialog{
	private JTable table;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnAgergar;
	private JButton btnBorrar;
	private JSpinner spinnerLote;
	private JSpinner spinnerAmbientes;
	private JSpinner spinnerCubiertos;
	private JCheckBox chckbxAptoACredito;
	private TipoPropiedadComboBoxModel tipoCombo;
	private HabitacionTableModel tableModel;

	@Inject
	private PropiedadOtrosDatosForm() {
		setTitle("Otros datos");
		getContentPane().setLayout(null);
		setModal(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(460, 540));
		
		JLabel lblTipo = new JLabel("Tipo: ");
		lblTipo.setBounds(27, 92, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblAmbientes = new JLabel("Ambientes: ");
		lblAmbientes.setBounds(27, 142, 65, 14);
		getContentPane().add(lblAmbientes);
		
		JLabel lblMcubiertos = new JLabel("M\u00B2 cubiertos: ");
		lblMcubiertos.setBounds(254, 139, 78, 14);
		getContentPane().add(lblMcubiertos);
		
		JLabel lblMLote = new JLabel("M\u00B2 Lote: ");
		lblMLote.setBounds(27, 184, 65, 14);
		getContentPane().add(lblMLote);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 264, 424, 2);
		getContentPane().add(separator);
		
		JLabel lblHabitacionesYOtros = new JLabel("Habitaciones y otros");
		lblHabitacionesYOtros.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHabitacionesYOtros.setBounds(27, 239, 155, 14);
		getContentPane().add(lblHabitacionesYOtros);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 293, 394, 92);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnAgergar = new JButton("Agregar");
		btnAgergar.setBounds(37, 396, 89, 23);
		getContentPane().add(btnAgergar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(299, 396, 89, 23);
		getContentPane().add(btnBorrar);
		
		JComboBox<String> comboBoxTipoProp = new JComboBox<>();
		comboBoxTipoProp.setBounds(64, 89, 102, 20);
		getContentPane().add(comboBoxTipoProp);
		
		spinnerAmbientes = new JSpinner();
		spinnerAmbientes.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(Integer.MAX_VALUE), new Integer(1)));
		spinnerAmbientes.setBounds(97, 139, 46, 20);
		getContentPane().add(spinnerAmbientes);
		
		spinnerCubiertos = new JSpinner();
		spinnerCubiertos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(Integer.MAX_VALUE), new Integer(10)));
		spinnerCubiertos.setBounds(342, 136, 46, 20);
		getContentPane().add(spinnerCubiertos);
		
		spinnerLote = new JSpinner();
		spinnerLote.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(Integer.MAX_VALUE), new Integer(10)));
		spinnerLote.setBounds(97, 184, 46, 20);
		getContentPane().add(spinnerLote);
		
		chckbxAptoACredito = new JCheckBox("Apto a credito");
		chckbxAptoACredito.setBounds(291, 88, 111, 23);
		getContentPane().add(chckbxAptoACredito);
		
		JLabel lblDatosDeEspacio = new JLabel("Datos de espacio");
		lblDatosDeEspacio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosDeEspacio.setBounds(27, 32, 129, 14);
		getContentPane().add(lblDatosDeEspacio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 57, 424, 2);
		getContentPane().add(separator_1);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(77, 440, 89, 39);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(272, 440, 89, 39);
		getContentPane().add(btnCancelar);
		
		tipoCombo = new TipoPropiedadComboBoxModel();
		comboBoxTipoProp.setModel(tipoCombo);
		
		tableModel = new HabitacionTableModel();
		table.setModel(tableModel);
		table.setColumnModel(tableModel.getTableColumnModel());
		table.getTableHeader().setReorderingAllowed(false);
		
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnAgergar() {
		return btnAgergar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JSpinner getSpinnerLote() {
		return spinnerLote;
	}

	public JSpinner getSpinnerAmbientes() {
		return spinnerAmbientes;
	}

	public JSpinner getSpinnerCubiertos() {
		return spinnerCubiertos;
	}

	public JCheckBox getChckbxAptoACredito() {
		return chckbxAptoACredito;
	}

	public TipoPropiedadComboBoxModel getTipoCombo() {
		return tipoCombo;
	}

	public HabitacionTableModel getTableModel() {
		return tableModel;
	}
}
