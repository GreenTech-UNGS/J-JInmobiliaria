package presentacion.vista.filtros;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.swing.JButton;

@Singleton
public class ContratoAlquilerFiltroView extends JDialog{
	private JTextField textField;
	private JButton btnLupa;
	private JButton btnAceptar;
	
	@Inject
	private ContratoAlquilerFiltroView() {
		setTitle("Filtrar Contratos");
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		setLocationRelativeTo(null);
		setSize(new Dimension(350, 300));
		setModal(true);
		
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPropiedad = new JLabel("Propiedad: ");
		lblPropiedad.setBounds(31, 57, 72, 14);
		panel.add(lblPropiedad);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(100, 54, 149, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		btnLupa = new JButton("");
		btnLupa.setIcon(new ImageIcon(imgLup));
		btnLupa.setBounds(259, 54, 33, 23);
		panel.add(btnLupa);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(125, 213, 89, 23);
		panel.add(btnAceptar);
	}

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnLupa() {
		return btnLupa;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	
	
}
