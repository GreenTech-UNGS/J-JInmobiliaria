package presentacion.combo;

import java.util.List;

import entities.Provincia;
import entities.TipoContratoAlquiler;
import entities.TipoOfrecimiento;

public class TipoContratoAlqComboBoxModel extends BaseComboBoxModel<TipoContratoAlquiler>{


	@Override
	public void actualize(List<TipoContratoAlquiler> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(TipoContratoAlquiler toSelect) {
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

	@Override
	public void agregaElemento(TipoContratoAlquiler element) {
		String str = element.toString().toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		str = str.replaceAll("_", " ");
		
		this.addElement(str);
		values.put(str, element);
		
	}

	
}
