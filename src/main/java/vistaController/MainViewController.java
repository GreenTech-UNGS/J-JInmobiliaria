package vistaController;

import vista.MainView;

public class MainViewController {
	
	private MainView view = MainView.getView();
	
	AddPropiedadesController propiedadesController = AddPropiedadesController.getController();
	AddContratoController contratoController = AddContratoController.getController();
	
	public MainViewController(MainView vista){
		
		this.view = vista;
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
		this.view.getBtnContrato().addActionListener(e -> agregarContrato());
	}

	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.propiedadesController.showView();;
	}
	
	private Object agregarContrato() {
		this.contratoController.showView();
		return null;
	}
}
