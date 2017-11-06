package presentacion.controller;

import com.google.inject.Inject;

import entities.Cliente;
import entities.Propiedad;
import entities.Reserva;
import model.ReservaService;
import presentacion.validators.MessageShow;
import presentacion.validators.ReservarPropiedadFormValidator;
import presentacion.vista.ReservarPropiedadForm;

public class ReservarPropiedadController {
    private ReservarPropiedadForm view;
    
    private ReservaService reservaService;
    private ReservarPropiedadFormValidator reservaValidator;
    private ElegirClienteController clienteController;
    private ElegirPropiedadController propiedadController;

    private Reserva currentReserva;
    private Propiedad currentPropiedad;
    private Cliente currentCliente;
    private MessageShow msgShw;


    @Inject
    public ReservarPropiedadController(ReservarPropiedadForm view,
                                       ReservaService reservaService,
                                       ReservarPropiedadFormValidator reservaValidator,
                                       ElegirClienteController clienteController,
                                       ElegirPropiedadController propiedadController,
                                       MessageShow msgShw) {
        this.view = view;
        this.reservaService = reservaService;
        this.reservaValidator = reservaValidator;
        this.clienteController = clienteController;
        this.propiedadController = propiedadController;
        this.msgShw = msgShw;

        view.getBtnCancelar().addActionListener(e -> closeView());
        view.getBtnGuardar().addActionListener(e -> reservarPropiedad());
        view.getBtnSelecCliente().addActionListener(e -> selectCliente());
        view.getBtnSelecPropiedad().addActionListener(e -> selectPropiedad());

    }

    private void reservarPropiedad() {

      if(reservaValidator.isValid()) {
     
            reservaService.saveReserva(currentReserva);
    		closeView();
        }
        else{
          msgShw.showErrorMessage(reservaValidator.getErrorMessage(), "Error");
      }
    }

    private void selectPropiedad() {
        this.propiedadController.showViewProp();
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
        view.getTfCliente().setText("");
        view.getTfPropiedad().setText("");

        currentReserva = reservaService.getEmptyReserva();
        currentPropiedad = null;
        currentCliente = null;
    }

    public void showView() {
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }

}
