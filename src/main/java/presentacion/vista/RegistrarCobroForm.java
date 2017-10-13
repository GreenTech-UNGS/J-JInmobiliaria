package presentacion.vista;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;

@Singleton
public class RegistrarCobroForm extends JDialog{

	JDateChooser dateChooser;
	private JButton btnOk;
	private Component horizontalStrut;
	
	@Inject
	private RegistrarCobroForm() {
		setTitle("Registrar cobro de alquiler");
		setModal(true);
		setSize(new Dimension(300, 150));
		setResizable(false);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 136, 113, 0};
		gridBagLayout.rowHeights = new int[]{53, 15, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 1;
		getContentPane().add(dateChooser, gbc_dateChooser);
		
		btnOk = new JButton("Ok");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.anchor = GridBagConstraints.NORTH;
		gbc_btnOk.gridwidth = 2;
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 2;
		getContentPane().add(btnOk, gbc_btnOk);
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JButton getBtnOk() {
		return btnOk;
	}
}
