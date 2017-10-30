package presentacion.combo;

import java.util.List;

import entities.Provincia;
import entities.TipoCita;

public class TipoCitaComboBoxModel extends BaseComboBoxModel<TipoCita>{


	@Override
	public void actualize(List<TipoCita> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(TipoCita toSelect) {
		if(toSelect == null){
			this.setSelectedItem(null);
		}
		else{
			
		String nombre = toSelect.toString();
		
		this.setSelectedItem(nombre);
		
		}
	}

	@Override
	public void agregaElemento(TipoCita element) {
		this.addElement(element.toString());
		values.put(element.toString(), element);
		
	}

}
