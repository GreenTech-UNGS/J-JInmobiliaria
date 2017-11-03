package presentacion.main.vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JCalendar;

import model.UsuarioService;
import presentacion.controller.UsuarioController;
import presentacion.validators.MessageShow;

import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@Singleton
public class MainView {

    private JFrame frmLpezLpez;
    private JCalendar jCalendar;
    private JPanel panelNotificaciones;
    private JMenuItem mntmEditar;
    private JMenuItem mntmCambiarContrasea;
    
    @Inject
    public MainView(PropiedadesPanel panelPropiedades,
    		ContratosPanel panelContratos,
    		PersonasPanel panelInquilinos,
    		PagosPanel panelPagos,
    		InmobiliariaPanel panelInmobiliaria,
    		MenuPanel panelMenu,
    		CitasPanel panelCitas) {  
    	
    	this.
    	
    	frmLpezLpez = new JFrame();
        frmLpezLpez.setBackground(new Color(255, 255, 255));
        frmLpezLpez.setTitle("L\u00F3pez & L\u00F3pez");
        frmLpezLpez.setResizable(false);
        frmLpezLpez.setBounds(100, 100, 1047, 559);
        frmLpezLpez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLpezLpez.getContentPane().setLayout(null);
        frmLpezLpez.setLocationRelativeTo(null);

        Image imgVentana = new ImageIcon(this.getClass().getResource("/cityscape.png")).getImage();
        frmLpezLpez.setIconImage(imgVentana);

        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(null);
        panelContainer.setBounds(93, 11, 692, 487);
        frmLpezLpez.getContentPane().add(panelContainer);
        panelContainer.setLayout(new CardLayout(0, 0));

        panelContainer.add(panelPropiedades, "name_1084621145273363");
        panelContainer.add(panelContratos, "name_1084753155363088");
        panelContainer.add(panelInquilinos, "name_1084846370736461");
        panelContainer.add(panelPagos, "name_1283035568116550");
        panelContainer.add(panelInmobiliaria);
       
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelPrincipal.setBackground(new Color(47, 79, 79));
        panelPrincipal.setBounds(0, 0, 1041, 505);
        frmLpezLpez.getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(null);

        JPanel panelNotif = new JPanel();
        panelNotif.setBounds(794, 193, 237, 301);
        panelPrincipal.add(panelNotif);
        panelNotif.setLayout(null);

        panelMenu.setBounds(10, 11, 74, 483);
        panelPrincipal.add(panelMenu);
        

        JPanel panelCalendar = new JPanel();
        panelCalendar.setBounds(794, 11, 237, 175);
        panelPrincipal.add(panelCalendar);
        panelCalendar.setLayout(null);
        jCalendar = new JCalendar();
        jCalendar.setBounds(0, 0, 237, 175);
        jCalendar.setTodayButtonVisible(true);
        jCalendar.setWeekOfYearVisible(false);
        panelCalendar.add(jCalendar);
        
        panelContainer.add(panelCitas, "name_1283074869718816");

        JLabel lblNotificaciones = new JLabel("Notificaciones:");
        lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNotificaciones.setBounds(75, 11, 104, 14);
        panelNotif.add(lblNotificaciones);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 37, 217, 14);
        panelNotif.add(separator);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 48, 217, 242);
        panelNotif.add(scrollPane);
        
        panelNotificaciones = new JPanel();
        JPanel borderlaoutpanel = new JPanel();
        borderlaoutpanel.setLayout(new BorderLayout(0, 0));
        
        scrollPane.setViewportView(borderlaoutpanel);

        panelNotificaciones.setLayout(new GridLayout(0, 1, 0, 1));
        panelNotificaciones.setBackground(Color.gray);

        borderlaoutpanel.add(panelNotificaciones, BorderLayout.NORTH);
        
        JMenuBar menuBar = new JMenuBar();
        frmLpezLpez.setJMenuBar(menuBar);
        
        JMenu mnMiCuenta = new JMenu("Mi cuenta");
        mnMiCuenta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuBar.add(mnMiCuenta);
        
        mntmEditar = new JMenuItem("Editar mis datos");
        mntmEditar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mnMiCuenta.add(mntmEditar);
        
        mntmCambiarContrasea = new JMenuItem("Cambiar contrase\u00F1a");
        mntmCambiarContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mnMiCuenta.add(mntmCambiarContrasea);
        
        JMenu mnConfiguracin = new JMenu("Configuraci\u00F3n");
        mnConfiguracin.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuBar.add(mnConfiguracin);
        
        JMenuItem mntmBaseDeDatos = new JMenuItem("Base de datos");
        mntmBaseDeDatos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        mnConfiguracin.add(mntmBaseDeDatos);
    }

    public void show() {
        this.frmLpezLpez.setVisible(true);
    }


	public JFrame getFrmLpezLpez() {
		return frmLpezLpez;
	}

	public JCalendar getjCalendar() {
		return jCalendar;
	}

	public JPanel getPanelNotificaciones() {
		return panelNotificaciones;
	}

	public JMenuItem getMntmMiCuenta() {
		return mntmEditar;
	}

	public JMenuItem getMntmCambiarContrasea() {
		return mntmCambiarContrasea;
	}
	
	
}
