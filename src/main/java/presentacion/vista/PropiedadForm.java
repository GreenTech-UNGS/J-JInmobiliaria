package presentacion.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.google.inject.Inject;

@SuppressWarnings("serial")
public class PropiedadForm extends JDialog{

	private JPanel AgregarPropiedad;
	private JTextField tfAltura;
	private JTextField tfCalle;
	private JTextField tfIdentificador;
	private JTextField tfEntrecalles;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JComboBox<String> comboProvincia;
	private JComboBox<String> comboMoneda;
	private JComboBox<String> comboTipoOfre;
	private JTextArea taDescPubl;
	private JTextArea taDescPriv;
	private JLabel lblReservada;
	private JButton btnCancelar;
	private JComboBox<String> comboLocalidad;
	private JTextField tfPropietario;
	private JButton btnLupita;
	private JButton btnVerHistorial;
	private JMapViewer mapa;
	private JButton btnActualizar;
	private JTextField tfInmobiliaria;
	private JButton botonLupitaInmobiliaria;
	private JTextField tfPrecio;
	private JButton btnGuardarDisponible;
	private JButton btnMasDatos;
	private JButton btnBorrador;
	private JButton btnImprimirFicha;
	private JButton btnVerGaleria;

	@Inject
	private PropiedadForm() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setModal(true);
		setSize(new Dimension(706, 660));
		setResizable(false);
		setLocationRelativeTo(null);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		getContentPane().setLayout(null);
						
						AgregarPropiedad = new JPanel();
						AgregarPropiedad.setBounds(0, 0, 695, 603);
						getContentPane().add(AgregarPropiedad);
						AgregarPropiedad.setForeground(new Color(204, 0, 0));
						AgregarPropiedad.setBorder(new EmptyBorder(5, 5, 5, 5));
						AgregarPropiedad.setLayout(null);
						
						JLabel lblPropierario = new JLabel("Propietario:");
						lblPropierario.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblPropierario.setBounds(474, 62, 61, 14);
						AgregarPropiedad.add(lblPropierario);
						
						JLabel lblDireccin = new JLabel("Calle:");
						lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDireccin.setBounds(30, 182, 46, 14);
						AgregarPropiedad.add(lblDireccin);
						
						JLabel lblNewLabel = new JLabel("Tipo de");
						lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblNewLabel.setBounds(30, 84, 46, 14);
						AgregarPropiedad.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel("Localidad:");
						lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblNewLabel_1.setBounds(474, 207, 61, 14);
						AgregarPropiedad.add(lblNewLabel_1);
						
						JLabel lblProvincia = new JLabel("Provincia:");
						lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblProvincia.setBounds(474, 182, 61, 14);
						AgregarPropiedad.add(lblProvincia);
						
						JLabel lblAltura = new JLabel("Altura:");
						lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblAltura.setBounds(30, 207, 46, 14);
						AgregarPropiedad.add(lblAltura);
						
						JLabel lblPrecio = new JLabel("Precio:");
						lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblPrecio.setBounds(266, 62, 46, 14);
						AgregarPropiedad.add(lblPrecio);
						
						this.tfAltura = new JTextField();
						tfAltura.setBounds(86, 204, 117, 20);
						AgregarPropiedad.add(tfAltura);
						tfAltura.setColumns(10);
						
						tfCalle = new JTextField();
						tfCalle.setBounds(86, 179, 117, 20);
						AgregarPropiedad.add(tfCalle);
						tfCalle.setColumns(10);
						
						comboTipoOfre = new JComboBox<>();
						comboTipoOfre.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboTipoOfre.setBounds(92, 90, 117, 20);
						AgregarPropiedad.add(comboTipoOfre);
						
						JLabel lblMoneda = new JLabel("Moneda:");
						lblMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblMoneda.setBounds(254, 93, 51, 14);
						AgregarPropiedad.add(lblMoneda);
						
						comboMoneda = new JComboBox<>();
						comboMoneda.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboMoneda.setBounds(305, 90, 122, 20);
						AgregarPropiedad.add(comboMoneda);
						
						JLabel lblDescripcin = new JLabel("Descripci\u00F3n privada:");
						lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDescripcin.setBounds(353, 460, 110, 14);
						AgregarPropiedad.add(lblDescripcin);
						
						JLabel lblDatosGenerales = new JLabel("Datos generales");
						lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblDatosGenerales.setBounds(30, 24, 123, 14);
						AgregarPropiedad.add(lblDatosGenerales);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(20, 49, 654, 2);
						AgregarPropiedad.add(separator);
						
						JLabel lblIdPropiedad = new JLabel("Codigo:");
						lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblIdPropiedad.setBounds(30, 62, 80, 14);
						AgregarPropiedad.add(lblIdPropiedad);
						
						tfIdentificador = new JTextField();
						tfIdentificador.setColumns(10);
						tfIdentificador.setBounds(91, 59, 117, 20);
						AgregarPropiedad.add(tfIdentificador);
						
						JLabel lblDatosUbicacionales = new JLabel("Datos geograficos");
						lblDatosUbicacionales.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblDatosUbicacionales.setBounds(30, 144, 123, 14);
						AgregarPropiedad.add(lblDatosUbicacionales);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(20, 169, 654, 2);
						AgregarPropiedad.add(separator_1);
						
						JLabel lblNewLabel_2 = new JLabel("Entre calles:");
						lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblNewLabel_2.setBounds(15, 232, 61, 14);
						AgregarPropiedad.add(lblNewLabel_2);
						
						tfEntrecalles = new JTextField();
						tfEntrecalles.setColumns(10);
						tfEntrecalles.setBounds(86, 229, 117, 20);
						AgregarPropiedad.add(tfEntrecalles);
						
						mapa = new JMapViewer();
						mapa.setBorder(new LineBorder(Color.LIGHT_GRAY));
						mapa.setZoomContolsVisible(false);
						mapa.setBounds(38, 260, 621, 141);
						AgregarPropiedad.add(mapa);
						
						btnActualizar = new JButton("Actualizar mapa");
						btnActualizar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnActualizar.setBounds(495, 11, 116, 23);
						mapa.add(btnActualizar);
						
						JLabel lblInmobiliariaAmiga = new JLabel("Inmobiliaria amiga:");
						lblInmobiliariaAmiga.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblInmobiliariaAmiga.setBounds(439, 93, 96, 14);
						AgregarPropiedad.add(lblInmobiliariaAmiga);
						
						JLabel lblPiso = new JLabel("Piso:");
						lblPiso.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblPiso.setBounds(274, 182, 31, 14);
						AgregarPropiedad.add(lblPiso);
						
						tfPiso = new JTextField();
						tfPiso.setColumns(10);
						tfPiso.setBounds(305, 179, 122, 20);
						AgregarPropiedad.add(tfPiso);
						
						JLabel lblDepartamento = new JLabel("Dpto.:");
						lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDepartamento.setBounds(266, 207, 31, 14);
						AgregarPropiedad.add(lblDepartamento);
						
						tfDepto = new JTextField();
						tfDepto.setColumns(10);
						tfDepto.setBounds(305, 204, 121, 20);
						AgregarPropiedad.add(tfDepto);
						
						JLabel lblOtrosDatos = new JLabel("Otros datos");
						lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblOtrosDatos.setBounds(20, 422, 71, 14);
						AgregarPropiedad.add(lblOtrosDatos);
						
						JSeparator separator_2 = new JSeparator();
						separator_2.setBounds(20, 447, 654, 2);
						AgregarPropiedad.add(separator_2);
						
						JLabel lblDescripcinPblica = new JLabel("Descripci\u00F3n p\u00FAblica:");
						lblDescripcinPblica.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDescripcinPblica.setBounds(38, 460, 96, 14);
						AgregarPropiedad.add(lblDescripcinPblica);
						
						comboProvincia = new JComboBox<>();
						comboProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboProvincia.setBounds(536, 179, 123, 20);
						AgregarPropiedad.add(comboProvincia);
						
						comboLocalidad = new JComboBox<>();
						comboLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboLocalidad.setBounds(536, 206, 123, 20);
						AgregarPropiedad.add(comboLocalidad);
						
						tfPropietario = new JTextField();
						tfPropietario.setEditable(false);
						tfPropietario.setColumns(10);
						tfPropietario.setBounds(536, 59, 117, 20);
						AgregarPropiedad.add(tfPropietario);
						
						this.btnLupita = new JButton("");
						btnLupita.setIcon(new ImageIcon(imgLup));
						btnLupita.setBounds(652, 59, 22, 20);
						AgregarPropiedad.add(btnLupita);
						
						btnVerHistorial = new JButton("Ver historial");
						btnVerHistorial.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnVerHistorial.setBounds(460, 19, 102, 19);
						AgregarPropiedad.add(btnVerHistorial);
						
						tfInmobiliaria = new JTextField();
						
								tfInmobiliaria.setEditable(false);
								tfInmobiliaria.setBounds(536, 90, 117, 20);
								AgregarPropiedad.add(tfInmobiliaria);
								tfInmobiliaria.setColumns(10);
								
								botonLupitaInmobiliaria = new JButton("");
								botonLupitaInmobiliaria.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
									}
								});
								botonLupitaInmobiliaria.setIcon(new ImageIcon(imgLup));
								botonLupitaInmobiliaria.setBounds(652, 90, 22, 20);
								AgregarPropiedad.add(botonLupitaInmobiliaria);
								
								tfPrecio = new JTextField();
								tfPrecio.setBounds(305, 59, 122, 20);
								AgregarPropiedad.add(tfPrecio);
								
								JLabel lblOfrecimiento = new JLabel("ofrecimiento:");
								lblOfrecimiento.setFont(new Font("Tahoma", Font.PLAIN, 11));
								lblOfrecimiento.setBounds(20, 96, 76, 14);
								AgregarPropiedad.add(lblOfrecimiento);
								
								lblReservada = new JLabel("Propiedad Reservada");
								lblReservada.setForeground(new Color(204, 0, 0));
								lblReservada.setFont(new Font("Tahoma", Font.BOLD, 12));
								lblReservada.setBounds(181, 17, 145, 27);
								AgregarPropiedad.add(lblReservada);
								
								JScrollPane scrollPane = new JScrollPane();
								scrollPane.setBounds(38, 485, 288, 58);
								scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
								AgregarPropiedad.add(scrollPane);
								
								taDescPubl = new JTextArea();
								scrollPane.setViewportView(taDescPubl);
								taDescPubl.setLineWrap(true);
								taDescPubl.setBorder(new LineBorder(Color.LIGHT_GRAY));
								
										
										JScrollPane scrollPane_1 = new JScrollPane();
										scrollPane_1.setBounds(353, 484, 306, 59);
										scrollPane_1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
										AgregarPropiedad.add(scrollPane_1);
										
										taDescPriv = new JTextArea();
										scrollPane_1.setViewportView(taDescPriv);
										taDescPriv.setLineWrap(true);
										taDescPriv.setBorder(new LineBorder(Color.LIGHT_GRAY));
										
										btnGuardarDisponible = new JButton("Guardar disponible");
										btnGuardarDisponible.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
										btnGuardarDisponible.setFont(new Font("Tahoma", Font.PLAIN, 11));
										btnGuardarDisponible.setBounds(263, 565, 132, 33);
										AgregarPropiedad.add(btnGuardarDisponible);
										
										btnMasDatos = new JButton("Mas datos");
										btnMasDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
										btnMasDatos.setBounds(557, 554, 96, 23);
										AgregarPropiedad.add(btnMasDatos);
										
										btnBorrador = new JButton("Guardar no disponible");
										btnBorrador.setFont(new Font("Tahoma", Font.PLAIN, 11));
										btnBorrador.setBounds(99, 565, 145, 33);
										AgregarPropiedad.add(btnBorrador);
										

										btnCancelar = new JButton("Cancelar");
										btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
										btnCancelar.setBounds(405, 565, 130, 33);
										AgregarPropiedad.add(btnCancelar);
										
										btnImprimirFicha = new JButton("Imprimir ficha");
										btnImprimirFicha.setFont(new Font("Tahoma", Font.PLAIN, 11));
										btnImprimirFicha.setBounds(572, 18, 102, 20);
										AgregarPropiedad.add(btnImprimirFicha);
										
										btnVerGaleria = new JButton("Ver Galeria");
										btnVerGaleria.setFont(new Font("Dialog", Font.PLAIN, 11));
										btnVerGaleria.setBounds(352, 19, 96, 18);
										AgregarPropiedad.add(btnVerGaleria);
										btnCancelar.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
											}
										});
		btnGuardarDisponible.setVisible(false);
		lblReservada.setVisible(false);

		btnVerHistorial.setVisible(false);
	}

	public JButton getBotonLupitaInmobiliaria() {
		return botonLupitaInmobiliaria;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JMapViewer getMapa() {
		return mapa;
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

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JComboBox<String> getComboLocalidad() {
		return comboLocalidad;
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
	public JPanel getAgregarPropiedad() {
		return AgregarPropiedad;
	}

	public void setAgregarPropiedad(JPanel agregarPropiedad) {
		AgregarPropiedad = agregarPropiedad;
	}

	public JButton getBtnVerHistorial() {
		return btnVerHistorial;
	}

	public void setBtnVerHistorial(JButton btnVerHistorial) {
		this.btnVerHistorial = btnVerHistorial;
	}

	public void setTfAltura(JTextField tfAltura) {
		this.tfAltura = tfAltura;
	}

	public void setTfCalle(JTextField tfCalle) {
		this.tfCalle = tfCalle;
	}

	public void setTfIdentificador(JTextField tfIdentificador) {
		this.tfIdentificador = tfIdentificador;
	}

	public void setTfEntrecalles(JTextField tfEntrecalles) {
		this.tfEntrecalles = tfEntrecalles;
	}

	public void setTfPiso(JTextField tfPiso) {
		this.tfPiso = tfPiso;
	}

	public void setTfDepto(JTextField tfDepto) {
		this.tfDepto = tfDepto;
	}

	public void setComboProvincia(JComboBox<String> comboProvincia) {
		this.comboProvincia = comboProvincia;
	}

	public void setComboMoneda(JComboBox<String> comboMoneda) {
		this.comboMoneda = comboMoneda;
	}

	public void setComboTipoOfre(JComboBox<String> comboTipoOfre) {
		this.comboTipoOfre = comboTipoOfre;
	}

	public void setTaDescPubl(JTextArea taDescPubl) {
		this.taDescPubl = taDescPubl;
	}

	public void setTaDescPriv(JTextArea taDescPriv) {
		this.taDescPriv = taDescPriv;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public void setComboLocalidad(JComboBox<String> comboLocalidad) {
		this.comboLocalidad = comboLocalidad;
	}

	public JTextField getTfInmobiliaria() {
		return tfInmobiliaria;
	}

	public void setTfInmobiliaria(JTextField tfInmobiliaria) {
		this.tfInmobiliaria = tfInmobiliaria;
	}

	public JLabel getLblReservada() {
		return lblReservada;
	}

	public void setLblReservada(JLabel lblReservada) {
		this.lblReservada = lblReservada;
	}

	public JButton getBtnGuardarDisponible() {
		return btnGuardarDisponible;
	}

	public void setBtnGuardarDisponible(JButton btnGuardarCambios) {
		this.btnGuardarDisponible = btnGuardarCambios;
	}

	public JButton getBtnMasDatos() {
		return btnMasDatos;
	}

	public JButton getBtnBorrador() {
		return btnBorrador;
	}

	public void setBtnBorrador(JButton btnBorrador) {
		this.btnBorrador = btnBorrador;
	}

	public JButton getBtnImprimirFicha() {
		return btnImprimirFicha;
	}

	public JButton getBtnVerGaleria() {
		return btnVerGaleria;
	}
}
