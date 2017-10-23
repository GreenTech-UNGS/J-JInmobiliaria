package presentacion.combo;

import java.util.List;

import entities.TipoHabitacion;
import entities.TipoPropiedad;

public class TipoHabitacionComboBoxModel extends BaseComboBoxModel<TipoHabitacion>{

	@Override
	public void actualize(List<TipoHabitacion> list) {
		list.forEach(e -> agregaElemento(e));
	}

	@Override
	public void agregaElemento(TipoHabitacion element) {
		String str = element.toString().toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		str = str.replaceAll("_", " ");
		
		this.addElement(str);
		values.put(str, element);
		
	}

	@Override
	public void setSelected(TipoHabitacion toSelect) {
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
