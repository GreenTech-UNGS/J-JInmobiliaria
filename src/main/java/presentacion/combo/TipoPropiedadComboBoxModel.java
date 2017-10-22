package presentacion.combo;

import java.util.List;

import entities.TipoPropiedad;

public class TipoPropiedadComboBoxModel extends BaseComboBoxModel<TipoPropiedad>{

	@Override
	public void actualize(List<TipoPropiedad> list) {
		list.forEach(e -> agregaElemento(e));
	}

	@Override
	public void agregaElemento(TipoPropiedad element) {
		String str = element.toString().toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		str = str.replaceAll("_", " ");
		
		this.addElement(str);
		values.put(str, element);
		
	}

	@Override
	public void setSelected(TipoPropiedad toSelect) {
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

}
