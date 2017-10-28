package presentacion.combo;

import java.util.List;

import entities.Rol;

@SuppressWarnings("serial")
public class RolComboBoxModel extends BaseComboBoxModel<Rol>{

	@Override
	public void actualize(List<Rol> list) {
		list.forEach(c -> agregaElemento(c));
		
	}

	@Override
	public void agregaElemento(Rol element) {
		
		String str = element.toString().toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		str = str.replaceAll("_", " ");
		
		this.addElement(str);
		values.put(str, element);
		
	}

	@Override
	public void setSelected(Rol toSelect) {
		
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			String str = toSelect.toString().toLowerCase();
			str = str.substring(0, 1).toUpperCase() + str.substring(1);
			str = str.replaceAll("_", " ");
		
			this.setSelectedItem(str);
		}	
	}
}
