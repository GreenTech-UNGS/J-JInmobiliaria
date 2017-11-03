package presentacion.main.vista;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;

@Singleton
public class LoginView {

	private JFrame loginFrame;
	private JTextField textUsuario;
	private JTextField textPass;
	private JButton btnLogin;
	private JButton btnRecuperarContrasea;
	
	@Inject
	private LoginView() {
		
		loginFrame = new JFrame("Login");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 112, 0, 0, 0, 0, 0, 10, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0 ,0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		loginFrame.getContentPane().setLayout(gridBagLayout);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loginFrame.setSize(450, 300);
		loginFrame.setResizable(false);
		loginFrame.setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 2;
		loginFrame.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.gridwidth = 5;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 2;
		gbc_textUsuario.gridy = 2;
		loginFrame.getContentPane().add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 4;
		loginFrame.getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		textPass = new JTextField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.gridwidth = 5;
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 2;
		gbc_textPass.gridy = 4;
		loginFrame.getContentPane().add(textPass, gbc_textPass);
		textPass.setColumns(10);
		
		btnRecuperarContrasea = new JButton("Recuperar contraseña");
		GridBagConstraints gbc_btnRecuperarContrasea = new GridBagConstraints();
		gbc_btnRecuperarContrasea.gridwidth = 2;
		gbc_btnRecuperarContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecuperarContrasea.gridx = 1;
		gbc_btnRecuperarContrasea.gridy = 6;
		loginFrame.getContentPane().add(btnRecuperarContrasea, gbc_btnRecuperarContrasea);
		
		btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 4;
		gbc_btnLogin.gridy = 6;
		loginFrame.getContentPane().add(btnLogin, gbc_btnLogin);
		
	}
	
	public void show() {
		this.loginFrame.setVisible(true);
	}

	public JFrame getLoginFrame() {
		return loginFrame;
	}

	public JTextField getTextUsuario() {
		return textUsuario;
	}

	public JTextField getTextPass() {
		return textPass;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void dispose() {
		this.loginFrame.dispose();
		
	}

	public JButton getBtnRecuperarContrasea() {
		return btnRecuperarContrasea;
	}
	
}
