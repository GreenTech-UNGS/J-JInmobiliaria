package presentacion.vista;

import javax.swing.JDialog;

import com.google.inject.Singleton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;

@Singleton
public class GaleriaFotosView extends JDialog{
	private JLabel lblImagen1;
	private JLabel lblImagen2;
	private JLabel lblImagen3;
	private JLabel lblImagen4;
	private JLabel lblImagen5;
	private JLabel lblImagen6;
	private JLabel lblImagen7;
	private JLabel lblImagen8;
	private JLabel lblImagen9;
	private JButton btnPrev;
	private JButton btnProx;
	
	
	public GaleriaFotosView() {
		
		setModal(true);
		setSize(400, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblImagen1 = new JLabel("");
		GridBagConstraints gbc_lblImagen1 = new GridBagConstraints();
		gbc_lblImagen1.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen1.gridx = 0;
		gbc_lblImagen1.gridy = 0;
		panel.add(lblImagen1, gbc_lblImagen1);
		
		lblImagen2 = new JLabel("");
		GridBagConstraints gbc_lblImagen2 = new GridBagConstraints();
		gbc_lblImagen2.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen2.gridx = 2;
		gbc_lblImagen2.gridy = 0;
		panel.add(lblImagen2, gbc_lblImagen2);
		
		lblImagen3 = new JLabel("");
		GridBagConstraints gbc_lblImagen3 = new GridBagConstraints();
		gbc_lblImagen3.insets = new Insets(0, 0, 5, 0);
		gbc_lblImagen3.gridx = 4;
		gbc_lblImagen3.gridy = 0;
		panel.add(lblImagen3, gbc_lblImagen3);
		
		lblImagen4 = new JLabel("");
		GridBagConstraints gbc_lblImagen4 = new GridBagConstraints();
		gbc_lblImagen4.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen4.gridx = 0;
		gbc_lblImagen4.gridy = 2;
		panel.add(lblImagen4, gbc_lblImagen4);
		
		lblImagen5 = new JLabel("");
		GridBagConstraints gbc_lblImagen5 = new GridBagConstraints();
		gbc_lblImagen5.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen5.gridx = 2;
		gbc_lblImagen5.gridy = 2;
		panel.add(lblImagen5, gbc_lblImagen5);
		
		lblImagen6 = new JLabel("");
		GridBagConstraints gbc_lblImagen6 = new GridBagConstraints();
		gbc_lblImagen6.insets = new Insets(0, 0, 5, 0);
		gbc_lblImagen6.gridx = 4;
		gbc_lblImagen6.gridy = 2;
		panel.add(lblImagen6, gbc_lblImagen6);
		
		lblImagen7 = new JLabel("");
		GridBagConstraints gbc_lblImagen7 = new GridBagConstraints();
		gbc_lblImagen7.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen7.gridx = 0;
		gbc_lblImagen7.gridy = 4;
		panel.add(lblImagen7, gbc_lblImagen7);
		
		lblImagen8 = new JLabel("");
		GridBagConstraints gbc_lblImagen8 = new GridBagConstraints();
		gbc_lblImagen8.insets = new Insets(0, 0, 0, 5);
		gbc_lblImagen8.gridx = 2;
		gbc_lblImagen8.gridy = 4;
		panel.add(lblImagen8, gbc_lblImagen8);
		
		lblImagen9 = new JLabel("");
		GridBagConstraints gbc_lblImagen9 = new GridBagConstraints();
		gbc_lblImagen9.gridx = 4;
		gbc_lblImagen9.gridy = 4;
		panel.add(lblImagen9, gbc_lblImagen9);
		
		JPanel panelButtons = new JPanel();
		getContentPane().add(panelButtons);
		
		btnPrev = new JButton("<");
		panelButtons.add(btnPrev);
		
		btnProx = new JButton(">");
		panelButtons.add(btnProx);
		
	}


	public JLabel getLblImagen1() {
		return lblImagen1;
	}


	public JLabel getLblImagen2() {
		return lblImagen2;
	}


	public JButton getBtnPrev() {
		return btnPrev;
	}


	public JButton getBtnProx() {
		return btnProx;
	}
	
	public JLabel[] getImagesLabels(){
		
		return new JLabel[]{
			lblImagen1,
			lblImagen2,
			lblImagen3,
			lblImagen4,
			lblImagen5,
			lblImagen6,
			lblImagen7,
			lblImagen8,
			lblImagen9
			
		};
		
	}
	
	

}
