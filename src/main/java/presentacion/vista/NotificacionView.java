package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class NotificacionView extends JPanel{
	private JLabel lblTitulo;
	public NotificacionView() {
		setBorder(new LineBorder(new Color(0, 0, 255), 2));
		
		this.setBounds(0, 0, 200, 75);
		this.setBackground(new Color(0, 204, 255));
		this.setPreferredSize(new Dimension(200,75));
		setLayout(null);
		
		lblTitulo = new JLabel("Test");
		lblTitulo.setBounds(10, 11, 180, 14);
		add(lblTitulo);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(145, 41, 45, 23);
		add(btnOk);
		
	}
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

}
