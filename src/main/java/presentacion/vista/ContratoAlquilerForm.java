package presentacion.vista;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.TipoContratoAlqComboBoxModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ContratoAlquilerForm extends JDialog {

	private JPanel agregarContrato;
	private JTextField textIdContrato;
	private JTextField tfIdPropiedad;
	private JTextField tfDniInquilino;
	private JTextField textPrecio;
	private JComboBox<String> comboMoneda;
	
	private JButton btnGuardarContrato;
	private JButton btnCancelarContrato;
	private JButton btnLupaPropiedad;
	private JSpinner spinnerDuracionContrato;
	private JComboBox<String> comboTipoContrato;
	private JButton btnLupaCliente;
	private JTextArea textGarantia;
	private JSpinner spinnerGastosAdmin;
	private JSpinner spinnerActualizaContrato;
	private JSpinner spinnerPorcenajeActualiza;
	private JCheckBox chckbxAcumulativoActualiza;
	private JSpinner spinnerTiempoPago;
	private JSpinner spinnerPorcentajePunitorio;
	private JCheckBox chkbxAcumulativoPunitorio;
	private JCheckBox chckbxVencimiento;
	private JSpinner spinnerVencimientoEmail;
	private JCheckBox chckbxIntimacion;
	private JSpinner spinnerIntimacionEmail;
	private JButton btnRenovarContrato;
	private JButton btnBorrador;
	private TipoContratoAlqComboBoxModel comboTipoContratoModel;
	private MonedaComboBoxModel monedaComboModel;
	
	
	public ContratoAlquilerForm() {
		super();
		setTitle("Agregar Contrato");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(630, 700));
		setResizable(false);
		setLocationRelativeTo(null);
		
		agregarContrato = new JPanel();
		agregarContrato.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(agregarContrato);
		agregarContrato.setLayout(null);
		
		JLabel lblIdContrato = new JLabel("Codigo:");
		lblIdContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdContrato.setBounds(22, 50, 75, 14);
		agregarContrato.add(lblIdContrato);
		
		JLabel lblIdPropiedad = new JLabel("Propiedad: ");
		lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPropiedad.setBounds(22, 75, 75, 14);
		agregarContrato.add(lblIdPropiedad);
		
		JLabel lblDniInq = new JLabel("Cliente:");
		lblDniInq.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDniInq.setBounds(350, 50, 75, 14);
		agregarContrato.add(lblDniInq);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(22, 210, 75, 14);
		agregarContrato.add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(22, 236, 65, 14);
		agregarContrato.add(lblMoneda);
		
		JLabel lblInvervaloAct = new JLabel("Cada:");
		lblInvervaloAct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInvervaloAct.setBounds(22, 318, 75, 14);
		agregarContrato.add(lblInvervaloAct);
		
		JLabel lblPjeAct = new JLabel("Porcentaje:");
		lblPjeAct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeAct.setBounds(22, 344, 75, 14);
		agregarContrato.add(lblPjeAct);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales:");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(22, 11, 128, 14);
		agregarContrato.add(lblDatosGenerales);
		
		JLabel lblDatosFinancieros = new JLabel("Datos financieros:");
		lblDatosFinancieros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosFinancieros.setBounds(22, 173, 142, 14);
		agregarContrato.add(lblDatosFinancieros);
		
		JLabel lblDiaVenc = new JLabel("Dia de vencimiento:");
		lblDiaVenc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDiaVenc.setBounds(22, 435, 128, 14);
		agregarContrato.add(lblDiaVenc);
		
		JLabel lblPjeMontoPun = new JLabel("Monto punitorio:");
		lblPjeMontoPun.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPjeMontoPun.setBounds(22, 466, 110, 14);
		agregarContrato.add(lblPjeMontoPun);
		
		JLabel lblGastos = new JLabel("Gastos administrativos:");
		lblGastos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGastos.setBounds(305, 211, 144, 14);
		agregarContrato.add(lblGastos);
		
		JLabel lblGaranta = new JLabel("Garantia:");
		lblGaranta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGaranta.setBounds(350, 76, 100, 14);
		agregarContrato.add(lblGaranta);
		
		JLabel lblMailVenc = new JLabel("Antes de:");
		lblMailVenc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMailVenc.setBounds(22, 575, 65, 14);
		agregarContrato.add(lblMailVenc);
		
		JLabel lblAvisos = new JLabel("Avisos");
		lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvisos.setBounds(22, 507, 46, 14);
		agregarContrato.add(lblAvisos);
		
		JLabel lblMailIntim = new JLabel("Antes de:");
		lblMailIntim.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMailIntim.setBounds(350, 575, 85, 14);
		agregarContrato.add(lblMailIntim);
		
		textIdContrato = new JTextField();
		textIdContrato.setBounds(102, 48, 167, 17);
		agregarContrato.add(textIdContrato);
		textIdContrato.setColumns(10);
		
		tfIdPropiedad = new JTextField();
		tfIdPropiedad.setEditable(false);
		tfIdPropiedad.setBounds(102, 75, 128, 19);
		agregarContrato.add(tfIdPropiedad);
		tfIdPropiedad.setColumns(10);
		
		tfDniInquilino = new JTextField();
		tfDniInquilino.setEditable(false);
		tfDniInquilino.setBounds(430, 48, 128, 17);
		agregarContrato.add(tfDniInquilino);
		tfDniInquilino.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(127, 209, 128, 17);
		agregarContrato.add(textPrecio);
		textPrecio.setColumns(10);
		
		this.comboMoneda = new JComboBox<>();
		comboMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboMoneda.setBounds(127, 234, 128, 17);
		agregarContrato.add(comboMoneda);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 37, 574, 2);
		agregarContrato.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 196, 574, 2);
		agregarContrato.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(22, 534, 574, 2);
		agregarContrato.add(separator_2);
		
		this.btnGuardarContrato = new JButton(" Guardar definitivo");
		btnGuardarContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardarContrato.setBounds(102, 625, 128, 38);
		agregarContrato.add(btnGuardarContrato);
		
		this.btnCancelarContrato = new JButton("Cancelar");
		btnCancelarContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelarContrato.setBounds(412, 625, 120, 38);
		agregarContrato.add(btnCancelarContrato);
		
		btnLupaPropiedad = new JButton("");
		btnLupaPropiedad.setBounds(234, 75, 35, 23);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnLupaPropiedad.setIcon(new ImageIcon(imgLup));
		agregarContrato.add(btnLupaPropiedad);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(430, 75, 166, 55);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		agregarContrato.add(scrollPane);
		
		textGarantia = new JTextArea();
		textGarantia.setLineWrap(true);
		scrollPane.setViewportView(textGarantia);
		
		btnLupaCliente = new JButton("");
		btnLupaCliente.setBounds(560, 48, 35, 23);
		btnLupaCliente.setIcon(new ImageIcon(imgLup));
		agregarContrato.add(btnLupaCliente);
		
		spinnerGastosAdmin = new JSpinner();
		spinnerGastosAdmin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerGastosAdmin.setModel(new SpinnerNumberModel(new Float(8), new Float(0), new Float(100), new Float(0.1)));
		spinnerGastosAdmin.setBounds(461, 207, 46, 20);
		agregarContrato.add(spinnerGastosAdmin);
		
		JLabel label = new JLabel("%");
		label.setBounds(513, 209, 22, 15);
		agregarContrato.add(label);
		
		JLabel lblTiempoDeAlquiler = new JLabel("Duracion:");
		lblTiempoDeAlquiler.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblTiempoDeAlquiler.setBounds(22, 102, 75, 15);
		agregarContrato.add(lblTiempoDeAlquiler);
		
		spinnerTiempoPago = new JSpinner();
		spinnerTiempoPago.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerTiempoPago.setModel(new SpinnerNumberModel(0, 0, 28, 1));
		spinnerTiempoPago.setBounds(142, 432, 45, 20);
		agregarContrato.add(spinnerTiempoPago);
		
		JLabel lblDias = new JLabel("Dias");
		lblDias.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDias.setBounds(205, 435, 70, 15);
		agregarContrato.add(lblDias);
		
		JLabel lblDatosPunitorios = new JLabel("Datos punitorios:");
		lblDatosPunitorios.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDatosPunitorios.setBounds(22, 384, 142, 14);
		agregarContrato.add(lblDatosPunitorios);
		
		JLabel lblDatosDeActualizacion = new JLabel("Datos de actualizacion del contrato:");
		lblDatosDeActualizacion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDatosDeActualizacion.setBounds(22, 278, 247, 14);
		agregarContrato.add(lblDatosDeActualizacion);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(22, 304, 574, 2);
		agregarContrato.add(separator_3);
		
		chckbxAcumulativoActualiza = new JCheckBox("Acumulativo");
		chckbxAcumulativoActualiza.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxAcumulativoActualiza.setVerticalAlignment(SwingConstants.TOP);
		chckbxAcumulativoActualiza.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxAcumulativoActualiza.setBounds(350, 313, 129, 23);
		agregarContrato.add(chckbxAcumulativoActualiza);
		
		spinnerActualizaContrato = new JSpinner();
		spinnerActualizaContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerActualizaContrato.setBounds(102, 315, 45, 20);
		spinnerActualizaContrato.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		agregarContrato.add(spinnerActualizaContrato);
		
		spinnerPorcenajeActualiza = new JSpinner();
		spinnerPorcenajeActualiza.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerPorcenajeActualiza.setBounds(102, 345, 45, 20);
		spinnerPorcenajeActualiza.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.1)));
		agregarContrato.add(spinnerPorcenajeActualiza);
		
		JLabel label_1 = new JLabel("%");
		label_1.setBounds(165, 347, 22, 15);
		agregarContrato.add(label_1);
		
		JLabel lblMeses = new JLabel("Meses");
		lblMeses.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblMeses.setBounds(166, 318, 56, 15);
		agregarContrato.add(lblMeses);
		
		spinnerDuracionContrato = new JSpinner();
		spinnerDuracionContrato.setBounds(102, 102, 45, 20);
		spinnerDuracionContrato.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		agregarContrato.add(spinnerDuracionContrato);
		
		JLabel label_2 = new JLabel("Meses");
		label_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_2.setBounds(152, 107, 56, 15);
		agregarContrato.add(label_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(22, 410, 574, 2);
		agregarContrato.add(separator_4);
		
		spinnerPorcentajePunitorio = new JSpinner();
		spinnerPorcentajePunitorio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerPorcentajePunitorio.setBounds(142, 461, 46, 20);
		spinnerPorcentajePunitorio.setModel(new SpinnerNumberModel(new Float(0.5), new Float(0), new Float(100), new Float(0.1)));
		agregarContrato.add(spinnerPorcentajePunitorio);
		
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(205, 465, 22, 15);
		agregarContrato.add(label_3);
		
		chkbxAcumulativoPunitorio = new JCheckBox("Acumulativo");
		chkbxAcumulativoPunitorio.setVerticalAlignment(SwingConstants.TOP);
		chkbxAcumulativoPunitorio.setHorizontalAlignment(SwingConstants.LEFT);
		chkbxAcumulativoPunitorio.setFont(new Font("Dialog", Font.PLAIN, 11));
		chkbxAcumulativoPunitorio.setBounds(350, 430, 129, 23);
		agregarContrato.add(chkbxAcumulativoPunitorio);
		
		comboTipoContrato = new JComboBox<>();
		comboTipoContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboTipoContrato.setBounds(102, 129, 167, 18);
		agregarContrato.add(comboTipoContrato);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblTipo.setBounds(22, 129, 75, 15);
		agregarContrato.add(lblTipo);
		
		chckbxVencimiento = new JCheckBox("Vencimiento");
		chckbxVencimiento.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxVencimiento.setBounds(22, 541, 129, 23);
		agregarContrato.add(chckbxVencimiento);
		
		chckbxIntimacion = new JCheckBox("Intimacion");
		chckbxIntimacion.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxIntimacion.setBounds(350, 541, 129, 23);
		agregarContrato.add(chckbxIntimacion);
		
		spinnerVencimientoEmail = new JSpinner();
		spinnerVencimientoEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		spinnerVencimientoEmail.setBounds(89, 572, 45, 20);
		spinnerVencimientoEmail.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		agregarContrato.add(spinnerVencimientoEmail);
		
		JLabel label_4 = new JLabel("Meses");
		label_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_4.setBounds(152, 574, 56, 15);
		agregarContrato.add(label_4);
		
		spinnerIntimacionEmail = new JSpinner();
		spinnerIntimacionEmail.setBounds(412, 572, 45, 20);
		spinnerIntimacionEmail.setModel(new SpinnerNumberModel(0, 0, 28, 1));
		agregarContrato.add(spinnerIntimacionEmail);
		
		JLabel label_5 = new JLabel("Dias");
		label_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		label_5.setBounds(475, 574, 70, 15);
		agregarContrato.add(label_5);
		
		btnRenovarContrato = new JButton("Renovar contrato");
		btnRenovarContrato.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRenovarContrato.setBounds(249, 629, 128, 30);
		agregarContrato.add(btnRenovarContrato);
		btnRenovarContrato.setVisible(false);
		
		comboTipoContratoModel = new TipoContratoAlqComboBoxModel();
		this.comboTipoContrato.setModel(comboTipoContratoModel);
		
		monedaComboModel = new MonedaComboBoxModel();
		this.comboMoneda.setModel(monedaComboModel);
		
		btnBorrador = new JButton("Guardar borrador");
		btnBorrador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrador.setBounds(259, 625, 128, 38);
		agregarContrato.add(btnBorrador);
		
		
	}


	public TipoContratoAlqComboBoxModel getComboTipoContratoModel() {
		return comboTipoContratoModel;
	}


	public JPanel getAgregarContrato() {
		return agregarContrato;
	}


	public JTextField getTextIdContrato() {
		return textIdContrato;
	}


	public JTextField getTfIdPropiedad() {
		return tfIdPropiedad;
	}


	public JTextField getTfDniInquilino() {
		return tfDniInquilino;
	}


	public JTextField getTextPrecio() {
		return textPrecio;
	}


	public JButton getBtnGuardarContrato() {
		return btnGuardarContrato;
	}


	public JButton getBtnCancelarContrato() {
		return btnCancelarContrato;
	}


	public JButton getBtnLupaPropiedad() {
		return btnLupaPropiedad;
	}


	public JSpinner getSpinnerDuracionContrato() {
		return spinnerDuracionContrato;
	}


	public JButton getBtnLupaCliente() {
		return btnLupaCliente;
	}


	public JTextArea getTextGarantia() {
		return textGarantia;
	}


	public JSpinner getSpinnerGastosAdmin() {
		return spinnerGastosAdmin;
	}


	public JSpinner getSpinnerActualizaContrato() {
		return spinnerActualizaContrato;
	}


	public JSpinner getSpinnerPorcenajeActualiza() {
		return spinnerPorcenajeActualiza;
	}


	public JCheckBox getChckbxAcumulativoActualiza() {
		return chckbxAcumulativoActualiza;
	}


	public JSpinner getSpinnerTiempoPago() {
		return spinnerTiempoPago;
	}


	public JSpinner getSpinnerPorcentajePunitorio() {
		return spinnerPorcentajePunitorio;
	}


	public JCheckBox getChkbxAcumulativoPunitorio() {
		return chkbxAcumulativoPunitorio;
	}


	public JCheckBox getChckbxVencimiento() {
		return chckbxVencimiento;
	}


	public JSpinner getSpinnerVencimientoEmail() {
		return spinnerVencimientoEmail;
	}


	public JCheckBox getChckbxIntimacion() {
		return chckbxIntimacion;
	}


	public JSpinner getSpinnerIntimacionEmail() {
		return spinnerIntimacionEmail;
	}


	public void setTextIdContrato(JTextField textIdContrato) {
		this.textIdContrato = textIdContrato;
	}


	public void setTfIdPropiedad(JTextField tfIdPropiedad) {
		this.tfIdPropiedad = tfIdPropiedad;
	}


	public void setTfDniInquilino(JTextField tfDniInquilino) {
		this.tfDniInquilino = tfDniInquilino;
	}


	public void setTextPrecio(JTextField textPrecio) {
		this.textPrecio = textPrecio;
	}

	public MonedaComboBoxModel getMonedaComboModel() {
		return monedaComboModel;
	}


	public void setTextGarantia(JTextArea textGarantia) {
		this.textGarantia = textGarantia;
	}


	public void setSpinnerDuracionContrato(JSpinner spinnerDuracionContrato) {
		this.spinnerDuracionContrato = spinnerDuracionContrato;
	}


	public JButton getBtnRenovarContrato() {
		return btnRenovarContrato;
	}


	public void setBtnRenovarContrato(JButton btnRenovarContrato) {
		this.btnRenovarContrato = btnRenovarContrato;
	}


	public JButton getBtnBorrador() {
		return btnBorrador;
	}
}
