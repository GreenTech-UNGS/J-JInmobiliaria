package presentacion.main.vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ReportesPanel extends JPanel{
	
	@Inject
	private ReportesPanel() {
		
        JLabel lblReportes = new JLabel("Reportes");
        this.add(lblReportes);
		
	}

}
