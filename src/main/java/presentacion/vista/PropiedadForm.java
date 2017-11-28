package presentacion.vista;

import com.google.inject.Inject;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.openstreetmap.gui.jmapviewer.JMapViewer;

import com.google.inject.Inject;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PropiedadForm extends JFrame{

	private JPanel AgregarPropiedad;
	private JTextField tfAltura;
	private JTextField tfCalle;
	private JTextField tfIdentificador;
	private JTextField tfPiso;
	private JTextField tfDepto;
	private JComboBox<String> comboProvincia;
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
	private JButton btnGuardarDisponible;
	private JButton btnMasDatos;
	private JButton btnBorrador;
	private JButton btnImprimirFicha;
	private JButton btnImprimirFichaVisita;
	private JButton btnVerGaleria;
	//private PrecontratoAlquilerForm alquilerOfrecimiento;
	//private PrecontratoVentaForm ventaOfrecimiento;
	private JPanel panelBotones;
	private JTabbedPane tabbedPane;
	private JButton btnSiguiente;
	private JPanel panelOfrecimientos;
	private JButton btnAtras;
	private JButton btnRemoverPropietario;
	private JButton btnRemoverInmobiliaria;

	@Inject
	private PropiedadForm(PrecontratoAlquilerForm alquilerOfrecimiento, PrecontratoVentaForm ventaOfrecimiento) {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setModalityType(ModalityType.MODELESS);
		setSize(new Dimension(706, 655));
		setResizable(false);
		setLocationRelativeTo(null);
		Image imgLup = new ImageIcon(this.getClass().getResource("/buscar.png")).getImage();
		getContentPane().setLayout(null);
		
		Image imgRemover = new ImageIcon(this.getClass().getResource("/cancelar.png")).getImage();
		
		AgregarPropiedad = new JPanel();
		AgregarPropiedad.setBounds(0, 0, 695, 575);
		getContentPane().add(AgregarPropiedad);
		AgregarPropiedad.setForeground(new Color(204, 0, 0));
		AgregarPropiedad.setBorder(new EmptyBorder(5, 5, 5, 5));
		AgregarPropiedad.setLayout(null);
		AgregarPropiedad.setVisible(true);
		
		JLabel lblPropierario = new JLabel("Propietario:");
		lblPropierario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPropierario.setBounds(235, 53, 61, 14);
		AgregarPropiedad.add(lblPropierario);
		
		JLabel lblDireccin = new JLabel("Calle:");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDireccin.setBounds(25, 119, 46, 14);
		AgregarPropiedad.add(lblDireccin);
		
		JLabel lblNewLabel_1 = new JLabel("Localidad:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(469, 144, 61, 14);
		AgregarPropiedad.add(lblNewLabel_1);
		
		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProvincia.setBounds(469, 119, 61, 14);
		AgregarPropiedad.add(lblProvincia);
		
		JLabel lblPiso = new JLabel("Piso:");
		lblPiso.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPiso.setBounds(25, 144, 46, 14);
		AgregarPropiedad.add(lblPiso);
		
				JLabel lblAltura = new JLabel("Altura:");
				lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 11));
				lblAltura.setBounds(261, 119, 122, 14);
				AgregarPropiedad.add(lblAltura);
				
				this.tfAltura = new JTextField();
				tfAltura.setBounds(300, 116, 122, 20);
				AgregarPropiedad.add(tfAltura);
				tfAltura.setColumns(10);
				
						tfPiso = new JTextField();
						tfPiso.setColumns(10);
						tfPiso.setBounds(81, 141, 31, 20);
						AgregarPropiedad.add(tfPiso);
						
						tfCalle = new JTextField();
						tfCalle.setBounds(81, 116, 117, 20);
						AgregarPropiedad.add(tfCalle);
						tfCalle.setColumns(10);
						
						JLabel lblDescripcin = new JLabel("Descripci\u00F3n privada:");
						lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDescripcin.setBounds(348, 397, 110, 14);
						AgregarPropiedad.add(lblDescripcin);
						
						JLabel lblDatosGenerales = new JLabel("Datos generales");
						lblDatosGenerales.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblDatosGenerales.setBounds(25, 18, 123, 14);
						AgregarPropiedad.add(lblDatosGenerales);
						
						JSeparator separator = new JSeparator();
						separator.setBounds(15, 43, 654, 2);
						AgregarPropiedad.add(separator);
						
						JLabel lblIdPropiedad = new JLabel("Codigo:");
						lblIdPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblIdPropiedad.setBounds(25, 56, 80, 14);
						AgregarPropiedad.add(lblIdPropiedad);
						
						tfIdentificador = new JTextField();
						tfIdentificador.setColumns(10);
						tfIdentificador.setBounds(86, 53, 117, 20);
						AgregarPropiedad.add(tfIdentificador);
						
						JLabel lblDatosUbicacionales = new JLabel("Datos geograficos");
						lblDatosUbicacionales.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblDatosUbicacionales.setBounds(25, 81, 123, 14);
						AgregarPropiedad.add(lblDatosUbicacionales);
						
						JSeparator separator_1 = new JSeparator();
						separator_1.setBounds(15, 106, 654, 2);
						AgregarPropiedad.add(separator_1);
						
						mapa = new JMapViewer();
						mapa.setBorder(new LineBorder(Color.LIGHT_GRAY));
						mapa.setZoomContolsVisible(false);
						mapa.setBounds(33, 197, 621, 141);
						AgregarPropiedad.add(mapa);
						
						btnActualizar = new JButton("Actualizar mapa");
						btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnActualizar.setBounds(495, 11, 116, 23);
						mapa.add(btnActualizar);
						
						JLabel lblInmobiliariaAmiga = new JLabel("<html>Inmobiliaria<br>amiga:</html>");
						lblInmobiliariaAmiga.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblInmobiliariaAmiga.setBounds(459, 51, 71, 32);
						AgregarPropiedad.add(lblInmobiliariaAmiga);
						
						JLabel lblDepartamento = new JLabel("Dpto.:");
						lblDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDepartamento.setBounds(261, 144, 31, 14);
						AgregarPropiedad.add(lblDepartamento);
						
						tfDepto = new JTextField();
						tfDepto.setColumns(10);
						tfDepto.setBounds(300, 141, 121, 20);
						AgregarPropiedad.add(tfDepto);
						
						JLabel lblOtrosDatos = new JLabel("Otros datos");
						lblOtrosDatos.setFont(new Font("Tahoma", Font.BOLD, 11));
						lblOtrosDatos.setBounds(15, 359, 71, 14);
						AgregarPropiedad.add(lblOtrosDatos);
						
						JSeparator separator_2 = new JSeparator();
						separator_2.setBounds(15, 384, 654, 2);
						AgregarPropiedad.add(separator_2);
						
						JLabel lblDescripcinPblica = new JLabel("Descripci\u00F3n p\u00FAblica:");
						lblDescripcinPblica.setFont(new Font("Tahoma", Font.PLAIN, 11));
						lblDescripcinPblica.setBounds(33, 397, 96, 14);
						AgregarPropiedad.add(lblDescripcinPblica);
						
						comboProvincia = new JComboBox<>();
						comboProvincia.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboProvincia.setBounds(531, 116, 123, 20);
						AgregarPropiedad.add(comboProvincia);
						
						comboLocalidad = new JComboBox<>();
						comboLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 11));
						comboLocalidad.setBounds(531, 143, 123, 20);
						AgregarPropiedad.add(comboLocalidad);
						
						tfPropietario = new JTextField();
						tfPropietario.setEditable(false);
						tfPropietario.setColumns(10);
						tfPropietario.setBounds(297, 50, 117, 20);
						AgregarPropiedad.add(tfPropietario);
						
						this.btnLupita = new JButton("");
						btnLupita.setIcon(new ImageIcon(imgLup));
						btnLupita.setBounds(413, 50, 22, 20);
						AgregarPropiedad.add(btnLupita);
						
						btnVerHistorial = new JButton("Ver historial");
						btnVerHistorial.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnVerHistorial.setBounds(498, 15, 96, 20);
						AgregarPropiedad.add(btnVerHistorial);
						
						tfInmobiliaria = new JTextField();
						
						tfInmobiliaria.setEditable(false);
						tfInmobiliaria.setBounds(531, 53, 117, 20);
						AgregarPropiedad.add(tfInmobiliaria);
						tfInmobiliaria.setColumns(10);
						
						botonLupitaInmobiliaria = new JButton("");
						botonLupitaInmobiliaria.setIcon(new ImageIcon(imgLup));
						botonLupitaInmobiliaria.setBounds(647, 53, 22, 20);
						AgregarPropiedad.add(botonLupitaInmobiliaria);
						
						lblReservada = new JLabel("Propiedad Reservada");
						lblReservada.setForeground(new Color(204, 0, 0));
						lblReservada.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblReservada.setBounds(146, 11, 145, 27);
						AgregarPropiedad.add(lblReservada);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(33, 422, 288, 117);
						scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
						AgregarPropiedad.add(scrollPane);
						
						taDescPubl = new JTextArea();
						scrollPane.setViewportView(taDescPubl);
						taDescPubl.setLineWrap(true);
						taDescPubl.setBorder(new LineBorder(Color.LIGHT_GRAY));
						
								
						JScrollPane scrollPane_1 = new JScrollPane();
						scrollPane_1.setBounds(348, 421, 306, 118);
						scrollPane_1.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
						AgregarPropiedad.add(scrollPane_1);
						
						taDescPriv = new JTextArea();
						scrollPane_1.setViewportView(taDescPriv);
						taDescPriv.setLineWrap(true);
						taDescPriv.setBorder(new LineBorder(Color.LIGHT_GRAY));
						
						btnMasDatos = new JButton("Mas datos");
						btnMasDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnMasDatos.setBounds(550, 355, 96, 23);
						AgregarPropiedad.add(btnMasDatos);
						
						btnImprimirFicha = new JButton("Imprimir ficha");
						btnImprimirFicha.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						btnImprimirFicha.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnImprimirFicha.setBounds(392, 15, 104, 20);
						AgregarPropiedad.add(btnImprimirFicha);
						
						btnImprimirFichaVisita = new JButton("Ficha Visita");
						btnImprimirFichaVisita.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						btnImprimirFichaVisita.setFont(new Font("Tahoma", Font.PLAIN, 11));
						btnImprimirFichaVisita.setBounds(302, 15, 89, 20);
						AgregarPropiedad.add(btnImprimirFichaVisita);
						
						btnVerGaleria = new JButton("Ver Galeria");
						btnVerGaleria.setFont(new Font("Dialog", Font.PLAIN, 11));
						btnVerGaleria.setBounds(596, 15, 89, 20);
						AgregarPropiedad.add(btnVerGaleria);
						
						btnRemoverPropietario = new JButton("");
						btnRemoverPropietario.setBounds(436, 49, 22, 20);
						btnRemoverPropietario.setIcon(new ImageIcon(imgRemover));
						AgregarPropiedad.add(btnRemoverPropietario);
						
						btnRemoverInmobiliaria = new JButton("");
						btnRemoverInmobiliaria.setBounds(671, 53, 22, 20);
						btnRemoverInmobiliaria.setIcon(new ImageIcon(imgRemover));
						AgregarPropiedad.add(btnRemoverInmobiliaria);
						lblReservada.setVisible(false);
						AgregarPropiedad.setVisible(true);

		
		panelOfrecimientos = new JPanel();
		panelOfrecimientos.setBounds(0, 0, 695, 575);
		getContentPane().add(panelOfrecimientos);
		panelOfrecimientos.setLayout(null);
		panelOfrecimientos.add(alquilerOfrecimiento);
		panelOfrecimientos.add(ventaOfrecimiento);
		panelOfrecimientos.setVisible(true);
		
		JLabel lblVenta = new JLabel("Venta");
		lblVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVenta.setBounds(30, 323, 46, 14);
		panelOfrecimientos.add(lblVenta);
		
		JLabel lblAlquiler = new JLabel("Alquiler");
		lblAlquiler.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAlquiler.setBounds(30, 15, 46, 14);
		panelOfrecimientos.add(lblAlquiler);
										
//		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(0, 0, 700, 603);
//		getContentPane().add(tabbedPane);
		alquilerOfrecimiento.setBounds(0, 40, 695, 232);
		ventaOfrecimiento.setBounds(0, 348, 695, 153);
		
		panelBotones = new JPanel();
		panelBotones.setBounds(10, 603, 680, 23);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue);
		
		btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelBotones.add(btnAtras);
		
		btnBorrador = new JButton("Guardar no disponible");
		panelBotones.add(btnBorrador);
		btnBorrador.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnGuardarDisponible = new JButton("Guardar disponible");
		panelBotones.add(btnGuardarDisponible);
		btnGuardarDisponible.setFont(new Font("Tahoma", Font.BOLD, 11));
		

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelBotones.add(btnSiguiente);
		panelBotones.add(btnCancelar);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panelBotones.add(horizontalGlue_1);
		
		
		btnGuardarDisponible.setVisible(false);
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

	public JTextField getTfIdentificador() {
		return tfIdentificador;
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

	public void setTfPiso(JTextField tfPiso) {
		this.tfPiso = tfPiso;
	}

	public void setTfDepto(JTextField tfDepto) {
		this.tfDepto = tfDepto;
	}

	public void setComboProvincia(JComboBox<String> comboProvincia) {
		this.comboProvincia = comboProvincia;
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

	public JButton getBtnImprimirFichaVisita() {
		return btnImprimirFichaVisita;
	}

	public JButton getBtnVerGaleria() {
		return btnVerGaleria;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public JPanel getPanelOfrecimientos() {
		return panelOfrecimientos;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public JButton getBtnRemoverPropietario() {
		return btnRemoverPropietario;
	}

	public JButton getBtnRemoverInmobiliaria() {
		return btnRemoverInmobiliaria;
	}
	
}
