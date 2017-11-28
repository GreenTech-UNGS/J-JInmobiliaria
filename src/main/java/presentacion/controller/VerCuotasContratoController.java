package presentacion.controller;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.ContratoAlquiler;
import model.CuotaService;
import presentacion.table.CuotasTableModel;
import presentacion.vista.CuotasDeContratoView;

@Singleton
public class VerCuotasContratoController {
	
	private CuotasDeContratoView view;
	private CuotasTableModel cuotasModel;
	private CuotaService cuotaService;
	
	@Inject 
	public VerCuotasContratoController(CuotasDeContratoView view, CuotaService cuotaService){
		this.view = view;
		this.cuotaService = cuotaService;
		this.cuotasModel = new CuotasTableModel(cuotaService);
	}
	
	public void setModeView(ContratoAlquiler c){
		fillTable(c);
	}
	
	public void showView(){
		this.view.setVisible(true);
	}
	
	private void fillTable(ContratoAlquiler c){
		this.cuotasModel.clean();
		this.view.getTableCuotas().setModel(cuotasModel);

		cuotaService.getcuotasOf(c).forEach(e-> cuotasModel.addRow(e));
		this.view.getTableCuotas().getTableHeader().setReorderingAllowed(false);
	}
}
