package presentacion.validators;

import javax.swing.JOptionPane;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class MessageShow {

	@Inject
	private MessageShow() {
		// TODO Auto-generated constructor stub
	}
	
	public void showErrorMessage(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
	}
	
}
