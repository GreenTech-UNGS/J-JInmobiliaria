package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCitaComboBoxModel;

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
	private JTextField tfMetros;
	private JTextField tfAmbientes;
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
	private JButton btnGuardarCambios;
	private JLabel lblMoneda;
	private JComboBox<String> comboBox;
	
	@Inject
	private InteresadoForm(){
		super();
		
		setTitle("Agregar interesado");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(419, 464));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		cbCredencial = new JComboBox();
		cbCredencial.setBounds(197, 69, 67, 20);
		getContentPane().add(cbCredencial);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosPersonales.setBounds(30, 31, 104, 14);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 56, 353, 2);
		getContentPane().add(separator);
		
		tfCredencial = new JTextField();
		tfCredencial.setBounds(274, 69, 109, 20);
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
		lblEmail.setBounds(197, 94, 46, 14);
		getContentPane().add(lblEmail);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(73, 69, 109, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(73, 91, 109, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(274, 91, 109, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 130, 353, 67);
		getContentPane().add(scrollPane);
		
		tableTel = new JTable();
		scrollPane.setColumnHeaderView(tableTel);
		
		btnAgregarTelefono = new JButton("Agregar telefono");
		btnAgregarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarTelefono.setBounds(73, 208, 115, 23);
		getContentPane().add(btnAgregarTelefono);
		
		btnBorrarTelefono = new JButton("Borrar telefono");
		btnBorrarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBorrarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrarTelefono.setBounds(224, 208, 115, 23);
		getContentPane().add(btnBorrarTelefono);
		
		JLabel lblPreferencias = new JLabel("Preferencias de propiedad");
		lblPreferencias.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreferencias.setBounds(30, 254, 158, 14);
		getContentPane().add(lblPreferencias);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 279, 353, 2);
		getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Localidad:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(217, 295, 60, 14);
		getContentPane().add(lblNewLabel);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(274, 292, 109, 20);
		getContentPane().add(cbLocalidad);
		
		JLabel lblMetros = new JLabel("Metros\u00B2:");
		lblMetros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMetros.setBounds(217, 339, 46, 14);
		getContentPane().add(lblMetros);
		
		tfMetros = new JTextField();
		tfMetros.setBounds(274, 336, 109, 20);
		getContentPane().add(tfMetros);
		tfMetros.setColumns(10);
		
		JLabel lblA = new JLabel("Ambientes:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblA.setBounds(217, 317, 60, 14);
		getContentPane().add(lblA);
		
		tfAmbientes = new JTextField();
		tfAmbientes.setColumns(10);
		tfAmbientes.setBounds(274, 314, 109, 20);
		getContentPane().add(tfAmbientes);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(19, 317, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDesde = new JLabel("Desde precio:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesde.setBounds(19, 339, 67, 14);
		getContentPane().add(lblDesde);
		
		tfDesdePrecio = new JTextField();
		tfDesdePrecio.setColumns(10);
		tfDesdePrecio.setBounds(84, 336, 104, 20);
		getContentPane().add(tfDesdePrecio);
		
		JLabel lblHasta = new JLabel("Hasta precio:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHasta.setBounds(19, 361, 67, 14);
		getContentPane().add(lblHasta);
		
		tfHastaPrecio = new JTextField();
		tfHastaPrecio.setBounds(84, 358, 104, 20);
		getContentPane().add(tfHastaPrecio);
		tfHastaPrecio.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(62, 395, 135, 31);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(224, 392, 136, 34);
		getContentPane().add(btnCancelar);
		
		cbTipoOfrec = new JComboBox();
		cbTipoOfrec.setBounds(84, 314, 104, 20);
		getContentPane().add(cbTipoOfrec);
		
		cbProvincia = new JComboBox();
		cbProvincia.setBounds(84, 292, 104, 20);
		getContentPane().add(cbProvincia);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		
		cbProvincia.setModel(comboModelProvincia);
		cbLocalidad.setModel(comboModelLocalidad);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(19, 292, 60, 14);
		getContentPane().add(lblProvincia);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardarCambios.setBounds(62, 395, 136, 31);
		getContentPane().add(btnGuardarCambios);
		
		lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(217, 364, 46, 14);
		getContentPane().add(lblMoneda);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(274, 358, 109, 20);
		getContentPane().add(comboBox);
		btnGuardarCambios.setVisible(false);
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

	public JTextField getTfAmbientes() {
		return tfAmbientes;
	}

	public void setTfAmbientes(JTextField tfAmbientes) {
		this.tfAmbientes = tfAmbientes;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfMetros() {
		return tfMetros;
	}

	public void setTfMetros(JTextField tfMetros) {
		this.tfMetros = tfMetros;
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

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}
	
	
	
}
