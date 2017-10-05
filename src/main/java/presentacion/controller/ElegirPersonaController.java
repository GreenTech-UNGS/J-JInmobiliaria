package presentacion.controller;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona;
import model.PersonaService;
import presentacion.table.PersonaTableModel;
import presentacion.vista.ElegirPersonaView;

@Singleton
public class ElegirPersonaController {

	PersonaService personaService;
	ElegirPersonaView view;
	
	PersonaTableModel personaTable;
	
	@Inject
	private ElegirPersonaController(ElegirPersonaView view, PersonaService personaService) {
		
		this.view = view;
		this.personaService = personaService;
		
		personaTable = new PersonaTableModel();
		
		fillTable();
		
	}

	private void fillTable() {
		view.getTablePersonas().setModel(personaTable);
		view.getTablePersonas().setColumnModel(personaTable.getTableColumnModel());
		view.getTablePersonas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		personaTable.clean();
		personaTable.actualizeRows(personaService.getAll());
		
		view.getBtnSeleccionar().addActionListener(e -> view.setVisible(false));
		
	}
	
	public void showView() {
		this.view.setVisible(true);
	}

	public Persona getPersona() {
		
		int selected = view.getTablePersonas().getSelectedRow();
		
		if(selected == -1) return null;
		
		return personaTable.getRow(selected);
		
	}
}
