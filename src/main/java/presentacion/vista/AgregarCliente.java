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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarCliente extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textNombre, textApellido, textMail, textCredencial;
	private JComboBox<String> comboCredencial;
	private JButton btnGuardar, btnCancelar, btnBuscar;
	private JTable tableTelefono;
	private JButton btnAgregarTelefono;
	private JButton btnBorrarTelefono;
	private JButton btnGuardarCambios;
	private JScrollPane tablePanel;

	@Inject
	private AgregarCliente() {
		super();
		
		setTitle("Agregar Cliente");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(350, 420));
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(30, 83, 80, 20);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(30, 114, 80, 20);
		panel.add(lblApellido);
		
		JLabel lblMail = new JLabel("Email:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMail.setBounds(30, 145, 80, 20);
		panel.add(lblMail);

		textNombre = new JTextField();
		textNombre.setBounds(100, 83, 212, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(100, 114, 212, 20);
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(100, 145, 212, 20);
		panel.add(textMail);
		textMail.setColumns(10);
		
		comboCredencial = new JComboBox<String>();
		comboCredencial.setBounds(31, 52, 61, 20);
		panel.add(comboCredencial);
		comboCredencial.addItem("DNI");
		comboCredencial.addItem("CUIT");
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(20, 330, 98, 29);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(226, 330, 98, 29);
		panel.add(btnCancelar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBuscar.setBounds(234, 21, 90, 20);
		panel.add(btnBuscar);
		
		textCredencial = new JTextField();
		textCredencial.setBounds(100, 52, 212, 20);
		panel.add(textCredencial);
		textCredencial.setColumns(10);
		
		tablePanel = new JScrollPane();
		tablePanel.setBounds(20, 201, 304, 83);
		panel.add(tablePanel);
		
		tableTelefono = new JTable();
		tablePanel.setViewportView(tableTelefono);
		
		btnAgregarTelefono = new JButton("Agregar Telefono");
		btnAgregarTelefono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAgregarTelefono.setBounds(201, 296, 123, 23);
		panel.add(btnAgregarTelefono);
		
		btnBorrarTelefono = new JButton("Borrar Telefono");
		btnBorrarTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnBorrarTelefono.setBounds(20, 296, 135, 23);
		panel.add(btnBorrarTelefono);
		
		btnGuardarCambios = new JButton("Guardar cambios");
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardarCambios.setBounds(113, 330, 123, 29);
		panel.add(btnGuardarCambios);
		btnGuardarCambios.setVisible(false);

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

	public JButton getBtnAgregarTelefono() {
		return btnAgregarTelefono;
	}

	public JTable getTableTelefono() {
		return tableTelefono;
	}

	public JButton getBtnBorrarTelefono() {
		return btnBorrarTelefono;
	}

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	public void setBtnGuardarCambios(JButton btnGuardarCambios) {
		this.btnGuardarCambios = btnGuardarCambios;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public void setTextMail(JTextField textMail) {
		this.textMail = textMail;
	}

	public void setTextCredencial(JTextField textCredencial) {
		this.textCredencial = textCredencial;
	}

	public JScrollPane getTablePanel() {
		return tablePanel;
	}

	public void setTablePanel(JScrollPane tablePanel) {
		this.tablePanel = tablePanel;
	}
	
	
}
