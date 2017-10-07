package presentacion.controller;

import com.google.inject.Inject;
import entities.Cliente;
import entities.Propiedad;
import model.ClienteService;
import model.PropiedadService;
import presentacion.combo.ClienteComboBoxModel;
import presentacion.combo.PropiedadComboBoxModel;
import presentacion.vista.ReservarPropiedadView;

import java.util.List;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    private PropiedadService propiedadService;
    private ClienteService clienteService;
    private PropiedadComboBoxModel propiedadComboBoxModelModel;
    private ClienteComboBoxModel clienteComboBoxModel;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view,
                                       PropiedadService propiedadService,
                                       ClienteService clienteService) {
        this.view = view;
        this.propiedadService = propiedadService;
        this.clienteService = clienteService;
        this.propiedadComboBoxModelModel = new PropiedadComboBoxModel();
        this.clienteComboBoxModel = new ClienteComboBoxModel();

        view.getBtnCancelar().addActionListener(e -> closeView());

        fillComboCliente();
        fillComboPropiedad();
    }

    void fillComboCliente() {
        //TODO se conecta siempre a la base de datos. Es viable arreglarlo?
        view.getComboCliente().removeAllItems();

        List<Cliente> listCliente = clienteService.getAll();

        clienteComboBoxModel.actualize(listCliente);
        view.getComboCliente().setModel(clienteComboBoxModel);

        clienteComboBoxModel.setSelected(null);
    }

    void fillComboPropiedad() {
        //TODO verificar que esto ande, no se ha probado aún
        view.getComboPropiedad().removeAllItems();
        List<Propiedad> listPropiedad = propiedadService.getAll();

        propiedadComboBoxModelModel.actualize(listPropiedad);
        view.getComboPropiedad().setModel(propiedadComboBoxModelModel);

        propiedadComboBoxModelModel.setSelected(null);
    }

    public void showView() {
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }
}
