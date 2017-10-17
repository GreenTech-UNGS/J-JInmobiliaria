package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class InmobiliariaForm extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	@Inject
	private InmobiliariaForm(){
		super();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		setTitle("Agregar Inmobiliaria");	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(470, 470));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(47, 72, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblCuit = new JLabel("CUIT:");
		lblCuit.setBounds(47, 97, 46, 14);
		getContentPane().add(lblCuit);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(47, 122, 57, 14);
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
		lblEmail.setBounds(47, 147, 46, 14);
		getContentPane().add(lblEmail);
		
		textField = new JTextField();
		textField.setBounds(103, 144, 123, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 94, 123, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(103, 69, 123, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(296, 69, 123, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(296, 94, 123, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(296, 119, 123, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(296, 144, 123, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(103, 119, 123, 20);
		getContentPane().add(comboBox);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(47, 34, 105, 14);
		getContentPane().add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(47, 59, 372, 2);
		getContentPane().add(separator);
		
		JLabel lblTelefonos = new JLabel("Telefonos");
		lblTelefonos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefonos.setBounds(47, 187, 78, 14);
		getContentPane().add(lblTelefonos);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(47, 212, 372, 2);
		getContentPane().add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 225, 297, 56);
		getContentPane().add(scrollPane);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregar.setBounds(348, 225, 71, 23);
		getContentPane().add(btnAgregar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(348, 259, 71, 23);
		getContentPane().add(btnBorrar);
		
		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContactos.setBounds(47, 306, 78, 14);
		getContentPane().add(lblContactos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(47, 331, 372, 2);
		getContentPane().add(separator_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 344, 297, 56);
		getContentPane().add(scrollPane_1);
		
		JButton button = new JButton("Agregar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setBounds(348, 344, 71, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("Borrar");
		button_1.setBounds(348, 378, 71, 23);
		getContentPane().add(button_1);
	}
}
