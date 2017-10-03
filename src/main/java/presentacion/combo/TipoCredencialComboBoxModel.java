package presentacion.combo;

import java.util.List;

import entities.Persona.TipoCredencial;

public class TipoCredencialComboBoxModel extends BaseComboBoxModel<TipoCredencial>{

	@Override
	public void actualize(List<TipoCredencial> list) {
		
		list.forEach(e -> this.addElement(e.toString()));
		list.forEach(e -> values.put(e.toString(), e));
		
	}

	@Override
	public void setSelected(TipoCredencial toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString();
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(TipoCredencial element) {
		this.addElement(element.toString());
		values.put(element.toString(), element);
		
	}

}
