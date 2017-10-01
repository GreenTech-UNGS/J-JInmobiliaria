package vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class AgregarPropiedad extends JDialog{

	private JPanel AgregarPropiedad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	public AgregarPropiedad() {
		super();
		
		setTitle("Agregar Propiedad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(574, 329));
		setResizable(false);
		
		AgregarPropiedad = new JPanel();
		AgregarPropiedad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AgregarPropiedad);
		AgregarPropiedad.setLayout(null);
	
		
		JLabel lblPropierario = new JLabel("Propietario:");
		lblPropierario.setBounds(269, 53, 80, 14);
		AgregarPropiedad.add(lblPropierario);
		
		JLabel lblDireccin = new JLabel("Calle:");
		lblDireccin.setBounds(20, 28, 46, 14);
		AgregarPropiedad.add(lblDireccin);
		
		JLabel lblNewLabel = new JLabel("Tipo de ofrecimiento:");
		lblNewLabel.setBounds(269, 28, 110, 14);
		AgregarPropiedad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setBounds(20, 76, 61, 14);
		AgregarPropiedad.add(lblNewLabel_1);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(20, 101, 68, 14);
		AgregarPropiedad.add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(20, 53, 61, 14);
		AgregarPropiedad.add(lblAltura);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(269, 101, 46, 14);
		AgregarPropiedad.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(82, 25, 159, 20);
		AgregarPropiedad.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 50, 159, 20);
		AgregarPropiedad.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(82, 73, 159, 20);
		AgregarPropiedad.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(82, 98, 159, 20);
		AgregarPropiedad.add(textField_3);
		textField_3.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(385, 25, 159, 20);
		AgregarPropiedad.add(comboBox);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(385, 50, 159, 20);
		AgregarPropiedad.add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(385, 98, 159, 20);
		AgregarPropiedad.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(126, 242, 135, 42);
		AgregarPropiedad.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(295, 242, 123, 42);
		AgregarPropiedad.add(btnCancelar);
		
		JLabel lblTipoDeMoneda = new JLabel("Tipo de moneda:");
		lblTipoDeMoneda.setBounds(269, 78, 94, 14);
		AgregarPropiedad.add(lblTipoDeMoneda);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(385, 73, 159, 20);
		AgregarPropiedad.add(comboBox_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 154, 80, 14);
		AgregarPropiedad.add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(87, 149, 456, 70);
		AgregarPropiedad.add(textArea);
	}
	
	
}
