package presentacion.combo;

import java.util.List;

import entities.TipoOfrecimiento;

public class TipoOfrecimientoComboBoxModel extends BaseComboBoxModel<TipoOfrecimiento>{

	@Override
	public void actualize(List<TipoOfrecimiento> list) {
		
		list.forEach(e -> agregaElemento(e));
		
	}

	@Override
	public void setSelected(TipoOfrecimiento toSelect) {
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
	public void agregaElemento(TipoOfrecimiento element) {
		String str = element.toString().toLowerCase();
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		str = str.replaceAll("_", " ");
		
		this.addElement(str);
		values.put(str, element);
		
	}

}
