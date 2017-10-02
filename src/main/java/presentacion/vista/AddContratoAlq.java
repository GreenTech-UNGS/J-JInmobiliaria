package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_6;
	private JTextField textField_11;
	private JTextField textField_12;
	
	@Inject
	private AddContratoAlq() {
		super();
		setTitle("Agregar Contrato");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(629, 554));
		setResizable(false);
		
		agregarContrato = new JPanel();
		agregarContrato.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(agregarContrato);
		agregarContrato.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id contrato:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(48, 50, 69, 14);
		agregarContrato.add(lblNewLabel);
		
		JLabel lblIdPropiedad = new JLabel("Id propiedad:");
		lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPropiedad.setBounds(48, 75, 75, 14);
		agregarContrato.add(lblIdPropiedad);
		
		JLabel lblNewLabel_1 = new JLabel("Dni inquilino:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(386, 50, 75, 14);
		agregarContrato.add(lblNewLabel_1);
		
		JLabel lblPrecio = new JLabel("Precio alquiler:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(42, 165, 75, 14);
		agregarContrato.add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(71, 215, 46, 14);
		agregarContrato.add(lblMoneda);
		
		JLabel lblInvervaloDeActualizacin = new JLabel("Invervalo actualizaci\u00F3n:");
		lblInvervaloDeActualizacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInvervaloDeActualizacin.setBounds(22, 240, 128, 14);
		agregarContrato.add(lblInvervaloDeActualizacin);
		
		JLabel lblPorcentajeDeActualizacin = new JLabel("Porcentaje actualizaci\u00F3n:");
		lblPorcentajeDeActualizacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPorcentajeDeActualizacin.setBounds(22, 265, 128, 14);
		agregarContrato.add(lblPorcentajeDeActualizacin);
		
		JLabel lblPorcentajeAcumulativo = new JLabel("Porcentaje acumulativo:");
		lblPorcentajeAcumulativo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPorcentajeAcumulativo.setBounds(22, 290, 128, 14);
		agregarContrato.add(lblPorcentajeAcumulativo);
		
		JLabel lblDatosPrimarios = new JLabel("Datos generales:");
		lblDatosPrimarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosPrimarios.setBounds(22, 11, 128, 14);
		agregarContrato.add(lblDatosPrimarios);
		
		JLabel lblDatosFinancieros = new JLabel("Datos financieros:");
		lblDatosFinancieros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosFinancieros.setBounds(22, 127, 142, 14);
		agregarContrato.add(lblDatosFinancieros);
		
		JLabel lblDaDeVencimiento = new JLabel("D\u00EDa de vencimiento:");
		lblDaDeVencimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDaDeVencimiento.setBounds(22, 190, 95, 14);
		agregarContrato.add(lblDaDeVencimiento);
		
		JLabel lblPorcentajeMontoPunitorio = new JLabel("Porcentaje monto punitorio:");
		lblPorcentajeMontoPunitorio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPorcentajeMontoPunitorio.setBounds(305, 190, 142, 14);
		agregarContrato.add(lblPorcentajeMontoPunitorio);
		
		JLabel lblMontoPunitorioAcumulativo = new JLabel("Monto punitorio acumulativo:");
		lblMontoPunitorioAcumulativo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMontoPunitorioAcumulativo.setBounds(305, 215, 142, 14);
		agregarContrato.add(lblMontoPunitorioAcumulativo);
		
		JLabel lblGastosAdministrativos = new JLabel("Gastos administrativos:");
		lblGastosAdministrativos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGastosAdministrativos.setBounds(329, 165, 120, 14);
		agregarContrato.add(lblGastosAdministrativos);
		
		JLabel lblGarantaDePago = new JLabel("Garant\u00EDa de pago:");
		lblGarantaDePago.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGarantaDePago.setBounds(361, 75, 100, 14);
		agregarContrato.add(lblGarantaDePago);
		
		textField = new JTextField();
		textField.setBounds(127, 48, 128, 17);
		agregarContrato.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(127, 73, 128, 17);
		agregarContrato.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(461, 48, 135, 17);
		agregarContrato.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(461, 73, 135, 17);
		agregarContrato.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(461, 188, 135, 17);
		agregarContrato.add(textField_4);
		textField_4.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(461, 214, 135, 17);
		agregarContrato.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setBounds(127, 163, 128, 17);
		agregarContrato.add(textField_5);
		textField_5.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(127, 214, 128, 17);
		agregarContrato.add(comboBox_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(127, 188, 128, 17);
		agregarContrato.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(145, 238, 110, 17);
		agregarContrato.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(145, 263, 110, 17);
		agregarContrato.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(145, 290, 110, 17);
		agregarContrato.add(textField_10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(461, 163, 135, 17);
		agregarContrato.add(textField_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 37, 574, 2);
		agregarContrato.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 152, 574, 2);
		agregarContrato.add(separator_1);
		
		JLabel lblAvisos = new JLabel("Avisos");
		lblAvisos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAvisos.setBounds(22, 335, 46, 14);
		agregarContrato.add(lblAvisos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(22, 360, 574, 2);
		agregarContrato.add(separator_2);
		
		JLabel lblNewLabel_2 = new JLabel("Mail de vencimiento:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(22, 376, 110, 14);
		agregarContrato.add(lblNewLabel_2);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(183, 399, 128, 17);
		agregarContrato.add(textField_11);
		
		JLabel lblMailIntimacinPor = new JLabel("Mail intimaci\u00F3n por vencimiento:");
		lblMailIntimacinPor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMailIntimacinPor.setBounds(22, 401, 151, 14);
		agregarContrato.add(lblMailIntimacinPor);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(127, 373, 184, 17);
		agregarContrato.add(textField_12);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(183, 453, 128, 38);
		agregarContrato.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(327, 453, 120, 38);
		agregarContrato.add(btnCancelar);

	}
}
