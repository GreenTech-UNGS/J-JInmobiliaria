package presentacion.vista;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class ContratoVentaForm extends JDialog{
	private JTextField tfIdContrato;
	private JTextField tfCliente;
	private JTextField tfPropiedad;
	private JTextField tfPrecio;
	private JTextField tfGarantia;
	private JButton btnGuardarContVen;
	private JButton btnCancelarContVen;
	private JButton btnBuscarCliente;
	private JButton btnBuscarPropiedad;
	private JTextField tfMoneda;
	private JSpinner spinnerPorcentaje;
	
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
		lblPrecio.setBounds(287, 69, 45, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(287, 94, 46, 14);
		getContentPane().add(lblMoneda);
		
		JLabel lblPjeAdm = new JLabel("Porcentaje gastos administrativos:");
		lblPjeAdm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeAdm.setBounds(27, 274, 175, 14);
		getContentPane().add(lblPjeAdm);
		
		JLabel lblGarantia = new JLabel("Garant\u00EDa de pago:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGarantia.setBounds(27, 216, 121, 14);
		getContentPane().add(lblGarantia);
		
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
		
		spinnerPorcentaje = new JSpinner();
		spinnerPorcentaje.setBounds(206, 271, 45, 20);
		getContentPane().add(spinnerPorcentaje);
		
		btnBuscarPropiedad = new JButton("");
		btnBuscarPropiedad.setBounds(192, 115, 27, 23);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnBuscarPropiedad.setIcon(new ImageIcon(imgLup));
		getContentPane().add(btnBuscarPropiedad);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.setBounds(192, 90, 27, 23);
		btnBuscarCliente.setIcon(new ImageIcon(imgLup));
		getContentPane().add(btnBuscarCliente);
		
		tfMoneda = new JTextField();
		tfMoneda.setBounds(332, 91, 127, 20);
		getContentPane().add(tfMoneda);
		tfMoneda.setColumns(10);
		tfMoneda.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 216, 334, 44);
		getContentPane().add(scrollPane);
		
		tfGarantia = new JTextField();
		scrollPane.setViewportView(tfGarantia);
		tfGarantia.setColumns(10);
		
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

	public JTextField getTfGarantia() {
		return tfGarantia;
	}

	public void setTfGarantia(JTextField tfGarantia) {
		this.tfGarantia = tfGarantia;
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

	public JTextField getTfMoneda() {
		return tfMoneda;
	}

	public void setTfMoneda(JTextField tfMoneda) {
		this.tfMoneda = tfMoneda;
	}

	public JSpinner getSpinnerPorcentaje() {
		return spinnerPorcentaje;
	}
}
