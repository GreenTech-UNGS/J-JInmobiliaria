package presentacion.vista;

import com.google.inject.Inject;
import presentacion.controller.ElegirClienteController;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ReservarPropiedadView extends JDialog {
	
	private JPanel panel;
	private JButton btnGuardar;
	private JButton btnCancelar;

	private JButton btnSelecCliente;
	private JButton btnSelecPropiedad;

	private JTextField tfCliente;
	private JTextField tfPropiedad;

	@Inject
    private ReservarPropiedadView(){
		super();
		
		setTitle("Reservar propiedad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(350, 420));
		setResizable(false);
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Cliente:");
		lblNombre.setBounds(20, 83, 80, 20);
		panel.add(lblNombre);
		
		JLabel lblMail = new JLabel("Propiedad:");
		lblMail.setBounds(20, 145, 80, 20);
		panel.add(lblMail);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(20, 330, 135, 42);
		panel.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(189, 330, 123, 42);
		panel.add(btnCancelar);

		btnSelecCliente = new JButton("+");
		btnSelecCliente.setBounds(270, 83, 40, 20);
		panel.add(btnSelecCliente);

		btnSelecPropiedad = new JButton("+");
		btnSelecPropiedad.setBounds(270, 145, 40, 20);
		panel.add(btnSelecPropiedad);

		tfCliente = new JTextField();
		tfCliente.setEditable(false);
        tfCliente.setBounds(110, 83, 150, 20);
        panel.add(tfCliente);

        tfPropiedad = new JTextField();
		tfPropiedad.setEditable(false);
		tfPropiedad.setBounds(110, 145, 150, 20);
		panel.add(tfPropiedad);
	}

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnSelecCliente() {
        return btnSelecCliente;
    }

    public JButton getBtnSelecPropiedad() {
        return btnSelecPropiedad;
    }

    public JTextField getTfCliente() {
        return tfCliente;
    }

    public JTextField getTfPropiedad() {
        return tfPropiedad;
    }
}
