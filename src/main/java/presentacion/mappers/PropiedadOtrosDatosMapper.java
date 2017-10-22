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
		// TODO Auto-generated method stub
		
	}
	
	
}
