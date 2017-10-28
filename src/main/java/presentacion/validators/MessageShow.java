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
	
	public void showInformationMessage(String msg, String title){
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public  String showInputMessage(String msg, String title) {
		
		return JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
