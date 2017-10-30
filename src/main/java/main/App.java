package main;

import java.util.TimeZone;
import java.util.stream.Collectors;

import org.joda.time.DateTimeZone;

import com.google.inject.Guice;
import com.google.inject.Injector;

import misc.ProdModule;
import model.NotificacionesService;
import model.permisos.PermisosService;
import presentacion.main.controller.LoginController;
import presentacion.main.controller.MainViewController;

public class App{
	
    static Injector injector = Guice.createInjector(new ProdModule());
    
    public static void main( String[] args ){
        showMainView();
    }
    
    private static void showMainView(){
    	
    	LoginController controlador = injector.getInstance(LoginController.class);
    	PermisosService permisos = injector.getInstance(PermisosService.class);
    	
    	startNotificationThread();
    	
    	DateTimeZone.setDefault(DateTimeZone.UTC);

    	controlador.addLoginListener(() -> permisos.setupViews(injector
    			.getAllBindings()
    			.values()
    			.stream()
    			.map(v -> v.getProvider().get())
    			.collect(Collectors.toList())));
    	
		controlador.showView();
	}
    
    private static void startNotificationThread() {
    	
    	MainViewController controller = injector.getInstance(MainViewController.class);
    	NotificacionesService service = injector.getInstance(NotificacionesService.class);
    	
    	service.addCallback(n -> controller.acceptNotificacion(n));
    	
    	Thread t = new Thread(() -> {
    		while(true) {
    		try {
				Thread.sleep(10000);
				service.fetch();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		}
    		
    	});
    	
    	t.setDaemon(true);
    	t.start();
    	
    }
}
