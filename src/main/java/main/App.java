package main;

import com.google.inject.Guice;
import com.google.inject.Injector;

import misc.ProdModule;
import presentacion.controller.MainViewController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        showMainView();
    }
    
    private static void showMainView(){
    	Injector injector = Guice.createInjector(new ProdModule());
    	
    	
    	MainViewController controlador = injector.getInstance(MainViewController.class);
		controlador.showView();
	}
}
