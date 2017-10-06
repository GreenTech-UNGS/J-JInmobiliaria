package presentacion.combo;

import java.util.List;

import entities.Moneda;
import entities.Provincia;

public class MonedaComboBoxModel extends BaseComboBoxModel<Moneda>{

	@Override
	public void actualize(List<Moneda> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(Moneda toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString().replaceAll("_", " ");
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(Moneda element) {
		this.addElement(element.toString().replaceAll("_", " "));
		values.put(element.toString().replaceAll("_", " "), element);
		
	}

}
