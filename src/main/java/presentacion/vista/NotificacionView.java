package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class NotificacionView extends JPanel{
	private JLabel lblTitulo;
	private JButton btnOk;
	private JLabel lblDescripcion;
	public NotificacionView() {
		setBorder(new LineBorder(new Color(0, 0, 255), 2));
		
		this.setBounds(0, 0, 200, 75);
		this.setBackground(new Color(0, 204, 255));
		this.setPreferredSize(new Dimension(200, 125));
		setLayout(null);
		
		lblTitulo = new JLabel("Test");
		lblTitulo.setBounds(10, 11, 180, 14);
		add(lblTitulo);
		
		btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnOk.setBounds(77, 102, 53, 19);
		add(btnOk);
		
		lblDescripcion = new JLabel("descripcion");
		lblDescripcion.setBounds(12, 26, 178, 76);
		add(lblDescripcion);
		
	}
	public JLabel getLblTitulo() {
		return lblTitulo;
	}
	public JButton getBtnOk() {
		return btnOk;
	}
	public JLabel getLblDescripcion() {
		return lblDescripcion;
	}
}
