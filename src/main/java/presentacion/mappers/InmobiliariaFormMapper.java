package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Inmobiliaria;
import entities.Localidad;
import presentacion.vista.InmobiliariaForm;

@Singleton
public class InmobiliariaFormMapper implements Mapper<Inmobiliaria>{

	private InmobiliariaForm view;
	
	@Inject
	private InmobiliariaFormMapper(InmobiliariaForm view) {
		this.view = view;
	}
	
	@Override
	public void fillBean(Inmobiliaria t) {
		String CUIT = view.getTfCuit().getText();
		String nombre = view.getTfNombre().getText();
		String calle = view.getTfCalle().getText();
		String altura = view.getTfAltura().getText();
		String piso = view.getTfPiso().getText();
		String depto = view.getTfDepto().getText();
		String email = view.getTfEmail().getText();
		
		Localidad localidad = view.getComboModelLocalidad().getSelected();
		
		
		
		t.setCUIT(CUIT);
		t.setNombre(nombre);
		t.setCalle(calle);
		t.setAltura(altura);
		t.setPiso(piso);
		t.setDepto(depto);
		t.setEmail(email);
		t.setLocalidad(localidad);
	}

	@Override
	public void fillFields(Inmobiliaria t) {
		String CUIT = t.getCUIT();
		String nombre = t.getNombre();
		String calle = t.getCalle();
		String altura = t.getAltura();
		String piso = t.getPiso();
		String depto = t.getDepto();
		String email = t.getEmail();
		
		view.getTfCuit().setText(CUIT);
		view.getTfNombre().setText(nombre);
		view.getTfCalle().setText(calle);
		view.getTfAltura().setText(altura);
		view.getTfPiso().setText(piso);
		view.getTfDepto().setText(depto);
		view.getTfEmail().setText(email);

//		view.getComboModelLocalidad().setSelected(t.getLocalidad());
		
		view.getComboModelLocalidad().setSelected(t.getLocalidad());
		if(t.getLocalidad() != null)
			view.getComboModelProvincia().setSelected(t.getLocalidad().getProvincia());
//		view.getCbLocalidad().setSelectedItem(t.getLocalidad());
//		view.getCbProvincia().setSelectedItem(t.getLocalidad().getProvincia());
//		view.getCbLocalidad().getModel().setSelectedItem(t.getLocalidad());
		
	}

}
