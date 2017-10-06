package presentacion.combo;

import entities.Cliente;

import java.util.List;

public class ClienteComboBoxModel extends BaseComboBoxModel<Cliente> {
    @Override
    public void actualize(List<Cliente> list) {
        list.forEach(c -> agregaElemento(c));
    }

    @Override
    public void agregaElemento(Cliente element) {
        String addedElement = element.getID()+ " - "
                + element.getPersona().getNombre() + " " + element.getPersona().getApellido();
        addElement(addedElement);
        values.put(addedElement, element);
    }

    @Override
    public void setSelected(Cliente toSelect) {
        if(toSelect == null){
            this.setSelectedItem(null);
        }
        else{

            String nombre = toSelect.toString();

            this.setSelectedItem(nombre);

        }
    }
}
