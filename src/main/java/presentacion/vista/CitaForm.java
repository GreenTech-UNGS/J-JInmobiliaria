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

@Singleton
public class CitaForm extends JDialog{
	private JTable table;
	private JDateChooser dateChooser;
	private JTextField textField;
	private JTextField textField_1;
	
	@Inject
	public CitaForm() {
		getContentPane().setLayout(null);
		
		JLabel lblAsistentes = new JLabel("Asistentes: ");
		lblAsistentes.setBounds(12, 12, 91, 15);
		getContentPane().add(lblAsistentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 12, 286, 77);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(110, 101, 117, 25);
		getContentPane().add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(279, 101, 117, 25);
		getContentPane().add(btnBorrar);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora: ");
		lblFechaYHora.setBounds(12, 147, 117, 15);
		getContentPane().add(lblFechaYHora);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(120, 147, 107, 22);
		getContentPane().add(dateChooser);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner.setBounds(249, 147, 36, 20);
		getContentPane().add(spinner);
		
		JLabel label = new JLabel(":");
		label.setBounds(294, 150, 20, 15);
		getContentPane().add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinner_1.setBounds(304, 148, 36, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(12, 200, 91, 15);
		getContentPane().add(lblDuracion);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_2.setBounds(110, 198, 36, 20);
		getContentPane().add(spinner_2);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(150, 200, 20, 15);
		getContentPane().add(label_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinner_3.setBounds(158, 198, 36, 20);
		getContentPane().add(spinner_3);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(230, 242, 91, 15);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(12, 280, 70, 15);
		getContentPane().add(lblCalle);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBounds(12, 242, 91, 15);
		getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(223, 280, 70, 15);
		getContentPane().add(lblAltura);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(98, 237, 107, 24);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(312, 237, 101, 24);
		getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(80, 278, 114, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 278, 114, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDesdePropiedad = new JButton("Desde propiedad");
		btnDesdePropiedad.setBounds(263, 203, 156, 15);
		getContentPane().add(btnDesdePropiedad);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setBounds(12, 327, 70, 15);
		getContentPane().add(lblMotivo);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(98, 322, 107, 24);
		getContentPane().add(comboBox_2);
		
		
	}
}
