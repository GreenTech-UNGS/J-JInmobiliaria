package presentacion.main.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MenuPanel extends JPanel{

	private JButton btnPropiedades;
	private JButton btnContratos;
	private JButton btnPersonas;
	private JButton btnPagos;
	private JButton btnInmobiliaria;
	private JButton btnCitas;
	private JButton btnHome;
	private Component glue;

	@Inject
	private MenuPanel() {
		this.setMaximumSize(new Dimension(200, 200));
		this.setMinimumSize(new Dimension(200, 200));
		this.setBackground(new Color(47, 79, 79));
		
		 this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Image imgProp = new ImageIcon(this.getClass().getResource("/props1.png")).getImage();

       
        btnHome = new JButton("");
        btnHome.setToolTipText("Escritorio");
        btnHome.setPreferredSize(new Dimension(70, 70));
        btnHome.setBackground(new Color(0, 51, 51));
        Image imgHome = new ImageIcon(this.getClass().getResource("/escritorio.png")).getImage();
        btnHome.setIcon(new ImageIcon(imgHome));
        this.add(btnHome);
        

        btnContratos = new JButton("");
        btnContratos.setToolTipText("Contratos");
        Image imgCon = new ImageIcon(this.getClass().getResource("/contratos1.png")).getImage();
        btnContratos.setIcon(new ImageIcon(imgCon));

        btnContratos.setPreferredSize(new Dimension(70, 70));
        btnContratos.setBackground(new Color(0, 51, 51));
		
		Component glue_95 = Box.createGlue();
		this.add(glue_95);
        
		 
		btnPropiedades = new JButton("");
		btnPropiedades.setToolTipText("Propiedades");
		btnPropiedades.setIcon(new ImageIcon(imgProp));
		
		btnPropiedades.setPreferredSize(new Dimension(70, 70));
		btnPropiedades.setBackground(new Color(0, 51, 51));
		this.add(btnPropiedades);
        
        Component glue_3 = Box.createGlue();
        this.add(glue_3);
        this.add(btnContratos);

        btnPersonas = new JButton("");
        btnPersonas.setToolTipText("Personas");

        Image imgInq = new ImageIcon(this.getClass().getResource("/clientes1.png")).getImage();
        btnPersonas.setIcon(new ImageIcon(imgInq));
        
        Component glue_4 = Box.createGlue();
        this.add(glue_4);
        btnPersonas.setPreferredSize(new Dimension(70, 70));
        btnPersonas.setBackground(new Color(0, 51, 51));
        this.add(btnPersonas);

        this.btnPagos = new JButton("");
        btnPagos.setToolTipText("Pagos");

        Image imgPago = new ImageIcon(this.getClass().getResource("/pagos1.png")).getImage();
        btnPagos.setIcon(new ImageIcon(imgPago));
        
        Component glue_5 = Box.createGlue();
        this.add(glue_5);
        btnPagos.setPreferredSize(new Dimension(70, 70));
        btnPagos.setBackground(new Color(0, 51, 51));
        this.add(btnPagos);

        btnCitas = new JButton("");
        btnCitas.setToolTipText("Citas");
        Image imgRep = new ImageIcon(this.getClass().getResource("/reunion.png")).getImage();
        
        Component glue_6 = Box.createGlue();
        this.add(glue_6);
        btnCitas.setIcon(new ImageIcon(imgRep));
        btnCitas.setPreferredSize(new Dimension(70, 70));
        btnCitas.setBackground(new Color(0, 51, 51));
        this.add(btnCitas);
        
        btnInmobiliaria = new JButton("");
        btnInmobiliaria.setToolTipText("Inmobiliarias");
        Image imgInm = new ImageIcon(this.getClass().getResource("/inmobiliarias1.png")).getImage();
        
        Component glue_7 = Box.createGlue();
        this.add(glue_7);
        btnInmobiliaria.setIcon(new ImageIcon(imgInm));
        btnInmobiliaria.setPreferredSize(new Dimension(70, 70));
        btnInmobiliaria.setBackground(new Color(0, 51, 51));
        this.add(btnInmobiliaria);
	}

	public JButton getBtnPropiedades() {
		return btnPropiedades;
	}

	public JButton getBtnContratos() {
		return btnContratos;
	}

	public JButton getBtnInquilinos() {
		return btnPersonas;
	}

	public JButton getBtnPagos() {
		return btnPagos;
	}

	public JButton getBtnInmobiliaria() {
		return btnInmobiliaria;
	}

	public JButton getBtnReportes() {
		return btnCitas;
	}

	public JButton getBtnHome() {
		return btnHome;
	}
}
