package presentacion.main.controller;

import com.google.inject.Inject;

import presentacion.main.vista.MainView;

public class MainViewController {
	
	private MainView view;
	private MenuPanelController menuController;
	
	@Inject
	private MainViewController(MainView view,
			MenuPanelController menuController){
		
		this.view = view;
		this.menuController = menuController;
		
		this.menuController.showView();

	}


	public void showView(){
		this.view.show();
	}


}
