package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgregarPropiedad extends JDialog{

	private JPanel AgregarPropiedad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	@Inject
	private AgregarPropiedad() {
		super();
		
		setTitle("Agregar Propiedad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(574, 660));
		setResizable(false);
		
		AgregarPropiedad = new JPanel();
		AgregarPropiedad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AgregarPropiedad);
		AgregarPropiedad.setLayout(null);
	
		
		JLabel lblPropierario = new JLabel("Propietario:");
		lblPropierario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropierario.setBounds(331, 87, 61, 14);
		AgregarPropiedad.add(lblPropierario);
		
		JLabel lblDireccin = new JLabel("Calle:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccin.setBounds(54, 209, 46, 14);
		AgregarPropiedad.add(lblDireccin);
		
		JLabel lblNewLabel = new JLabel("Tipo de ofrecimiento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(282, 62, 110, 14);
		AgregarPropiedad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(331, 209, 61, 14);
		AgregarPropiedad.add(lblNewLabel_1);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(331, 237, 61, 14);
		AgregarPropiedad.add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(49, 234, 46, 14);
		AgregarPropiedad.add(lblAltura);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(54, 87, 46, 14);
		AgregarPropiedad.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(395, 206, 149, 20);
		AgregarPropiedad.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(395, 234, 149, 20);
		AgregarPropiedad.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 234, 149, 20);
		AgregarPropiedad.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 206, 149, 20);
		AgregarPropiedad.add(textField_3);
		textField_3.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(395, 59, 149, 20);
		AgregarPropiedad.add(comboBox);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(395, 87, 149, 20);
		AgregarPropiedad.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 87, 149, 20);
		AgregarPropiedad.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(149, 563, 135, 42);
		AgregarPropiedad.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(293, 563, 123, 42);
		AgregarPropiedad.add(btnCancelar);
		
		JLabel lblTipoDeMoneda = new JLabel("Tipo de moneda:");
		lblTipoDeMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoDeMoneda.setBounds(6, 112, 85, 14);
		AgregarPropiedad.add(lblTipoDeMoneda);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(92, 112, 149, 20);
		AgregarPropiedad.add(comboBox_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n privada:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcin.setBounds(20, 458, 110, 14);
		AgregarPropiedad.add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(20, 394, 524, 53);
		AgregarPropiedad.add(textArea);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(20, 24, 123, 14);
		AgregarPropiedad.add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 49, 524, 2);
		AgregarPropiedad.add(separator);
		
		JLabel lblIdPropiedad = new JLabel("Id propiedad:");
		lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPropiedad.setBounds(20, 62, 80, 14);
		AgregarPropiedad.add(lblIdPropiedad);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(92, 62, 149, 20);
		AgregarPropiedad.add(textField_5);
		
		JLabel lblDatosUbicacionales = new JLabel("Datos ubicacionales:");
		lblDatosUbicacionales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosUbicacionales.setBounds(20, 171, 123, 14);
		AgregarPropiedad.add(lblDatosUbicacionales);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 196, 524, 2);
		AgregarPropiedad.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Entrecalles:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(331, 262, 61, 14);
		AgregarPropiedad.add(lblNewLabel_2);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(395, 259, 149, 20);
		AgregarPropiedad.add(textField_6);
		
		JLabel lblInmobiliariaAmiga = new JLabel("Inmobiliaria amiga:");
		lblInmobiliariaAmiga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInmobiliariaAmiga.setBounds(296, 118, 96, 14);
		AgregarPropiedad.add(lblInmobiliariaAmiga);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(395, 118, 149, 20);
		AgregarPropiedad.add(comboBox_3);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(54, 262, 31, 14);
		AgregarPropiedad.add(lblPiso);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(92, 259, 149, 20);
		AgregarPropiedad.add(textField_7);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(20, 287, 75, 14);
		AgregarPropiedad.add(lblDepartamento);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(92, 284, 149, 20);
		AgregarPropiedad.add(textField_8);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(20, 338, 71, 14);
		AgregarPropiedad.add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 363, 524, 2);
		AgregarPropiedad.add(separator_2);
		
		JLabel lblDescripcinPblica = new JLabel("Descripci\u00F3n p\u00FAblica:");
		lblDescripcinPblica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcinPblica.setBounds(20, 374, 96, 14);
		AgregarPropiedad.add(lblDescripcinPblica);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(20, 480, 524, 53);
		AgregarPropiedad.add(textArea_1);
	}
}
