package vista;

import java.awt.EventQueue;
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

public class Vista {

	private JFrame frmLpezLpez;
	private JTextField txtContratos;
	private JTextField txtInquilinos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista window = new Vista();
					window.frmLpezLpez.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Vista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLpezLpez = new JFrame();
		frmLpezLpez.setBackground(new Color(255, 255, 255));
		frmLpezLpez.setTitle("L\u00F3pez & L\u00F3pez");
		frmLpezLpez.setResizable(false);
		frmLpezLpez.setBounds(100, 100, 964, 484);
		frmLpezLpez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLpezLpez.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		menuBar.setBounds(0, 0, 839, 21);
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setMaximumSize(new Dimension(100, 100));
		panelMenu.setMinimumSize(new Dimension(100, 100));
		panelMenu.setBackground(new Color(0, 0, 51));
		panelMenu.setBounds(10, 30, 118, 414);
		frmLpezLpez.getContentPane().add(panelMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(138, 32, 557, 412);
		frmLpezLpez.getContentPane().add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panelPropiedades = new JPanel();
		panel_1.add(panelPropiedades, "name_1084621145273363");
		panelPropiedades.setLayout(null);
		
		JButton btnAgregarPropiedad = new JButton("Agregar Propiedad");
		btnAgregarPropiedad.setBounds(10, 11, 149, 32);
		panelPropiedades.add(btnAgregarPropiedad);
		
		JPanel panelContratos = new JPanel();
		panel_1.add(panelContratos, "name_1084753155363088");
		
		txtContratos = new JTextField();
		txtContratos.setText("contratos");
		txtContratos.setColumns(10);
		panelContratos.add(txtContratos);
		
		JPanel panelInquilinos = new JPanel();
		panel_1.add(panelInquilinos, "name_1084846370736461");
		
		txtInquilinos = new JTextField();
		txtInquilinos.setText("Inquilinos");
		txtInquilinos.setColumns(10);
		panelInquilinos.add(txtInquilinos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(0, 21, 958, 434);
		frmLpezLpez.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBounds(396, 5, 46, 14);
		panel_2.add(label);
		
		JLabel lblLabel = new JLabel("Label");
		Image img = new ImageIcon(this.getClass().getResource("/calen.png")).getImage();
		lblLabel.setIcon(new ImageIcon(img));
		lblLabel.setBounds(706, 11, 242, 172);
		panel_2.add(lblLabel);
		
		JButton btnPropiedades = new JButton("Propiedades");
		btnPropiedades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(panelPropiedades);
				panel_1.repaint();
				panel_1.repaint();
			}
		});
		btnPropiedades.setPreferredSize(new Dimension(120, 30));
		btnPropiedades.setMaximumSize(new Dimension(100, 100));
		btnPropiedades.setMinimumSize(new Dimension(100, 100));
		btnPropiedades.setBackground(SystemColor.inactiveCaptionBorder);
		panelMenu.add(btnPropiedades);
		
		JButton btnContratos = new JButton("Contratos");
		btnContratos.setPreferredSize(new Dimension(120, 30));
		btnContratos.setBackground(SystemColor.inactiveCaptionBorder);
		btnContratos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(panelContratos);
				panel_1.repaint();
				panel_1.repaint();
			}
		});
		panelMenu.add(btnContratos);
		
		JButton btnInquilinos = new JButton("Inquilinos");
		btnInquilinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(panelInquilinos);
				panel_1.repaint();
				panel_1.repaint();
			}
		});
		btnInquilinos.setPreferredSize(new Dimension(120, 30));
		btnInquilinos.setBackground(SystemColor.inactiveCaptionBorder);
		panelMenu.add(btnInquilinos);
	}
}
