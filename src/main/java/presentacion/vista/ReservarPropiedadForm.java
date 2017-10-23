package presentacion.vista;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

@SuppressWarnings("serial")
public class ReservarPropiedadForm extends JDialog {
	
	private JPanel panel;
	private JButton btnGuardar;
	private JButton btnCancelar;

	private JButton btnSelecCliente;
	private JButton btnSelecPropiedad;

	private JTextField tfCliente;
	private JTextField tfPropiedad;

	@Inject
    private ReservarPropiedadForm(){
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
		lblNombre.setBounds(20, 83, 57, 20);
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

		btnSelecCliente = new JButton("");
		btnSelecCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSelecCliente.setBounds(257, 83, 32, 20);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		btnSelecCliente.setIcon(new ImageIcon(imgLup));
		panel.add(btnSelecCliente);

		btnSelecPropiedad = new JButton("");
		btnSelecPropiedad.setBounds(257, 145, 32, 20);
		btnSelecPropiedad.setIcon(new ImageIcon(imgLup));
		panel.add(btnSelecPropiedad);

		tfCliente = new JTextField();
		tfCliente.setEditable(false);
        tfCliente.setBounds(97, 83, 150, 20);
        panel.add(tfCliente);

        tfPropiedad = new JTextField();
		tfPropiedad.setEditable(false);
		tfPropiedad.setBounds(97, 145, 150, 20);
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
