package presentacion.main.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Notificacion;
import presentacion.main.vista.MainView;
import presentacion.vista.NotificacionView;

@Singleton
public class MainViewController {
	
	private MainView view;
	private MenuPanelController menuController;
	
	@Inject
	private MainViewController(MainView view,
			MenuPanelController menuController){
		
		this.view = view;
		this.menuController = menuController;
		
		this.menuController.showView();
		this.menuController.actualizeAll();

	}


	public void showView(){
		this.view.show();
	}
	
	public void acceptNotificacion(Notificacion n) {
		
		NotificacionView nView = new NotificacionView();
		nView.getLblTitulo().setText(n.getTitulo());
		
		view.getPanelNotificaciones().removeAll();
		
		view.getPanelNotificaciones().add(nView);
		
	}


}
