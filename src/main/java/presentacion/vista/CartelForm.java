package presentacion.vista;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.swing.*;
import java.awt.*;

@Singleton
public class CartelForm extends JDialog{
	private JTextField textIdentificador;
	private JSpinner spinnerAlto;
	private JSpinner spinnerAncho;
	private JTextArea textDescripcion;
	private JButton btnAceptar;
	
	@Inject
	private CartelForm() {
		setTitle("Agregar cartel");
		getContentPane().setLayout(null);
		setModal(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(425, 300));
		
		JLabel lblIdentificador = new JLabel("Codigo: ");
		lblIdentificador.setBounds(30, 30, 50, 20);
		getContentPane().add(lblIdentificador);	

		JLabel lblAlto = new JLabel("Alto:");
		lblAlto.setBounds(30, 80, 40, 20);
		getContentPane().add(lblAlto);
		
		JLabel lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(200, 80, 50, 20);
		getContentPane().add(lblAncho);
		
		JLabel lblCmAlto = new JLabel("cm.");
		lblCmAlto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmAlto.setBounds(120, 80, 40, 20);
		getContentPane().add(lblCmAlto);

		JLabel lblCmAncho = new JLabel("cm.");
		lblCmAncho.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmAncho.setBounds(300, 80, 40, 20);
		getContentPane().add(lblCmAncho);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(30, 130, 80, 20);
		getContentPane().add(lblDescripcion);
		
		textIdentificador = new JTextField();
		textIdentificador.setBounds(80, 30, 150, 20);
		getContentPane().add(textIdentificador);
		textIdentificador.setColumns(10);

		spinnerAlto = new JSpinner();
		spinnerAlto.setModel(new SpinnerNumberModel(1, 1, 2147483647, 1));
		spinnerAlto.setBounds(70, 80, 50, 20);
		getContentPane().add(spinnerAlto);
		
		spinnerAncho = new JSpinner();
		spinnerAncho.setModel(new SpinnerNumberModel(1, 1, 2147483647, 1));
		spinnerAncho.setBounds(250, 80, 50, 20);
		getContentPane().add(spinnerAncho);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(159, 216, 89, 23);
		getContentPane().add(btnAceptar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 130, 220, 60);
		scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		getContentPane().add(scrollPane);
		
		textDescripcion = new JTextArea();
		textDescripcion.setLineWrap(true);
		scrollPane.setViewportView(textDescripcion);
		
	}

	public JTextField getTextIdentificador() {
		return textIdentificador;
	}
	
	public JTextArea getTextDescripcion() {
		return textDescripcion;
	}

	public JSpinner getSpinnerAlto() {
		return spinnerAlto;
	}

	public JSpinner getSpinnerAncho() {
		return spinnerAncho;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}
}
