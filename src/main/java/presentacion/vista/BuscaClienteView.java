package presentacion.vista;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;

public class BuscaClienteView extends JDialog{
	private JTable tablePersonas;
	private JTextField textCredencial;
	private JTextField textNombre;
	private JTextField textApellido;
	public BuscaClienteView() {
		setTitle("Buscar Persona");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		Component glue_3 = Box.createGlue();
		panel.add(glue_3);
		
		JLabel lblDnicuit = new JLabel("Dni/CUIT:");
		panel.add(lblDnicuit);
		
		textCredencial = new JTextField();
		panel.add(textCredencial);
		textCredencial.setColumns(10);
		
		Component glue_1 = Box.createGlue();
		panel.add(glue_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		
		textNombre = new JTextField();
		panel.add(textNombre);
		textNombre.setColumns(10);
		
		Component glue_2 = Box.createGlue();
		panel.add(glue_2);
		
		JLabel lblApellido = new JLabel("Apellido");
		panel.add(lblApellido);
		
		textApellido = new JTextField();
		panel.add(textApellido);
		textApellido.setColumns(10);
		
		Component glue = Box.createGlue();
		panel.add(glue);
		
		JButton btnAplicar = new JButton("Aplicar");
		panel.add(btnAplicar);
		
		Component glue_4 = Box.createGlue();
		panel.add(glue_4);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		tablePersonas = new JTable();
		scrollPane.setViewportView(tablePersonas);
	}
	
	

}
