package presentacion.combo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;

public abstract class BaseComboBoxModel<T> extends DefaultComboBoxModel<String>{
	
	Map<String, T> values;
	
	public BaseComboBoxModel() {
		values = new HashMap<>();
	}
	
	public abstract void actualize(List<T> list);
	
	public T getSelected(){
		
		String selected = (String)super.getSelectedItem();
		
		return values.get(selected);
	}
	
	public abstract void setSelected(T toSelect);
	
	public void clearSelection(){
		
		setSelectedItem(null);
		
	}
}
