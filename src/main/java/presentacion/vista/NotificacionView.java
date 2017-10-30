package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;

public class NotificacionView extends JPanel{
	private JLabel lblTitulo;
	public NotificacionView() {
		
		setSize(225, 75);
		setLayout(null);
		
		lblTitulo = new JLabel("Test");
		lblTitulo.setBounds(95, 11, 21, 14);
		add(lblTitulo);
		
	}
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

}
