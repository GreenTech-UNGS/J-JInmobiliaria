package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JCheckBox;

@Singleton
public class CitaForm extends JDialog{
	private JTable table;
	private JDateChooser dateChooser;
	private JTextField textField;
	private JTextField textField_1;
	
	@Inject
	public CitaForm() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 76, 286, 77);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(53, 164, 117, 25);
		getContentPane().add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(222, 164, 117, 25);
		getContentPane().add(btnBorrar);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora: ");
		lblFechaYHora.setBounds(37, 249, 117, 15);
		getContentPane().add(lblFechaYHora);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(145, 249, 107, 22);
		getContentPane().add(dateChooser);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(274, 249, 36, 20);
		getContentPane().add(spinner);
		
		JLabel label = new JLabel(":");
		label.setBounds(319, 252, 20, 15);
		getContentPane().add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(329, 250, 36, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(37, 284, 91, 15);
		getContentPane().add(lblDuracion);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_2.setBounds(135, 282, 36, 20);
		getContentPane().add(spinner_2);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(175, 284, 20, 15);
		getContentPane().add(label_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_3.setBounds(183, 282, 36, 20);
		getContentPane().add(spinner_3);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(248, 360, 91, 15);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(37, 386, 70, 15);
		getContentPane().add(lblCalle);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBounds(37, 360, 91, 15);
		getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(248, 386, 70, 15);
		getContentPane().add(lblAltura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 355, 114, 24);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(319, 355, 114, 24);
		getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(105, 383, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(319, 386, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDesdePropiedad = new JButton("Desde propiedad");
		btnDesdePropiedad.setBounds(300, 322, 156, 15);
		getContentPane().add(btnDesdePropiedad);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setBounds(248, 47, 70, 15);
		getContentPane().add(lblMotivo);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(300, 42, 114, 24);
		getContentPane().add(comboBox_2);
		
		JLabel lblAvisoLargo = new JLabel("Aviso largo: ");
		lblAvisoLargo.setBounds(37, 489, 72, 14);
		getContentPane().add(lblAvisoLargo);
		
		JLabel lblAvisoCorto = new JLabel("Aviso corto:");
		lblAvisoCorto.setBounds(248, 489, 70, 14);
		getContentPane().add(lblAvisoCorto);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(105, 486, 29, 20);
		getContentPane().add(spinner_4);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(319, 486, 29, 20);
		getContentPane().add(spinner_5);
		
		JLabel lblDias = new JLabel("dias antes");
		lblDias.setBounds(145, 489, 74, 14);
		getContentPane().add(lblDias);
		
		JLabel lblHoras = new JLabel("horas antes");
		lblHoras.setBounds(358, 489, 75, 14);
		getContentPane().add(lblHoras);
		
		JLabel lblNotas = new JLabel("Notas:");
		lblNotas.setBounds(37, 545, 46, 14);
		getContentPane().add(lblNotas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 539, 337, 77);
		getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 464, 2);
		getContentPane().add(separator);
		
		JLabel lblAsistentes_1 = new JLabel("Asistentes");
		lblAsistentes_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAsistentes_1.setBounds(37, 11, 83, 14);
		getContentPane().add(lblAsistentes_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 236, 464, 2);
		getContentPane().add(separator_1);
		
		JLabel lblMomentoYDuracion = new JLabel("Momento y duracion");
		lblMomentoYDuracion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMomentoYDuracion.setBounds(37, 211, 140, 14);
		getContentPane().add(lblMomentoYDuracion);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 346, 464, 3);
		getContentPane().add(separator_2);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUbicacion.setBounds(37, 321, 91, 14);
		getContentPane().add(lblUbicacion);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 470, 464, 2);
		getContentPane().add(separator_3);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOtrosDatos.setBounds(37, 445, 87, 14);
		getContentPane().add(lblOtrosDatos);
		
		JCheckBox chckbxAsistir = new JCheckBox("Asistir");
		chckbxAsistir.setBounds(48, 43, 97, 23);
		getContentPane().add(chckbxAsistir);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(197, 630, 89, 49);
		getContentPane().add(btnAceptar);
		
		
	}
}
