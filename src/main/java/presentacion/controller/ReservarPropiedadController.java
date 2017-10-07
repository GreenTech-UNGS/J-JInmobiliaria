package presentacion.controller;

import com.google.inject.Inject;
import entities.Cliente;
import entities.Propiedad;
import misc.Binder;
import model.ClienteService;
import model.PropiedadService;
import presentacion.combo.ClienteComboBoxModel;
import presentacion.combo.PropiedadComboBoxModel;
import presentacion.vista.ElegirCliente;
import presentacion.vista.ReservarPropiedadView;

import java.util.List;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    private PropiedadService propiedadService;
    private ClienteService clienteService;

    private ElegirClienteController clienteController;
    private ElegirPropiedadController propiedadController;

    private PropiedadComboBoxModel propiedadComboBoxModelModel;
    private ClienteComboBoxModel clienteComboBoxModel;

    Propiedad currentPropiedad;
    Cliente currentCliente;

    private Binder<Cliente> clienteBinder;
    private Binder<Propiedad> propiedadBinder;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view,
                                       PropiedadService propiedadService,
                                       ClienteService clienteService,
                                       ElegirClienteController clienteController,
                                       ElegirPropiedadController propiedadController) {
        this.view = view;
        this.propiedadService = propiedadService;
        this.clienteService = clienteService;
        this.propiedadComboBoxModelModel = new PropiedadComboBoxModel();
        this.clienteComboBoxModel = new ClienteComboBoxModel();
        this.clienteController = clienteController;
        this.propiedadController = propiedadController;

        view.getBtnCancelar().addActionListener(e -> closeView());
        view.getBtnSelecCliente().addActionListener(e -> selectCliente());
        view.getBtnSelecPropiedad().addActionListener(e -> selectPropiedad());


        this.clienteBinder = new Binder<>();
        this.propiedadBinder = new Binder<>();

    }

    private void selectPropiedad() {
        this.propiedadController.showView();
        Propiedad propiedad = propiedadController.getPropiedad();

        if(propiedad != null){

        }

    }

    private void selectCliente() {
        this.clienteController.showView();
        Cliente cliente = clienteController.getCliente();

        if (cliente != null){
            currentCliente = cliente;
        }
    }

    public void showView() {
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }
}
