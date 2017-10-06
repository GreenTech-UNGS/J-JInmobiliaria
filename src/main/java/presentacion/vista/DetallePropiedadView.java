package presentacion.vista;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.google.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextPane;

public class DetallePropiedadView extends JDialog {
	private JTextField tfCalle;
	private JTextField tfAltura;
	private JTextField tfLoc;
	private JTextField tfEntrecalles;
	private JTextField tfIdentificador;
	private JTextField tfPrecio;
	private JTextField tfMoneda;
	private JTextField tfTipoOfrec;
	private JTextField tfPropietario;
	private JTextField tfInmobiliaria;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JTextField tfProvincia;
	private JTextPane tpDescPubl;
	private JTextPane tpDescPriv;
	
	@Inject
	private DetallePropiedadView(){
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(490, 590));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panelPrincipal = new JPanel();
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		JPanel panelDetalle = new JPanel();
		panelPrincipal.add(panelDetalle);
		panelDetalle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Datos ubicacionales");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(31, 163, 119, 14);
		panelDetalle.add(lblNewLabel);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCalle.setBounds(68, 201, 33, 14);
		panelDetalle.add(lblCalle);
		
		tfCalle = new JTextField();
		tfCalle.setBounds(110, 198, 86, 20);
		panelDetalle.add(tfCalle);
		tfCalle.setColumns(10);
		tfCalle.setEnabled(false);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura.setBounds(68, 226, 46, 14);
		panelDetalle.add(lblAltura);
		
		tfAltura = new JTextField();
		tfAltura.setBounds(110, 223, 86, 20);
		panelDetalle.add(tfAltura);
		tfAltura.setColumns(10);
		tfAltura.setEnabled(false);
		
		JLabel lblCiudad = new JLabel("Localidad:");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCiudad.setBounds(284, 226, 66, 14);
		panelDetalle.add(lblCiudad);
		
		tfLoc = new JTextField();
		tfLoc.setBounds(346, 223, 86, 20);
		panelDetalle.add(tfLoc);
		tfLoc.setColumns(10);
		tfLoc.setEnabled(false);
		
		JLabel lblProvincia = new JLabel("Entrecalles:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(284, 251, 57, 14);
		panelDetalle.add(lblProvincia);
		
		tfEntrecalles = new JTextField();
		tfEntrecalles.setBounds(346, 248, 86, 20);
		panelDetalle.add(tfEntrecalles);
		tfEntrecalles.setColumns(10);
		tfEntrecalles.setEnabled(false);
		
		JLabel lblDatosGenerales = new JLabel("Datos Generales");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(31, 26, 98, 14);
		panelDetalle.add(lblDatosGenerales);
		
		JLabel lblIdentificador = new JLabel("Identificador:");
		lblIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIdentificador.setBounds(35, 64, 65, 14);
		panelDetalle.add(lblIdentificador);
		
		tfIdentificador = new JTextField();
		tfIdentificador.setBounds(110, 61, 86, 20);
		panelDetalle.add(tfIdentificador);
		tfIdentificador.setColumns(10);
		tfIdentificador.setEnabled(false);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecio.setBounds(68, 89, 46, 14);
		panelDetalle.add(lblPrecio);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(110, 86, 86, 20);
		panelDetalle.add(tfPrecio);
		tfPrecio.setColumns(10);
		tfPrecio.setEnabled(false);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(54, 114, 46, 14);
		panelDetalle.add(lblMoneda);
		
		tfMoneda = new JTextField();
		tfMoneda.setBounds(110, 111, 86, 20);
		panelDetalle.add(tfMoneda);
		tfMoneda.setColumns(10);
		tfMoneda.setEnabled(false);
		
		JLabel lblTipoDeOfrecimiento = new JLabel("Tipo de ofrecimiento:");
		lblTipoDeOfrecimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoDeOfrecimiento.setBounds(241, 64, 109, 14);
		panelDetalle.add(lblTipoDeOfrecimiento);
		
		tfTipoOfrec = new JTextField();
		tfTipoOfrec.setBounds(346, 61, 86, 20);
		panelDetalle.add(tfTipoOfrec);
		tfTipoOfrec.setColumns(10);
		tfTipoOfrec.setEnabled(false);
		
		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropietario.setBounds(279, 89, 60, 14);
		panelDetalle.add(lblPropietario);
		
		tfPropietario = new JTextField();
		tfPropietario.setBounds(346, 86, 86, 20);
		panelDetalle.add(tfPropietario);
		tfPropietario.setColumns(10);
		tfPropietario.setEnabled(false);
		
		JLabel lblInmobiliariaAmiga = new JLabel("Inmobiliaria amiga:");
		lblInmobiliariaAmiga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblInmobiliariaAmiga.setBounds(253, 114, 97, 14);
		panelDetalle.add(lblInmobiliariaAmiga);
		
		tfInmobiliaria = new JTextField();
		tfInmobiliaria.setBounds(346, 111, 86, 20);
		panelDetalle.add(tfInmobiliaria);
		tfInmobiliaria.setColumns(10);
		tfInmobiliaria.setEnabled(false);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 51, 424, 2);
		panelDetalle.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(31, 188, 424, 2);
		panelDetalle.add(separator_1);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPiso.setBounds(78, 251, 33, 14);
		panelDetalle.add(lblPiso);
		
		tfPiso = new JTextField();
		tfPiso.setBounds(110, 248, 86, 20);
		panelDetalle.add(tfPiso);
		tfPiso.setColumns(10);
		tfPiso.setEnabled(false);
		
		JLabel lblAltura_1 = new JLabel("Depto:");
		lblAltura_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAltura_1.setBounds(68, 276, 46, 14);
		panelDetalle.add(lblAltura_1);
		
		tfDepto = new JTextField();
		tfDepto.setBounds(110, 273, 86, 20);
		panelDetalle.add(tfDepto);
		tfDepto.setColumns(10);
		tfDepto.setEnabled(false);
		
		JLabel lblProvincia_1 = new JLabel("Provincia:");
		lblProvincia_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia_1.setBounds(284, 201, 57, 14);
		panelDetalle.add(lblProvincia_1);
		
		tfProvincia = new JTextField();
		tfProvincia.setBounds(346, 198, 86, 20);
		panelDetalle.add(tfProvincia);
		tfProvincia.setColumns(10);
		tfProvincia.setEnabled(false);
		
		JLabel lblOtros = new JLabel("Otros datos");
		lblOtros.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtros.setBounds(31, 322, 70, 14);
		panelDetalle.add(lblOtros);
		
		JLabel lblDescripcinPblica = new JLabel("Descripción pública:");
		lblDescripcinPblica.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcinPblica.setBounds(31, 360, 96, 14);
		panelDetalle.add(lblDescripcinPblica);
		
		tpDescPubl = new JTextPane();
		tpDescPubl.setBounds(31, 385, 424, 51);
		panelDetalle.add(tpDescPubl);
		tpDescPubl.setEnabled(false);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(31, 347, 424, 2);
		panelDetalle.add(separator_2);
		
		JLabel lblDescripcinPrivada = new JLabel("Descripción privada:");
		lblDescripcinPrivada.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcinPrivada.setBounds(31, 447, 98, 14);
		panelDetalle.add(lblDescripcinPrivada);
		
		tpDescPriv = new JTextPane();
		tpDescPriv.setBounds(31, 472, 424, 51);
		panelDetalle.add(tpDescPriv);
		tpDescPriv.setEnabled(false);
		
	}
}
