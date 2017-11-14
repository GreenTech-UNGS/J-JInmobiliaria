package presentacion.vista.filtros;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import com.google.inject.Singleton;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Singleton
@SuppressWarnings("serial")
public class InmobiliariaFiltroView extends JDialog {
	private JTextField tfCuit;
	private JTextField tfNombre;
	
	private LocalidadComboBoxModel comboModelLocalidad;
	private ProvinciaComboBoxModel comboModelProvincia;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JComboBox cbProvincia;
	private JComboBox cbLocalidad;
	
	public InmobiliariaFiltroView(){
		
		super();
		
		setTitle("Filtrar inmobiliarias");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(336, 250));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblCuit = new JLabel("Cuit:");
		lblCuit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCuit.setBounds(51, 33, 46, 14);
		getContentPane().add(lblCuit);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(51, 58, 46, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(51, 83, 65, 14);
		getContentPane().add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(51, 109, 65, 14);
		getContentPane().add(lblLocalidad);
		
		tfCuit = new JTextField();
		tfCuit.setBounds(107, 30, 165, 20);
		getContentPane().add(tfCuit);
		tfCuit.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(107, 55, 165, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		cbProvincia = new JComboBox();
		cbProvincia.setBounds(107, 80, 165, 20);
		getContentPane().add(cbProvincia);
		
		cbLocalidad = new JComboBox();
		cbLocalidad.setBounds(107, 106, 165, 20);
		getContentPane().add(cbLocalidad);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAceptar.setBounds(51, 165, 106, 31);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(167, 165, 106, 31);
		getContentPane().add(btnCancelar);
		
		comboModelProvincia = new ProvinciaComboBoxModel();
		comboModelLocalidad = new LocalidadComboBoxModel();
		
		cbProvincia.setModel(comboModelProvincia);
		cbLocalidad.setModel(comboModelLocalidad);
	}

	public JTextField getTfCuit() {
		return tfCuit;
	}

	public void setTfCuit(JTextField tfCuit) {
		this.tfCuit = tfCuit;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public LocalidadComboBoxModel getComboModelLocalidad() {
		return comboModelLocalidad;
	}

	public void setComboModelLocalidad(LocalidadComboBoxModel comboModelLocalidad) {
		this.comboModelLocalidad = comboModelLocalidad;
	}

	public ProvinciaComboBoxModel getComboModelProvincia() {
		return comboModelProvincia;
	}

	public void setComboModelProvincia(ProvinciaComboBoxModel comboModelProvincia) {
		this.comboModelProvincia = comboModelProvincia;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JComboBox getCbProvincia() {
		return cbProvincia;
	}

	public void setCbProvincia(JComboBox cbProvincia) {
		this.cbProvincia = cbProvincia;
	}

	public JComboBox getCbLocalidad() {
		return cbLocalidad;
	}

	public void setCbLocalidad(JComboBox cbLocalidad) {
		this.cbLocalidad = cbLocalidad;
	}
	
	
}
