package presentacion.vista.filtros;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import presentacion.combo.TipoCredencialComboBoxModel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

@Singleton
public class CuotaFiltroView extends JDialog{
	
	private JPanel panel;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JYearChooser desdeAnio;
	private JMonthChooser desdeMes;
	private JYearChooser hastaAnio;
	private JMonthChooser hastaMes;

	@Inject
	private CuotaFiltroView() {
		super();
		
		setTitle("Filtrar Cuotas");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(350, 250));
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(30, 161, 98, 29);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(214, 161, 98, 29);
		panel.add(btnCancelar);
		
		desdeAnio = new JYearChooser();
		desdeAnio.setBounds(229, 28, 63, 19);
		panel.add(desdeAnio);
		
		desdeMes = new JMonthChooser();
		desdeMes.setBounds(92, 28, 125, 19);
		panel.add(desdeMes);
		
		hastaAnio = new JYearChooser();
		hastaAnio.setBounds(229, 76, 63, 19);
		panel.add(hastaAnio);
		
		hastaMes = new JMonthChooser();
		hastaMes.setBounds(92, 76, 125, 19);
		panel.add(hastaMes);
		
		JLabel lblDesde = new JLabel("Desde: ");
		lblDesde.setBounds(27, 28, 70, 15);
		panel.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta: ");
		lblHasta.setBounds(27, 80, 70, 15);
		panel.add(lblHasta);
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JYearChooser getDesdeAnio() {
		return desdeAnio;
	}

	public JMonthChooser getDesdeMes() {
		return desdeMes;
	}

	public JYearChooser getHastaAnio() {
		return hastaAnio;
	}

	public JMonthChooser getHastaMes() {
		return hastaMes;
	}
}
