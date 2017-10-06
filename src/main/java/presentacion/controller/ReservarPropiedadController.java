package presentacion.controller;

import com.google.inject.Inject;
import entities.Cliente;
import entities.Propiedad;
import misc.Binder;
import model.PropiedadService;
import presentacion.combo.PropiedadComboBoxModel;
import presentacion.vista.ReservarPropiedadView;

import java.util.List;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    private PropiedadService propiedadService;

    private PropiedadComboBoxModel propiedadComboBoxModelModel;

    private Binder<Cliente> clienteBinder;
    private Binder<Propiedad> propiedadBinder;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view,
                                       PropiedadService propiedadService) {
        this.view = view;
        this.propiedadService = propiedadService;
        this.propiedadComboBoxModelModel = new PropiedadComboBoxModel();

        view.getBtnCancelar().addActionListener(e -> closeView());

        this.clienteBinder = new Binder<>();
        this.propiedadBinder = new Binder<>();

        fillComboCliente();
        fillComboPropiedad();
    }

    private void fillComboCliente(){

    }

    private void fillComboPropiedad(){
        //TODO verificar que esto ande, no se ha probado aún
        List<Propiedad> list = propiedadService.getAll();
        System.out.println(list);
        propiedadComboBoxModelModel.actualize(list);
        //propiedadComboBoxModelModel.setSelected(list.get(0));
        view.getComboPropiedad().setModel(propiedadComboBoxModelModel);
    }

    public void showView(){
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }
}
