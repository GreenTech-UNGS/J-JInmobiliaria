package presentacion.validators;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

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
		JOptionPane.showMessageDialog(null, new JLabel(msg), title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public  String showInputMessage(String msg, String title) {
		
		return JOptionPane.showInputDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public boolean showYesNoMessage(String msg, String title) {

		return JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.OK_CANCEL_OPTION) == 0;
	}
	
	public Integer showInputMessageInt(String title, int max, int min) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(min, min, max, 1));
		int opcion = JOptionPane.showConfirmDialog(null, spinner, title, JOptionPane.OK_CANCEL_OPTION);
		
		if(opcion != 0)
			return null;
		
		return (int) spinner.getValue();
	}
	
}
