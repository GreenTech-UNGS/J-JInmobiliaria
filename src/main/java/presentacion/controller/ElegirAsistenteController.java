package presentacion.controller;

import javax.swing.ListSelectionModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import entities.Persona;
import entities.PersonaBasica;
import model.PersonaService;
import presentacion.table.PersonaBasicaTableModel;
import presentacion.table.PersonaTableModel;
import presentacion.vista.ElegirPersonaView;

@Singleton
public class ElegirAsistenteController {

	ElegirPersonaView view;
	
	@Inject PersonaService personaService;
	
	private PersonaBasicaTableModel personaTable;
	
	@Inject
	private ElegirAsistenteController(ElegirPersonaView view) {
		
		this.view = view;
		
		personaTable = new PersonaBasicaTableModel();

		view.getBtnSeleccionar().addActionListener(e -> view.setVisible(false));
		view.getTablePersonas().setModel(personaTable);
		view.getTablePersonas().setColumnModel(personaTable.getTableColumnModel());
		view.getTablePersonas().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		view.getTablePersonas().getTableHeader().setReorderingAllowed(false);
		
	}

	private void fillTable() {

		personaTable.clean();
		personaTable.actualizeRows(personaService.getBasicas());
		
		
	}
	
	public void showView() {
		fillTable();
		this.view.setVisible(true);
	}

	public PersonaBasica getAsistente() {
		
		int selected = view.getTablePersonas().getSelectedRow();
		
		if(selected == -1) return null;
		
		return personaTable.getRow(selected);
		
	}
}
