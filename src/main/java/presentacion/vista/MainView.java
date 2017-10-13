package presentacion.vista;

import com.google.inject.Inject;
import com.toedter.calendar.JCalendar;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    @SuppressWarnings("unused")
    private static MainView instance;

    private JFrame frmLpezLpez;
    private JPanel panelReportes;

    private JButton btnPropiedades;
    private JButton btnEditarPropiedad;
    private JButton btnContratos;
    private JButton btnInquilinos;
    private JButton btnAgregarPropiedad;
    private JButton btnAgregarContratoAlq;
    private JButton btnAgregarContratoVen;
    private JButton btnPagos;
    private JButton btnAgregarCliente;
    private JButton btnAgregarPropietario;
    private JButton btnReservarPropiedad;
    private JTable tablePropiedades;
    private JTable tableClientes;
    private JTable tablePropietarios;
    private JTable tableCuotas;
    private JButton btnEditarCliente;
    private JButton btnEditarPropietario;
    private JButton btnDesreservar;
    private JButton btnRenovar;
    
    private JCalendar jCalendar;
    private JTable tablaContratoVenta;
    private JTable tablaContratoAlquiler;
    private JTable tablaReservas;
    private JButton btnRegistrarCobro;
    private JTable tablePagosPropietarios;
    private JButton btnRegistrarPago;
    private JButton btnGenerarReportePropietarios;

    @Inject
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

        Image imgVentana = new ImageIcon(this.getClass().getResource("/cityscape.png")).getImage();
        frmLpezLpez.setIconImage(imgVentana);

        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(null);
        panelContainer.setBounds(93, 20, 668, 474);
        frmLpezLpez.getContentPane().add(panelContainer);
        panelContainer.setLayout(new CardLayout(0, 0));

        JPanel panelPropiedades = new JPanel();
        panelContainer.add(panelPropiedades, "name_1084621145273363");

        JPanel panelContratos = new JPanel();
        panelContainer.add(panelContratos, "name_1084753155363088");
        panelContratos.setLayout(new CardLayout(0, 0));

        JTabbedPane PanelTablas = new JTabbedPane(JTabbedPane.TOP);
        panelContratos.add(PanelTablas, "name_1165565257819909");

        JPanel contratoAlquiler = new JPanel();
        PanelTablas.addTab("Contratos de alquiler", null, contratoAlquiler, null);

        JPanel contratoVenta = new JPanel();
        PanelTablas.addTab("Contratos de venta", null, contratoVenta, null);
        contratoVenta.setLayout(new BoxLayout(contratoVenta, BoxLayout.Y_AXIS));
        
        
        tablaContratoVenta = new JTable();
        JScrollPane scrollPane_5 = new JScrollPane(tablaContratoVenta);
        contratoVenta.add(scrollPane_5);

        this.btnAgregarContratoVen = new JButton("Agregar contrato de venta");
        btnAgregarContratoVen.setAlignmentX(Component.CENTER_ALIGNMENT);
        contratoVenta.add(btnAgregarContratoVen);
        contratoAlquiler.setLayout(new BoxLayout(contratoAlquiler, BoxLayout.Y_AXIS));
        
        tablaContratoAlquiler = new JTable();
        JScrollPane scrollPane_4 = new JScrollPane(tablaContratoAlquiler);
        contratoAlquiler.add(scrollPane_4);
                
                JPanel panel_2 = new JPanel();
                contratoAlquiler.add(panel_2);
                
                
                        btnAgregarContratoAlq = new JButton("Agregar contrato de aquiler");
                        panel_2.add(btnAgregarContratoAlq);
                        btnAgregarContratoAlq.setAlignmentX(Component.CENTER_ALIGNMENT);
                        
                        btnRenovar = new JButton("Renovar contrato");
                        panel_2.add(btnRenovar);
                        btnAgregarContratoAlq.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                            }
                        });

        JPanel panelInquilinos = new JPanel();
        panelContainer.add(panelInquilinos, "name_1084846370736461");
        panelInquilinos.setLayout(null);

        JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane_2.setBounds(0, 0, 668, 474);
        panelInquilinos.add(tabbedPane_2);

        JPanel TabCliente = new JPanel();
        tabbedPane_2.addTab("Clientes", null, TabCliente, null);
        TabCliente.setLayout(new BoxLayout(TabCliente, BoxLayout.Y_AXIS));

        tableClientes = new JTable();

        JScrollPane scrollPane_1 = new JScrollPane(tableClientes);
        TabCliente.add(scrollPane_1);

        JPanel panel = new JPanel();
        TabCliente.add(panel);
        
        btnAgregarCliente = new JButton("Agregar cliente");
        panel.add(btnAgregarCliente);
        
        btnEditarCliente = new JButton("Editar cliente");
        panel.add(btnEditarCliente);
                
        JPanel TabPropietarios = new JPanel();
        tabbedPane_2.addTab("Propietarios", null, TabPropietarios, null);
        TabPropietarios.setLayout(new BoxLayout(TabPropietarios, BoxLayout.Y_AXIS));

        tablePropietarios = new JTable();
        
        JScrollPane scrollPane_2 = new JScrollPane(tablePropietarios);
        TabPropietarios.add(scrollPane_2);
        
        JPanel panel2 = new JPanel();
        TabPropietarios.add(panel2);
        
        btnAgregarPropietario = new JButton("Agregar propietario");
        panel2.add(btnAgregarPropietario);
        
        btnEditarPropietario = new JButton("Editar propietario");
        panel2.add(btnEditarPropietario);
       
        
        JPanel panelPagos = new JPanel();
        panelContainer.add(panelPagos, "name_1283035568116550");
        panelPagos.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 668, 474);
        panelPagos.add(tabbedPane);

        JPanel panelPagoAlq = new JPanel();
        tabbedPane.addTab("Cobro de alquileres", null, panelPagoAlq, null);
        panelPagoAlq.setLayout(new BoxLayout(panelPagoAlq, BoxLayout.Y_AXIS));
        
        tableCuotas = new JTable();
        
        JScrollPane scrollPane_3 = new JScrollPane(tableCuotas);
        panelPagoAlq.add(scrollPane_3);
        
        JPanel botonesAlquiler = new JPanel();
        panelPagoAlq.add(botonesAlquiler);
        botonesAlquiler.setLayout(new BoxLayout(botonesAlquiler, BoxLayout.X_AXIS));
        
        btnRegistrarCobro = new JButton("Registrar Cobro");
        botonesAlquiler.add(btnRegistrarCobro);

        JPanel panelPagoProp = new JPanel();
        tabbedPane.addTab("Pagos a propietarios", null, panelPagoProp, null);
        panelPagoProp.setLayout(new BoxLayout(panelPagoProp, BoxLayout.Y_AXIS));
        
        tablePagosPropietarios = new JTable();
        
        JScrollPane scrollPane_7 = new JScrollPane(tablePagosPropietarios);
        panelPagoProp.add(scrollPane_7);
        
        JPanel bontones = new JPanel();
        panelPagoProp.add(bontones);
        bontones.setLayout(new BoxLayout(bontones, BoxLayout.X_AXIS));
        
        Component glue = Box.createGlue();
        bontones.add(glue);
        
        btnRegistrarPago = new JButton("Registrar Pago");
        bontones.add(btnRegistrarPago);
        
        Component glue_1 = Box.createGlue();
        bontones.add(glue_1);
        
        btnGenerarReportePropietarios = new JButton("Generar Reporte");
        bontones.add(btnGenerarReportePropietarios);
        
        Component glue_2 = Box.createGlue();
        bontones.add(glue_2);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelPrincipal.setBackground(new Color(47, 79, 79));
        panelPrincipal.setBounds(0, 0, 1016, 517);
        frmLpezLpez.getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(null);

        JPanel panelNotif = new JPanel();
        panelNotif.setBounds(769, 193, 237, 292);
        panelPrincipal.add(panelNotif);
        panelNotif.setLayout(null);

        JPanel panelMenu = new JPanel();
        panelMenu.setBounds(10, 5, 74, 480);
        panelPrincipal.add(panelMenu);
        panelMenu.setMaximumSize(new Dimension(100, 100));
        panelMenu.setMinimumSize(new Dimension(100, 100));
        panelMenu.setBackground(new Color(47, 79, 79));

        JPanel panelCalendar = new JPanel();
        panelCalendar.setBounds(769, 11, 237, 175);
        panelPrincipal.add(panelCalendar);
        panelCalendar.setLayout(null);
        jCalendar = new JCalendar();
        jCalendar.setBounds(0, 0, 237, 175);
        jCalendar.setTodayButtonVisible(true);
        jCalendar.setWeekOfYearVisible(false);
        panelCalendar.add(jCalendar);
               
        this.panelReportes = new JPanel();
        panelContainer.add(panelReportes, "name_1283074869718816");

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
        panelPropiedades.setLayout(new BoxLayout(panelPropiedades, BoxLayout.Y_AXIS));
        
        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        panelPropiedades.add(tabbedPane_1);
                        
        JPanel panelTodas = new JPanel();
        tabbedPane_1.addTab("Todas las propiedades", null, panelTodas, null);
        panelTodas.setLayout(new BoxLayout(panelTodas, BoxLayout.Y_AXIS));
                        
        JScrollPane scrollPane = new JScrollPane();
        panelTodas.add(scrollPane);
                                
        tablePropiedades = new JTable();
        scrollPane.setViewportView(tablePropiedades);
                                        
       JPanel panelButtons = new JPanel();
       panelTodas.add(panelButtons);
       panelButtons.setLayout(new BoxLayout(panelButtons, BoxLayout.X_AXIS));
                                                
       Component horizontalGlue = Box.createHorizontalGlue();
       panelButtons.add(horizontalGlue);
                                                        
       btnAgregarPropiedad = new JButton("Agregar propiedad");
       btnAgregarPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
       panelButtons.add(btnAgregarPropiedad);
                                                                
      Component horizontalGlue_3 = Box.createHorizontalGlue();
      panelButtons.add(horizontalGlue_3);
                                                                        
      btnReservarPropiedad = new JButton("Reservar propiedad");
      btnReservarPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
      panelButtons.add(btnReservarPropiedad);

      Component horizontalGlue_4 = Box.createHorizontalGlue();
      panelButtons.add(horizontalGlue_4);

      btnEditarPropiedad = new JButton("Editar propiedad");
      btnEditarPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));

      panelButtons.add(btnEditarPropiedad);

      Component horizontalGlue_1 = Box.createHorizontalGlue();
      panelButtons.add(horizontalGlue_1);
                                                                                        
      JPanel panelReservas = new JPanel();
      tabbedPane_1.addTab("Reservas a propiedades", null, panelReservas, null);
      panelReservas.setLayout(new BoxLayout(panelReservas, BoxLayout.Y_AXIS));
                                                                                        
      tablaReservas = new JTable();
      JScrollPane scrollPane_6 = new JScrollPane(tablaReservas);
      panelReservas.add(scrollPane_6);                                                                             
                                                                                     
      JPanel panel_1 = new JPanel();
      panelReservas.add(panel_1);
      
      btnDesreservar = new JButton("Desreservar");
      panel_1.add(btnDesreservar);
    }

    public JTable getTablePropiedades() {
        return tablePropiedades;
    }

    public void show() {
        this.frmLpezLpez.setVisible(true);
    }

    public JButton getBtnPropiedades() {
        return this.btnAgregarPropiedad;
    }

    public JButton getBtnContratoAlq() {
        return this.btnAgregarContratoAlq;
    }

    public JButton getBtnContratoVen() {
        return this.btnAgregarContratoVen;
    }

    public JButton getBtnAgregarCliente() {
        return btnAgregarCliente;
    }
    
    public JButton getBtnAgregarPropietario() {
        return btnAgregarPropietario;
    }

    public JButton getBtnReservarPropiedad() {
        return btnReservarPropiedad;
    }

    public JButton getBtnEditPropiedad() {
        return btnEditarPropiedad;
    }

    public void setBtnEditarPropiedad(JButton btnEditarPropiedad) {
        this.btnEditarPropiedad = btnEditarPropiedad;
    }

    public JTable getTableClientes() {
        return tableClientes;
    }

    public void setTableClientes(JTable tableClientes) {
        this.tableClientes = tableClientes;
    }

    public JTable getTablePropietarios() {
        return tablePropietarios;
    }
    
    public JTable getTableCuotas() {
        return tableCuotas;
    }

	public JTable getTablaContratoVenta() {
		return tablaContratoVenta;
	}

	public void setTablaContratoVenta(JTable tablaContratoVenta) {
		this.tablaContratoVenta = tablaContratoVenta;
	}

	public JTable getTablaContratoAlquiler() {
		return tablaContratoAlquiler;
	}

	public void setTablaContratoAlquiler(JTable tablaContratoAlquiler) {
		this.tablaContratoAlquiler = tablaContratoAlquiler;
	}


	public JButton getBtnEditarCliente() {
		return btnEditarCliente;
	}


	public void setBtnEditarCliente(JButton btnEditarCliente) {
		this.btnEditarCliente = btnEditarCliente;
	}
	
	public JButton getBtnEditarPropietario() {
		return btnEditarPropietario;
	}

	public void setBtnEditarPropietario(JButton btnEditarPropietario) {
		this.btnEditarPropietario = btnEditarPropietario;
	}


	public JTable getTablaReservas() {
		return tablaReservas;
	}


	public void setTablaReservas(JTable tablaReservas) {
		this.tablaReservas = tablaReservas;
	}


	public JButton getBtnDesreservar() {
		return btnDesreservar;
	}


	public void setBtnDesreservar(JButton btnDesreservar) {
		this.btnDesreservar = btnDesreservar;
	}
	
	public JButton getBtnRegistrarCobro() {
		return btnRegistrarCobro;
	}


	public JButton getBtnRenovar() {
		return btnRenovar;
	}


	public void setBtnRenovar(JButton btnRenovar) {
		this.btnRenovar = btnRenovar;
	}
	
	
	public JTable getTablePagosPropietarios() {
		return tablePagosPropietarios;
	}


	public JButton getBtnRegistrarPago() {
		return btnRegistrarPago;
	}


	public JButton getBtnGenerarReportePropietarios() {
		return btnGenerarReportePropietarios;
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
}
