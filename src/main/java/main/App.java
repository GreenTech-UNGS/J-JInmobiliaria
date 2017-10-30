package main;

import java.util.TimeZone;
import java.util.stream.Collectors;

import org.joda.time.DateTimeZone;

import com.google.inject.Guice;
import com.google.inject.Injector;

import misc.ProdModule;
import model.permisos.PermisosService;
import presentacion.main.controller.LoginController;

public class App{
    public static void main( String[] args ){
        showMainView();
    }
    
    private static void showMainView(){
    	Injector injector = Guice.createInjector(new ProdModule());
    	
    	LoginController controlador = injector.getInstance(LoginController.class);
    	PermisosService permisos = injector.getInstance(PermisosService.class);
    	
    	DateTimeZone.setDefault(DateTimeZone.UTC);

    	controlador.addLoginListener(() -> permisos.setupViews(injector
    			.getAllBindings()
    			.values()
    			.stream()
    			.map(v -> v.getProvider().get())
    			.collect(Collectors.toList())));
    	
		controlador.showView();
	}
}
