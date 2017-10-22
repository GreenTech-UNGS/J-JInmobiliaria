package presentacion.main.vista;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class InmobiliariaPanel extends JPanel{

	private JTable tableInmobiliaria;
	private JButton btnAgregarInmobiliaria;
	private JButton btnEditarInmobiliaria;

	@Inject
	public InmobiliariaPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
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
	
}
