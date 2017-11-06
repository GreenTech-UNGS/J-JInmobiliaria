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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Singleton
public class InteresadoFiltroView extends JDialog {
	
	private JPanel panel;
	private JTextField textNombre;
	private JComboBox<String> comboCredencial;
	private JButton btnAceptar, btnCancelar;
	private TipoCredencialComboBoxModel tipoComboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public InteresadoFiltroView(){
		
		super();
		setTitle("Filtrar interesados");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(420, 278));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Metros\u00B2:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(30, 83, 80, 20);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Tipo de");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(214, 139, 55, 20);
		panel.add(lblApellido);

		textNombre = new JTextField();
		textNombre.setBounds(100, 83, 98, 20);
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		comboCredencial = new JComboBox<String>();
		comboCredencial.setBounds(100, 52, 97, 20);
		panel.add(comboCredencial);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(65, 192, 98, 29);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(258, 192, 98, 29);
		panel.add(btnCancelar);
		
		tipoComboBox = new TipoCredencialComboBoxModel();
		comboCredencial.setModel(tipoComboBox);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(30, 55, 67, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(214, 58, 55, 14);
		panel.add(lblLocalidad);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(279, 52, 97, 20);
		panel.add(comboBox);
		
		JLabel lblAmbientes = new JLabel("Ambientes:");
		lblAmbientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAmbientes.setBounds(208, 86, 61, 14);
		panel.add(lblAmbientes);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(279, 83, 98, 20);
		panel.add(textField);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(278, 139, 98, 20);
		panel.add(comboBox_1);
		
		JLabel lblPrecioDesde = new JLabel("Precio desde:");
		lblPrecioDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecioDesde.setBounds(30, 114, 67, 14);
		panel.add(lblPrecioDesde);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 111, 98, 20);
		panel.add(textField_1);
		
		JLabel lblPrecioHasta = new JLabel("Precio hasta:");
		lblPrecioHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecioHasta.setBounds(214, 114, 67, 14);
		panel.add(lblPrecioHasta);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(279, 111, 98, 20);
		panel.add(textField_2);
		
		JLabel lblOfrecimiento = new JLabel("ofrecimiento:");
		lblOfrecimiento.setBounds(214, 156, 67, 14);
		panel.add(lblOfrecimiento);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(30, 142, 46, 14);
		panel.add(lblMoneda);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(100, 139, 97, 20);
		panel.add(comboBox_2);
		
	}

	public JTextField getTextNombre() {
		return textNombre;
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
