package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import presentacion.combo.TipoHabitacionComboBoxModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import java.awt.Dimension;

import javax.swing.JButton;

@Singleton
public class HabitacionForm extends JDialog{
	private JTextField textObservaciones;
	private JSpinner spinnerLargo;
	private JSpinner spinnerAncho;
	private TipoHabitacionComboBoxModel comboModel;
	
	@Inject
	private HabitacionForm() {
		setTitle("Agregar habitacion");
		getContentPane().setLayout(null);
		setModal(true);
		setLocationRelativeTo(null);
		setSize(new Dimension(425, 300));
		
		JLabel lblNewLabel = new JLabel("Tipo: ");
		lblNewLabel.setBounds(35, 38, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblObservaciones = new JLabel("Observaciones: ");
		lblObservaciones.setBounds(35, 89, 82, 14);
		getContentPane().add(lblObservaciones);
		
		JLabel lblLargo = new JLabel("Largo:");
		lblLargo.setBounds(22, 151, 46, 14);
		getContentPane().add(lblLargo);
		
		JLabel lblAncho = new JLabel("Ancho:");
		lblAncho.setBounds(241, 148, 46, 14);
		getContentPane().add(lblAncho);
		
		JLabel lblMts = new JLabel("Mts.");
		lblMts.setBounds(122, 151, 46, 14);
		getContentPane().add(lblMts);
		
		JLabel label = new JLabel("Mts.");
		label.setBounds(348, 148, 46, 14);
		getContentPane().add(label);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(122, 35, 126, 20);
		getContentPane().add(comboBox);
		
		textObservaciones = new JTextField();
		textObservaciones.setBounds(127, 86, 209, 20);
		getContentPane().add(textObservaciones);
		textObservaciones.setColumns(10);
		
		spinnerLargo = new JSpinner();
		spinnerLargo.setBounds(71, 148, 46, 20);
		getContentPane().add(spinnerLargo);
		
		spinnerAncho = new JSpinner();
		spinnerAncho.setBounds(290, 145, 46, 20);
		getContentPane().add(spinnerAncho);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(159, 216, 89, 23);
		getContentPane().add(btnAceptar);
		
		comboModel = new TipoHabitacionComboBoxModel();
		comboBox.setModel(comboModel);
	}

	public JTextField getTextObservaciones() {
		return textObservaciones;
	}

	public JSpinner getSpinnerLargo() {
		return spinnerLargo;
	}

	public JSpinner getSpinnerAncho() {
		return spinnerAncho;
	}

	public TipoHabitacionComboBoxModel getComboModel() {
		return comboModel;
	}
}
