package presentacion.main.vista;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.toedter.calendar.JCalendar;

import presentacion.table.MovimientosCajaTableModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Singleton
public class MainView {

    private JFrame frmLpezLpez;
    private JCalendar jCalendar;

    @Inject
    public MainView(PropiedadesPanel panelPropiedades,
    		ContratosPanel panelContratos,
    		InquilinosPanel panelInquilinos,
    		PagosPanel panelPagos,
    		InmobiliariaPanel panelInmobiliaria,
    		MenuPanel panelMenu,
    		ReportesPanel panelReportes) {  
    	
    	frmLpezLpez = new JFrame();
        frmLpezLpez.setBackground(new Color(255, 255, 255));
        frmLpezLpez.setTitle("L\u00F3pez & L\u00F3pez");
        frmLpezLpez.setResizable(false);
        frmLpezLpez.setBounds(100, 100, 1047, 534);
        frmLpezLpez.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmLpezLpez.getContentPane().setLayout(null);
        frmLpezLpez.setLocationRelativeTo(null);

        Image imgVentana = new ImageIcon(this.getClass().getResource("/cityscape.png")).getImage();
        frmLpezLpez.setIconImage(imgVentana);

        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(null);
        panelContainer.setBounds(93, 11, 692, 483);
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
        
        panelContainer.add(panelReportes, "name_1283074869718816");

        JLabel lblNotificaciones = new JLabel("Notificaciones:");
        lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNotificaciones.setBounds(75, 11, 104, 14);
        panelNotif.add(lblNotificaciones);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 37, 217, 14);
        panelNotif.add(separator);
    }

    public void show() {
        this.frmLpezLpez.setVisible(true);
    }

    

}
