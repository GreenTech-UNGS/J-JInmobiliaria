package presentacion.combo;

import entities.Propiedad;

import java.util.List;

public class PropiedadComboBoxModel extends BaseComboBoxModel<Propiedad> {
    @Override
    public void actualize(List<Propiedad> list) {
        list.forEach(p -> agregaElemento(p));
    }

    @Override
    public void agregaElemento(Propiedad element) {
        String addedElement = element.getIdentificador().toString();
        addElement(addedElement);
        values.put(addedElement, element);
    }

    @Override
    public void setSelected(Propiedad toSelect) {
        if(toSelect == null){
            this.setSelectedItem(null);
        }
        else{

            String nombre = toSelect.toString();

            this.setSelectedItem(nombre);

        }
    }
}
