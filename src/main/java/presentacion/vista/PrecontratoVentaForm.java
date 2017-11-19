package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.MonedaComboBoxModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
@Singleton
public class PrecontratoVentaForm extends JPanel{
	private JTextField tfPrecio;
	private JCheckBox chckbxHabilitar;
	private JSpinner spinnerComprador;
	private JSpinner spinnerVendedor;
	private MonedaComboBoxModel monedaCombo;
	private JComboBox<String> cbMoneda;
	
	@Inject
	private PrecontratoVentaForm(){
		
		super();
		
		this.setPreferredSize(new Dimension(700, 170));
		setLayout(null);
		
		chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setBounds(32, 0, 65, 23);
		add(chckbxHabilitar);
		
		JLabel lblComisiones = new JLabel("Datos generales");
		lblComisiones.setBounds(32, 32, 92, 14);
		lblComisiones.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblComisiones);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 51, 657, 9);
		add(separator);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(32, 70, 41, 14);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(78, 65, 86, 20);
		tfPrecio.setColumns(10);
		add(tfPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(205, 70, 50, 14);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblMoneda);
		
		cbMoneda = new JComboBox<String>();
		cbMoneda.setBounds(260, 65, 96, 20);
		add(cbMoneda);
		
		JLabel lblComisiones_1 = new JLabel("Comisiones:");
		lblComisiones_1.setBounds(32, 95, 67, 14);
		lblComisiones_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblComisiones_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 115, 657, 2);
		add(separator_1);
		
		JLabel lblComprador = new JLabel("Comprador:");
		lblComprador.setBounds(32, 128, 57, 14);
		lblComprador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblComprador);
		
		spinnerComprador = new JSpinner();
		spinnerComprador.setBounds(108, 125, 47, 20);
		spinnerComprador.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
		add(spinnerComprador);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(205, 128, 50, 14);
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblVendedor);
		
		spinnerVendedor = new JSpinner();
		spinnerVendedor.setBounds(260, 125, 47, 20);
		spinnerVendedor.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(1)));
		add(spinnerVendedor);
		
		monedaCombo = new MonedaComboBoxModel();
		cbMoneda.setModel(monedaCombo);
		
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public JCheckBox getChckbxHabilitar() {
		return chckbxHabilitar;
	}

	public JSpinner getSpinnerComprador() {
		return spinnerComprador;
	}

	public JSpinner getSpinnerVendedor() {
		return spinnerVendedor;
	}

	public MonedaComboBoxModel getMonedaCombo() {
		return monedaCombo;
	}

	public JComboBox<String> getCbMoneda() {
		return cbMoneda;
	}

}
