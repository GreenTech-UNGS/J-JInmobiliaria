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
import javax.swing.border.LineBorder;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JMapViewer mapa;
	private JButton btnActualizar;
	
	@Inject
	public CitaForm() {
		setTitle("Crear Cita");
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 76, 236, 77);
		getContentPane().add(scrollPane);
		setLocationRelativeTo(null);
		setModal(true);
		setSize(850, 620);
		setResizable(false);
		
		tableAsistentes = new JTable();
		scrollPane.setViewportView(tableAsistentes);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(271, 164, 97, 25);
		getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(399, 164, 91, 25);
		getContentPane().add(btnBorrar);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora: ");
		lblFechaYHora.setBounds(37, 250, 91, 15);
		getContentPane().add(lblFechaYHora);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(134, 250, 107, 22);
		getContentPane().add(dateChooser);
		
		spinnerHoraMomento = new JSpinner();
		spinnerHoraMomento.setModel(new SpinnerNumberModel(12, 0, 23, 1));
		spinnerHoraMomento.setBounds(251, 252, 36, 20);
		getContentPane().add(spinnerHoraMomento);
		
		JLabel label = new JLabel(":");
		label.setBounds(290, 256, 20, 15);
		getContentPane().add(label);
		
		spinnerMinutoMomento = new JSpinner();
		spinnerMinutoMomento.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinutoMomento.setBounds(297, 252, 36, 20);
		getContentPane().add(spinnerMinutoMomento);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setBounds(549, 255, 91, 15);
		getContentPane().add(lblDuracion);
		
		spinnerHoraDuracion = new JSpinner();
		spinnerHoraDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHoraDuracion.setBounds(610, 252, 36, 20);
		getContentPane().add(spinnerHoraDuracion);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(650, 254, 20, 15);
		getContentPane().add(label_1);
		
		spinnerMinutoDuracion = new JSpinner();
		spinnerMinutoDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerMinutoDuracion.setBounds(658, 252, 36, 20);
		getContentPane().add(spinnerMinutoDuracion);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setBounds(646, 347, 91, 15);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setBounds(36, 347, 70, 15);
		getContentPane().add(lblCalle);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setBounds(439, 347, 91, 15);
		getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setBounds(244, 344, 70, 15);
		getContentPane().add(lblAltura);
		
		comboProvincia = new JComboBox<>();
		comboProvincia.setBounds(507, 342, 114, 24);
		getContentPane().add(comboProvincia);
		
		comboLocalidad = new JComboBox<>();
		comboLocalidad.setBounds(711, 342, 114, 24);
		getContentPane().add(comboLocalidad);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(101, 341, 114, 19);
		getContentPane().add(tfCalle);
		tfCalle.setColumns(10);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(315, 344, 114, 19);
		getContentPane().add(tfAltura);
		tfAltura.setColumns(10);
		
		btnDesdePropiedad = new JButton("Desde propiedad");
		btnDesdePropiedad.setBounds(111, 304, 156, 15);
		getContentPane().add(btnDesdePropiedad);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setBounds(20, 51, 70, 15);
		getContentPane().add(lblMotivo);
		
		comboMotivo = new JComboBox<>();
		comboMotivo.setBounds(100, 46, 151, 24);
		getContentPane().add(comboMotivo);
		
		JLabel lblAvisoLargo = new JLabel("Aviso largo: ");
		lblAvisoLargo.setBounds(20, 84, 72, 14);
		getContentPane().add(lblAvisoLargo);
		
		JLabel lblAvisoCorto = new JLabel("Aviso corto:");
		lblAvisoCorto.setBounds(20, 112, 70, 14);
		getContentPane().add(lblAvisoCorto);
		
		spinnerAvisoLargo = new JSpinner();
		spinnerAvisoLargo.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoLargo.setBounds(88, 81, 40, 20);
		getContentPane().add(spinnerAvisoLargo);
		
		spinnerAvisoCorto = new JSpinner();
		spinnerAvisoCorto.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoCorto.setBounds(91, 109, 36, 20);
		getContentPane().add(spinnerAvisoCorto);
		
		JLabel lblDias = new JLabel("dias antes");
		lblDias.setBounds(138, 84, 74, 14);
		getContentPane().add(lblDias);
		
		JLabel lblHoras = new JLabel("horas antes");
		lblHoras.setBounds(137, 112, 70, 14);
		getContentPane().add(lblHoras);
		
		JLabel lblNotas = new JLabel("Notas:");
		lblNotas.setBounds(549, 51, 46, 14);
		getContentPane().add(lblNotas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(595, 51, 230, 77);
		getContentPane().add(scrollPane_1);
		
		taNotas = new JTextArea();
		scrollPane_1.setViewportView(taNotas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 824, 2);
		getContentPane().add(separator);
		
		JLabel lblAsistentes_1 = new JLabel("Asistentes");
		lblAsistentes_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAsistentes_1.setBounds(37, 11, 83, 14);
		getContentPane().add(lblAsistentes_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 237, 816, 2);
		getContentPane().add(separator_1);
		
		JLabel lblMomentoYDuracion = new JLabel("Momento y duracion");
		lblMomentoYDuracion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMomentoYDuracion.setBounds(37, 212, 140, 14);
		getContentPane().add(lblMomentoYDuracion);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 329, 815, 2);
		getContentPane().add(separator_2);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUbicacion.setBounds(37, 303, 91, 14);
		getContentPane().add(lblUbicacion);
		
		chckbxAsistir = new JCheckBox("Asistir");
		chckbxAsistir.setBounds(261, 46, 97, 23);
		getContentPane().add(chckbxAsistir);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(382, 529, 89, 49);
		getContentPane().add(btnAceptar);
		
		JLabel lblHs = new JLabel("hs.");
		lblHs.setBounds(337, 256, 46, 14);
		getContentPane().add(lblHs);
		
		mapa = new JMapViewer();
		mapa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mapa.setZoomContolsVisible(false);
		mapa.setBounds(116, 377, 621, 141);
		getContentPane().add(mapa);
		
		btnActualizar = new JButton("Actualizar mapa");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnActualizar.setBounds(495, 11, 116, 23);
		mapa.add(btnActualizar);
		
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

	public JMapViewer getMapa() {
		return mapa;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}
}
