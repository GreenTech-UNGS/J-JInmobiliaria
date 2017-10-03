package presentacion.vista;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.CardLayout;
import javax.swing.JTextField;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class MainView {

	private static MainView instance;
	
	private JFrame frmLpezLpez;
	private JTextField txtInquilinos;
	private JPanel panelReportes;
	
	private JButton btnPropiedades;
	private JButton btnContratos;
	private JButton btnInquilinos;
	private JButton btnAgregarPropiedad;
	private JButton btnAgregarContratoAlq;
	private JButton btnAgregarContratoVen;
	private JButton btnPagos;
	private JButton btnAgregarCliente;

	
	public static MainView getView(){
		if(instance == null)
			instance = new MainView();
		return instance;

	}
	
	public MainView() {
		initialize();
	}


	private void initialize() {
		
		frmLpezLpez = new JFrame();
		frmLpezLpez.setBackground(new Color(255, 255, 255));
		frmLpezLpez.setTitle("L\u00F3pez & L\u00F3pez");
		frmLpezLpez.setResizable(false);
		frmLpezLpez.setBounds(100, 100, 1022, 546);
		frmLpezLpez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLpezLpez.getContentPane().setLayout(null);
		frmLpezLpez.setLocationRelativeTo(null);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBorder(null);
		panelContainer.setBounds(93, 32, 668, 474);
		frmLpezLpez.getContentPane().add(panelContainer);
		panelContainer.setLayout(new CardLayout(0, 0));
		
		JPanel panelPropiedades = new JPanel();
		panelContainer.add(panelPropiedades, "name_1084621145273363");
		panelPropiedades.setLayout(null);
		
		JPanel panelContratos = new JPanel();
		panelContainer.add(panelContratos, "name_1084753155363088");
		panelContratos.setLayout(new CardLayout(0, 0));
		
		JTabbedPane PanelTablas = new JTabbedPane(JTabbedPane.TOP);
		panelContratos.add(PanelTablas, "name_1165565257819909");
		
		JPanel contratoAlquiler = new JPanel();
		PanelTablas.addTab("Contratos de alquiler", null, contratoAlquiler, null);
		
		JPanel contratoVenta = new JPanel();
		PanelTablas.addTab("Contratos de venta", null, contratoVenta, null);
		
		this.btnAgregarContratoVen = new JButton("Agregar contrato de venta");
		contratoVenta.add(btnAgregarContratoVen);
		
		btnAgregarContratoAlq = new JButton("Agregar contrato de aquiler");
		btnAgregarContratoAlq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contratoAlquiler.add(btnAgregarContratoAlq);
		
		JPanel panelInquilinos = new JPanel();
		panelContainer.add(panelInquilinos, "name_1084846370736461");
		
		txtInquilinos = new JTextField();
		txtInquilinos.setText("Inquilinos");
		txtInquilinos.setColumns(10);
		panelInquilinos.add(txtInquilinos);
		
		JPanel panelPagos = new JPanel();
		panelContainer.add(panelPagos, "name_1283035568116550");
		
		JLabel lblPagos = new JLabel("Pagos");
		panelPagos.add(lblPagos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(0, 21, 1016, 496);
		frmLpezLpez.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panelNotif = new JPanel();
		panelNotif.setBounds(769, 193, 237, 292);
		panel_2.add(panelNotif);
		panelNotif.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(10, 9, 74, 476);
		panel_2.add(panelMenu);
		panelMenu.setMaximumSize(new Dimension(100, 100));
		panelMenu.setMinimumSize(new Dimension(100, 100));
		panelMenu.setBackground(new Color(47, 79, 79));
		
		this.panelReportes = new JPanel();
		panelContainer.add(panelReportes, "name_1283074869718816");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		menuBar.setBounds(0, 0, 1016, 21);
		frmLpezLpez.getContentPane().add(menuBar);
		
		JMenu mnItem = new JMenu("Item1");
		menuBar.add(mnItem);
		
		JMenuItem mntmAlgo = new JMenuItem("Algo1");
		mnItem.add(mntmAlgo);
		
		JMenuItem mntmAlgo_1 = new JMenuItem("Algo2");
		mnItem.add(mntmAlgo_1);
		
		JMenu mnItem_1 = new JMenu("Item2");
		menuBar.add(mnItem_1);
		
		JMenuItem mntmAlgo_2 = new JMenuItem("Algo3");
		mnItem_1.add(mntmAlgo_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(396, 5, 46, 14);
		panel_2.add(label);
		
		JLabel lblCalendario = new JLabel("Label");
		Image img = new ImageIcon(this.getClass().getResource("/calen.png")).getImage();
		lblCalendario.setIcon(new ImageIcon(img));
		lblCalendario.setBounds(769, 11, 237, 175);
		panel_2.add(lblCalendario);
		
		JLabel lblNotificaciones = new JLabel("Notificaciones:");
		lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNotificaciones.setBounds(75, 11, 104, 14);
		panelNotif.add(lblNotificaciones);
		
		JLabel lblReportes = new JLabel("Reportes");
		panelReportes.add(lblReportes);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 37, 217, 14);
		panelNotif.add(separator);
		
		btnPropiedades = new JButton("");
		btnPropiedades.setToolTipText("Propiedades");
		Image imgProp = new ImageIcon(this.getClass().getResource("/propiedades.png")).getImage();
		btnPropiedades.setIcon(new ImageIcon(imgProp));
		btnPropiedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				panelContainer.repaint();
				panelContainer.revalidate();
				
				panelContainer.add(panelPropiedades);
				panelContainer.repaint();
				panelContainer.repaint();
			}
		});
		btnPropiedades.setPreferredSize(new Dimension(70, 70));
		btnPropiedades.setMaximumSize(new Dimension(100, 100));
		btnPropiedades.setMinimumSize(new Dimension(100, 100));
		btnPropiedades.setBackground(new Color(0, 51, 51));
		panelMenu.add(btnPropiedades);
		
		btnContratos = new JButton("");
		btnContratos.setToolTipText("Contratos");
		Image imgCon = new ImageIcon(this.getClass().getResource("/contratos.png")).getImage();
		btnContratos.setIcon(new ImageIcon(imgCon));
		
		btnContratos.setPreferredSize(new Dimension(70, 70));
		btnContratos.setBackground(new Color(0, 51, 51));
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelContainer.removeAll();
				panelContainer.repaint();
				panelContainer.revalidate();
				
				panelContainer.add(panelContratos);
				panelContainer.repaint();
				panelContainer.repaint();
			}
		});
		panelMenu.add(btnContratos);
		
		btnInquilinos = new JButton("");
		btnInquilinos.setToolTipText("Inquilinos");
		
		Image imgInq = new ImageIcon(this.getClass().getResource("/inquilinos.png")).getImage();
		btnInquilinos.setIcon(new ImageIcon(imgInq));
		
		btnInquilinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				panelContainer.repaint();
				panelContainer.revalidate();
				
				panelContainer.add(panelInquilinos);
				panelContainer.repaint();
				panelContainer.repaint();
			}
		});
		btnInquilinos.setPreferredSize(new Dimension(70, 70));
		btnInquilinos.setBackground(new Color(0, 51, 51));
		panelMenu.add(btnInquilinos);
		
		this.btnPagos = new JButton("");
		btnPagos.setToolTipText("Pagos");
		
		Image imgPago = new ImageIcon(this.getClass().getResource("/pagos.png")).getImage();
		btnPagos.setIcon(new ImageIcon(imgPago));
		
		btnPagos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				panelContainer.repaint();
				panelContainer.revalidate();
				
				panelContainer.add(panelPagos);
				panelContainer.repaint();
				panelContainer.repaint();
			}
		});
		btnPagos.setPreferredSize(new Dimension(70, 70));
		btnPagos.setBackground(new Color(0, 51, 51));
		panelMenu.add(btnPagos);
		
		JButton btnReportes = new JButton("");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelContainer.removeAll();
				panelContainer.repaint();
				panelContainer.revalidate();
				
				panelContainer.add(panelReportes);
				panelContainer.repaint();
				panelContainer.repaint();
			}
		});
		btnReportes.setToolTipText("Reportes");
		Image imgRep = new ImageIcon(this.getClass().getResource("/reportes.png")).getImage();
		btnReportes.setIcon(new ImageIcon(imgRep));
		btnReportes.setPreferredSize(new Dimension(70, 70));
		btnReportes.setBackground(new Color(0, 51, 51));
		panelMenu.add(btnReportes);
		
		btnAgregarPropiedad = new JButton("Agregar Propiedad");
		btnAgregarPropiedad.setBounds(10, 11, 149, 32);
		panelPropiedades.add(btnAgregarPropiedad);
		
		btnAgregarCliente = new JButton("Agregar cliente");
		panelInquilinos.add(btnAgregarCliente);
	}
	
	public void show()
	{
		this.frmLpezLpez.setVisible(true);
	}
	
	public  JButton getBtnPropiedades(){
		return this.btnAgregarPropiedad;
	}
	
	public  JButton getBtnContratoAlq(){
		return this.btnAgregarContratoAlq;
	}
	public  JButton getBtnContratoVen(){
		return this.btnAgregarContratoVen;
	}
	
	public JButton getBtnAgregarCliente() {
		return btnAgregarCliente;
	}
}
