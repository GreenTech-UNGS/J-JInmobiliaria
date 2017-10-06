package presentacion.vista;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Inject;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgregarPropiedad extends JDialog{

	private JPanel AgregarPropiedad;
	private JTextField tfAltura;
	private JTextField tfCalle;
	private JTextField tfPrecio;
	private JTextField tfIdentificador;
	private JTextField tfEntrecalles;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JComboBox<String> comboProvincia;
	private JComboBox<String> comboMoneda;
	private JComboBox<String> comboTipoOfre;
	private JTextArea taDescPubl;
	private JTextArea taDescPriv;

	private JButton btnGuardar;
	private JButton btnCancelar;
	private JComboBox<String> comboLocalidad;
	private JButton bttAddLoc;
	private JTextField tfPropietario;
	private JButton btnLupita;

	@Inject
	private AgregarPropiedad() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(574, 660));
		setResizable(false);
		setLocationRelativeTo(null);
		
		AgregarPropiedad = new JPanel();
		AgregarPropiedad.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(AgregarPropiedad);
		AgregarPropiedad.setLayout(null);
	
		
		JLabel lblPropierario = new JLabel("Propietario:");
		lblPropierario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropierario.setBounds(331, 87, 61, 14);
		AgregarPropiedad.add(lblPropierario);
		
		JLabel lblDireccin = new JLabel("Calle:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccin.setBounds(54, 209, 46, 14);
		AgregarPropiedad.add(lblDireccin);
		
		JLabel lblNewLabel = new JLabel("Tipo de ofrecimiento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(282, 62, 110, 14);
		AgregarPropiedad.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(331, 234, 61, 14);
		AgregarPropiedad.add(lblNewLabel_1);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(331, 209, 61, 14);
		AgregarPropiedad.add(lblProvincia);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(49, 234, 46, 14);
		AgregarPropiedad.add(lblAltura);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(54, 87, 46, 14);
		AgregarPropiedad.add(lblPrecio);
		
		this.tfAltura = new JTextField();
		tfAltura.setBounds(92, 234, 149, 20);
		AgregarPropiedad.add(tfAltura);
		tfAltura.setColumns(10);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(92, 206, 149, 20);
		AgregarPropiedad.add(tfCalle);
		tfCalle.setColumns(10);
		
		comboTipoOfre = new JComboBox<>();
		comboTipoOfre.setBounds(395, 59, 149, 20);
		AgregarPropiedad.add(comboTipoOfre);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(92, 87, 149, 20);
		AgregarPropiedad.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGuardar.setBounds(149, 563, 135, 42);
		AgregarPropiedad.add(btnGuardar);
		

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(293, 563, 123, 42);
		AgregarPropiedad.add(btnCancelar);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(41, 112, 54, 14);
		AgregarPropiedad.add(lblMoneda);
		
		comboMoneda = new JComboBox<>();
		comboMoneda.setBounds(92, 112, 149, 20);
		AgregarPropiedad.add(comboMoneda);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n privada:");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcin.setBounds(20, 458, 110, 14);
		AgregarPropiedad.add(lblDescripcin);
		
		taDescPubl = new JTextArea();
		taDescPubl.setBounds(20, 394, 524, 53);
		AgregarPropiedad.add(taDescPubl);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(20, 24, 123, 14);
		AgregarPropiedad.add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 49, 524, 2);
		AgregarPropiedad.add(separator);
		
		JLabel lblIdPropiedad = new JLabel("Identificador:");
		lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdPropiedad.setBounds(20, 62, 80, 14);
		AgregarPropiedad.add(lblIdPropiedad);
		
		tfIdentificador = new JTextField();
		tfIdentificador.setColumns(10);
		tfIdentificador.setBounds(92, 62, 149, 20);
		AgregarPropiedad.add(tfIdentificador);
		
		JLabel lblDatosUbicacionales = new JLabel("Datos ubicacionales:");
		lblDatosUbicacionales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosUbicacionales.setBounds(20, 171, 123, 14);
		AgregarPropiedad.add(lblDatosUbicacionales);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 196, 524, 2);
		AgregarPropiedad.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Entre calles:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(331, 262, 61, 14);
		AgregarPropiedad.add(lblNewLabel_2);
		
		tfEntrecalles = new JTextField();
		tfEntrecalles.setColumns(10);
		tfEntrecalles.setBounds(395, 259, 149, 20);
		AgregarPropiedad.add(tfEntrecalles);
		
		JLabel lblInmobiliariaAmiga = new JLabel("Inmobiliaria amiga:");
		lblInmobiliariaAmiga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInmobiliariaAmiga.setBounds(296, 118, 96, 14);
		AgregarPropiedad.add(lblInmobiliariaAmiga);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(395, 118, 149, 20);
		AgregarPropiedad.add(comboBox_3);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setBounds(54, 262, 31, 14);
		AgregarPropiedad.add(lblPiso);
		
		tfPiso = new JTextField();
		tfPiso.setColumns(10);
		tfPiso.setBounds(92, 259, 149, 20);
		AgregarPropiedad.add(tfPiso);
		
		JLabel lblDepartamento = new JLabel("Dpto.:");
		lblDepartamento.setBounds(49, 287, 46, 14);
		AgregarPropiedad.add(lblDepartamento);
		
		tfDepto = new JTextField();
		tfDepto.setColumns(10);
		tfDepto.setBounds(92, 284, 149, 20);
		AgregarPropiedad.add(tfDepto);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(20, 338, 71, 14);
		AgregarPropiedad.add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 363, 524, 2);
		AgregarPropiedad.add(separator_2);
		
		JLabel lblDescripcinPblica = new JLabel("Descripci\u00F3n p\u00FAblica:");
		lblDescripcinPblica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcinPblica.setBounds(20, 374, 96, 14);
		AgregarPropiedad.add(lblDescripcinPblica);
		
		taDescPriv = new JTextArea();
		taDescPriv.setBounds(20, 480, 524, 53);
		AgregarPropiedad.add(taDescPriv);
		
		comboProvincia = new JComboBox<>();
		comboProvincia.setBounds(395, 206, 149, 20);
		AgregarPropiedad.add(comboProvincia);
		
		comboLocalidad = new JComboBox<>();
		comboLocalidad.setBounds(396, 231, 102, 20);
		AgregarPropiedad.add(comboLocalidad);
		
		bttAddLoc = new JButton("+");
		bttAddLoc.setBounds(503, 230, 41, 23);
		AgregarPropiedad.add(bttAddLoc);
		
		tfPropietario = new JTextField();
		tfPropietario.setEditable(false);
		tfPropietario.setColumns(10);
		tfPropietario.setBounds(395, 84, 123, 20);
		AgregarPropiedad.add(tfPropietario);
		
		this.btnLupita = new JButton("New button");
//		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
//		btnLupita.setIcon(new ImageIcon(imgLup));
		btnLupita.setBounds(522, 83, 22, 23);
		AgregarPropiedad.add(btnLupita);
	}

	public JTextField getTfAltura() {
		return tfAltura;
	}

	public JTextField getTfCalle() {
		return tfCalle;
	}

	public JTextField getTfPrecio() {
		return tfPrecio;
	}

	public JTextField getTfIdentificador() {
		return tfIdentificador;
	}

	public JTextField getTfEntrecalles() {
		return tfEntrecalles;
	}

	public JTextField getTfPiso() {
		return tfPiso;
	}

	public JTextField getTfDepto() {
		return tfDepto;
	}

	public JComboBox<String> getComboProvincia() {
		return comboProvincia;
	}

	public JComboBox<String> getComboMoneda() {
		return comboMoneda;
	}

	public JComboBox<String> getComboTipoOfre() {
		return comboTipoOfre;
	}

	public JTextArea getTaDescPubl() {
		return taDescPubl;
	}

	public JTextArea getTaDescPriv() {
		return taDescPriv;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JComboBox<String> getComboLocalidad() {
		return comboLocalidad;
	}

	public JButton getBttAddLoc() {
		return bttAddLoc;
	}

	public JButton getBtnLupita() {
		return btnLupita;
	}

	public void setBtnLupita(JButton btnLupita) {
		this.btnLupita = btnLupita;
	}

	public JTextField getTfPropietario() {
		return tfPropietario;
	}

	public void setTfPropietario(JTextField tfPropietario) {
		this.tfPropietario = tfPropietario;
	}
	
	
	
	
}
