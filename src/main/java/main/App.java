package main;

import vista.MainView;
import vistaController.MainViewController;

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
		MainView vista = MainView.getView();
		MainViewController controlador = new MainViewController(vista);
		controlador.showView();
	}
}
