package presentacion.vista;

import javax.swing.JDialog;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class RegistrarCobroView extends JDialog{

	@Inject
	private RegistrarCobroView() {
		setModal(true);
	}
	
	
}
