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
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AgregarCliente extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textNombre, textApellido, textMail, textCredencial;
	private JComboBox<String> comboCredencial;
	private JButton btnGuardar, btnCancelar, btnBuscar;
	private JTable table;

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
		
		comboCredencial = new JComboBox<String>();
		comboCredencial.setBounds(20, 114, 61, 20);
		panel.add(comboCredencial);
		comboCredencial.addItem("DNI");
		comboCredencial.addItem("CUIT");
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(20, 330, 135, 42);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(189, 330, 123, 42);
		panel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(210, 9, 90, 20);
		panel.add(btnBuscar);
		
		textCredencial = new JTextField();
		textCredencial.setBounds(100, 114, 200, 20);
		panel.add(textCredencial);
		textCredencial.setColumns(10);
		
		JScrollPane tablePanel = new JScrollPane();
		tablePanel.setBounds(20, 201, 304, 83);
		panel.add(tablePanel);
		
		table = new JTable();
		tablePanel.setViewportView(table);
		
		JButton btnAgregarTelefono = new JButton("Agregar Telefono");
		btnAgregarTelefono.setBounds(189, 295, 123, 23);
		panel.add(btnAgregarTelefono);

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


	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

}
