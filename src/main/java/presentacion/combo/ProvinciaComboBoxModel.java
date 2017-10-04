package presentacion.combo;

import java.util.List;

import entities.Persona.TipoCredencial;
import entities.Provincia;

public class ProvinciaComboBoxModel extends BaseComboBoxModel<Provincia>{

	
	@Override
	public void actualize(List<Provincia> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(Provincia toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString();
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(Provincia element) {
		this.addElement(element.toString().replaceAll("_", " "));
		values.put(element.toString().replaceAll("_", " "), element);
		
	}

}
