package presentacion.controller;

import com.google.inject.Inject;

import entities.Inmobiliaria;
import misc.Binder;
import model.InmobiliariaService;
import presentacion.vista.InmobiliariaForm;

public class InmobiliariaController {
	
	private InmobiliariaForm view;
	private InmobiliariaService inmobiliariaService;
	private Inmobiliaria currentInmobiliaria;
	private Binder<Inmobiliaria> binder;
	
	@Inject
	private InmobiliariaController(InmobiliariaForm view, InmobiliariaService inmobiliariaService){
		this.view = view;
		this.inmobiliariaService = inmobiliariaService;
		this.binder = new Binder<>();
	}
	
	public void showView(){
		view.setVisible(true);
	}
	
	public void setModeNew() {
		currentInmobiliaria = new Inmobiliaria();
		binder.setObjective(currentInmobiliaria);
		binder.fillFields();
	}

}