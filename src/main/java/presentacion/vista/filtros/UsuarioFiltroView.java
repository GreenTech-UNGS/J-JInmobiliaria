package presentacion.vista.filtros;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.TipoCredencialComboBoxModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Singleton
public class UsuarioFiltroView extends JDialog{
	private JTextField tfCredencial;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox<String> cbTipoCredencial;
	private TipoCredencialComboBoxModel tipoComboBox;
	
	@Inject
	private UsuarioFiltroView(){
		super();
		
		setTitle("Filtrar Usuarios");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(319, 210));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		cbTipoCredencial = new JComboBox<String>();
		cbTipoCredencial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbTipoCredencial.setBounds(49, 25, 65, 20);
		getContentPane().add(cbTipoCredencial);
		
		tfCredencial = new JTextField();
		tfCredencial.setBounds(124, 25, 138, 20);
		getContentPane().add(tfCredencial);
		tfCredencial.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(49, 56, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(49, 81, 46, 14);
		getContentPane().add(lblApellido);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(124, 53, 138, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(124, 78, 138, 20);
		getContentPane().add(tfApellido);
		tfApellido.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(62, 129, 89, 30);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(161, 129, 89, 30);
		getContentPane().add(btnCancelar);
		
		tipoComboBox = new TipoCredencialComboBoxModel();
		cbTipoCredencial.setModel(tipoComboBox);
	}

	public JTextField getTfCredencial() {
		return tfCredencial;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public JTextField getTfApellido() {
		return tfApellido;
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
