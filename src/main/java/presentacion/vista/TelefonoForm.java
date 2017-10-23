package presentacion.vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@SuppressWarnings("serial")
@Singleton
public class TelefonoForm extends JDialog{
	private JTextField textTelefono;
	private JTextField textDescr;
	private JButton btnOk;
	private JComboBox<String> comboTipo;
	private JButton btnCancelar;
	private JLabel lblTipo;
	private JLabel lblNotas;
	private JPanel panel;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component verticalStrut;
	private Component horizontalStrut;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Inject
	private TelefonoForm() {
		setResizable(false);
		setTitle("Agregar Telefono");
		
		setModal(true);
		setSize(new Dimension(300, 200));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 30, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		setLocationRelativeTo(null);
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 3;
		gbc_verticalStrut.gridy = 0;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 1;
		gbc_lblTelefono.gridy = 1;
		getContentPane().add(lblTelefono, gbc_lblTelefono);
		
		textTelefono = new JTextField();
		GridBagConstraints gbc_textTelefono = new GridBagConstraints();
		gbc_textTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefono.gridx = 3;
		gbc_textTelefono.gridy = 1;
		getContentPane().add(textTelefono, gbc_textTelefono);
		textTelefono.setColumns(10);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		lblTipo = new JLabel("Tipo: ");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 1;
		gbc_lblTipo.gridy = 2;
		getContentPane().add(lblTipo, gbc_lblTipo);
		
		comboTipo = new JComboBox();
		GridBagConstraints gbc_comboTipo = new GridBagConstraints();
		gbc_comboTipo.insets = new Insets(0, 0, 5, 5);
		gbc_comboTipo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboTipo.gridx = 3;
		gbc_comboTipo.gridy = 2;
		getContentPane().add(comboTipo, gbc_comboTipo);
		
		lblNotas = new JLabel("Notas:");
		GridBagConstraints gbc_lblNotas = new GridBagConstraints();
		gbc_lblNotas.insets = new Insets(0, 0, 5, 5);
		gbc_lblNotas.gridx = 1;
		gbc_lblNotas.gridy = 3;
		getContentPane().add(lblNotas, gbc_lblNotas);
		
		textDescr = new JTextField();
		textDescr.setEnabled(false);
		GridBagConstraints gbc_textDescr = new GridBagConstraints();
		gbc_textDescr.insets = new Insets(0, 0, 5, 5);
		gbc_textDescr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDescr.gridx = 3;
		gbc_textDescr.gridy = 3;
		getContentPane().add(textDescr, gbc_textDescr);
		textDescr.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 4;
		getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
		
		btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar);
	}


	public JLabel getLblNotas() {
		return lblNotas;
	}
	
	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public JTextField getTextDescr() {
		return textDescr;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public JComboBox<String> getComboTipo() {
		return comboTipo;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

}
