package presentacion.combo;

import java.util.List;

import entities.Localidad;

public class LocalidadComboBoxModel extends BaseComboBoxModel<Localidad>{

	
	@Override
	public void actualize(List<Localidad> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(Localidad toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.getNombre();
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(Localidad element) {
		this.addElement(element.getNombre());
		values.put(element.getNombre(), element);
		
	}

}
