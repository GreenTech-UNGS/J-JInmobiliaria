package presentacion.vista.filtros;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Singleton;

import presentacion.combo.TipoCredencialComboBoxModel;

@Singleton
public class PropietarioFiltroView extends JDialog{
	
	private JPanel panel;
	private JTextField textNombre, textApellido, textCredencial;
	private JComboBox<String> comboCredencial;
	private JButton btnAceptar, btnCancelar;
	private TipoCredencialComboBoxModel tipoComboBox;
	
	public PropietarioFiltroView() {
		super();
		
		setTitle("Filtrar Propietarios");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(350, 250));
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

		textNombre = new JTextField();
		textNombre.setBounds(100, 83, 212, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(100, 114, 212, 20);
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		comboCredencial = new JComboBox<String>();
		comboCredencial.setBounds(31, 52, 61, 20);
		panel.add(comboCredencial);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(30, 161, 98, 29);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(214, 161, 98, 29);
		panel.add(btnCancelar);
		
		textCredencial = new JTextField();
		textCredencial.setBounds(100, 52, 212, 20);
		panel.add(textCredencial);
		textCredencial.setColumns(10);
		
		tipoComboBox = new TipoCredencialComboBoxModel();
		comboCredencial.setModel(tipoComboBox);
		
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public JTextField getTextCredencial() {
		return textCredencial;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public TipoCredencialComboBoxModel getTipoComboBox() {
		return tipoComboBox;
	}
}
