package presentacion.combo;

import java.util.List;

import com.google.inject.Singleton;

import entities.Telefono;
import entities.Telefono.Tipo;

@Singleton
public class TipoTelefonoComboBoxModel extends BaseComboBoxModel<Telefono.Tipo>{

	@Override
	public void actualize(List<Tipo> list) {
		list.forEach(e -> this.addElement(e.toString()));
		list.forEach(e -> values.put(e.toString(), e));
	}

	@Override
	public void agregaElemento(Tipo element) {
		this.addElement(element.toString());
		values.put(element.toString(), element);
		
	}

	@Override
	public void setSelected(Tipo toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString();
		
		this.setSelectedItem(nombre);
		
		}
		
	}

	
	
}
