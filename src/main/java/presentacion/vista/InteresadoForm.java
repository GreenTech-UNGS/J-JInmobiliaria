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
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfEmail;
	private JTable tableTel;
	private JTextField tfDesdeMetros;
	private JTextField tfDesdeAmbientes;
	private JTextField tfDesdePrecioVenta;
	private JTextField tfHastaPrecioVenta;
	private JTextField tfDesdePrecioAlquiler;
	private JTextField tfHastaPrecioAlquiler;
	private JButton btnAgregarTelefono;
	private JButton btnBorrarTelefono;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JComboBox<String> cbLocalidad;
	private JComboBox<String> cbTipoOfrec;
	private JComboBox<String> cbProvincia;
	
	private ProvinciaComboBoxModel comboModelProvincia;
	private LocalidadComboBoxModel comboModelLocalidad;
	private MonedaComboBoxModel comboModelMonedaVenta;
	private MonedaComboBoxModel comboModelMonedaAlquiler;
	private TipoOfrecimientoComboBoxModel comboModelOfrecimiento;
	private JButton btnGuardarCambios;
	private JLabel lblMonedaVenta;
	private JComboBox<String> cbMonedaVenta;
	private JComboBox<String> cbMonedaAlquiler;
	private JTextField tfHastaAmbientes;
	private JTextField tfHastaMetros;
	
	@Inject
	private InteresadoForm(){
		super();
		
		setTitle("Agregar interesado");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(473, 680));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblDatosPersonales = new JLabel("Datos personales");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosPersonales.setBounds(30, 31, 104, 14);
		getContentPane().add(lblDatosPersonales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 56, 405, 2);
		getContentPane().add(separator);
		
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
		lblEmail.setBounds(237, 69, 46, 14);
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
		tfEmail.setBounds(300, 69, 124, 20);
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
		lblNewLabel.setBounds(237, 290, 60, 14);
		getContentPane().add(lblNewLabel);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(300, 287, 124, 20);
		getContentPane().add(cbLocalidad);
		
		JLabel lblMetros = new JLabel("Desde metros\u00B2:");
		lblMetros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMetros.setBounds(30, 340, 87, 14);
		getContentPane().add(lblMetros);
		
		tfDesdeMetros = new JTextField();
		tfDesdeMetros.setBounds(108, 337, 98, 20);
		getContentPane().add(tfDesdeMetros);
		tfDesdeMetros.setColumns(10);
		
		JLabel lblA = new JLabel("Hasta ambientes:");
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblA.setBounds(237, 365, 104, 14);
		getContentPane().add(lblA);
		
		tfDesdeAmbientes = new JTextField();
		tfDesdeAmbientes.setColumns(10);
		tfDesdeAmbientes.setBounds(324, 337, 100, 20);
		getContentPane().add(tfDesdeAmbientes);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(30, 265, 46, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblDesdeVenta = new JLabel("Desde precio (venta):");
		lblDesdeVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesdeVenta.setBounds(30, 398, 127, 14);
		getContentPane().add(lblDesdeVenta);
		
		tfDesdePrecioVenta = new JTextField();
		tfDesdePrecioVenta.setColumns(10);
		tfDesdePrecioVenta.setBounds(30, 418, 124, 20);
		getContentPane().add(tfDesdePrecioVenta);
		
		JLabel lblHastaVenta = new JLabel("Hasta precio (venta):");
		lblHastaVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHastaVenta.setBounds(30, 454, 127, 14);
		getContentPane().add(lblHastaVenta);
		
		tfHastaPrecioVenta = new JTextField();
		tfHastaPrecioVenta.setBounds(30, 472, 124, 20);
		getContentPane().add(tfHastaPrecioVenta);
		tfHastaPrecioVenta.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardar.setBounds(93, 600, 135, 31);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.setBounds(237, 598, 136, 34);
		getContentPane().add(btnCancelar);
		
		cbTipoOfrec = new JComboBox();
		cbTipoOfrec.setBounds(93, 262, 124, 20);
		getContentPane().add(cbTipoOfrec);
		
		cbProvincia = new JComboBox();
		cbProvincia.setBounds(300, 262, 124, 20);
		getContentPane().add(cbProvincia);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		
		cbProvincia.setModel(comboModelProvincia);
		cbLocalidad.setModel(comboModelLocalidad);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(237, 265, 60, 14);
		getContentPane().add(lblProvincia);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGuardarCambios.setBounds(93, 600, 136, 31);
		getContentPane().add(btnGuardarCambios);
		
		lblMonedaVenta = new JLabel("Moneda (venta):");
		lblMonedaVenta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMonedaVenta.setBounds(30, 510, 127, 14);
		getContentPane().add(lblMonedaVenta);
		
		cbMonedaVenta = new JComboBox<String>();
		cbMonedaVenta.setBounds(30, 527, 124, 20);
		getContentPane().add(cbMonedaVenta);
		btnGuardarCambios.setVisible(false);
		
		comboModelMonedaVenta = new MonedaComboBoxModel();
		cbMonedaVenta.setModel(comboModelMonedaVenta);
		
		cbMonedaAlquiler = new JComboBox<String>();
		cbMonedaAlquiler.setBounds(230, 527, 124, 20);
		getContentPane().add(cbMonedaAlquiler);
		btnGuardarCambios.setVisible(false);
		
		comboModelMonedaAlquiler = new MonedaComboBoxModel();
		cbMonedaAlquiler.setModel(comboModelMonedaAlquiler);		
		
		JLabel lblHastaMetros = new JLabel("Hasta metros\u00B2:");
		lblHastaMetros.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHastaMetros.setBounds(30, 365, 78, 14);
		getContentPane().add(lblHastaMetros);
		
		JLabel lblDesdeAmbientes = new JLabel("Desde ambientes:");
		lblDesdeAmbientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesdeAmbientes.setBounds(237, 340, 87, 14);
		getContentPane().add(lblDesdeAmbientes);
		
		tfHastaAmbientes = new JTextField();
		tfHastaAmbientes.setBounds(324, 362, 100, 20);
		getContentPane().add(tfHastaAmbientes);
		tfHastaAmbientes.setColumns(10);
		
		tfHastaMetros = new JTextField();
		tfHastaMetros.setBounds(108, 362, 98, 20);
		getContentPane().add(tfHastaMetros);
		tfHastaMetros.setColumns(10);

		
		comboModelOfrecimiento = new TipoOfrecimientoComboBoxModel();
		cbTipoOfrec.setModel(comboModelOfrecimiento);
		
		JLabel lblDesdePrecioalquiler = new JLabel("Desde precio (alquiler):");
		lblDesdePrecioalquiler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesdePrecioalquiler.setBounds(230, 398, 127, 14);
		getContentPane().add(lblDesdePrecioalquiler);
		
		tfDesdePrecioAlquiler = new JTextField();
		tfDesdePrecioAlquiler.setColumns(10);
		tfDesdePrecioAlquiler.setBounds(230, 418, 124, 20);
		getContentPane().add(tfDesdePrecioAlquiler);
		
		JLabel lblHastaPrecioalquiler = new JLabel("Hasta precio (alquiler):");
		lblHastaPrecioalquiler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHastaPrecioalquiler.setBounds(230, 454, 127, 14);
		getContentPane().add(lblHastaPrecioalquiler);
		
		tfHastaPrecioAlquiler = new JTextField();
		tfHastaPrecioAlquiler.setColumns(10);
		tfHastaPrecioAlquiler.setBounds(230, 472, 124, 20);
		getContentPane().add(tfHastaPrecioAlquiler);
		
		JLabel lblMonedaalquiler = new JLabel("Moneda (alquiler):");
		lblMonedaalquiler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMonedaalquiler.setBounds(230, 510, 127, 14);
		getContentPane().add(lblMonedaalquiler);

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
	
	public JTextField getTfDesdePrecioVenta() {
		return tfDesdePrecioVenta;
	}

	public JTextField getTfHastaPrecioVenta() {
		return tfHastaPrecioVenta;
	}

	public JComboBox<String> getCbMonedaVenta() {
		return cbMonedaVenta;
	}

	public JTextField getTfDesdePrecioAlquiler() {
		return tfDesdePrecioAlquiler;
	}

	public JTextField getTfHastaPrecioAlquiler() {
		return tfHastaPrecioAlquiler;
	}

	public JComboBox<String> getCbMonedaAlquiler() {
		return cbMonedaAlquiler;
	}
	
	public ProvinciaComboBoxModel getComboModelProvincia() {
		return comboModelProvincia;
	}

	public LocalidadComboBoxModel getComboModelLocalidad() {
		return comboModelLocalidad;
	}
	
	public MonedaComboBoxModel getComboModelMonedaVenta(){
		return comboModelMonedaVenta;
	}
	
	public MonedaComboBoxModel getComboModelMonedaAlquiler(){
		return comboModelMonedaAlquiler;
	}

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

}
