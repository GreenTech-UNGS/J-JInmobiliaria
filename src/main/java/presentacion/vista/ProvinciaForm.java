package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

import com.google.inject.Singleton;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;

@Singleton
public class ProvinciaForm extends JDialog{
	private JSpinner valorSpinner;
	private JComboBox<String> provinciaCombo;
	private JButton btnGuardar;
	
	public ProvinciaForm() {
		setTitle("Valores de Sellado");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setSize(450, 170);
		getContentPane().setLayout(null);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(51, 33, 64, 14);
		getContentPane().add(lblProvincia);
		
		provinciaCombo = new JComboBox<>();
		provinciaCombo.setBounds(147, 30, 152, 20);
		getContentPane().add(provinciaCombo);
		
		JLabel lblValorSellado = new JLabel("Valor sellado:");
		lblValorSellado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblValorSellado.setBounds(51, 58, 85, 14);
		getContentPane().add(lblValorSellado);
		
		valorSpinner = new JSpinner();
		valorSpinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(0.5)));
		valorSpinner.setBounds(146, 55, 47, 20);
		getContentPane().add(valorSpinner);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGuardar.setBounds(164, 107, 89, 23);
		getContentPane().add(btnGuardar);
	}

	public JSpinner getValorSpinner() {
		return valorSpinner;
	}

	public JComboBox<String> getProvinciaCombo() {
		return provinciaCombo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
