package presentacion.table;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public abstract class BaseTableModel<T> extends DefaultTableModel{

	private static final long serialVersionUID = 1L;
	
	protected List<String> columnas;
	public List<T> rows;
	protected TableColumnModel colModel;
	

	public BaseTableModel() {
		super(new Object[]{}, 0);

		columnas = new ArrayList<>();
		rows = new ArrayList<>();
		colModel = new DefaultTableColumnModel();
		
		
	}
	
	public void addColumn(String name, boolean resizable, int preferredWidth){
		this.columnas.add(name);
		
		this.addColumn(name);

		TableColumn c = new TableColumn(this.columnas.size() - 1);
		c.setHeaderValue(name);
		c.setResizable(resizable);
		c.setPreferredWidth(preferredWidth);
		
		colModel.addColumn(c);
		
	}
	
	public void clean(){
		this.setRowCount(0);
		this.rows.clear();
	}
	
	public void actualizeRows(List<T> newlist){
		clean();
		addRows(newlist);
	}
	
	public void addRows(List<T> toAdd){
		
		toAdd.forEach(t -> addRow(t));
		
	}
	
	public void addRow(T t){
		this.rows.add(t);
		this.addRow(toRow(t));
	}
	
	public T getRow(int i){
		return this.rows.get(i);
	}
	
	public TableColumnModel getTableColumnModel(){
		return colModel;
	}
	
    @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
	
	protected abstract Object[] toRow(T t);

	
}
