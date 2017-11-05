package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
@Singleton
public class ContrasenaForm extends JDialog {
	private JPasswordField tfContActual;
	private JPasswordField tfNuevaCont;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	@Inject
	private ContrasenaForm(){
		setTitle("Cambiar contraseña");
		getContentPane().setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a actual:");
		lblContraseaActual.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContraseaActual.setBounds(47, 34, 92, 14);
		getContentPane().add(lblContraseaActual);
		
		JLabel lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNuevaContrasea.setBounds(47, 59, 92, 14);
		getContentPane().add(lblNuevaContrasea);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(68, 106, 101, 36);
		getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(179, 106, 101, 36);
		getContentPane().add(btnCancelar);
		
		tfContActual = new JPasswordField();
		tfContActual.setBounds(149, 31, 150, 20);
		getContentPane().add(tfContActual);
		tfContActual.setColumns(10);
		
		tfNuevaCont = new JPasswordField();
		tfNuevaCont.setBounds(149, 56, 150, 20);
		getContentPane().add(tfNuevaCont);
		tfNuevaCont.setColumns(10);
		setLocationRelativeTo(null);
		setModal(true);
		setSize(354, 194);
		setResizable(false);
	}

	public JTextField getTfContActual() {
		return tfContActual;
	}

	public JTextField getTfNuevaCont() {
		return tfNuevaCont;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
}
