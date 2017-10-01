package vistaController;

import vista.MainView;

public class MainViewController {
	
	private MainView view = MainView.getView();
	
	AddPropiedadesController PropiedadesController = AddPropiedadesController.getController();
	
	public MainViewController(MainView vista){
		
		this.view = vista;
		
		this.view.getBtnPropiedades().addActionListener(e -> agregarPropiedad());
	}
	
	public void showView(){
		this.view.show();
	}

	private void agregarPropiedad(){
		this.PropiedadesController.showView();;
	}
}
