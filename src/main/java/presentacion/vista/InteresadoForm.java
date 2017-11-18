package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCitaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InteresadoForm extends JDialog{
	private JTextField tfCredencial;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfEmail;
	private JTable tableTel;
	private JTextField tfDesdeMetros;
	private JTextField tfDesdeAmbientes;
	private JTextField tfDesdePrecio;
	private JTextField tfHastaPrecio;
	private JButton btnAgregarTelefono;
	private JButton btnBorrarTelefono;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JComboBox<String> cbCredencial;
	private JComboBox<String> cbLocalidad;
	private JComboBox<String> cbTipoOfrec;
	private JComboBox<String> cbProvincia;
	
	private ProvinciaComboBoxModel comboModelProvincia;
	private LocalidadComboBoxModel comboModelLocalidad;
	private MonedaComboBoxModel comboModelMoneda;
	private TipoOfrecimientoComboBoxModel comboModelOfrecimiento;
	private JButton btnGuardarCambios;
	private JLabel lblMoneda;
	private JComboBox<String> cbMoneda;
	private JTextField tfHastaAmbientes;
	private JTextField tfHastaMetros;
	
	@Inject
	private InteresadoForm(){
		super();
		
		setTitle("Agregar interesado");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(473, 511));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		cbCredencial = new JComboBox();
		cbCredencial.setBounds(237, 69, 67, 20);
		getContentPane().add(cbCredencial);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosPersonales.setBounds(30, 31, 104, 14);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 56, 405, 2);
		getContentPane().add(separator);
		
		tfCredencial = new JTextField();
		tfCredencial.setBounds(314, 69, 124, 20);
		getContentPane().add(tfCredencial);
		tfCredencial.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(30, 69, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(30, 94, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(237, 94, 46, 14);
		getContentPane().add(lblEmail);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(93, 69, 124, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(93, 91, 124, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(314, 91, 124, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 130, 327, 67);
		getContentPane().add(scrollPane);
		
		tableTel = new JTable();
		scrollPane.setColumnHeaderView(tableTel);
		
		btnAgregarTelefono = new JButton("Agregar");
		btnAgregarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAgregarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarTelefono.setBounds(359, 140, 78, 23);
		getContentPane().add(btnAgregarTelefono);
		
		btnBorrarTelefono = new JButton("Borrar");
		btnBorrarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBorrarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrarTelefono.setBounds(359, 164, 78, 23);
		getContentPane().add(btnBorrarTelefono);
		
		JLabel lblPreferencias = new JLabel("Preferencias de propiedad");
		lblPreferencias.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreferencias.setBounds(30, 227, 158, 14);
		getContentPane().add(lblPreferencias);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 252, 405, 2);
		getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Localidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(30, 315, 60, 14);
		getContentPane().add(lblNewLabel);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(93, 312, 124, 20);
		getContentPane().add(cbLocalidad);
		
		JLabel lblMetros = new JLabel("Desde metros\u00B2:");
		lblMetros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMetros.setBounds(30, 340, 87, 14);
		getContentPane().add(lblMetros);
		
		tfDesdeMetros = new JTextField();
		tfDesdeMetros.setBounds(108, 337, 109, 20);
		getContentPane().add(tfDesdeMetros);
		tfDesdeMetros.setColumns(10);
		
		JLabel lblA = new JLabel("Hasta ambientes:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblA.setBounds(237, 365, 104, 14);
		getContentPane().add(lblA);
		
		tfDesdeAmbientes = new JTextField();
		tfDesdeAmbientes.setColumns(10);
		tfDesdeAmbientes.setBounds(324, 337, 114, 20);
		getContentPane().add(tfDesdeAmbientes);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(30, 265, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDesde = new JLabel("Desde precio:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesde.setBounds(237, 265, 67, 14);
		getContentPane().add(lblDesde);
		
		tfDesdePrecio = new JTextField();
		tfDesdePrecio.setColumns(10);
		tfDesdePrecio.setBounds(314, 262, 124, 20);
		getContentPane().add(tfDesdePrecio);
		
		JLabel lblHasta = new JLabel("Hasta precio:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHasta.setBounds(237, 290, 67, 14);
		getContentPane().add(lblHasta);
		
		tfHastaPrecio = new JTextField();
		tfHastaPrecio.setBounds(314, 287, 124, 20);
		getContentPane().add(tfHastaPrecio);
		tfHastaPrecio.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(93, 417, 135, 31);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(237, 415, 136, 34);
		getContentPane().add(btnCancelar);
		
		cbTipoOfrec = new JComboBox();
		cbTipoOfrec.setBounds(93, 262, 124, 20);
		getContentPane().add(cbTipoOfrec);
		
		cbProvincia = new JComboBox();
		cbProvincia.setBounds(93, 287, 124, 20);
		getContentPane().add(cbProvincia);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		
		cbProvincia.setModel(comboModelProvincia);
		cbLocalidad.setModel(comboModelLocalidad);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(30, 290, 60, 14);
		getContentPane().add(lblProvincia);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardarCambios.setBounds(92, 417, 136, 31);
		getContentPane().add(btnGuardarCambios);
		
		lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(237, 315, 46, 14);
		getContentPane().add(lblMoneda);
		
		cbMoneda = new JComboBox<String>();
		cbMoneda.setBounds(314, 312, 124, 20);
		getContentPane().add(cbMoneda);
		btnGuardarCambios.setVisible(false);
		
		comboModelMoneda = new MonedaComboBoxModel();
		cbMoneda.setModel(comboModelMoneda);
		
		JLabel lblHastaMetros = new JLabel("Hasta metros\u00B2:");
		lblHastaMetros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHastaMetros.setBounds(30, 365, 78, 14);
		getContentPane().add(lblHastaMetros);
		
		JLabel lblDesdeAmbientes = new JLabel("Desde ambientes:");
		lblDesdeAmbientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesdeAmbientes.setBounds(237, 340, 87, 14);
		getContentPane().add(lblDesdeAmbientes);
		
		tfHastaAmbientes = new JTextField();
		tfHastaAmbientes.setBounds(324, 362, 114, 20);
		getContentPane().add(tfHastaAmbientes);
		tfHastaAmbientes.setColumns(10);
		
		tfHastaMetros = new JTextField();
		tfHastaMetros.setBounds(108, 362, 109, 20);
		getContentPane().add(tfHastaMetros);
		tfHastaMetros.setColumns(10);

		
		comboModelOfrecimiento = new TipoOfrecimientoComboBoxModel();
		cbTipoOfrec.setModel(comboModelOfrecimiento);
		
	}

	public TipoOfrecimientoComboBoxModel getComboModelOfrecimiento() {
		return comboModelOfrecimiento;
	}

	public JButton getBtnAgregarTelefono() {
		return btnAgregarTelefono;
	}

	public void setBtnAgregarTelefono(JButton btnAgregarTelefono) {
		this.btnAgregarTelefono = btnAgregarTelefono;
	}

	public JButton getBtnBorrarTelefono() {
		return btnBorrarTelefono;
	}

	public void setBtnBorrarTelefono(JButton btnBorrarTelefono) {
		this.btnBorrarTelefono = btnBorrarTelefono;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTable getTableTel() {
		return tableTel;
	}

	public void setTableTel(JTable tableTel) {
		this.tableTel = tableTel;
	}

	public JComboBox getCbCredencial() {
		return cbCredencial;
	}

	public void setCbCredencial(JComboBox cbCredencial) {
		this.cbCredencial = cbCredencial;
	}

	public JTextField getTfCredencial() {
		return tfCredencial;
	}

	public void setTfCredencial(JTextField tfCredencial) {
		this.tfCredencial = tfCredencial;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfApellido() {
		return tfApellido;
	}

	public void setTfApellido(JTextField tfApellido) {
		this.tfApellido = tfApellido;
	}

	public JTextField getTfDesdeAmbientes() {
		return tfDesdeAmbientes;
	}

	public void setTfDesdeAmbientes(JTextField tfAmbientes) {
		this.tfDesdeAmbientes = tfAmbientes;
	}

	public JTextField getTfHastaAmbientes() {
		return tfHastaAmbientes;
	}

	public void setTfHastaAmbientes(JTextField tfAmbientes) {
		this.tfHastaAmbientes = tfAmbientes;
	}
	
	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfDesdeMetros() {
		return tfDesdeMetros;
	}

	public void setTfDesdeMetros(JTextField tfMetros) {
		this.tfDesdeMetros = tfMetros;
	}
	
	public JTextField getTfHastaMetros() {
		return tfHastaMetros;
	}

	public void setTfHastaMetros(JTextField tfMetros) {
		this.tfHastaMetros = tfMetros;
	}

	public JTextField getTfDesdePrecio() {
		return tfDesdePrecio;
	}

	public void setTfDesdePrecio(JTextField tfDesdePrecio) {
		this.tfDesdePrecio = tfDesdePrecio;
	}

	public JTextField getTfHastaPrecio() {
		return tfHastaPrecio;
	}

	public void setTfHastaPrecio(JTextField tfHastaPrecio) {
		this.tfHastaPrecio = tfHastaPrecio;
	}

	public JComboBox<String> getCbLocalidad() {
		return cbLocalidad;
	}

	public void setCbLocalidad(JComboBox<String> cbLocalidad) {
		this.cbLocalidad = cbLocalidad;
	}

	public JComboBox<String> getCbTipoOfrec() {
		return cbTipoOfrec;
	}

	public void setCbTipoOfrec(JComboBox<String> cbTipoOfrec) {
		this.cbTipoOfrec = cbTipoOfrec;
	}

	public JComboBox<String> getCbProvincia() {
		return cbProvincia;
	}

	public void setCbProvincia(JComboBox<String> cbProvincia) {
		this.cbProvincia = cbProvincia;
	}
	
	public ProvinciaComboBoxModel getComboModelProvincia() {
		return comboModelProvincia;
	}

	public LocalidadComboBoxModel getComboModelLocalidad() {
		return comboModelLocalidad;
	}
	
	public MonedaComboBoxModel getComboModelMoneda(){
		return comboModelMoneda;
	}

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	public JComboBox<String> getCbMoneda() {
		return cbMoneda;
	}
}
