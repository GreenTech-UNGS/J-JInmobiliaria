package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCitaComboBoxModel;
import presentacion.combo.UnidadTiempoComboBoxModel;

import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

@Singleton
public class CitaForm extends JDialog{
	private JDateChooser dateChooser;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JCheckBox chckbxAsistir;
	private JComboBox<String> comboMotivo;
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
	private UnidadTiempoComboBoxModel unidadLarga;
	private UnidadTiempoComboBoxModel unidadCorta;
	
	private JMapViewer mapa;
	private JButton btnActualizar;
	private JComboBox<String> comboTiempoLargo;
	private JComboBox<String> comboTiempoCorto;
	
	private UnidadTiempoComboBoxModel unidadComboModel;
	private UnidadTiempoComboBoxModel unidadComboModel2;
	
	private JTextField tfIdentificador;
	private JButton btnVerPropiedad;
	private JTextField tfCliente;
	private JButton btnBuscarCliente;
	
	@Inject
	public CitaForm() {
		setTitle("Crear Cita");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setModal(true);
		setSize(850, 550);
		setResizable(false);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora: ");
		lblFechaYHora.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblFechaYHora.setBounds(37, 177, 91, 15);
		getContentPane().add(lblFechaYHora);
		
		dateChooser = new JDateChooser(new Date());
		dateChooser.setBounds(134, 177, 107, 22);
		getContentPane().add(dateChooser);
		
		spinnerHoraMomento = new JSpinner();
		spinnerHoraMomento.setModel(new SpinnerNumberModel(12, 0, 23, 1));
		spinnerHoraMomento.setBounds(251, 179, 36, 20);
		getContentPane().add(spinnerHoraMomento);
		
		JLabel label = new JLabel(":");
		label.setBounds(290, 183, 20, 15);
		getContentPane().add(label);
		
		spinnerMinutoMomento = new JSpinner();
		spinnerMinutoMomento.setModel(new SpinnerNumberModel(0, 0, 59, 5));
		spinnerMinutoMomento.setBounds(297, 179, 36, 20);
		getContentPane().add(spinnerMinutoMomento);
		
		JLabel lblDuracion = new JLabel("Duracion: ");
		lblDuracion.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDuracion.setBounds(535, 182, 70, 15);
		getContentPane().add(lblDuracion);
		
		spinnerHoraDuracion = new JSpinner();
		spinnerHoraDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHoraDuracion.setBounds(610, 179, 36, 20);
		getContentPane().add(spinnerHoraDuracion);
		
		JLabel label_1 = new JLabel(":");
		label_1.setBounds(650, 181, 20, 15);
		getContentPane().add(label_1);
		
		spinnerMinutoDuracion = new JSpinner();
		spinnerMinutoDuracion.setModel(new SpinnerNumberModel(0, 0, 23, 5));
		spinnerMinutoDuracion.setBounds(658, 179, 36, 20);
		getContentPane().add(spinnerMinutoDuracion);
		
		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblLocalidad.setBounds(646, 274, 91, 15);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle: ");
		lblCalle.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCalle.setBounds(36, 274, 70, 15);
		getContentPane().add(lblCalle);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblProvincia.setBounds(439, 274, 91, 15);
		getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura: ");
		lblAltura.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblAltura.setBounds(244, 271, 70, 15);
		getContentPane().add(lblAltura);
		
		comboProvincia = new JComboBox<>();
		comboProvincia.setBounds(507, 269, 114, 24);
		getContentPane().add(comboProvincia);
		
		comboLocalidad = new JComboBox<>();
		comboLocalidad.setBounds(711, 269, 114, 24);
		getContentPane().add(comboLocalidad);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(101, 268, 114, 19);
		getContentPane().add(tfCalle);
		tfCalle.setColumns(10);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(315, 271, 114, 19);
		getContentPane().add(tfAltura);
		tfAltura.setColumns(10);
		
		btnDesdePropiedad = new JButton("Desde propiedad");
		btnDesdePropiedad.setBounds(111, 227, 156, 19);
		getContentPane().add(btnDesdePropiedad);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblMotivo.setBounds(36, 94, 70, 15);
		getContentPane().add(lblMotivo);
		
		comboMotivo = new JComboBox<>();
		comboMotivo.setBounds(100, 88, 151, 24);
		getContentPane().add(comboMotivo);
		
		JLabel lblAvisoLargo = new JLabel("Aviso largo: ");
		lblAvisoLargo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblAvisoLargo.setBounds(269, 75, 72, 14);
		getContentPane().add(lblAvisoLargo);
		
		JLabel lblAvisoCorto = new JLabel("Aviso corto:");
		lblAvisoCorto.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblAvisoCorto.setBounds(269, 102, 70, 14);
		getContentPane().add(lblAvisoCorto);
		
		spinnerAvisoLargo = new JSpinner();
		spinnerAvisoLargo.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoLargo.setBounds(351, 72, 40, 20);
		getContentPane().add(spinnerAvisoLargo);
		
		spinnerAvisoCorto = new JSpinner();
		spinnerAvisoCorto.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinnerAvisoCorto.setBounds(351, 99, 39, 20);
		getContentPane().add(spinnerAvisoCorto);
		
		JLabel lblDias = new JLabel("antes");
		lblDias.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDias.setBounds(508, 75, 55, 14);
		getContentPane().add(lblDias);
		
		JLabel lblHoras = new JLabel("antes");
		lblHoras.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblHoras.setBounds(507, 102, 55, 14);
		getContentPane().add(lblHoras);
		
		JLabel lblNotas = new JLabel("Descripcion:");
		lblNotas.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblNotas.setBounds(575, 49, 46, 14);
		getContentPane().add(lblNotas);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(595, 75, 230, 77);
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
		separator_1.setBounds(10, 164, 816, 2);
		getContentPane().add(separator_1);
		
		JLabel lblMomentoYDuracion = new JLabel("Momento y duracion");
		lblMomentoYDuracion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMomentoYDuracion.setBounds(37, 139, 140, 14);
		getContentPane().add(lblMomentoYDuracion);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 256, 815, 2);
		getContentPane().add(separator_2);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUbicacion.setBounds(37, 230, 91, 14);
		getContentPane().add(lblUbicacion);
		
		chckbxAsistir = new JCheckBox("Asistir");
		chckbxAsistir.setBounds(20, 47, 97, 23);
		getContentPane().add(chckbxAsistir);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(382, 456, 89, 49);
		getContentPane().add(btnAceptar);
		
		JLabel lblHs = new JLabel("hs.");
		lblHs.setBounds(337, 183, 46, 14);
		getContentPane().add(lblHs);
		
		mapa = new JMapViewer();
		mapa.setBorder(new LineBorder(Color.LIGHT_GRAY));
		mapa.setZoomContolsVisible(false);
		mapa.setBounds(116, 304, 621, 141);
		getContentPane().add(mapa);
		
		btnActualizar = new JButton("Actualizar mapa");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnActualizar.setBounds(495, 11, 116, 23);
		mapa.add(btnActualizar);
		
		comboTiempoLargo = new JComboBox<String>();
		comboTiempoLargo.setBounds(401, 69, 97, 24);
		getContentPane().add(comboTiempoLargo);
		
		comboTiempoCorto = new JComboBox<String>();
		comboTiempoCorto.setBounds(400, 98, 98, 24);
		getContentPane().add(comboTiempoCorto);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		comboModelTipoCita = new TipoCitaComboBoxModel();
		unidadLarga = new UnidadTiempoComboBoxModel();
		unidadCorta = new UnidadTiempoComboBoxModel();
		
		comboProvincia.setModel(comboModelProvincia);
		comboLocalidad.setModel(comboModelLocalidad);
		comboMotivo.setModel(comboModelTipoCita);
		comboTiempoCorto.setModel(unidadCorta);
		comboTiempoLargo.setModel(unidadLarga);
		
		tfIdentificador = new JTextField();
		tfIdentificador.setColumns(10);
		tfIdentificador.setBounds(315, 227, 55, 19);
		getContentPane().add(tfIdentificador);
		tfIdentificador.isEditable();
		
		btnVerPropiedad = new JButton("Ver propiedad");
		btnVerPropiedad.setBounds(382, 227, 156, 19);
		getContentPane().add(btnVerPropiedad);
		
		tfCliente = new JTextField();
		tfCliente.setBounds(610, 227, 98, 19);
		getContentPane().add(tfCliente);
		tfCliente.setColumns(10);
		tfCliente.setEditable(false);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(710, 227, 27, 20);		
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnBuscarCliente.setIcon(new ImageIcon(imgLup));
		getContentPane().add(btnBuscarCliente);

		
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

	public UnidadTiempoComboBoxModel getUnidadLarga() {
		return unidadLarga;
	}

	public UnidadTiempoComboBoxModel getUnidadCorta() {
		return unidadCorta;
	}

	public JComboBox<String> getComboTiempoLargo() {
		return comboTiempoLargo;
	}

	public JComboBox<String> getComboTiempoCorto() {
		return comboTiempoCorto;
	}
	
	public JTextField getTfIdentificador() {
		return tfIdentificador;
	}

	public JButton getBtnVerPropiedad() {
		return btnVerPropiedad;
	}

	public JTextField getTfCliente() {
		return tfCliente;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}
}
