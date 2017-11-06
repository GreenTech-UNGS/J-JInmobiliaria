package presentacion.vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.google.inject.Inject;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class PrecontratoAlquilerForm extends JPanel{
	private JTextField tfPrecio;
	private JTextField tfMonto;
	
	@Inject
	private PrecontratoAlquilerForm(){
		super();
		
		this.setBounds(0, 0, 200, 75);
		this.setPreferredSize(new Dimension(404, 368));
		setLayout(null);
		
		
		JLabel lblDatosBsicos = new JLabel("Datos b\u00E1sicos:");
		lblDatosBsicos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosBsicos.setBounds(33, 30, 89, 14);
		add(lblDatosBsicos);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 57, 335, 2);
		add(separator);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(33, 70, 46, 14);
		add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(73, 67, 89, 17);
		add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(205, 70, 46, 14);
		add(lblMoneda);
		
		JLabel lblMeses = new JLabel("Meses:");
		lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMeses.setBounds(33, 95, 46, 14);
		add(lblMeses);
		
		JComboBox tfMoneda = new JComboBox();
		tfMoneda.setBounds(261, 67, 89, 20);
		add(tfMoneda);
		
		JCheckBox chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setBounds(202, 93, 97, 23);
		add(chckbxHabilitar);
		
		JLabel lblActualizacion = new JLabel("Actualizacion:");
		lblActualizacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblActualizacion.setBounds(33, 151, 89, 14);
		add(lblActualizacion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 176, 335, 2);
		add(separator_1);
		
		JLabel lblCada = new JLabel("Intervalo en meses:");
		lblCada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCada.setBounds(33, 189, 97, 14);
		add(lblCada);
		
		JSpinner spinnerIntervalo = new JSpinner();
		spinnerIntervalo.setBounds(133, 186, 29, 20);
		add(spinnerIntervalo);
		
		JCheckBox chckbxAcumulativo = new JCheckBox("Acumulativo");
		chckbxAcumulativo.setBounds(205, 185, 97, 23);
		add(chckbxAcumulativo);
		
		JLabel lblPorcentaje = new JLabel("Porcentaje:");
		lblPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPorcentaje.setBounds(33, 214, 69, 14);
		add(lblPorcentaje);
		
		JSpinner spinnerPorcentaje = new JSpinner();
		spinnerPorcentaje.setBounds(133, 211, 29, 20);
		add(spinnerPorcentaje);
		
		JLabel lblOtrosDatos = new JLabel("Otros gastos:");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(33, 262, 97, 14);
		add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(33, 287, 335, 2);
		add(separator_2);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMonto.setBounds(33, 300, 46, 14);
		add(lblMonto);
		
		tfMonto = new JTextField();
		tfMonto.setColumns(10);
		tfMonto.setBounds(73, 300, 89, 17);
		add(tfMonto);
		
		JLabel label = new JLabel("Moneda:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label.setBounds(205, 300, 46, 14);
		add(label);
		
		JComboBox cbMonedaMonto = new JComboBox();
		cbMonedaMonto.setBounds(261, 300, 89, 20);
		add(cbMonedaMonto);
		
		JSpinner spinnerMeses = new JSpinner();
		spinnerMeses.setBounds(73, 92, 29, 20);
		add(spinnerMeses);
	}
}
