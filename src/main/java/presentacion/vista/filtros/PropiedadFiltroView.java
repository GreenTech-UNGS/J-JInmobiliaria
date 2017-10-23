package presentacion.vista.filtros;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.google.inject.Singleton;

import presentacion.combo.LocalidadComboBoxModel;
import presentacion.combo.MonedaComboBoxModel;
import presentacion.combo.ProvinciaComboBoxModel;
import presentacion.combo.TipoOfrecimientoComboBoxModel;

@SuppressWarnings("serial")
@Singleton
public class PropiedadFiltroView extends JDialog {
	private JTextField tfPrecioDesde;
	private JTextField tfPrecioHasta;
	private JButton btnFiltrar;
	private JComboBox<String> cbProvincia;
	private JComboBox<String> cbLocalidad;
	private JComboBox<String> cbMoneda;
	private JTextField tfAmbientes;
	private JComboBox<String> cbTipoOfrec;
	
	ProvinciaComboBoxModel provCombo;
	MonedaComboBoxModel monedaCombo;
	LocalidadComboBoxModel localidadCombo;
	TipoOfrecimientoComboBoxModel tipoOfrCombo;
	
	public PropiedadFiltroView(){
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(392, 396));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblRangoDePrecio = new JLabel("Rango de precio");
		lblRangoDePrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRangoDePrecio.setBounds(22, 108, 98, 14);
		getContentPane().add(lblRangoDePrecio);
		
		JLabel lblDesde = new JLabel("Desde:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesde.setBounds(22, 146, 46, 14);
		getContentPane().add(lblDesde);
		
		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHasta.setBounds(22, 171, 46, 14);
		getContentPane().add(lblHasta);
		
		tfPrecioDesde = new JTextField();
		tfPrecioDesde.setBounds(74, 143, 105, 20);
		getContentPane().add(tfPrecioDesde);
		tfPrecioDesde.setColumns(10);
		
		tfPrecioHasta = new JTextField();
		tfPrecioHasta.setBounds(74, 171, 105, 20);
		getContentPane().add(tfPrecioHasta);
		tfPrecioHasta.setColumns(10);
		
		JLabel lblMoneda = new JLabel("Moneda:");
		lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMoneda.setBounds(203, 146, 46, 14);
		getContentPane().add(lblMoneda);
		

		cbMoneda = new JComboBox<String>();
		cbMoneda.setBounds(259, 143, 105, 20);
		getContentPane().add(cbMoneda);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUbicacion.setBounds(22, 23, 72, 14);
		getContentPane().add(lblUbicacion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 48, 342, 2);
		getContentPane().add(separator);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(22, 61, 58, 14);
		getContentPane().add(lblProvincia);
		
		cbProvincia = new JComboBox<String>();
		cbProvincia.setBounds(74, 61, 105, 20);
		getContentPane().add(cbProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLocalidad.setBounds(210, 61, 58, 14);
		getContentPane().add(lblLocalidad);
		
		cbLocalidad = new JComboBox<String>();
		cbLocalidad.setBounds(259, 61, 105, 20);
		getContentPane().add(cbLocalidad);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(22, 133, 342, 2);
		getContentPane().add(separator_1);
		
		JLabel lblOtrosDatos = new JLabel("Otros datos");
		lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOtrosDatos.setBounds(22, 222, 72, 14);
		getContentPane().add(lblOtrosDatos);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(22, 247, 342, 2);
		getContentPane().add(separator_2);
		
		JLabel lblAmbientes = new JLabel("Ambientes:");
		lblAmbientes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAmbientes.setBounds(22, 263, 72, 14);
		getContentPane().add(lblAmbientes);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(160, 333, 89, 23);
		getContentPane().add(btnFiltrar);
		
		tfAmbientes = new JTextField();
		tfAmbientes.setBounds(74, 260, 105, 20);
		getContentPane().add(tfAmbientes);
		tfAmbientes.setColumns(10);
		
		JLabel lblTipoOfrec = new JLabel("Tipo ofrec:");
		lblTipoOfrec.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipoOfrec.setBounds(203, 171, 58, 14);
		getContentPane().add(lblTipoOfrec);
		
		cbTipoOfrec = new JComboBox<String>();
		cbTipoOfrec.setBounds(259, 171, 105, 20);
		getContentPane().add(cbTipoOfrec);
		
		this.provCombo = new ProvinciaComboBoxModel();
		this.monedaCombo = new MonedaComboBoxModel();
		this.localidadCombo = new LocalidadComboBoxModel();
		this.tipoOfrCombo = new TipoOfrecimientoComboBoxModel();
		
		getCbProvincia().setModel(provCombo);
		getCbMoneda().setModel(monedaCombo);
		getCbLocalidad().setModel(localidadCombo);
		getCbTipoOfrec().setModel(tipoOfrCombo);

		
	}

	public JTextField getTfPrecioDesde() {
		return tfPrecioDesde;
	}

	public void setTfPrecioDesde(JTextField tfPrecioDesde) {
		this.tfPrecioDesde = tfPrecioDesde;
	}

	public JTextField getTfPrecioHasta() {
		return tfPrecioHasta;
	}

	public void setTfPrecioHasta(JTextField tfPrecioHasta) {
		this.tfPrecioHasta = tfPrecioHasta;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public void setBtnFiltrar(JButton btnFiltrar) {
		this.btnFiltrar = btnFiltrar;
	}

	public JComboBox<String> getCbProvincia() {
		return cbProvincia;
	}

	public void setCbProvincia(JComboBox<String> cbProvincia) {
		this.cbProvincia = cbProvincia;
	}

	public JComboBox<String> getCbLocalidad() {
		return cbLocalidad;
	}

	public void setCbLocalidad(JComboBox<String> cbLocalidad) {
		this.cbLocalidad = cbLocalidad;
	}

	public JComboBox<String> getCbMoneda() {
		return cbMoneda;
	}

	public void setCbMoneda(JComboBox<String> cbMoneda) {
		this.cbMoneda = cbMoneda;
	}

	public JTextField getTfAmbientes() {
		return tfAmbientes;
	}

	public void setTfAmbientes(JTextField tfAmbientes) {
		this.tfAmbientes = tfAmbientes;
	}

	public JComboBox<String> getCbTipoOfrec() {
		return cbTipoOfrec;
	}

	public void setCbTipoOfrec(JComboBox<String> cbTipoOfrec) {
		this.cbTipoOfrec = cbTipoOfrec;
	}

	public ProvinciaComboBoxModel getProvCombo() {
		return provCombo;
	}

	public MonedaComboBoxModel getMonedaCombo() {
		return monedaCombo;
	}

	public LocalidadComboBoxModel getLocalidadCombo() {
		return localidadCombo;
	}

	public TipoOfrecimientoComboBoxModel getTipoOfrCombo() {
		return tipoOfrCombo;
	}
	
	

}
