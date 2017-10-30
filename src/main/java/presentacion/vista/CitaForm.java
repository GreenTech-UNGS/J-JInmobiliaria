package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCitaComboBoxModel;

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
	
	private JTable tableAsistentes;
	private JDateChooser dateChooser;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JCheckBox chckbxAsistir;
	private JComboBox<String> comboMotivo;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JSpinner spinnerHoraMomento;
	private JSpinner spinnerMinutoMomento;
	private JSpinner spinnerHoraDuracion;
	private JSpinner spinnerMinutoDuracion;
	private JButton btnDesdePropiedad;
	private JComboBox<String> comboProvincia;
	private JComboBox<String> comboLocalidad;
	private JTextArea taNotas;
	private JSpinner spinnerAvisoLargo;
	private JSpinner spinnerAvisoCorto;
	private JButton btnAceptar;
	
	private ProvinciaComboBoxModel comboModelProvincia;
	private LocalidadComboBoxModel comboModelLocalidad;
	private TipoCitaComboBoxModel comboModelTipoCita;
	
	@Inject
	public CitaForm() {
		setTitle("Crear Cita");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 73, 286, 77);
		getContentPane().add(scrollPane);
		setLocationRelativeTo(null);
		setModal(true);
		setSize(500, 725);
		setResizable(false);
		
		tableAsistentes = new JTable();
		scrollPane.setViewportView(tableAsistentes);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(105, 161, 117, 25);
		getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(274, 161, 117, 25);
		getContentPane().add(btnBorrar);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora: ");
		lblFechaYHora.setBounds(37, 249, 91, 15);
		getContentPane().add(lblFechaYHora);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(135, 249, 107, 22);
		getContentPane().add(dateChooser);
		
		spinnerHoraMomento = new JSpinner();
		spinnerHoraMomento.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHoraMomento.setBounds(264, 249, 36, 20);
		getContentPane().add(spinnerHoraMomento);
		
		JLabel label = new JLabel(":");
		label.setBounds(309, 252, 20, 15);
		getContentPane().add(label);
		
		spinnerMinutoMomento = new JSpinner();
		spinnerMinutoMomento.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinutoMomento.setBounds(319, 250, 36, 20);
		getContentPane().add(spinnerMinutoMomento);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(37, 284, 91, 15);
		getContentPane().add(lblDuracion);
		
		spinnerHoraDuracion = new JSpinner();
		spinnerHoraDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHoraDuracion.setBounds(135, 282, 36, 20);
		getContentPane().add(spinnerHoraDuracion);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(175, 284, 20, 15);
		getContentPane().add(label_1);
		
		spinnerMinutoDuracion = new JSpinner();
		spinnerMinutoDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerMinutoDuracion.setBounds(183, 282, 36, 20);
		getContentPane().add(spinnerMinutoDuracion);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(248, 360, 91, 15);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(37, 395, 70, 15);
		getContentPane().add(lblCalle);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBounds(37, 360, 91, 15);
		getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(248, 395, 70, 15);
		getContentPane().add(lblAltura);
		
		comboProvincia = new JComboBox<>();
		comboProvincia.setBounds(105, 355, 114, 24);
		getContentPane().add(comboProvincia);
		
		comboLocalidad = new JComboBox<>();
		comboLocalidad.setBounds(319, 355, 114, 24);
		getContentPane().add(comboLocalidad);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(105, 392, 114, 19);
		getContentPane().add(tfCalle);
		tfCalle.setColumns(10);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(319, 395, 114, 19);
		getContentPane().add(tfAltura);
		tfAltura.setColumns(10);
		
		btnDesdePropiedad = new JButton("Desde propiedad");
		btnDesdePropiedad.setBounds(300, 322, 156, 15);
		getContentPane().add(btnDesdePropiedad);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setBounds(248, 47, 70, 15);
		getContentPane().add(lblMotivo);
		
		comboMotivo = new JComboBox<>();
		comboMotivo.setBounds(300, 42, 114, 24);
		getContentPane().add(comboMotivo);
		
		JLabel lblAvisoLargo = new JLabel("Aviso largo: ");
		lblAvisoLargo.setBounds(37, 489, 72, 14);
		getContentPane().add(lblAvisoLargo);
		
		JLabel lblAvisoCorto = new JLabel("Aviso corto:");
		lblAvisoCorto.setBounds(248, 489, 70, 14);
		getContentPane().add(lblAvisoCorto);
		
		spinnerAvisoLargo = new JSpinner();
		spinnerAvisoLargo.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoLargo.setBounds(105, 486, 40, 20);
		getContentPane().add(spinnerAvisoLargo);
		
		spinnerAvisoCorto = new JSpinner();
		spinnerAvisoCorto.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoCorto.setBounds(319, 486, 36, 20);
		getContentPane().add(spinnerAvisoCorto);
		
		JLabel lblDias = new JLabel("dias antes");
		lblDias.setBounds(155, 489, 74, 14);
		getContentPane().add(lblDias);
		
		JLabel lblHoras = new JLabel("horas antes");
		lblHoras.setBounds(365, 489, 75, 14);
		getContentPane().add(lblHoras);
		
		JLabel lblNotas = new JLabel("Notas:");
		lblNotas.setBounds(37, 545, 46, 14);
		getContentPane().add(lblNotas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(96, 539, 337, 77);
		getContentPane().add(scrollPane_1);
		
		taNotas = new JTextArea();
		scrollPane_1.setViewportView(taNotas);
		
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
		
		chckbxAsistir = new JCheckBox("Asistir");
		chckbxAsistir.setBounds(48, 43, 97, 23);
		getContentPane().add(chckbxAsistir);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(197, 630, 89, 49);
		getContentPane().add(btnAceptar);
		
		JLabel lblHs = new JLabel("hs.");
		lblHs.setBounds(364, 255, 46, 14);
		getContentPane().add(lblHs);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		comboModelTipoCita = new TipoCitaComboBoxModel();
		
		comboProvincia.setModel(comboModelProvincia);
		comboLocalidad.setModel(comboModelLocalidad);
		comboMotivo.setModel(comboModelTipoCita);
		
		
	}

	public JTable getTableAsistentes() {
		return tableAsistentes;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public JCheckBox getChckbxAsistir() {
		return chckbxAsistir;
	}

	public JComboBox<String> getComboMotivo() {
		return comboMotivo;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JSpinner getSpinnerHoraMomento() {
		return spinnerHoraMomento;
	}

	public JSpinner getSpinnerMinutoMomento() {
		return spinnerMinutoMomento;
	}

	public JSpinner getSpinnerHoraDuracion() {
		return spinnerHoraDuracion;
	}

	public JSpinner getSpinnerMinutoDuracion() {
		return spinnerMinutoDuracion;
	}

	public JButton getBtnDesdePropiedad() {
		return btnDesdePropiedad;
	}

	public JComboBox<String> getComboProvincia() {
		return comboProvincia;
	}

	public JComboBox<String> getComboLocalidad() {
		return comboLocalidad;
	}

	public JTextArea getTaNotas() {
		return taNotas;
	}

	public JSpinner getSpinnerAvisoLargo() {
		return spinnerAvisoLargo;
	}

	public JSpinner getSpinnerAvisoCorto() {
		return spinnerAvisoCorto;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public ProvinciaComboBoxModel getComboModelProvincia() {
		return comboModelProvincia;
	}

	public LocalidadComboBoxModel getComboModelLocalidad() {
		return comboModelLocalidad;
	}

	public TipoCitaComboBoxModel getComboModelTipoCita() {
		return comboModelTipoCita;
	}
}
