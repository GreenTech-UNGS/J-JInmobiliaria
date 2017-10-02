package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

import entities.Telefono;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;

public class AgregarCliente extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textNombre, textApellido, textMail, textCredencial;
	private JComboBox<String> comboCredencial, comboTel1, comboTel2, comboTel3;
	private JButton btnGuardar, btnCancelar, btnBuscar;
	private JTextField textTelefono1, textTelefono2, textTelefono3;

	@Inject
	private AgregarCliente() {
		super();
		
		setTitle("Agregar Cliente");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(350, 420));
		setResizable(false);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 40, 80, 20);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 80, 80, 20);
		panel.add(lblApellido);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setBounds(20, 145, 80, 20);
		panel.add(lblMail);
		
		JLabel lblTelefono1 = new JLabel("Telefono 1:");
		lblTelefono1.setBounds(20, 210, 80, 20);
		panel.add(lblTelefono1);
		
		JLabel lblTelefono2 = new JLabel("Telefono 2:");
		lblTelefono2.setBounds(20, 240, 80, 20);
		panel.add(lblTelefono2);
		
		JLabel lblTelefono3 = new JLabel("Telefono 3:");
		lblTelefono3.setBounds(20, 270, 80, 20);
		panel.add(lblTelefono3);

		textNombre = new JTextField();
		textNombre.setBounds(100, 40, 200, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(100, 80, 200, 20);
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(100, 145, 200, 20);
		panel.add(textMail);
		textMail.setColumns(10);
		
		textTelefono1 = new JTextField();
		textTelefono1.setColumns(10);
		textTelefono1.setBounds(200, 210, 100, 20);
		panel.add(textTelefono1);
		
		textTelefono2 = new JTextField();
		textTelefono2.setColumns(10);
		textTelefono2.setBounds(200, 240, 100, 20);
		panel.add(textTelefono2);
		
		textTelefono3 = new JTextField();
		textTelefono3.setColumns(10);
		textTelefono3.setBounds(200, 270, 100, 20);
		panel.add(textTelefono3);
		
		comboCredencial = new JComboBox<String>();
		comboCredencial.setBounds(20, 114, 61, 20);
		panel.add(comboCredencial);
		comboCredencial.addItem("DNI");
		comboCredencial.addItem("CUIT");
		
		comboTel1 = new JComboBox<String>();
		comboTel1.setBounds(100, 210, 90, 20);
		panel.add(comboTel1);
		fillTipoTel(comboTel1);
		
		comboTel2 = new JComboBox<String>();
		comboTel2.setBounds(100, 240, 90, 20);
		panel.add(comboTel2);
		fillTipoTel(comboTel2);
		
		comboTel3 = new JComboBox<String>();
		comboTel3.setBounds(100, 270, 90, 20);
		panel.add(comboTel3);
		fillTipoTel(comboTel3);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(20, 330, 135, 42);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(189, 330, 123, 42);
		panel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(230, 9, 70, 20);
		panel.add(btnBuscar);
		
		textCredencial = new JTextField();
		textCredencial.setBounds(100, 114, 200, 20);
		panel.add(textCredencial);
		textCredencial.setColumns(10);

	}

	private void fillTipoTel(JComboBox<String> comboBox){
		
		//TODO: Pasar al Controlador
		Object[] tiposTel = Telefono.Tipo.values();
		for(int i = 0 ; i < tiposTel.length ; i ++){
			comboBox.addItem(tiposTel[i].toString());
		}
	}
	
	public JTextField getTextCredencial() {
		return textCredencial;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}
	
	public JTextField getTextApellido() {
		return textApellido;
	}

	public JTextField getTextMail() {
		return textMail;
	}

	public JComboBox<String> getComboCredencial() {
		return comboCredencial;
	}

	public JComboBox<String> getComboTel1() {
		return comboTel1;
	}

	public JComboBox<String> getComboTel2() {
		return comboTel2;
	}

	public JComboBox<String> getComboTel3() {
		return comboTel3;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JTextField getTextTelefono1() {
		return textTelefono1;
	}

	public JTextField getTextTelefono2() {
		return textTelefono2;
	}

	public JTextField getTextTelefono3() {
		return textTelefono3;
	}
}
