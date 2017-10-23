package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;

import entities.Localidad;
import entities.Provincia;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class InmobiliariaForm extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfEmail;
	private JTextField tfCuit;
	private JTextField tfNombre;
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JComboBox<String> cbLocalidad;
	private JComboBox<String> cbProvincia;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnGuardarCambios;
	private JTable tableTelefono;
	private JButton btnAgregarTel;
	private JButton btnBorrarTel;
	private JTable tableTel;
	
	@Inject
	private InmobiliariaForm(){
		super();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		setTitle("Agregar Inmobiliaria");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(470, 449));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(47, 72, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblCuit = new JLabel("CUIT:");
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCuit.setBounds(47, 97, 46, 14);
		getContentPane().add(lblCuit);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(47, 178, 57, 14);
		getContentPane().add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCalle.setBounds(260, 72, 46, 14);
		getContentPane().add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(260, 97, 46, 14);
		getContentPane().add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPiso.setBounds(260, 122, 46, 14);
		getContentPane().add(lblPiso);
		
		JLabel lblNewLabel = new JLabel("Depto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(260, 147, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(47, 122, 46, 14);
		getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(103, 119, 123, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfCuit = new JTextField();
		tfCuit.setBounds(103, 94, 123, 20);
		getContentPane().add(tfCuit);
		tfCuit.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(103, 69, 123, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(296, 69, 123, 20);
		getContentPane().add(tfCalle);
		tfCalle.setColumns(10);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(296, 94, 123, 20);
		getContentPane().add(tfAltura);
		tfAltura.setColumns(10);
		
		tfPiso = new JTextField();
		tfPiso.setBounds(296, 119, 123, 20);
		getContentPane().add(tfPiso);
		tfPiso.setColumns(10);
		
		tfDepto = new JTextField();
		tfDepto.setBounds(296, 144, 123, 20);
		getContentPane().add(tfDepto);
		tfDepto.setColumns(10);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(103, 175, 123, 20);
		getContentPane().add(cbLocalidad);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(47, 34, 105, 14);
		getContentPane().add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 59, 372, 2);
		getContentPane().add(separator);
		
		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefonos.setBounds(47, 220, 78, 14);
		getContentPane().add(lblTelefonos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(47, 245, 372, 2);
		getContentPane().add(separator_1);
		
		tableTelefono =new JTable();
		JScrollPane scrollPane = new JScrollPane(tableTelefono);
		scrollPane.setBounds(47, 258, 291, 56);
		getContentPane().add(scrollPane);
		
	
//		scrollPane.setColumnHeaderView(tableTelefono);
		
		btnAgregarTel = new JButton("Agregar");
		btnAgregarTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarTel.setBounds(341, 258, 78, 23);
		getContentPane().add(btnAgregarTel);
		
		btnBorrarTel = new JButton("Borrar");
		btnBorrarTel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBorrarTel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrarTel.setBounds(341, 291, 78, 23);
		getContentPane().add(btnBorrarTel);
		
		cbProvincia = new JComboBox<String>();
		cbProvincia.setBounds(103, 144, 123, 20);
		getContentPane().add(cbProvincia);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(121, 339, 105, 35);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(251, 339, 102, 35);
		getContentPane().add(btnCancelar);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(47, 147, 57, 14);
		getContentPane().add(lblProvincia);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(176, 339, 123, 35);
		getContentPane().add(btnGuardarCambios);
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfCuit() {
		return tfCuit;
	}

	public void setTfCuit(JTextField tfCuit) {
		this.tfCuit = tfCuit;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public void setTfCalle(JTextField tfCalle) {
		this.tfCalle = tfCalle;
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public void setTfAltura(JTextField tfAltura) {
		this.tfAltura = tfAltura;
	}

	public JTextField getTfPiso() {
		return tfPiso;
	}

	public void setTfPiso(JTextField tfPiso) {
		this.tfPiso = tfPiso;
	}

	public JTextField getTfDepto() {
		return tfDepto;
	}

	public void setTfDepto(JTextField tfDepto) {
		this.tfDepto = tfDepto;
	}

	public JComboBox<String> getCbLocalidad() {
		return cbLocalidad;
	}

	public void setCbLocalidad(JComboBox<String> cbLocalidad) {
		this.cbLocalidad = cbLocalidad;
	}

	public JComboBox<String> getCbProvincia() {
		return cbProvincia;
	}

	public void setCbProvincia(JComboBox<String> cbProvincia) {
		this.cbProvincia = cbProvincia;
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

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	public void setBtnGuardarCambios(JButton btnGuardarCambios) {
		this.btnGuardarCambios = btnGuardarCambios;
	}

	public JTable getTableTelefono() {
		return tableTelefono;
	}

	public void setTableTelefono(JTable tableTelefono) {
		this.tableTelefono = tableTelefono;
	}

	public JButton getBtnAgregarTel() {
		return btnAgregarTel;
	}

	public void setBtnAgregarTel(JButton btnAgregarTel) {
		this.btnAgregarTel = btnAgregarTel;
	}

	public JButton getBtnBorrarTel() {
		return btnBorrarTel;
	}

	public void setBtnBorrarTel(JButton btnBorrarTel) {
		this.btnBorrarTel = btnBorrarTel;
	}

	
}
