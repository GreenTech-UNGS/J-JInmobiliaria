package presentacion.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;

@Singleton
public class RegistrarCobroForm extends JDialog{

	JDateChooser dateChooser;
	private JButton btnOk;
	private Component horizontalStrut;
	private JTextField textInteres;
	private JTextField textPropiedad;
	private JTextField textCliente;
	
	@Inject
	private RegistrarCobroForm() {
		setTitle("Registrar cobro de alquiler");
		setModal(true);
		setSize(new Dimension(450, 275));
		setResizable(false);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 136, 113, 0, 0};
		gridBagLayout.rowHeights = new int[]{53, 15, 23, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblFechaDelCobro = new JLabel("Fecha del cobro:");
		lblFechaDelCobro.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblFechaDelCobro = new GridBagConstraints();
		gbc_lblFechaDelCobro.anchor = GridBagConstraints.NORTH;
		gbc_lblFechaDelCobro.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFechaDelCobro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDelCobro.gridx = 1;
		gbc_lblFechaDelCobro.gridy = 1;
		getContentPane().add(lblFechaDelCobro, gbc_lblFechaDelCobro);
		
		dateChooser = new JDateChooser(new Date());
		
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 1;
		getContentPane().add(dateChooser, gbc_dateChooser);
		
		JLabel lblNewLabel = new JLabel("Interes: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textInteres = new JTextField();
		textInteres.setEditable(false);
		GridBagConstraints gbc_textInteres = new GridBagConstraints();
		gbc_textInteres.insets = new Insets(0, 0, 5, 5);
		gbc_textInteres.fill = GridBagConstraints.HORIZONTAL;
		gbc_textInteres.gridx = 2;
		gbc_textInteres.gridy = 3;
		getContentPane().add(textInteres, gbc_textInteres);
		textInteres.setColumns(10);
		
		JLabel lblPropiedad = new JLabel("Propiedad: ");
		GridBagConstraints gbc_lblPropiedad = new GridBagConstraints();
		gbc_lblPropiedad.anchor = GridBagConstraints.WEST;
		gbc_lblPropiedad.insets = new Insets(0, 0, 5, 5);
		gbc_lblPropiedad.gridx = 1;
		gbc_lblPropiedad.gridy = 4;
		getContentPane().add(lblPropiedad, gbc_lblPropiedad);
		
		textPropiedad = new JTextField();
		textPropiedad.setEditable(false);
		GridBagConstraints gbc_textPropiedad = new GridBagConstraints();
		gbc_textPropiedad.insets = new Insets(0, 0, 5, 5);
		gbc_textPropiedad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPropiedad.gridx = 2;
		gbc_textPropiedad.gridy = 4;
		getContentPane().add(textPropiedad, gbc_textPropiedad);
		textPropiedad.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente: ");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.WEST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 5;
		getContentPane().add(lblCliente, gbc_lblCliente);
		
		textCliente = new JTextField();
		textCliente.setEditable(false);
		GridBagConstraints gbc_textCliente = new GridBagConstraints();
		gbc_textCliente.insets = new Insets(0, 0, 5, 5);
		gbc_textCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCliente.gridx = 2;
		gbc_textCliente.gridy = 5;
		getContentPane().add(textCliente, gbc_textCliente);
		textCliente.setColumns(10);
		
		btnOk = new JButton("Ok");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 0, 5);
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.gridwidth = 2;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 7;
		getContentPane().add(btnOk, gbc_btnOk);
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public Component getHorizontalStrut() {
		return horizontalStrut;
	}

	public JTextField getTextInteres() {
		return textInteres;
	}

	public JTextField getTextPropiedad() {
		return textPropiedad;
	}

	public JTextField getTextCliente() {
		return textCliente;
	}
}
