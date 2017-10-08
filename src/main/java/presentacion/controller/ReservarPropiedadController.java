package presentacion.controller;

import com.google.inject.Inject;
import entities.Cliente;
import entities.Propiedad;
import entities.Reserva;
import misc.Binder;
import model.ClienteService;
import model.PropiedadService;
import model.ReservaService;
import org.joda.time.DateTime;
import presentacion.combo.ClienteComboBoxModel;
import presentacion.combo.PropiedadComboBoxModel;
import presentacion.vista.ElegirCliente;
import presentacion.vista.ReservarPropiedadView;

import java.util.Date;
import java.util.List;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    private PropiedadService propiedadService;
    private ClienteService clienteService;
    ReservaService reservaService;

    private ElegirClienteController clienteController;
    private ElegirPropiedadController propiedadController;

    private PropiedadComboBoxModel propiedadComboBoxModelModel;
    private ClienteComboBoxModel clienteComboBoxModel;

    Reserva currentReserva;
    Propiedad currentPropiedad;
    Cliente currentCliente;

    private Binder<Cliente> clienteBinder;
    private Binder<Propiedad> propiedadBinder;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view,
                                       PropiedadService propiedadService,
                                       ClienteService clienteService,
                                       ReservaService reservaService,
                                       ElegirClienteController clienteController,
                                       ElegirPropiedadController propiedadController) {
        this.view = view;
        this.propiedadService = propiedadService;
        this.clienteService = clienteService;
        this.reservaService = reservaService;
        this.propiedadComboBoxModelModel = new PropiedadComboBoxModel();
        this.clienteComboBoxModel = new ClienteComboBoxModel();
        this.clienteController = clienteController;
        this.propiedadController = propiedadController;

        view.getBtnCancelar().addActionListener(e -> closeView());
        view.getBtnGuardar().addActionListener(e -> reservarPropiedad());
        view.getBtnSelecCliente().addActionListener(e -> selectCliente());
        view.getBtnSelecPropiedad().addActionListener(e -> selectPropiedad());


        this.clienteBinder = new Binder<>();
        this.propiedadBinder = new Binder<>();

    }

    private void reservarPropiedad() {
        reservaService.saveReserva(currentReserva);
        closeView();
    }

    private void selectPropiedad() {
        this.propiedadController.showView();
        Propiedad propiedad = propiedadController.getPropiedad();

        if(propiedad != null){
            currentPropiedad = propiedad;
            currentReserva.setPropiedad(currentPropiedad);
            view.getTfPropiedad().setText(currentPropiedad.getIdentificador() + " - " +
            currentPropiedad.getCalle() + " " + currentPropiedad.getAltura());
        }

    }

    private void selectCliente() {
        this.clienteController.showView();
        Cliente cliente = clienteController.getCliente();

        if (cliente != null){
            currentCliente = cliente;
            currentReserva.setReservador(currentCliente.getPersona());

            view.getTfCliente().setText(currentCliente.getPersona().getCredencial() + " - " +
            currentCliente.getPersona().getNombre() + " " + currentCliente.getPersona().getApellido());
        }
    }

    public void setModeNew(){
        view.setTitle("Reservar propiedad");

        currentReserva = reservaService.getEmptyReserva();
        currentPropiedad = null;
        currentCliente = null;
        throw new RuntimeException("No implementado aún");
    }

    public void showView() {
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }

}
