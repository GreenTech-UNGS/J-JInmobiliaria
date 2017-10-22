package presentacion.mappers;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.PropiedadOtrosDatos;
import entities.TipoPropiedad;
import presentacion.vista.PropiedadOtrosDatosForm;

@Singleton
public class PropiedadOtrosDatosMapper implements Mapper<PropiedadOtrosDatos>{

	private PropiedadOtrosDatosForm view;
	
	@Inject
	private PropiedadOtrosDatosMapper(PropiedadOtrosDatosForm view) {
		this.view = view;
	}

	@Override
	public void fillBean(PropiedadOtrosDatos t) {
		TipoPropiedad tipo = view.getTipoCombo().getSelected();
		boolean aptoCred = view.getChckbxAptoACredito().isSelected();
		int ambientes = (int) view.getSpinnerAmbientes().getValue();
		int metrosCubiertos = (int) view.getSpinnerCubiertos().getValue();
		int metrosLote = (int) view.getSpinnerLote().getValue();
		
		t.setCantidadAmbientes(ambientes);
		t.setEsAptoCredito(aptoCred);
		t.setMetrosCuadradosCubiertos(metrosCubiertos);
		t.setMetrosCuadradosLote(metrosLote);
		t.setTipo(tipo);
	
	}

	@Override
	public void fillFields(PropiedadOtrosDatos t) {
		TipoPropiedad tipo = t.getTipo();
		boolean aptoCred = t.isAptoCredito();
		int ambientes = t.getCantidadAmbientes();
		int metrosCubiertos = t.getMetrosCuadradosCubiertos();
		int metrosLote = t.getMetrosCuadradosLote();
		
		view.getTipoCombo().setSelected(tipo);
		view.getChckbxAptoACredito().setSelected(aptoCred);
		view.getSpinnerAmbientes().setValue(ambientes);
		view.getSpinnerCubiertos().setValue(metrosCubiertos);
		view.getSpinnerLote().setValue(metrosLote);
		
	}
	
	
}
