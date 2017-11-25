package presentacion.main.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DoubleClickListener extends MouseAdapter{
	
	private Runnable r;
	
	public DoubleClickListener(Runnable r) {
		this.r = r;
	}
	
	@Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
        	r.run();
        }
    }

}
