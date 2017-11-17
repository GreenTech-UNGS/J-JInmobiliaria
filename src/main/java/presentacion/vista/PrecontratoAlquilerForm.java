package presentacion.vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.MonedaComboBoxModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
@Singleton
public class PrecontratoAlquilerForm extends JPanel{
	private JTextField tfPrecio;
	private JTextField tfMonto;
	private JCheckBox chckbxHabilitar;
	private JSpinner spinnerMeses;
	private JSpinner spinnerIntervalo;
	private JSpinner spinnerPorcentaje;
	private JCheckBox chckbxAcumulativo;
	
	private MonedaComboBoxModel monedaBasico;
	private MonedaComboBoxModel monedaOtros;
	private JSpinner spinnerSellado;
	
	@Inject
	private PrecontratoAlquilerForm(){
		super();
		
		this.setPreferredSize(new Dimension(700, 260));
		setLayout(null);
		
		chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setBounds(33, 2, 96, 23);
		add(chckbxHabilitar);
		
		
		JLabel lblDatosBsicos = new JLabel("Datos b\u00E1sicos:");
		lblDatosBsicos.setBounds(33, 30, 81, 14);
		lblDatosBsicos.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblDatosBsicos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 49, 659, 2);
		add(separator);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(134, 56, 86, 20);
		add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(33, 59, 65, 14);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setBounds(265, 59, 56, 14);
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblMoneda);
		
		JComboBox<String> comboMonedaBasico = new JComboBox<>();
		comboMonedaBasico.setBounds(326, 56, 102, 20);
		add(comboMonedaBasico);
		
		JLabel lblMeses = new JLabel("Meses:");
		lblMeses.setBounds(446, 59, 53, 14);
		lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblMeses);
		
		spinnerMeses = new JSpinner();
		spinnerMeses.setBounds(504, 56, 48, 20);
		spinnerMeses.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		add(spinnerMeses);
		
		JLabel lblActualizacion = new JLabel("Actualizacion:");
		lblActualizacion.setBounds(33, 81, 96, 14);
		lblActualizacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblActualizacion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 105, 659, 2);
		add(separator_1);
		
		JLabel lblCada = new JLabel("Intervalo en meses:");
		lblCada.setBounds(33, 116, 96, 14);
		lblCada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblCada);
		
		spinnerIntervalo = new JSpinner();
		spinnerIntervalo.setBounds(147, 113, 48, 20);
		spinnerIntervalo.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		add(spinnerIntervalo);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setBounds(265, 116, 56, 14);
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblPorcentaje);
		
		spinnerPorcentaje = new JSpinner();
		spinnerPorcentaje.setBounds(326, 113, 47, 20);
		spinnerPorcentaje.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.5)));
		add(spinnerPorcentaje);
		
		chckbxAcumulativo = new JCheckBox("Acumulativo");
		chckbxAcumulativo.setBounds(433, 112, 119, 23);
		add(chckbxAcumulativo);
		
		JLabel lblOtrosDatos = new JLabel("Otros gastos:");
		lblOtrosDatos.setBounds(33, 140, 96, 14);
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(33, 159, 659, 2);
		add(separator_2);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(33, 169, 56, 17);
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(lblMonto);
		
		tfMonto = new JTextField();
		tfMonto.setBounds(134, 166, 86, 20);
		tfMonto.setColumns(10);
		add(tfMonto);
		
		JLabel label = new JLabel("Moneda:");
		label.setBounds(265, 166, 56, 14);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		add(label);
		
		JComboBox<String> cbMonedaOtros = new JComboBox<>();
		cbMonedaOtros.setBounds(326, 166, 102, 20);
		add(cbMonedaOtros);
		
		monedaBasico = new MonedaComboBoxModel();
		monedaOtros = new MonedaComboBoxModel();
		
		comboMonedaBasico.setModel(monedaBasico);
		cbMonedaOtros.setModel(monedaOtros);
		
		JLabel lblSellado = new JLabel("Sellado:");
		lblSellado.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblSellado.setBounds(33, 198, 70, 15);
		add(lblSellado);
		
		spinnerSellado = new JSpinner();
		spinnerSellado.setEnabled(true);
		spinnerSellado.setBounds(134, 195, 53, 20);
		spinnerSellado.setModel(new SpinnerNumberModel(new Float(0), new Float(0), new Float(100), new Float(0.5)));
		add(spinnerSellado);
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public JTextField getTfMonto() {
		return tfMonto;
	}

	public JCheckBox getChckbxHabilitar() {
		return chckbxHabilitar;
	}

	public JSpinner getSpinnerMeses() {
		return spinnerMeses;
	}

	public JSpinner getSpinnerIntervalo() {
		return spinnerIntervalo;
	}

	public JSpinner getSpinnerPorcentaje() {
		return spinnerPorcentaje;
	}

	public JCheckBox getChckbxAcumulativo() {
		return chckbxAcumulativo;
	}

	public MonedaComboBoxModel getMonedaBasico() {
		return monedaBasico;
	}

	public MonedaComboBoxModel getMonedaOtros() {
		return monedaOtros;
	}

	public JSpinner getSpinnerSellado() {
		return spinnerSellado;
	}
}
