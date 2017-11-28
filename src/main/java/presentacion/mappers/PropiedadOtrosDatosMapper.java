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
		Integer ambientes = (int) view.getSpinnerAmbientes().getValue();
		Integer metrosCubiertos = (int) view.getSpinnerCubiertos().getValue();
		Integer metrosLote = (int) view.getSpinnerLote().getValue();
		
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
		Integer ambientes = t.getCantidadAmbientes();
		Integer metrosCubiertos = t.getMetrosCuadradosCubiertos();
		Integer metrosLote = t.getMetrosCuadradosLote();
		
		view.getTipoCombo().setSelected(tipo);
		view.getChckbxAptoACredito().setSelected(aptoCred);
		view.getSpinnerAmbientes().setValue(getIntegerValue(ambientes));
		view.getSpinnerCubiertos().setValue(getIntegerValue(metrosCubiertos));
		view.getSpinnerLote().setValue(getIntegerValue(metrosLote));
		
	}
	
	public int getIntegerValue(Integer i){
		
		if(i == null) 
			return 0;
		else 
			return i.intValue();
	}
	
}
