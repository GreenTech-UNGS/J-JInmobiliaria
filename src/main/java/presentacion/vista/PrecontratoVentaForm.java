package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JPanel;

import com.google.inject.Inject;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class PrecontratoVentaForm extends JPanel{
	private JTextField tfComprador;
	private JTextField tfVendedor;
	private JTextField tfPrecio;
	
	@Inject 
	PrecontratoVentaForm(){
		
		super();
		
		this.setBounds(0, 0, 200, 75);
		this.setPreferredSize(new Dimension(376, 284));
		setLayout(null);
		
		JLabel lblComisiones = new JLabel("Datos generales");
		lblComisiones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComisiones.setBounds(32, 32, 106, 14);
		add(lblComisiones);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 58, 311, 14);
		add(separator);
		
		JLabel lblComprador = new JLabel("Comprador:");
		lblComprador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblComprador.setBounds(32, 71, 73, 14);
		add(lblComprador);
		
		tfComprador = new JTextField();
		tfComprador.setBounds(99, 68, 229, 20);
		add(tfComprador);
		tfComprador.setColumns(10);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblVendedor.setBounds(32, 96, 63, 14);
		add(lblVendedor);
		
		tfVendedor = new JTextField();
		tfVendedor.setColumns(10);
		tfVendedor.setBounds(99, 96, 229, 20);
		add(tfVendedor);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(32, 189, 46, 14);
		add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setColumns(10);
		tfPrecio.setBounds(79, 186, 86, 20);
		add(tfPrecio);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(196, 189, 46, 14);
		add(lblMoneda);
		
		JLabel lblComisiones_1 = new JLabel("Comisiones:");
		lblComisiones_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComisiones_1.setBounds(32, 151, 86, 14);
		add(lblComisiones_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 176, 311, 2);
		add(separator_1);
		
		JComboBox cbMoneda = new JComboBox();
		cbMoneda.setBounds(242, 186, 86, 20);
		add(cbMoneda);
		
		JCheckBox chckbxHabilitar = new JCheckBox("Habilitar");
		chckbxHabilitar.setBounds(32, 227, 97, 23);
		add(chckbxHabilitar);
		
	}

}
