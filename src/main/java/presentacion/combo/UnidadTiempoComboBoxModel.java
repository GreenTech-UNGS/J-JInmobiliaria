package presentacion.combo;

import java.util.List;

import entities.Moneda;
import entities.UnidadTiempo;

public class UnidadTiempoComboBoxModel extends BaseComboBoxModel<UnidadTiempo>{

	@Override
	public void actualize(List<UnidadTiempo> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(UnidadTiempo toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString().replaceAll("_", " ");
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(UnidadTiempo element) {
		this.addElement(element.toString().replaceAll("_", " "));
		values.put(element.toString().replaceAll("_", " "), element);
		
	}

}
