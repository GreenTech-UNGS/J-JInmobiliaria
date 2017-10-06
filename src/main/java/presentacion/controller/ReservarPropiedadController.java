package presentacion.controller;

import com.google.inject.Inject;
import presentacion.vista.ReservarPropiedadView;

public class ReservarPropiedadController {
    private ReservarPropiedadView view;

    @Inject
    public ReservarPropiedadController(ReservarPropiedadView view) {
        this.view = view;

        view.getBtnCancelar().addActionListener(e -> closeView());
    }

    public void showView(){
        view.setVisible(true);
    }

    private void closeView() {
        view.setVisible(false);
    }
}
