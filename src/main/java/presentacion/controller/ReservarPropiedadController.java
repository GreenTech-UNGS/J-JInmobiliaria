package presentacion.controller;

import com.google.inject.Inject;
import entities.Cliente;
import entities.Propiedad;
import misc.Binder;
import presentacion.vista.ReservarPropiedadView;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    private Binder<Cliente> clienteBinder;
    private Binder<Propiedad> propiedadBinder;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view) {
        this.view = view;

        view.getBtnCancelar().addActionListener(e -> closeView());

        this.clienteBinder = new Binder<>();
        this.propiedadBinder = new Binder<>();
    }

    private void fillComboCliente(){

    }



    public void showView(){
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }
}
