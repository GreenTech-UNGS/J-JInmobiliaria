package presentacion.combo;

import java.util.List;

import entities.TipoHabitacion;

public class TipoHabitacionComboBoxModel extends BaseComboBoxModel<TipoHabitacion>{

	@Override
	public void actualize(List<TipoHabitacion> list) {
		list.forEach(e -> agregaElemento(e));
	}

	@Override
	public void agregaElemento(TipoHabitacion element) {
		String str = element.getNombre();
		
		this.addElement(str);
		values.put(str, element);
		
	}

	@Override
	public void setSelected(TipoHabitacion toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			

			String str = toSelect.getNombre();
		
			this.setSelectedItem(str);
		
		}
		
	}

}
