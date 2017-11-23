package presentacion.main.vista;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.BorderLayout;

@Singleton
public class PropiedadesPanel extends JPanel{
	
	private JTable tablePropiedades;
	private JButton btnAgregarPropiedad;
	private JButton btnReservarPropiedad;
	private JButton btnEditarPropiedad;
	private JTable tableEnAlquiler;
	private JTable tableEnVenta;
	private JTable tablaReservas;
	private JButton btnDesreservar;
	private JTable tableAlquiladas;
	private JTable tableVendidas;
	private JButton btnFiltrar;
	private JButton btnRemoverFiltro;
	private JButton btnVerInteresados;

	@Inject
	private PropiedadesPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
        this.add(tabbedPane_1);
        
        JPanel panelTodas = new JPanel();
        tabbedPane_1.addTab("Todas las propiedades", null, panelTodas, null);
        panelTodas.setLayout(new BoxLayout(panelTodas, BoxLayout.Y_AXIS));
        
        JPanel panelFiltrosTodas = new JPanel();
        panelTodas.add(panelFiltrosTodas);
        panelFiltrosTodas.setLayout(new BoxLayout(panelFiltrosTodas, BoxLayout.X_AXIS));
        
               Component horizontalGlue_1 = Box.createHorizontalGlue();
               panelFiltrosTodas.add(horizontalGlue_1);
        
        btnFiltrar = new JButton("Aplicar Filtro");
        panelFiltrosTodas.add(btnFiltrar);
        btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
        
        btnRemoverFiltro = new JButton("Remover Filtro");
        btnRemoverFiltro.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panelFiltrosTodas.add(btnRemoverFiltro);
        
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
        btnAgregarPropiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelButtons.add(btnAgregarPropiedad);
                                                                 
       Component horizontalGlue_3 = Box.createHorizontalGlue();
       panelButtons.add(horizontalGlue_3);
                                                                         
       btnReservarPropiedad = new JButton("Reservar propiedad");
       btnReservarPropiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
       panelButtons.add(btnReservarPropiedad);

       Component horizontalGlue_4 = Box.createHorizontalGlue();
       panelButtons.add(horizontalGlue_4);

       btnEditarPropiedad = new JButton("Editar propiedad");
       btnEditarPropiedad.setFont(new Font("Tahoma", Font.BOLD, 11));
       panelButtons.add(btnEditarPropiedad);
       
       Component glue = Box.createHorizontalGlue();
       panelButtons.add(glue);
       
       btnVerInteresados = new JButton("Ver interesados");
       btnVerInteresados.setFont(new Font("Tahoma", Font.BOLD, 11));
       panelButtons.add(btnVerInteresados);
       
       Component glue2 = Box.createHorizontalGlue();
       panelButtons.add(glue2);
       
       JPanel panelEnAlquiler = new JPanel();
       tabbedPane_1.addTab("En alquiler", null, panelEnAlquiler, null);
       panelEnAlquiler.setLayout(new BoxLayout(panelEnAlquiler, BoxLayout.Y_AXIS));
       
       JScrollPane scrollPaneEnAlquiler = new JScrollPane();
       panelEnAlquiler.add(scrollPaneEnAlquiler);
       
       tableEnAlquiler = new JTable();
       scrollPaneEnAlquiler.setColumnHeaderView(tableEnAlquiler);
       scrollPaneEnAlquiler.setViewportView(tableEnAlquiler);
       
       JPanel panelEnVenta = new JPanel();
       tabbedPane_1.addTab("En venta", null, panelEnVenta, null);
       panelEnVenta.setLayout(new BoxLayout(panelEnVenta, BoxLayout.Y_AXIS));
       
       JScrollPane scrollPaneEnVenta = new JScrollPane();
       panelEnVenta.add(scrollPaneEnVenta);
       
       tableEnVenta = new JTable();
       scrollPaneEnVenta.setColumnHeaderView(tableEnVenta);
       scrollPaneEnVenta.setViewportView(tableEnVenta);
       
       JPanel panelReservas = new JPanel();
       tabbedPane_1.addTab("Reservadas", null, panelReservas, null);
       panelReservas.setLayout(new BoxLayout(panelReservas, BoxLayout.Y_AXIS));
       
       tablaReservas = new JTable();
       JScrollPane scrollPaneReservadas = new JScrollPane(tablaReservas);
       panelReservas.add(scrollPaneReservadas);                                                                             
       
       JPanel panel_1 = new JPanel();
       panelReservas.add(panel_1);
       panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
       
       btnDesreservar = new JButton("Desreservar");
       btnDesreservar.setAlignmentY(Component.BOTTOM_ALIGNMENT);
       btnDesreservar.setAlignmentX(Component.CENTER_ALIGNMENT);
       panel_1.add(btnDesreservar);
       
       JPanel panelAlquiladas = new JPanel();
       tabbedPane_1.addTab("Alquiladas", null, panelAlquiladas, null);
       panelAlquiladas.setLayout(new BoxLayout(panelAlquiladas, BoxLayout.Y_AXIS));
       
       JScrollPane scrollPaneAlquiladas = new JScrollPane();
       panelAlquiladas.add(scrollPaneAlquiladas);
       
       tableAlquiladas = new JTable();
       scrollPaneAlquiladas.setColumnHeaderView(tableAlquiladas);
       scrollPaneAlquiladas.setViewportView(tableAlquiladas);
       
       JPanel panelVendidas = new JPanel();
       tabbedPane_1.addTab("Vendidas", null, panelVendidas, null);
       panelVendidas.setLayout(new BoxLayout(panelVendidas, BoxLayout.Y_AXIS));
       
       JScrollPane scrollPaneVendidas = new JScrollPane();
       panelVendidas.add(scrollPaneVendidas);
       
       tableVendidas = new JTable();
       scrollPaneVendidas.setColumnHeaderView(tableVendidas);
       scrollPaneVendidas.setViewportView(tableVendidas);
	}

	public JTable getTablePropiedades() {
		return tablePropiedades;
	}

	public JButton getBtnAgregarPropiedad() {
		return btnAgregarPropiedad;
	}

	public JButton getBtnReservarPropiedad() {
		return btnReservarPropiedad;
	}

	public JButton getBtnEditarPropiedad() {
		return btnEditarPropiedad;
	}

	public JTable getTableEnAlquiler() {
		return tableEnAlquiler;
	}

	public JTable getTableEnVenta() {
		return tableEnVenta;
	}

	public JTable getTablaReservas() {
		return tablaReservas;
	}

	public JButton getBtnDesreservar() {
		return btnDesreservar;
	}

	public JTable getTableAlquiladas() {
		return tableAlquiladas;
	}

	public JTable getTableVendidas() {
		return tableVendidas;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public JButton getBtnRemoverFiltro() {
		return btnRemoverFiltro;
	}
	
	public JButton getBtnVerInteresados() {
		return btnVerInteresados;
	}

}
