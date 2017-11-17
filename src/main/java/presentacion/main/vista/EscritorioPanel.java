package presentacion.main.vista;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.awt.Component;
import java.awt.FlowLayout;

@Singleton
public class EscritorioPanel extends JPanel{

	private JTable tableInmobiliaria;
	private JButton btnAgregarInmobiliaria;
	private JButton btnEditarInmobiliaria;
	private JPanel panel;
	private JButton btnAplicarFiltro;
	private JButton btnRemoverFiltro;

	@Inject
	public EscritorioPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        add(panel);
        
        btnAplicarFiltro = new JButton("Aplicar filtro");
        btnAplicarFiltro.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel.add(btnAplicarFiltro);
        
        btnRemoverFiltro = new JButton("Remover filtro");
        btnRemoverFiltro.setFont(new Font("Tahoma", Font.PLAIN, 11));
        panel.add(btnRemoverFiltro);
        
        tableInmobiliaria = new JTable();
        
        JScrollPane scrollPane_6 = new JScrollPane(tableInmobiliaria);
        this.add(scrollPane_6);
        
        JPanel panelBtnInmb = new JPanel();
        this.add(panelBtnInmb);
        
        btnAgregarInmobiliaria = new JButton("Agregar inmobiliaria");
        btnAgregarInmobiliaria.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelBtnInmb.add(btnAgregarInmobiliaria);
        
        btnEditarInmobiliaria = new JButton("Editar inmobiliaria");
        btnEditarInmobiliaria.setFont(new Font("Tahoma", Font.BOLD, 11));
        panelBtnInmb.add(btnEditarInmobiliaria);
	}

	public JTable getTableInmobiliaria() {
		return tableInmobiliaria;
	}

	public JButton getBtnAgregarInmobiliaria() {
		return btnAgregarInmobiliaria;
	}

	public JButton getBtnEditarInmobiliaria() {
		return btnEditarInmobiliaria;
	}

	public JButton getBtnAplicarFiltro() {
		return btnAplicarFiltro;
	}

	public void setBtnAplicarFiltro(JButton btnAplicarFiltro) {
		this.btnAplicarFiltro = btnAplicarFiltro;
	}

	public JButton getBtnRemoverFiltro() {
		return btnRemoverFiltro;
	}

	public void setBtnRemoverFiltro(JButton btnRemoverFiltro) {
		this.btnRemoverFiltro = btnRemoverFiltro;
	}
	
}
