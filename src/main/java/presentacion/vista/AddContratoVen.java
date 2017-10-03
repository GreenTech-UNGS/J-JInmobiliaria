package presentacion.vista;

import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class AddContratoVen extends JDialog{
	private JTextField tfIdContrato;
	private JTextField tfComprador;
	private JTextField tfPropiedad;
	private JTextField tfMonto;
	private JTextField tfMoneda;
	private JTextField tfGastosAdm;
	private JTextField tfGarantia;
	
	private JButton btnAdjuntar;
	private JButton btnGuardarContVen;
	private JButton btnCancelarContVen;
	
	public AddContratoVen() {
		super();
		setTitle("Agregar contrato de venta");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(528, 460));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblIdContrato = new JLabel("Id contrato:");
		lblIdContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdContrato.setBounds(27, 69, 68, 14);
		getContentPane().add(lblIdContrato);
		
		JLabel lblComprador = new JLabel("Comprador:");
		lblComprador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComprador.setBounds(27, 94, 68, 14);
		getContentPane().add(lblComprador);
		
		JLabel lblPropiedad = new JLabel("Propiedad:");
		lblPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropiedad.setBounds(27, 119, 68, 14);
		getContentPane().add(lblPropiedad);
		
		JLabel lblMontoProp = new JLabel("Monto de propiedad:");
		lblMontoProp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMontoProp.setBounds(261, 69, 108, 14);
		getContentPane().add(lblMontoProp);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(323, 94, 46, 14);
		getContentPane().add(lblMoneda);
		
		JLabel lblPjeAdm = new JLabel("Porcentaje gastos administrativos:");
		lblPjeAdm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeAdm.setBounds(27, 216, 175, 14);
		getContentPane().add(lblPjeAdm);
		
		JLabel lblGarantia = new JLabel("Garant\u00EDa de pago:");
		lblGarantia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGarantia.setBounds(27, 241, 121, 14);
		getContentPane().add(lblGarantia);
		
		JLabel lblDocumentos = new JLabel("Documentos adjuntos:");
		lblDocumentos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDocumentos.setBounds(27, 269, 121, 14);
		getContentPane().add(lblDocumentos);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(27, 30, 108, 14);
		getContentPane().add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 55, 468, 3);
		getContentPane().add(separator);
		
		tfIdContrato = new JTextField();
		tfIdContrato.setBounds(92, 66, 127, 20);
		getContentPane().add(tfIdContrato);
		tfIdContrato.setColumns(10);
		
		tfComprador = new JTextField();
		tfComprador.setBounds(92, 91, 127, 20);
		getContentPane().add(tfComprador);
		tfComprador.setColumns(10);
		
		tfPropiedad = new JTextField();
		tfPropiedad.setBounds(92, 116, 127, 20);
		getContentPane().add(tfPropiedad);
		tfPropiedad.setColumns(10);
		
		tfMonto = new JTextField();
		tfMonto.setColumns(10);
		tfMonto.setBounds(368, 66, 127, 20);
		getContentPane().add(tfMonto);
		
		tfMoneda = new JTextField();
		tfMoneda.setColumns(10);
		tfMoneda.setBounds(368, 91, 127, 20);
		getContentPane().add(tfMoneda);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(27, 178, 80, 14);
		getContentPane().add(lblOtrosDatos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 203, 468, 2);
		getContentPane().add(separator_1);
		
		tfGastosAdm = new JTextField();
		tfGastosAdm.setColumns(10);
		tfGastosAdm.setBounds(200, 213, 127, 20);
		getContentPane().add(tfGastosAdm);
		
		tfGarantia = new JTextField();
		tfGarantia.setColumns(10);
		tfGarantia.setBounds(117, 238, 210, 20);
		getContentPane().add(tfGarantia);
		
		this.btnAdjuntar = new JButton("Adjuntar");
		btnAdjuntar.setBounds(144, 266, 89, 23);
		getContentPane().add(btnAdjuntar);
		
		this.btnGuardarContVen = new JButton("Guardar");
		btnGuardarContVen.setBounds(144, 359, 113, 36);
		getContentPane().add(btnGuardarContVen);
		
		this.btnCancelarContVen = new JButton("Cancelar");
		btnCancelarContVen.setBounds(286, 359, 113, 36);
		getContentPane().add(btnCancelarContVen);
		
	}

	public JTextField getTfIdContrato() {
		return tfIdContrato;
	}

	public void setTfIdContrato(JTextField tfIdContrato) {
		this.tfIdContrato = tfIdContrato;
	}

	public JTextField getTfComprador() {
		return tfComprador;
	}

	public void setTfComprador(JTextField tfComprador) {
		this.tfComprador = tfComprador;
	}

	public JTextField getTfPropiedad() {
		return tfPropiedad;
	}

	public void setTfPropiedad(JTextField tfPropiedad) {
		this.tfPropiedad = tfPropiedad;
	}

	public JTextField getTfMonto() {
		return tfMonto;
	}

	public void setTfMonto(JTextField tfMonto) {
		this.tfMonto = tfMonto;
	}

	public JTextField getTfMoneda() {
		return tfMoneda;
	}

	public void setTfMoneda(JTextField tfMoneda) {
		this.tfMoneda = tfMoneda;
	}

	public JTextField getTfGastosAdm() {
		return tfGastosAdm;
	}

	public void setTfGastosAdm(JTextField tfGastosAdm) {
		this.tfGastosAdm = tfGastosAdm;
	}

	public JTextField getTfGarantia() {
		return tfGarantia;
	}

	public void setTfGarantia(JTextField tfGarantia) {
		this.tfGarantia = tfGarantia;
	}

	public JButton getBtnAdjuntar() {
		return btnAdjuntar;
	}

	public void setBtnAdjuntar(JButton btnAdjuntar) {
		this.btnAdjuntar = btnAdjuntar;
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
	
	
}
