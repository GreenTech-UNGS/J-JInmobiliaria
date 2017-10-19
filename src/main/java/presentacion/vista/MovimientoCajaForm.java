package presentacion.vista;

import java.util.Date;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import presentacion.combo.MonedaComboBoxModel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;

@Singleton
public class MovimientoCajaForm extends JDialog{
	
	private JDateChooser dateChooser;
	private JTextField textMonto;
	private JComboBox<String> comboMoneda;
	private JTextArea textDetalle;
	private JButton btnGuardar;
	
	private MonedaComboBoxModel monedaModel;
	
	@Inject
	public MovimientoCajaForm() {
		setTitle("Registrar Movimiento de Caja");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setResizable(false);
		//setLocationRelativeTo(null);
		setSize(new Dimension(300, 250));
		
		setModal(true);
		
		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[]{0, 52, 114, 59, 0};
		gbl_mainPanel.rowHeights = new int[]{0, 19, 19, 72, 0};
		gbl_mainPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_mainPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		mainPanel.setLayout(gbl_mainPanel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 0;
		mainPanel.add(verticalStrut, gbc_verticalStrut);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 1;
		mainPanel.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblMonto = new JLabel("Monto: ");
		lblMonto.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMonto = new GridBagConstraints();
		gbc_lblMonto.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMonto.insets = new Insets(0, 0, 5, 5);
		gbc_lblMonto.gridx = 1;
		gbc_lblMonto.gridy = 1;
		mainPanel.add(lblMonto, gbc_lblMonto);
		
		textMonto = new JTextField();
		GridBagConstraints gbc_textMonto = new GridBagConstraints();
		gbc_textMonto.anchor = GridBagConstraints.NORTHWEST;
		gbc_textMonto.insets = new Insets(0, 0, 5, 5);
		gbc_textMonto.gridx = 2;
		gbc_textMonto.gridy = 1;
		mainPanel.add(textMonto, gbc_textMonto);
		textMonto.setColumns(10);
		
		comboMoneda = new JComboBox<>();
		GridBagConstraints gbc_comboMoneda = new GridBagConstraints();
		gbc_comboMoneda.fill = GridBagConstraints.BOTH;
		gbc_comboMoneda.insets = new Insets(0, 0, 5, 0);
		gbc_comboMoneda.gridx = 3;
		gbc_comboMoneda.gridy = 1;
		mainPanel.add(comboMoneda, gbc_comboMoneda);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 2;
		mainPanel.add(lblFecha, gbc_lblFecha);
		
		dateChooser = new JDateChooser(new Date());
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.anchor = GridBagConstraints.NORTH;
		gbc_dateChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 2;
		mainPanel.add(dateChooser, gbc_dateChooser);
		
		JLabel lblDetalle = new JLabel("Detalle: ");
		lblDetalle.setFont(new Font("Dialog", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDetalle = new GridBagConstraints();
		gbc_lblDetalle.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDetalle.insets = new Insets(0, 0, 0, 5);
		gbc_lblDetalle.gridx = 1;
		gbc_lblDetalle.gridy = 3;
		mainPanel.add(lblDetalle, gbc_lblDetalle);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		mainPanel.add(scrollPane, gbc_scrollPane);
		
		textDetalle = new JTextArea();
		scrollPane.setViewportView(textDetalle);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		btnGuardar = new JButton("Guardar");
		panel.add(btnGuardar);
		
		monedaModel = new MonedaComboBoxModel();
		comboMoneda.setModel(monedaModel);
		
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public JTextField getTextMonto() {
		return textMonto;
	}

	public JComboBox<String> getComboMoneda() {
		return comboMoneda;
	}

	public JTextArea getTextDetalle() {
		return textDetalle;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public MonedaComboBoxModel getMonedaModel() {
		return monedaModel;
	}
}
