package misc;

import com.google.inject.Binder;
import com.google.inject.Module;

import vista.AddContratoAlq;
import vista.AgregarCliente;
import vista.AgregarPropiedad;
import vista.MainView;
import vistaController.AddContratoController;
import vistaController.AddPropiedadesController;
import vistaController.AgregarClienteController;

public class ProdModule implements Module{

	@Override
	public void configure(Binder binder) {
		
		binder.bind(MainView.class).asEagerSingleton();
		binder.bind(AgregarCliente.class).asEagerSingleton();
		binder.bind(AddContratoAlq.class).asEagerSingleton();
		binder.bind(AgregarPropiedad.class).asEagerSingleton();
		binder.bind(MainView.class).asEagerSingleton();
		binder.bind(MainView.class).asEagerSingleton();
		binder.bind(AddPropiedadesController.class).asEagerSingleton();
		binder.bind(AddContratoController.class).asEagerSingleton();
		binder.bind(AgregarClienteController.class).asEagerSingleton();
	}
	

}
