package presentacion.vista;

import com.google.inject.Inject;
import presentacion.controller.ElegirClienteController;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ReservarPropiedadView extends JDialog {
	
	private JPanel panel;
	private JButton btnGuardar;
	private JButton btnCancelar;
    private ElegirClienteController clienteController;

	JButton btnSelecCliente;
	JButton btnSelecPropiedad;

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
		btnSelecCliente.setBounds(110, 83, 40, 20);
		panel.add(btnSelecCliente);

		btnSelecPropiedad = new JButton("+");
		btnSelecPropiedad.setBounds(110, 145, 40, 20);
		panel.add(btnSelecPropiedad);
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

}
