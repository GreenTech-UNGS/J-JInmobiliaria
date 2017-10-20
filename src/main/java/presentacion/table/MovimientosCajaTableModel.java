package presentacion.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.google.inject.Singleton;

import entities.Egreso;
import entities.Ingreso;
import entities.MovimientoCaja;

public class MovimientosCajaTableModel extends BaseTableModel<MovimientoCaja>{

	private class MovimientoCajaCellRenderer extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			MovimientosCajaTableModel model = (MovimientosCajaTableModel) table.getModel();
	        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        c.setBackground(model.getRowColor(row));
	        return c;
		}
	}
	
	public MovimientosCajaTableModel() {
		super.addColumn("Fecha", false, 100);
		super.addColumn("Monto", false, 100);
		super.addColumn("Descripcion", false, 200);
	}
	
	@Override
	protected Object[] toRow(MovimientoCaja t) {
		
		String fecha = t.getFecha().toString("YYYY-MM-DD HH:mm");
		String monto = t.getMonto().getMonto() + " " + t.getMonto().getMoneda().toString();
		String descripcion = t.getDetalle();
		
		if(t instanceof Ingreso) {
			monto = "+ " + monto;
		}
		else {
			monto = "- " + monto;
		}
		
		Object[] toRet = {fecha,
						monto,
						descripcion};
		
		return toRet;
	}
	
	protected Color getRowColor(int row) {
		if(getRow(row) instanceof Egreso) {
			return Color.red;
		}
		else {
			return Color.green;
		}
	}
	
	public DefaultTableCellRenderer getCellRenderer() {
		return new MovimientoCajaCellRenderer();
	}


}
