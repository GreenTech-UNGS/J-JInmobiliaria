package presentacion.controller;

import java.awt.Button;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import dto.Notificacion;
import model.NotificacionesService;
import presentacion.main.vista.MainView;
import presentacion.vista.NotificacionView;

@Singleton
public class NotificacionController {
	
	private JPanel view;
	
	private Map<NotificacionView, Notificacion> notificaciones;
	@Inject private NotificacionesService notificacionService;
	
	@Inject
	public NotificacionController(MainView view) {
		
		this.view = view.getPanelNotificaciones();
		this.notificaciones = new HashMap<>();
		
	}
	
	public void clear(){
		notificaciones.clear();
		view.removeAll();
		view.revalidate();
	}
	
	public void acceptNotificacion(Notificacion n) {
		
		NotificacionView notifView = new NotificacionView();
		notifView.getLblTitulo().setText(n.getTitulo());
		notifView.getLblDescripcion().setText(n.getDescripcion());
		
		notificaciones.put(notifView, n);
		
		notifView.getBtnOk().addActionListener(e -> 
			cierraNotificacion((NotificacionView)((JButton)e.getSource()).getParent())
			);
		
		
		view.add(notifView);
		
	}
	
	private void cierraNotificacion(NotificacionView nView){
		notificaciones.get(nView).getAvisoNotif().setVisto(true);
		nView.setVisible(false);
		view.remove(nView);
		
		System.out.println(notificaciones.get(nView).getAvisoNotif().isVisto());
		
		
		
		view.revalidate();
		
		notificacionService.save(notificaciones.get(nView).getAvisoNotif());
		notificaciones.remove(nView);
	}
	
}
