package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;

@Singleton
public class FotoView extends JDialog {
	private JLabel lblFoto;
	private JButton btnPortada;
	private JButton btnBorrarFoto;
	
	@Inject
	public FotoView() {
		setTitle("Visualizador de fotos");
		
		//setSize(1500, 900);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_3);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut);
		
		Component verticalGlue = Box.createVerticalGlue();
		panel_1.add(verticalGlue);
		
		lblFoto = new JLabel("");
		panel_1.add(lblFoto);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		panel_1.add(verticalGlue_1);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_1);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JPanel panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_1);
		
		btnPortada = new JButton("Seleccionar como portada");
		panelBotones.add(btnPortada);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_4);
		
		btnBorrarFoto = new JButton("Borrar Foto");
		panelBotones.add(btnBorrarFoto);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue);
		
	}


	public JLabel getLblFoto() {
		return lblFoto;
	}


	public JButton getBtnPortada() {
		return btnPortada;
	}


	public JButton getBtnBorrarFoto() {
		return btnBorrarFoto;
	}
	
	public void ajustarSize() {
		this.setLocationRelativeTo(null);
		this.pack();
		this.setLocationRelativeTo(null);
	}
	

}
