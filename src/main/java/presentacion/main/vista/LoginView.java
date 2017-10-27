package presentacion.main.vista;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;

public class LoginView {

	private JFrame loginFrame;
	private JTextField textUsuario;
	private JTextField textPass;
	private JButton btnLogin;
	
	public LoginView() {
		
		loginFrame = new JFrame("Login");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		loginFrame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.WEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 3;
		gbc_lblUsuario.gridy = 2;
		loginFrame.getContentPane().add(lblUsuario, gbc_lblUsuario);
		
		textUsuario = new JTextField();
		GridBagConstraints gbc_textUsuario = new GridBagConstraints();
		gbc_textUsuario.gridwidth = 3;
		gbc_textUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsuario.gridx = 5;
		gbc_textUsuario.gridy = 2;
		loginFrame.getContentPane().add(textUsuario, gbc_textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.WEST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 3;
		gbc_lblContrasea.gridy = 4;
		loginFrame.getContentPane().add(lblContrasea, gbc_lblContrasea);
		
		textPass = new JTextField();
		GridBagConstraints gbc_textPass = new GridBagConstraints();
		gbc_textPass.gridwidth = 3;
		gbc_textPass.insets = new Insets(0, 0, 5, 5);
		gbc_textPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPass.gridx = 5;
		gbc_textPass.gridy = 4;
		loginFrame.getContentPane().add(textPass, gbc_textPass);
		textPass.setColumns(10);
		
		btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 8;
		loginFrame.getContentPane().add(btnLogin, gbc_btnLogin);
		
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
	
}
