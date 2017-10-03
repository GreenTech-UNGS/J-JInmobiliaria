package presentacion.vista;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddContratoAlq extends JDialog {

	private JPanel agregarContrato;
	private JTextField tfIdContrato;
	private JTextField tfIdPropiedad;
	private JTextField tfDniInquilino;
	private JTextField tfGarantia;
	private JTextField tfMontoPunitorio;
	private JTextField tfPrecio;
	private JTextField tfVencimiento;
	private JTextField tfIntervaloAct;
	private JTextField tfPorcenjateAct;
	private JTextField tfPjeAcumulativo;
	private JTextField tfGastos;
	private JTextField tfMailIntimat;
	private JTextField tfMailVenc;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cbMontoPunitorio;
	@SuppressWarnings("rawtypes")
	private JComboBox cbMoneda;
	
	private JButton btnGuardarContrato;
	private JButton btnCancelarContrato;
	
	
	@SuppressWarnings("rawtypes")
	public AddContratoAlq() {
		super();
		setTitle("Agregar Contrato");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(629, 554));
		setResizable(false);
		setLocationRelativeTo(null);
		
		agregarContrato = new JPanel();
		agregarContrato.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(agregarContrato);
		agregarContrato.setLayout(null);
		
		JLabel lblIdContrato = new JLabel("Id contrato:");
		lblIdContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdContrato.setBounds(48, 50, 69, 14);
		agregarContrato.add(lblIdContrato);
		
		JLabel lblIdPropiedad = new JLabel("Id propiedad:");
		lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPropiedad.setBounds(48, 75, 75, 14);
		agregarContrato.add(lblIdPropiedad);
		
		JLabel lblDniInq = new JLabel("Dni inquilino:");
		lblDniInq.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDniInq.setBounds(386, 50, 75, 14);
		agregarContrato.add(lblDniInq);
		
		JLabel lblPrecio = new JLabel("Precio alquiler:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(42, 165, 75, 14);
		agregarContrato.add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(71, 215, 46, 14);
		agregarContrato.add(lblMoneda);
		
		JLabel lblInvervaloAct = new JLabel("Invervalo actualizaci\u00F3n:");
		lblInvervaloAct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInvervaloAct.setBounds(22, 240, 128, 14);
		agregarContrato.add(lblInvervaloAct);
		
		JLabel lblPjeAct = new JLabel("Porcentaje actualizaci\u00F3n:");
		lblPjeAct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeAct.setBounds(22, 265, 128, 14);
		agregarContrato.add(lblPjeAct);
		
		JLabel lblPjeAcum = new JLabel("Porcentaje acumulativo:");
		lblPjeAcum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeAcum.setBounds(22, 290, 128, 14);
		agregarContrato.add(lblPjeAcum);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales:");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(22, 11, 128, 14);
		agregarContrato.add(lblDatosGenerales);
		
		JLabel lblDatosFinancieros = new JLabel("Datos financieros:");
		lblDatosFinancieros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosFinancieros.setBounds(22, 127, 142, 14);
		agregarContrato.add(lblDatosFinancieros);
		
		JLabel lblDiaVenc = new JLabel("D\u00EDa de vencimiento:");
		lblDiaVenc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDiaVenc.setBounds(22, 190, 95, 14);
		agregarContrato.add(lblDiaVenc);
		
		JLabel lblPjeMontoPun = new JLabel("Porcentaje monto punitorio:");
		lblPjeMontoPun.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeMontoPun.setBounds(305, 190, 142, 14);
		agregarContrato.add(lblPjeMontoPun);
		
		JLabel lblMontoPunitorio = new JLabel("Monto punitorio acumulativo:");
		lblMontoPunitorio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMontoPunitorio.setBounds(305, 215, 142, 14);
		agregarContrato.add(lblMontoPunitorio);
		
		JLabel lblGastos = new JLabel("Gastos administrativos:");
		lblGastos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGastos.setBounds(329, 165, 120, 14);
		agregarContrato.add(lblGastos);
		
		JLabel lblGaranta = new JLabel("Garant\u00EDa de pago:");
		lblGaranta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGaranta.setBounds(361, 75, 100, 14);
		agregarContrato.add(lblGaranta);
		
		JLabel lblMailVenc = new JLabel("Mail de vencimiento:");
		lblMailVenc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMailVenc.setBounds(22, 376, 110, 14);
		agregarContrato.add(lblMailVenc);
		
		JLabel lblAvisos = new JLabel("Avisos");
		lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvisos.setBounds(22, 335, 46, 14);
		agregarContrato.add(lblAvisos);
		
		JLabel lblMailIntim = new JLabel("Mail intimaci\u00F3n por vencimiento:");
		lblMailIntim.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMailIntim.setBounds(22, 401, 151, 14);
		agregarContrato.add(lblMailIntim);
		
		tfIdContrato = new JTextField();
		tfIdContrato.setBounds(127, 48, 128, 17);
		agregarContrato.add(tfIdContrato);
		tfIdContrato.setColumns(10);
		
		tfIdPropiedad = new JTextField();
		tfIdPropiedad.setBounds(127, 73, 128, 17);
		agregarContrato.add(tfIdPropiedad);
		tfIdPropiedad.setColumns(10);
		
		tfDniInquilino = new JTextField();
		tfDniInquilino.setBounds(461, 48, 135, 17);
		agregarContrato.add(tfDniInquilino);
		tfDniInquilino.setColumns(10);
		
		tfGarantia = new JTextField();
		tfGarantia.setBounds(461, 73, 135, 17);
		agregarContrato.add(tfGarantia);
		tfGarantia.setColumns(10);
		
		tfMontoPunitorio = new JTextField();
		tfMontoPunitorio.setBounds(461, 188, 135, 17);
		agregarContrato.add(tfMontoPunitorio);
		tfMontoPunitorio.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(127, 163, 128, 17);
		agregarContrato.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		tfVencimiento = new JTextField();
		tfVencimiento.setBounds(127, 188, 128, 17);
		agregarContrato.add(tfVencimiento);
		tfVencimiento.setColumns(10);
		
		tfIntervaloAct = new JTextField();
		tfIntervaloAct.setBounds(145, 238, 110, 17);
		agregarContrato.add(tfIntervaloAct);
		tfIntervaloAct.setColumns(10);
		
		tfPorcenjateAct = new JTextField();
		tfPorcenjateAct.setBounds(145, 263, 110, 17);
		agregarContrato.add(tfPorcenjateAct);
		tfPorcenjateAct.setColumns(10);
		
		tfPjeAcumulativo = new JTextField();
		tfPjeAcumulativo.setColumns(10);
		tfPjeAcumulativo.setBounds(145, 290, 110, 17);
		agregarContrato.add(tfPjeAcumulativo);
		
		tfGastos = new JTextField();
		tfGastos.setColumns(10);
		tfGastos.setBounds(461, 163, 135, 17);
		agregarContrato.add(tfGastos);
		
		tfMailIntimat = new JTextField();
		tfMailIntimat.setColumns(10);
		tfMailIntimat.setBounds(183, 399, 128, 17);
		agregarContrato.add(tfMailIntimat);
		
		tfMailVenc = new JTextField();
		tfMailVenc.setColumns(10);
		tfMailVenc.setBounds(127, 373, 184, 17);
		agregarContrato.add(tfMailVenc);
		
		this.cbMontoPunitorio = new JComboBox();
		cbMontoPunitorio.setBounds(461, 214, 135, 17);
		agregarContrato.add(cbMontoPunitorio);
		
		this.cbMoneda = new JComboBox();
		cbMoneda.setBounds(127, 214, 128, 17);
		agregarContrato.add(cbMoneda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 37, 574, 2);
		agregarContrato.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 152, 574, 2);
		agregarContrato.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(22, 360, 574, 2);
		agregarContrato.add(separator_2);
		
		this.btnGuardarContrato = new JButton("Guardar");
		btnGuardarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarContrato.setBounds(183, 453, 128, 38);
		agregarContrato.add(btnGuardarContrato);
		
		this.btnCancelarContrato = new JButton("Cancelar");
		btnCancelarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelarContrato.setBounds(327, 453, 120, 38);
		agregarContrato.add(btnCancelarContrato);
	}


	public JTextField getTfIdContrato() {
		return tfIdContrato;
	}


	public void setTfIdContrato(JTextField tfIdContrato) {
		this.tfIdContrato = tfIdContrato;
	}


	public JTextField getTfIdPropiedad() {
		return tfIdPropiedad;
	}


	public void setTfIdPropiedad(JTextField tfIdPropiedad) {
		this.tfIdPropiedad = tfIdPropiedad;
	}


	public JTextField getTfDniInquilino() {
		return tfDniInquilino;
	}


	public void setTfDniInquilino(JTextField tfDniInquilino) {
		this.tfDniInquilino = tfDniInquilino;
	}


	public JTextField getTfGarantia() {
		return tfGarantia;
	}


	public void setTfGarantia(JTextField tfGarantia) {
		this.tfGarantia = tfGarantia;
	}


	public JTextField getTfMontoPunitorio() {
		return tfMontoPunitorio;
	}


	public void setTfMontoPunitorio(JTextField tfMontoPunitorio) {
		this.tfMontoPunitorio = tfMontoPunitorio;
	}


	public JTextField getTfPrecio() {
		return tfPrecio;
	}


	public void setTfPrecio(JTextField tfPrecio) {
		this.tfPrecio = tfPrecio;
	}


	public JTextField getTfVencimiento() {
		return tfVencimiento;
	}


	public void setTfVencimiento(JTextField tfVencimiento) {
		this.tfVencimiento = tfVencimiento;
	}


	public JTextField getTfIntervaloAct() {
		return tfIntervaloAct;
	}


	public void setTfIntervaloAct(JTextField tfIntervaloAct) {
		this.tfIntervaloAct = tfIntervaloAct;
	}


	public JTextField getTfPorcenjateAct() {
		return tfPorcenjateAct;
	}


	public void setTfPorcenjateAct(JTextField tfPorcenjateAct) {
		this.tfPorcenjateAct = tfPorcenjateAct;
	}


	public JTextField getTfPjeAcumulativo() {
		return tfPjeAcumulativo;
	}


	public void setTfPjeAcumulativo(JTextField tfPjeAcumulativo) {
		this.tfPjeAcumulativo = tfPjeAcumulativo;
	}


	public JTextField getTfGastos() {
		return tfGastos;
	}


	public void setTfGastos(JTextField tfGastos) {
		this.tfGastos = tfGastos;
	}


	public JTextField getTfMailIntimat() {
		return tfMailIntimat;
	}


	public void setTfMailIntimat(JTextField tfMailIntimat) {
		this.tfMailIntimat = tfMailIntimat;
	}


	public JTextField getTfMailVenc() {
		return tfMailVenc;
	}


	public void setTfMailVenc(JTextField tfMailVenc) {
		this.tfMailVenc = tfMailVenc;
	}


	@SuppressWarnings("rawtypes")
	public JComboBox getCbMontoPunitorio() {
		return cbMontoPunitorio;
	}


	@SuppressWarnings("rawtypes")
	public void setCbMontoPunitorio(JComboBox cbMontoPunitorio) {
		this.cbMontoPunitorio = cbMontoPunitorio;
	}


	@SuppressWarnings("rawtypes")
	public JComboBox getCbMoneda() {
		return cbMoneda;
	}


	public void setCbMoneda(@SuppressWarnings("rawtypes") JComboBox cbMoneda) {
		this.cbMoneda = cbMoneda;
	}


	public JButton getBtnGuardarContrato() {
		return btnGuardarContrato;
	}


	public void setBtnGuardarContrato(JButton btnGuardarContrato) {
		this.btnGuardarContrato = btnGuardarContrato;
	}


	public JButton getBtnCancelarContrato() {
		return btnCancelarContrato;
	}


	public void setBtnCancelarContrato(JButton btnCancelarContrato) {
		this.btnCancelarContrato = btnCancelarContrato;
	}
	
	
}
