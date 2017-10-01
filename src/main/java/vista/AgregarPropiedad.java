package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class AgregarPropiedad {

	private JFrame frmAgregarPropiedad;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarPropiedad window = new AgregarPropiedad();
					window.frmAgregarPropiedad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AgregarPropiedad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgregarPropiedad = new JFrame();
		frmAgregarPropiedad.setResizable(false);
		frmAgregarPropiedad.setTitle("Agregar propiedad");
		frmAgregarPropiedad.setBounds(100, 100, 582, 329);
		frmAgregarPropiedad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarPropiedad.getContentPane().setLayout(null);
		
		JLabel lblPropierario = new JLabel("Propietario:");
		lblPropierario.setBounds(269, 53, 80, 14);
		frmAgregarPropiedad.getContentPane().add(lblPropierario);
		
		JLabel lblDireccin = new JLabel("Calle:");
		lblDireccin.setBounds(20, 28, 46, 14);
		frmAgregarPropiedad.getContentPane().add(lblDireccin);
		
		JLabel lblNewLabel = new JLabel("Tipo de ofrecimiento:");
		lblNewLabel.setBounds(269, 28, 110, 14);
		frmAgregarPropiedad.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setBounds(20, 76, 61, 14);
		frmAgregarPropiedad.getContentPane().add(lblNewLabel_1);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(20, 101, 68, 14);
		frmAgregarPropiedad.getContentPane().add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(20, 53, 61, 14);
		frmAgregarPropiedad.getContentPane().add(lblAltura);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(269, 101, 46, 14);
		frmAgregarPropiedad.getContentPane().add(lblPrecio);
		
		textField = new JTextField();
		textField.setBounds(82, 25, 159, 20);
		frmAgregarPropiedad.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(82, 50, 159, 20);
		frmAgregarPropiedad.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(82, 73, 159, 20);
		frmAgregarPropiedad.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(82, 98, 159, 20);
		frmAgregarPropiedad.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(385, 25, 159, 20);
		frmAgregarPropiedad.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(385, 50, 159, 20);
		frmAgregarPropiedad.getContentPane().add(comboBox_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(385, 98, 159, 20);
		frmAgregarPropiedad.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(126, 242, 135, 42);
		frmAgregarPropiedad.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(295, 242, 123, 42);
		frmAgregarPropiedad.getContentPane().add(btnCancelar);
		
		JLabel lblTipoDeMoneda = new JLabel("Tipo de moneda:");
		lblTipoDeMoneda.setBounds(269, 78, 94, 14);
		frmAgregarPropiedad.getContentPane().add(lblTipoDeMoneda);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(385, 73, 159, 20);
		frmAgregarPropiedad.getContentPane().add(comboBox_2);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n:");
		lblDescripcin.setBounds(10, 154, 80, 14);
		frmAgregarPropiedad.getContentPane().add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(87, 149, 456, 70);
		frmAgregarPropiedad.getContentPane().add(textArea);
	}
}
