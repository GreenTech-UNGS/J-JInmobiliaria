package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.RolComboBoxModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Singleton
public class UsuarioForm extends JDialog {
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfDni;
	private JTextField tfEmail;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox<String> cbRol;
	
	private RolComboBoxModel comboModel;
	private JButton btnGuardarCambios;
	
	@Inject
	public UsuarioForm(){
		super();
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		setTitle("Agregar Usuario");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(299, 319));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(49, 48, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(49, 73, 46, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblIdentificacin = new JLabel("Dni:");
		lblIdentificacin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdentificacin.setBounds(49, 98, 46, 14);
		getContentPane().add(lblIdentificacin);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(49, 123, 46, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblTipoDeUsuario = new JLabel("Rol:");
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoDeUsuario.setBounds(49, 148, 53, 14);
		getContentPane().add(lblTipoDeUsuario);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(105, 45, 135, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(105, 70, 135, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		tfDni = new JTextField();
		tfDni.setBounds(105, 95, 135, 20);
		getContentPane().add(tfDni);
		tfDni.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(105, 120, 135, 20);
		getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		cbRol = new JComboBox<String>();
		cbRol.setBounds(105, 145, 135, 20);
		getContentPane().add(cbRol);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAceptar.setBounds(33, 216, 121, 31);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(158, 216, 113, 31);
		getContentPane().add(btnCancelar);
		
		comboModel = new RolComboBoxModel();
		cbRol.setModel(comboModel);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(33, 216, 121, 31);
		getContentPane().add(btnGuardarCambios);
		btnGuardarCambios.setVisible(false);
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfApellido() {
		return tfApellido;
	}

	public JTextField getTfDni() {
		return tfDni;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public RolComboBoxModel getComboModel() {
		return comboModel;
	}

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	public JComboBox<String> getCbRol() {
		return cbRol;
	}
	
	
}
