package presentacion.main.vista;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InquilinosPanel extends JPanel{
	
	private JTable tableClientes;
	private JButton btnAgregarCliente;
	private JButton btnEditarCliente;
	private JButton btnAplicarFiltro;
	private JTable tablePropietarios;
	private JButton btnAgregarPropietario;
	private JButton btnEditarPropietario;
	private JButton btnRemoverFiltro;

	@Inject
	private InquilinosPanel() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
        this.add(tabbedPane_2);
		
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
        
        JPanel panlBotonFiltro = new JPanel();
        TabPropietarios.add(panlBotonFiltro);
        panlBotonFiltro.setLayout(new BoxLayout(panlBotonFiltro, BoxLayout.X_AXIS));
        
        Component horizontalGlue_4 = Box.createHorizontalGlue();
        panlBotonFiltro.add(horizontalGlue_4);
        
        btnAplicarFiltro = new JButton("Aplicar Filtro");
        panlBotonFiltro.add(btnAplicarFiltro);
        
        btnRemoverFiltro = new JButton("Remover Filtro");
        panlBotonFiltro.add(btnRemoverFiltro);

        tablePropietarios = new JTable();
        
        JScrollPane scrollPane_2 = new JScrollPane(tablePropietarios);
        TabPropietarios.add(scrollPane_2);
        
        JPanel panel2 = new JPanel();
        TabPropietarios.add(panel2);
        
        btnAgregarPropietario = new JButton("Agregar propietario");
        panel2.add(btnAgregarPropietario);
        
        btnEditarPropietario = new JButton("Editar propietario");
        panel2.add(btnEditarPropietario);
        
	}

	public JTable getTableClientes() {
		return tableClientes;
	}

	public JButton getBtnAgregarCliente() {
		return btnAgregarCliente;
	}

	public JButton getBtnEditarCliente() {
		return btnEditarCliente;
	}

	public JButton getBtnAplicarFiltro() {
		return btnAplicarFiltro;
	}

	public JTable getTablePropietarios() {
		return tablePropietarios;
	}

	public JButton getBtnAgregarPropietario() {
		return btnAgregarPropietario;
	}

	public JButton getBtnEditarPropietario() {
		return btnEditarPropietario;
	}

	public JButton getBtnRemoverFiltro() {
		return btnRemoverFiltro;
	}

}
