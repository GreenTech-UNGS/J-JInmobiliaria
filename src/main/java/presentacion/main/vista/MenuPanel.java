package presentacion.main.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JButton btnInquilinos;
	private JButton btnPagos;
	private JButton btnInmobiliaria;
	private JButton btnReportes;

	@Inject
	private MenuPanel() {
		this.setMaximumSize(new Dimension(100, 100));
		this.setMinimumSize(new Dimension(100, 100));
		this.setBackground(new Color(47, 79, 79));
		
		btnPropiedades = new JButton("");
        btnPropiedades.setToolTipText("Propiedades");
        Image imgProp = new ImageIcon(this.getClass().getResource("/props1.png")).getImage();
        btnPropiedades.setIcon(new ImageIcon(imgProp));

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        btnPropiedades.setPreferredSize(new Dimension(70, 70));
        btnPropiedades.setMaximumSize(new Dimension(100, 100));
        btnPropiedades.setMinimumSize(new Dimension(100, 100));
        btnPropiedades.setBackground(new Color(0, 51, 51));
        this.add(btnPropiedades);

        btnContratos = new JButton("");
        btnContratos.setToolTipText("contratos");
        Image imgCon = new ImageIcon(this.getClass().getResource("/contratos1.png")).getImage();
        btnContratos.setIcon(new ImageIcon(imgCon));

        btnContratos.setPreferredSize(new Dimension(70, 70));
        btnContratos.setBackground(new Color(0, 51, 51));
        
        Component glue_3 = Box.createGlue();
        this.add(glue_3);
        this.add(btnContratos);

        btnInquilinos = new JButton("");
        btnInquilinos.setToolTipText("Clientes");

        Image imgInq = new ImageIcon(this.getClass().getResource("/clientes1.png")).getImage();
        btnInquilinos.setIcon(new ImageIcon(imgInq));
        
        Component glue_4 = Box.createGlue();
        this.add(glue_4);
        btnInquilinos.setPreferredSize(new Dimension(70, 70));
        btnInquilinos.setBackground(new Color(0, 51, 51));
        this.add(btnInquilinos);

        this.btnPagos = new JButton("");
        btnPagos.setToolTipText("Pagos");

        Image imgPago = new ImageIcon(this.getClass().getResource("/pagos1.png")).getImage();
        btnPagos.setIcon(new ImageIcon(imgPago));
        
        Component glue_5 = Box.createGlue();
        this.add(glue_5);
        btnPagos.setPreferredSize(new Dimension(70, 70));
        btnPagos.setBackground(new Color(0, 51, 51));
        this.add(btnPagos);

        btnReportes = new JButton("");
        btnReportes.setToolTipText("Reportes");
        Image imgRep = new ImageIcon(this.getClass().getResource("/reportes1.png")).getImage();
        
        Component glue_6 = Box.createGlue();
        this.add(glue_6);
        btnReportes.setIcon(new ImageIcon(imgRep));
        btnReportes.setPreferredSize(new Dimension(70, 70));
        btnReportes.setBackground(new Color(0, 51, 51));
        this.add(btnReportes);
        
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
		return btnInquilinos;
	}

	public JButton getBtnPagos() {
		return btnPagos;
	}

	public JButton getBtnInmobiliaria() {
		return btnInmobiliaria;
	}

	public JButton getBtnReportes() {
		return btnReportes;
	}
	
}
