package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.swing.SwingConstants;

import org.joda.time.DateTime;

@Singleton
public class GastoFijoForm extends JDialog{
	private JTextField textNombre;
	private JSpinner spinnerMonto;
	private JTextArea textDescripcion;
	private JButton btnAceptar;
	private JSpinner spinnerVencimiento;
	
	@Inject
	private GastoFijoForm() {
		setTitle("Agregar gasto fijo");
		getContentPane().setLayout(null);
		setModal(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(425, 290));
		
		JLabel lblNombre = new JLabel("Gasto:");
		lblNombre.setBounds(30, 30, 50, 20);
		getContentPane().add(lblNombre);	

		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(250, 70, 50, 20);
		getContentPane().add(lblMonto);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(30, 110, 80, 20);
		getContentPane().add(lblDescripcion);
		
		textNombre = new JTextField();
		textNombre.setBounds(110, 30, 240, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		spinnerMonto = new JSpinner();
		spinnerMonto.setModel(new SpinnerNumberModel(new Float(1), new Float(1), new Float(2147483647), new Float(1)));
		spinnerMonto.setBounds(300, 70, 50, 20);
		getContentPane().add(spinnerMonto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(158, 207, 90, 23);
		getContentPane().add(btnAceptar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 110, 240, 60);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		getContentPane().add(scrollPane);
		
		textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		
		spinnerVencimiento = new JSpinner();
		spinnerVencimiento.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(31), new Integer(1)));
		spinnerVencimiento.setBounds(110, 70, 40, 20);
		getContentPane().add(spinnerVencimiento);
		
		JLabel lblVto = new JLabel("Vencimiento:");
		lblVto.setBounds(30, 70, 80, 20);
		getContentPane().add(lblVto);
		
		JLabel lblMesVto = new JLabel("/ " + new DateTime().now().toString("MM"));
		lblMesVto.setBounds(158, 70, 40, 20);
		getContentPane().add(lblMesVto);
		
	}

	public JTextField getTextNombre() {
		return textNombre;
	}
	
	public JSpinner getTextVencimento() {
		return spinnerVencimiento;
	}
	
	public JTextArea getTextDescripcion() {
		return textDescripcion;
	}
	
	public JSpinner getSpinnerMonto() {
		return spinnerMonto;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
}
