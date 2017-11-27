package presentacion.combo;

import java.util.Collection;
import java.util.List;

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
			
		String nombre = toSelect.getNombre().replaceAll("_", " ");
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(Provincia element) {
		this.addElement(element.getNombre().replaceAll("_", " "));
		values.put(element.getNombre().replaceAll("_", " "), element);
		
	}
	
	public Provincia getPorNombre(String nombre) {
		return values.get(nombre);
	}
	
	public Collection<Provincia> getProvincias(){
		return values.values();
	}

}
