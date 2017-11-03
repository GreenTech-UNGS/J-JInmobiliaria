package presentacion.vista.filtros;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Singleton
public class UsuarioFiltro extends JDialog{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	@Inject
	private UsuarioFiltro(){
		super();
		
		setTitle("Filtrar Usuarios");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(319, 250));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(49, 25, 65, 20);
		getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(124, 25, 138, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(49, 56, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(49, 81, 46, 14);
		getContentPane().add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(124, 53, 138, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(124, 78, 138, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Filtrar");
		btnNewButton.setBounds(74, 129, 89, 30);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(180, 129, 89, 30);
		getContentPane().add(btnCancelar);
	}
}
