package presentacion.vista;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import com.google.inject.Singleton;

import presentacion.combo.MonedaComboBoxModel;

import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
@Singleton
public class ContratoVentaForm extends JDialog{
	
	private JTextField tfIdContrato;
	private JTextField tfCliente;
	private JTextField tfPropiedad;
	private JTextField tfPrecio;
	private JButton btnGuardarContVen;
	private JButton btnCancelarContVen;
	private JButton btnBuscarCliente;
	private JButton btnBuscarPropiedad;
	private JSpinner spinnerComprador;
	private JSpinner spinnerVendedor;
	private MonedaComboBoxModel monedaCombo;
	
	public ContratoVentaForm() {
		super();
		setTitle("Agregar contrato de venta");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(489, 419));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblIdContrato = new JLabel("Codigo:");
		lblIdContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdContrato.setBounds(27, 69, 68, 14);
		getContentPane().add(lblIdContrato);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCliente.setBounds(27, 94, 68, 14);
		getContentPane().add(lblCliente);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropiedad.setBounds(27, 119, 68, 14);
		getContentPane().add(lblPropiedad);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(256, 72, 45, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(256, 94, 77, 14);
		getContentPane().add(lblMoneda);

		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(27, 30, 108, 14);
		getContentPane().add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 56, 432, 2);
		getContentPane().add(separator);
		
		tfIdContrato = new JTextField();
		tfIdContrato.setBounds(92, 66, 127, 20);
		getContentPane().add(tfIdContrato);
		tfIdContrato.setColumns(10);
		
		tfCliente = new JTextField();
		tfCliente.setBounds(92, 91, 98, 20);
		getContentPane().add(tfCliente);
		tfCliente.setColumns(10);
		tfCliente.setEditable(false);
		
		tfPropiedad = new JTextField();
		tfPropiedad.setBounds(92, 116, 98, 20);
		getContentPane().add(tfPropiedad);
		tfPropiedad.setColumns(10);
		tfPropiedad.setEditable(false);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(332, 66, 127, 20);
		getContentPane().add(tfPrecio);
		tfPrecio.setEditable(false);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(27, 178, 80, 14);
		getContentPane().add(lblOtrosDatos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 203, 432, 2);
		getContentPane().add(separator_1);
		
		this.btnGuardarContVen = new JButton("Guardar");
		btnGuardarContVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarContVen.setBounds(118, 299, 113, 36);
		getContentPane().add(btnGuardarContVen);
		
		this.btnCancelarContVen = new JButton("Cancelar");
		btnCancelarContVen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelarContVen.setBounds(256, 299, 113, 36);
		getContentPane().add(btnCancelarContVen);
		
		btnBuscarPropiedad = new JButton("");
		btnBuscarPropiedad.setBounds(192, 115, 27, 23);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnBuscarPropiedad.setIcon(new ImageIcon(imgLup));
		getContentPane().add(btnBuscarPropiedad);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(192, 90, 27, 23);
		btnBuscarCliente.setIcon(new ImageIcon(imgLup));
		getContentPane().add(btnBuscarCliente);
		
		JComboBox<String> cbMoneda = new JComboBox<>();
		cbMoneda.setBounds(332, 88, 127, 24);
		getContentPane().add(cbMoneda);
		
		JLabel lblComisionComprador = new JLabel("Comision comprador:");
		lblComisionComprador.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblComisionComprador.setBounds(27, 216, 137, 15);
		getContentPane().add(lblComisionComprador);
		
		JLabel lblComisionVendedro = new JLabel("Comision vendedor:");
		lblComisionVendedro.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblComisionVendedro.setBounds(27, 243, 127, 15);
		getContentPane().add(lblComisionVendedro);
		
		spinnerComprador = new JSpinner();
		spinnerComprador.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.5)));
		spinnerComprador.setBounds(182, 213, 49, 20);
		getContentPane().add(spinnerComprador);
		
		spinnerVendedor = new JSpinner();
		spinnerVendedor.setBounds(182, 240, 49, 20);
		spinnerVendedor.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.5)));
		getContentPane().add(spinnerVendedor);
		
		monedaCombo = new MonedaComboBoxModel();
		cbMoneda.setModel(monedaCombo);

	}

	public JTextField getTfIdContrato() {
		return tfIdContrato;
	}

	public void setTfIdContrato(JTextField tfIdContrato) {
		this.tfIdContrato = tfIdContrato;
	}

	public JTextField getTfComprador() {
		return tfCliente;
	}

	public void setTfComprador(JTextField tfComprador) {
		this.tfCliente = tfComprador;
	}

	public JTextField getTfPropiedad() {
		return tfPropiedad;
	}

	public void setTfPropiedad(JTextField tfPropiedad) {
		this.tfPropiedad = tfPropiedad;
	}

	public JTextField getTfMonto() {
		return tfPrecio;
	}

	public void setTfMonto(JTextField tfMonto) {
		this.tfPrecio = tfMonto;
	}

	public JButton getBtnGuardarContVen() {
		return btnGuardarContVen;
	}

	public void setBtnGuardarContVen(JButton btnGuardarContVen) {
		this.btnGuardarContVen = btnGuardarContVen;
	}

	public JButton getBtnCancelarContVen() {
		return btnCancelarContVen;
	}

	public void setBtnCancelarContVen(JButton btnCancelarContVen) {
		this.btnCancelarContVen = btnCancelarContVen;
	}

	public JButton getBtnBuscarCliente() {
		return btnBuscarCliente;
	}

	public void setBtnBuscarCliente(JButton btnBuscarCliente) {
		this.btnBuscarCliente = btnBuscarCliente;
	}

	public JButton getBtnBuscarPropiedad() {
		return btnBuscarPropiedad;
	}

	public void setBtnBuscarPropiedad(JButton btnBuscarPropiedad) {
		this.btnBuscarPropiedad = btnBuscarPropiedad;
	}

	public JTextField getTfCliente() {
		return tfCliente;
	}

	public void setTfCliente(JTextField tfCliente) {
		this.tfCliente = tfCliente;
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public void setTfPrecio(JTextField tfPrecio) {
		this.tfPrecio = tfPrecio;
	}

	public JSpinner getSpinnerComprador() {
		return spinnerComprador;
	}

	public JSpinner getSpinnerVendedor() {
		return spinnerVendedor;
	}

	public MonedaComboBoxModel getMonedaCombo() {
		return monedaCombo;
	}
}
