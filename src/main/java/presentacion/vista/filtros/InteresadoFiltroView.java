package presentacion.vista.filtros;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.inject.Singleton;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoCredencialComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
@Singleton
public class InteresadoFiltroView extends JDialog {
	
	private JPanel panel;
	private JTextField tfMetros;
	private JComboBox<String> cbProvincia;
	private JButton btnAceptar, btnCancelar;
	private TipoCredencialComboBoxModel tipoComboBox;
	private JTextField tfPrecioHasta;
	private JTextField tfPrecioDesde;
	private JTextField tfAmbientes;
	private JComboBox<String> cbLocalidad;
	private JComboBox<String> cbTipoOfrecimiento;
	private JComboBox<String> cbMoneda;
	
	ProvinciaComboBoxModel provCombo;
	MonedaComboBoxModel monedaCombo;
	LocalidadComboBoxModel localidadCombo;
	TipoOfrecimientoComboBoxModel tipoOfrCombo;
	
	public InteresadoFiltroView(){
		
		super();
		setTitle("Filtrar interesados");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(420, 446));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		JLabel lblNombre = new JLabel("Metros\u00B2:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(30, 303, 55, 20);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Tipo de");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblApellido.setBounds(30, 93, 55, 20);
		panel.add(lblApellido);

		tfMetros = new JTextField();
		tfMetros.setBounds(95, 303, 98, 20);
		panel.add(tfMetros);
		tfMetros.setColumns(10);
		
		cbProvincia = new JComboBox<String>();
		cbProvincia.setBounds(95, 65, 97, 20);
		panel.add(cbProvincia);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAceptar.setBounds(95, 366, 98, 29);
		panel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancelar.setBounds(217, 366, 98, 29);
		panel.add(btnCancelar);
		
		tipoComboBox = new TipoCredencialComboBoxModel();
		cbProvincia.setModel(tipoComboBox);
		
		JLabel lblProvincia = new JLabel("Provincia: ");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(30, 68, 67, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(231, 68, 55, 14);
		panel.add(lblLocalidad);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(281, 65, 97, 20);
		panel.add(cbLocalidad);
		
		JLabel lblAmbientes = new JLabel("Ambientes:");
		lblAmbientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAmbientes.setBounds(217, 306, 61, 14);
		panel.add(lblAmbientes);
		
		tfPrecioHasta = new JTextField();
		tfPrecioHasta.setColumns(10);
		tfPrecioHasta.setBounds(281, 187, 98, 20);
		panel.add(tfPrecioHasta);
		
		cbTipoOfrecimiento = new JComboBox<String>();
		cbTipoOfrecimiento.setBounds(95, 93, 98, 20);
		panel.add(cbTipoOfrecimiento);
		
		JLabel lblPrecioDesde = new JLabel("Precio desde:");
		lblPrecioDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecioDesde.setBounds(30, 190, 67, 14);
		panel.add(lblPrecioDesde);
		
		tfPrecioDesde = new JTextField();
		tfPrecioDesde.setColumns(10);
		tfPrecioDesde.setBounds(95, 187, 98, 20);
		panel.add(tfPrecioDesde);
		
		JLabel lblPrecioHasta = new JLabel("Precio hasta:");
		lblPrecioHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecioHasta.setBounds(217, 190, 67, 14);
		panel.add(lblPrecioHasta);
		
		tfAmbientes = new JTextField();
		tfAmbientes.setColumns(10);
		tfAmbientes.setBounds(280, 303, 98, 20);
		panel.add(tfAmbientes);
		
		JLabel lblOfrecimiento = new JLabel("ofrecimiento:");
		lblOfrecimiento.setBounds(30, 110, 67, 14);
		panel.add(lblOfrecimiento);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(30, 215, 46, 14);
		panel.add(lblMoneda);
		
		cbMoneda = new JComboBox<String>();
		cbMoneda.setBounds(95, 212, 97, 20);
		panel.add(cbMoneda);
		
		JLabel lblDatosGenerales = new JLabel("Datos generales:");
		lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDatosGenerales.setBounds(30, 30, 106, 14);
		panel.add(lblDatosGenerales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 55, 348, 2);
		panel.add(separator);
		
		JLabel lblRangoDePrecio = new JLabel("Rango de precio:");
		lblRangoDePrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRangoDePrecio.setBounds(30, 155, 106, 14);
		panel.add(lblRangoDePrecio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 177, 348, 2);
		panel.add(separator_1);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos:");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(30, 265, 88, 14);
		panel.add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 290, 348, 2);
		panel.add(separator_2);
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		
		getCbProvincia().setModel(provCombo);
		getCbMoneda().setModel(monedaCombo);
		getCbLocalidad().setModel(localidadCombo);
		getCbTipoOfrecimiento().setModel(tipoOfrCombo);
		
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public TipoCredencialComboBoxModel getTipoComboBox() {
		return tipoComboBox;
	}

	public JTextField getTfMetros() {
		return tfMetros;
	}

	public JComboBox<String> getCbProvincia() {
		return cbProvincia;
	}

	public JTextField getTfPrecioHasta() {
		return tfPrecioHasta;
	}

	public JTextField getTfPrecioDesde() {
		return tfPrecioDesde;
	}

	public JTextField getTfAmbientes() {
		return tfAmbientes;
	}

	public JComboBox<String> getCbLocalidad() {
		return cbLocalidad;
	}

	public JComboBox<String> getCbMoneda() {
		return cbMoneda;
	}

	public JComboBox<String> getCbTipoOfrecimiento() {
		return cbTipoOfrecimiento;
	}

	public ProvinciaComboBoxModel getProvCombo() {
		return provCombo;
	}

	public void setProvCombo(ProvinciaComboBoxModel provCombo) {
		this.provCombo = provCombo;
	}

	public MonedaComboBoxModel getMonedaCombo() {
		return monedaCombo;
	}

	public void setMonedaCombo(MonedaComboBoxModel monedaCombo) {
		this.monedaCombo = monedaCombo;
	}

	public LocalidadComboBoxModel getLocalidadCombo() {
		return localidadCombo;
	}

	public void setLocalidadCombo(LocalidadComboBoxModel localidadCombo) {
		this.localidadCombo = localidadCombo;
	}

	public TipoOfrecimientoComboBoxModel getTipoOfrCombo() {
		return tipoOfrCombo;
	}

	public void setTipoOfrCombo(TipoOfrecimientoComboBoxModel tipoOfrCombo) {
		this.tipoOfrCombo = tipoOfrCombo;
	}
	
	
	
	
}
