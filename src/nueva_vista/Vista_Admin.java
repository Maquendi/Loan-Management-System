package nueva_vista;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.sistemaprestamo.controller.Controller;
import com.sistemaprestamo.controller.Time;
import com.sistemaprestamo.model.Contacto;
import com.sistemaprestamo.model.Direccion;
import com.sistemaprestamo.model.Empleado;
import com.sistemaprestamo.model.Empleo;
import com.sistemaprestamo.model.Interes;
import com.sistemaprestamo.model.Modelo;
import com.sistemaprestamo.model.Persona;
import com.sistemaprestamo.model.Referencia;
import com.sistemaprestamo.model.Solicitud;
import com.sistemaprestamo.model.User;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Vista_Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panel;
	private JInternalFrame internalFrame_Cuenta;
	private JMenu mnSolicitudes, mnEditar, mnAgregar, mnNavegar, mnAyuda;
	private JInternalFrame internalFrame_Informacion;
	private JInternalFrame internalFrame_Reportes;
	private JInternalFrame internalFrame_Navegar;
	private JInternalFrame internalFrame_Ayuda;
	private JTextField txtSearchForPeople;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JInternalFrame internalFrame_side;
	private JLabel label;
	private JLabel lblCalculadoraDePrestamos;
	private JLabel lblEditarUnaCuenta;
	private JInternalFrame registerUserFrame;
	private JLabel lblListaDeSolicitudes;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblEmail_1;
	private JLabel lblCedula;
	private JLabel lblNacionalidad;
	private JLabel lblTelefonoMobil;
	private JLabel lblTelefonoCasa;
	private JPanel panel_2;
	private JTextField txt_nombreR;
	private JTextField txt_apellidoR;
	private JTextField txt_cedulaR;
	private JTextField txt_emailR;
	private JTextField txtTelefR;
	private JTextField txtNacionalidad;
	private JLabel lblConfiguracionDeUsario;
	@SuppressWarnings("unused")
	private JLabel label_1;
	private JPanel panel_4;
	private JLabel lblRegistrarUser;
	private JLabel lblTime;

	private Time runningTime;
	private JTextField txtCalleR;
	private JTextField txtSectorR;
	private JTextField txtCiudadR;
	private JTextField txtreferenciaR;
	private JTextField txtNombreRef;
	private JTextField txtApellidoRef;
	private JTextField txtUserName;
	private JTextField txtPass;
	private JTextField txtTelRef;
	private JTextField txtParentescoR;
	private JComboBox<String> comboPriviledge;
	private JComboBox<String> comboSexoR;
	private JComboBox<String> comboCargo;
	private Controller controller;
	private JLabel lblSalario;
	private JTextField txtSalarioR;
	private JDateChooser dateChooser;
	private JLabel error_lbl;
	private JButton btnSubmitUser;
	private JButton btnSalir;
	private JInternalFrame findUserFrame;
	private JInternalFrame frameDesplegable;
	private JLabel lblFound;
	private JButton btnNewButton;
	private JLabel lblFound2;
	private JLabel lblFound3;
	private JLabel lblFound4;
	@SuppressWarnings("unused")
	private ArrayList<String> lista;
	JInternalFrame solicitudPendienteFrame;
	private JTable table;
	private JPanel panel_3;
	private JTextField nametxt;
	private JTextField empresatxt;
	private JButton btnAprobado;
	private JButton btnDeclinado;
	private JTextField telEmpresatxt;
	private JTextField salariotxt;
	private JTextField tiempotxt;
	private JTextField prestamotxt;
	private JTextField montotxt;
	private JTextField fechatxt;
	private JTextField plazotxt;
	private JTextField otroInterestxt;
	private JTextField txt_montoAproved;
	private JRadioButton rdbtnOtroMonto, rdbtnTodo;
	private JComboBox<String> comboInteres;
	private JRadioButton rdbtnFijo, rdbtnAnual, rdbtnMensual, rdbtnVariable;
	private ButtonGroup bg, tipoInteresGroup;
	private JLabel lblNoSolicitud;
	private JTextField txtNumeroSolicitud;
	private int selectedRow;
	private JCheckBox chckbxAddComment;
	private JTextPane textPaneReason;
	private JLabel lblDeclineReason;
	private JLabel userNamelable;
	private JPanel panel_5;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTable table_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblPlazoenMes;
	private JLabel lblCuotasMensuales;
	private JTextField textField_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	
	
	
	
	
	

	public Vista_Admin(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_dollar-exchange_532645 (1).png"));
		setTitle("LOAN MANAGER");
		this.initiate(controller);
	}

	private void initiate(Controller controller) {

		setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-8, 0, 1382, 736);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.controller = controller;

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1366, 697);
		contentPane.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 1366, 34);
		panel.add(menuBar);

		mnSolicitudes = new JMenu("Cuentas");
		menuBar.add(mnSolicitudes);
		mnSolicitudes.setBackground(new Color(204, 153, 0));
		mnSolicitudes.setBorder(UIManager.getBorder("MenuBar.border"));
		mnSolicitudes.setForeground(new Color(153, 204, 153));

		// TextPrompt tp = new TextPrompt("",this.textField);

		mnSolicitudes.setFont(new Font("Verdana", Font.BOLD, 16));

		mnEditar = new JMenu("Informacion");
		menuBar.add(mnEditar);
		mnEditar.setBorder(UIManager.getBorder("MenuBar.border"));
		mnEditar.setForeground(new Color(153, 204, 153));

		mnEditar.setFont(new Font("Verdana", Font.BOLD, 16));

		mnAgregar = new JMenu("Reportes");
		menuBar.add(mnAgregar);
		mnAgregar.setBorder(UIManager.getBorder("MenuBar.border"));
		mnAgregar.setForeground(new Color(153, 204, 153));

		mnAgregar.setFont(new Font("Verdana", Font.BOLD, 16));

		mnNavegar = new JMenu("Navegar");
		menuBar.add(mnNavegar);
		mnNavegar.setBorder(UIManager.getBorder("MenuBar.border"));
		mnNavegar.setForeground(new Color(153, 204, 153));

		mnNavegar.setFont(new Font("Verdana", Font.BOLD, 16));

		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		mnAyuda.setBorder(UIManager.getBorder("MenuBar.border"));
		mnAyuda.setForeground(new Color(153, 204, 153));

		mnAyuda.setFont(new Font("Verdana", Font.BOLD, 16));

		internalFrame_Cuenta = new JInternalFrame("");
		internalFrame_Cuenta.setRequestFocusEnabled(false);
		internalFrame_Cuenta.setBorder(null);
		// internalFrame_Cuenta.setBounds(0, 11, 353, 458);
		panel.add(internalFrame_Cuenta);
		internalFrame_Cuenta.setVisible(true);
		cancelInternalFrameMotion(internalFrame_Cuenta);

		internalFrame_Informacion = new JInternalFrame("");
		internalFrame_Informacion.setBorder(null);
		// internalFrame_Informacion.setBounds(89, 33, 274, 427);
		panel.add(internalFrame_Informacion);
		internalFrame_Informacion.setVisible(true);

		cancelInternalFrameMotion(internalFrame_Informacion);

		internalFrame_Reportes = new JInternalFrame("");
		internalFrame_Reportes.setBorder(null);
		// internalFrame_Reportes.setBounds(205, 33, 247, 450);
		panel.add(internalFrame_Reportes);
		internalFrame_Reportes.setVisible(true);
		cancelInternalFrameMotion(internalFrame_Reportes);

		internalFrame_Navegar = new JInternalFrame("");
		internalFrame_Navegar.setBorder(null);
		// internalFrame_Navegar.setBounds(290, 33, 380, 567);
		panel.add(internalFrame_Navegar);
		internalFrame_Navegar.setVisible(true);
		cancelInternalFrameMotion(internalFrame_Navegar);

		internalFrame_Ayuda = new JInternalFrame("");
		internalFrame_Ayuda.setBorder(null);
		// internalFrame_Ayuda.setBounds(162, 32, 266, 314);
		panel.add(internalFrame_Ayuda);
		internalFrame_Ayuda.setVisible(true);
		cancelInternalFrameMotion(internalFrame_Ayuda);

		internalFrame_side = new JInternalFrame("");
		internalFrame_side.getContentPane().setBackground(new Color(0, 0, 51));
		internalFrame_side.setBorder(null);
		 internalFrame_side.setBounds(0, 91, 390, 606); //uncomment this to edit
		panel.add(internalFrame_side);
		internalFrame_side.setVisible(true);
		internalFrame_side.getContentPane().setLayout(null);
		cancelInternalFrameMotion(internalFrame_side);

		registerUserFrame = new JInternalFrame("");
		registerUserFrame.setBackground(new Color(0, 0, 51));
		registerUserFrame.getContentPane().setBackground(Color.DARK_GRAY);
		registerUserFrame.setBorder(null);
		// registerUserFrame.setBounds(390, 91, 976, 606); //uncomment this to edit
		panel.add(registerUserFrame);
		registerUserFrame.setVisible(true);
		cancelInternalFrameMotion(registerUserFrame);
		registerUserFrame.getContentPane().setLayout(null);

		findUserFrame = new JInternalFrame("");
		findUserFrame.getContentPane().setBackground(new Color(51, 51, 51));
		findUserFrame.setBorder(null);
		//findUserFrame.setBounds(0, 90, 1366, 610); //this frame will display any user
		// that's found.......
		panel.add(findUserFrame);
		findUserFrame.getContentPane().setLayout(null);
		findUserFrame.setVisible(true);
		cancelInternalFrameMotion(findUserFrame);

		frameDesplegable = new JInternalFrame("");
		frameDesplegable.setBorder(null);
		//frameDesplegable.setBounds(337,75, 371, 388);
		panel.add(frameDesplegable);
		frameDesplegable.setVisible(true);
		cancelInternalFrameMotion(frameDesplegable);
		frameDesplegable.getContentPane().setLayout(null);

		solicitudPendienteFrame = new JInternalFrame("");
		solicitudPendienteFrame.getContentPane().setBackground(Color.GRAY);
		solicitudPendienteFrame.setBorder(null);
		//solicitudPendienteFrame.setBounds(388, 101, 968, 596); // uncomment this to edit
		panel.add(solicitudPendienteFrame);
		solicitudPendienteFrame.setVisible(true);

		cancelInternalFrameMotion(solicitudPendienteFrame);
		solicitudPendienteFrame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(new Color(0, 51, 51));
		scrollPane.setBackground(new Color(51, 102, 102));
		scrollPane.setBounds(10, 11, 948, 195);
		solicitudPendienteFrame.getContentPane().add(scrollPane);
		
		scrollPane.getViewport().setBackground(Color.DARK_GRAY);

		String[] columns = new String[] { "No. Sol", "Fecha ", "Nombre", "Cedula", "Empresa", "Tiempo L", "Sueldo",
				"Monto Sol", "Plazo", "Tipo P" };

		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);

		table = new JTable(model) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table.setFont(new Font("Verdana", Font.ITALIC, 13));
		processTable(table);
		scrollPane.setViewportView(table);

		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_3.setBackground(Color.LIGHT_GRAY);
		//panel_3.setBounds(10, 207, 948, 351);
		solicitudPendienteFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		btnAprobado = new JButton("Aprobar");
		btnAprobado.setBorder(UIManager.getBorder("RadioButton.border"));
		btnAprobado.setBounds(743, 306, 82, 23);
		panel_3.add(btnAprobado);

		btnDeclinado = new JButton("Declinar");
		btnDeclinado.setBorder(UIManager.getBorder("RadioButton.border"));
		btnDeclinado.setBounds(835, 306, 89, 23);
		panel_3.add(btnDeclinado);

		JLabel lblSolicitante = new JLabel("Solicitante");
		lblSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSolicitante.setBounds(10, 39, 71, 23);
		panel_3.add(lblSolicitante);

		nametxt = new JTextField();
		nametxt.setEditable(false);
		nametxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		nametxt.setBounds(114, 42, 213, 20);
		panel_3.add(nametxt);
		nametxt.setColumns(10);

		JLabel lblCondicionLaboral = new JLabel("Condicion Laboral");
		lblCondicionLaboral.setBorder(new LineBorder(null));
		lblCondicionLaboral.setHorizontalAlignment(SwingConstants.CENTER);
		lblCondicionLaboral.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblCondicionLaboral.setBounds(80, 128, 199, 23);
		panel_3.add(lblCondicionLaboral);

		empresatxt = new JTextField();
		empresatxt.setSelectedTextColor(UIManager.getColor("Button.shadow"));
		empresatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		empresatxt.setBackground(UIManager.getColor("Button.shadow"));
		empresatxt.setEditable(false);
		empresatxt.setColumns(10);
		empresatxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		empresatxt.setBounds(80, 184, 199, 20);
		panel_3.add(empresatxt);

		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpresa.setBounds(10, 181, 58, 23);
		panel_3.add(lblEmpresa);

		telEmpresatxt = new JTextField();
		telEmpresatxt.setSelectedTextColor(UIManager.getColor("Button.shadow"));
		telEmpresatxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		telEmpresatxt.setBackground(UIManager.getColor("Button.shadow"));
		telEmpresatxt.setEditable(false);
		telEmpresatxt.setColumns(10);
		telEmpresatxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		telEmpresatxt.setBounds(80, 218, 199, 20);
		panel_3.add(telEmpresatxt);

		JLabel lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono_1.setBounds(10, 215, 58, 23);
		panel_3.add(lblTelefono_1);

		salariotxt = new JTextField();
		salariotxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		salariotxt.setBackground(UIManager.getColor("Button.shadow"));
		salariotxt.setEditable(false);
		salariotxt.setColumns(10);
		salariotxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		salariotxt.setBounds(80, 254, 199, 20);
		panel_3.add(salariotxt);

		JLabel lblSalario_1 = new JLabel("Salario");
		lblSalario_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalario_1.setBounds(10, 251, 58, 23);
		panel_3.add(lblSalario_1);

		tiempotxt = new JTextField();
		tiempotxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tiempotxt.setBackground(UIManager.getColor("Button.shadow"));
		tiempotxt.setEditable(false);
		tiempotxt.setColumns(10);
		tiempotxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tiempotxt.setBounds(80, 288, 199, 20);
		panel_3.add(tiempotxt);

		JLabel lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTiempo.setBounds(10, 285, 58, 23);
		panel_3.add(lblTiempo);

		JLabel lblInformacionPrestamoSolicitado = new JLabel("Informacion Solicitud");
		lblInformacionPrestamoSolicitado.setBorder(new LineBorder(null));
		lblInformacionPrestamoSolicitado.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacionPrestamoSolicitado.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblInformacionPrestamoSolicitado.setBounds(361, 128, 206, 23);
		panel_3.add(lblInformacionPrestamoSolicitado);

		prestamotxt = new JTextField();
		prestamotxt.setEditable(false);
		prestamotxt.setColumns(10);
		prestamotxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		prestamotxt.setBounds(398, 184, 143, 20);
		panel_3.add(prestamotxt);

		JLabel lblPrestamo = new JLabel("Prestamo");
		lblPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrestamo.setBounds(328, 181, 58, 23);
		panel_3.add(lblPrestamo);

		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonto.setBounds(328, 215, 58, 23);
		panel_3.add(lblMonto);

		montotxt = new JTextField();
		montotxt.setEditable(false);
		montotxt.setColumns(10);
		montotxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		montotxt.setBounds(398, 218, 143, 20);
		panel_3.add(montotxt);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(328, 251, 58, 23);
		panel_3.add(lblFecha);

		fechatxt = new JTextField();
		fechatxt.setEditable(false);
		fechatxt.setColumns(10);
		fechatxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		fechatxt.setBounds(398, 254, 143, 20);
		panel_3.add(fechatxt);

		JLabel lblPlazo = new JLabel("Plazo");
		lblPlazo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlazo.setBounds(328, 285, 58, 23);
		panel_3.add(lblPlazo);

		plazotxt = new JTextField();
		plazotxt.setEditable(false);
		plazotxt.setColumns(10);
		plazotxt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		plazotxt.setBounds(398, 288, 143, 20);
		panel_3.add(plazotxt);

		JLabel label_3 = new JLabel("");
		label_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label_3.setBounds(732, 291, 206, 49);
		panel_3.add(label_3);

		JLabel lblAplicarInteres = new JLabel("Aplicar Interes");
		lblAplicarInteres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAplicarInteres.setBounds(631, 45, 91, 23);
		panel_3.add(lblAplicarInteres);

		comboInteres = new JComboBox<>();
		comboInteres.setModel(new DefaultComboBoxModel<String>(new String[] { "", "2%", "5%", "7%", "9%", "15%", "21%" }));
		comboInteres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboInteres.setBounds(743, 45, 71, 23);
		panel_3.add(comboInteres);

		otroInterestxt = new JTextField();
		otroInterestxt.setBounds(824, 45, 82, 23);
		panel_3.add(otroInterestxt);
		otroInterestxt.setColumns(10);

		rdbtnFijo = new JRadioButton("Fijo");
		rdbtnFijo.setSelected(true);
		rdbtnFijo.setBounds(743, 75, 71, 23);
		panel_3.add(rdbtnFijo);

		rdbtnVariable = new JRadioButton("Variable");
		rdbtnVariable.setBounds(824, 75, 82, 23);
		panel_3.add(rdbtnVariable);

		tipoInteresGroup = new ButtonGroup();

		tipoInteresGroup.add(rdbtnFijo);
		tipoInteresGroup.add(rdbtnVariable);

		rdbtnAnual = new JRadioButton("Anual");
		rdbtnAnual.setSelected(true);
		rdbtnAnual.setBounds(743, 109, 71, 23);
		panel_3.add(rdbtnAnual);

		rdbtnMensual = new JRadioButton("Mensual");
		rdbtnMensual.setBounds(824, 109, 82, 23);
		panel_3.add(rdbtnMensual);

		bg = new ButtonGroup();
		bg.add(rdbtnMensual);
		bg.add(rdbtnAnual);

		JLabel lblMontoAprobado = new JLabel("MONTO APROVADO");
		lblMontoAprobado.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblMontoAprobado.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontoAprobado.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblMontoAprobado.setBounds(743, 153, 158, 23);
		panel_3.add(lblMontoAprobado);

		rdbtnTodo = new JRadioButton("TODO");
		rdbtnTodo.setSelected(true);
		rdbtnTodo.setBounds(743, 183, 71, 23);
		panel_3.add(rdbtnTodo);

		rdbtnOtroMonto = new JRadioButton("OTRO");

		rdbtnOtroMonto.setBounds(827, 183, 74, 23);
		panel_3.add(rdbtnOtroMonto);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnTodo);
		buttonGroup.add(rdbtnOtroMonto);

		txt_montoAproved = new JTextField();
		txt_montoAproved.setEditable(false);
		txt_montoAproved.setBounds(743, 217, 118, 23);
		panel_3.add(txt_montoAproved);
		txt_montoAproved.setColumns(10);

		JLabel lblrd = new JLabel("$RD");
		lblrd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblrd.setBounds(869, 218, 30, 23);
		panel_3.add(lblrd);

		JLabel label_4 = new JLabel("%");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(915, 46, 23, 24);
		panel_3.add(label_4);

		lblNoSolicitud = new JLabel("NO. Solicitud");
		lblNoSolicitud.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNoSolicitud.setBounds(10, 79, 89, 19);
		panel_3.add(lblNoSolicitud);

		txtNumeroSolicitud = new JTextField();
		txtNumeroSolicitud.setEditable(false);
		txtNumeroSolicitud.setColumns(10);
		txtNumeroSolicitud.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtNumeroSolicitud.setBounds(114, 76, 104, 20);
		panel_3.add(txtNumeroSolicitud);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(551, 218, 171, 90);
		panel_3.add(scrollPane_1);
		
		textPaneReason = new JTextPane();
		textPaneReason.setBackground(Color.LIGHT_GRAY);
		textPaneReason.setEditable(false);
		scrollPane_1.setViewportView(textPaneReason);
		
	    lblDeclineReason = new JLabel("");
		lblDeclineReason.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDeclineReason.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeclineReason.setBounds(551, 196, 171, 23);
		panel_3.add(lblDeclineReason);
		
		chckbxAddComment = new JCheckBox("Add Comment");

		chckbxAddComment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chckbxAddComment.setBounds(612, 317, 111, 23);
		panel_3.add(chckbxAddComment);

		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(135);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setResizable(false);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);

		lblFound = new JLabel("");
		lblFound.setForeground(new Color(51, 102, 102));
		lblFound.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFound.setBounds(10, 48, 351, 45);
		frameDesplegable.getContentPane().add(lblFound);

		btnNewButton = new JButton("Busquedas Recientes");
		
		
		
		
		
		btnNewButton.setBorder(UIManager.getBorder("MenuItem.border"));
		btnNewButton.setForeground(new Color(0, 204, 204));
		btnNewButton.setFont(new Font("Verdana", Font.ITALIC, 13));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton.setBounds(2, 2, 369, 30);
		frameDesplegable.getContentPane().add(btnNewButton);

		lblFound2 = new JLabel("");
		lblFound2.setForeground(new Color(51, 102, 102));
		lblFound2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFound2.setBounds(10, 104, 351, 45);
		frameDesplegable.getContentPane().add(lblFound2);

		lblFound3 = new JLabel("");
		lblFound3.setForeground(new Color(51, 102, 102));
		lblFound3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFound3.setBounds(10, 160, 351, 45);
		frameDesplegable.getContentPane().add(lblFound3);

		lblFound4 = new JLabel("");
		lblFound4.setForeground(new Color(51, 102, 102));
		lblFound4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblFound4.setBounds(10, 216, 351, 45);
		frameDesplegable.getContentPane().add(lblFound4);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBounds(0, 0, 976, 73);
		registerUserFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblConfiguracionDeUsario = new JLabel(" CONFIGURACION DE USUARIO");
		lblConfiguracionDeUsario.setBorder(new LineBorder(new Color(0, 0, 102), 1, true));
		lblConfiguracionDeUsario.setForeground(new Color(255, 255, 255));
		lblConfiguracionDeUsario.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblConfiguracionDeUsario.setBounds(10, 11, 479, 40);
		panel_2.add(lblConfiguracionDeUsario);

		error_lbl = new JLabel("");
		error_lbl.setForeground(new Color(204, 0, 0));
		error_lbl.setFont(new Font("Verdana", Font.ITALIC, 19));
		error_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		error_lbl.setBorder(new LineBorder(new Color(0, 0, 102)));
		error_lbl.setBounds(495, 11, 471, 40);
		panel_2.add(error_lbl);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.GRAY);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_4.setBounds(0, 72, 976, 530);
		registerUserFrame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		lblTelefonoCasa = new JLabel("F. Nacimiento");
		lblTelefonoCasa.setBounds(400, 146, 113, 20);
		panel_4.add(lblTelefonoCasa);
		lblTelefonoCasa.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblTelefonoMobil = new JLabel("Sexo/Gender");
		lblTelefonoMobil.setBounds(400, 110, 113, 20);
		panel_4.add(lblTelefonoMobil);
		lblTelefonoMobil.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblEmail_1 = new JLabel("Nacionalidad");
		lblEmail_1.setBounds(400, 68, 113, 28);
		panel_4.add(lblEmail_1);
		lblEmail_1.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblEmail = new JLabel("Mobil/Home");
		lblEmail.setBounds(400, 36, 113, 20);
		panel_4.add(lblEmail);
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 16));

		txtTelefR = new JTextField();
		txtTelefR.setBounds(525, 36, 203, 20);
		panel_4.add(txtTelefR);
		txtTelefR.setColumns(10);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setBounds(525, 72, 203, 20);
		panel_4.add(txtNacionalidad);
		txtNacionalidad.setColumns(10);

		txt_cedulaR = new JTextField();
		txt_cedulaR.setBounds(108, 114, 244, 20);
		panel_4.add(txt_cedulaR);
		txt_cedulaR.setColumns(10);

		txt_apellidoR = new JTextField();
		txt_apellidoR.setBounds(108, 75, 244, 20);
		panel_4.add(txt_apellidoR);
		txt_apellidoR.setColumns(10);

		txt_nombreR = new JTextField();
		txt_nombreR.setBounds(108, 36, 244, 20);
		panel_4.add(txt_nombreR);
		txt_nombreR.setColumns(10);

		txt_emailR = new JTextField();
		txt_emailR.setBounds(108, 149, 244, 20);
		panel_4.add(txt_emailR);
		txt_emailR.setColumns(10);

		lblNacionalidad = new JLabel("Email");
		lblNacionalidad.setBounds(29, 146, 69, 20);
		panel_4.add(lblNacionalidad);
		lblNacionalidad.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(29, 107, 69, 20);
		panel_4.add(lblCedula);
		lblCedula.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(29, 68, 69, 20);
		panel_4.add(lblApellido);
		lblApellido.setFont(new Font("Verdana", Font.PLAIN, 16));

		lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(30, 36, 69, 20);
		panel_4.add(lblNombre);
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 16));

		txtCalleR = new JTextField();
		txtCalleR.setColumns(10);
		txtCalleR.setBounds(108, 270, 231, 20);
		panel_4.add(txtCalleR);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCalle.setBounds(29, 262, 69, 28);
		panel_4.add(lblCalle);

		JLabel lblSector = new JLabel("Sector");
		lblSector.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblSector.setBounds(29, 301, 69, 28);
		panel_4.add(lblSector);

		txtSectorR = new JTextField();
		txtSectorR.setColumns(10);
		txtSectorR.setBounds(108, 309, 231, 20);
		panel_4.add(txtSectorR);

		txtCiudadR = new JTextField();
		txtCiudadR.setColumns(10);
		txtCiudadR.setBounds(108, 348, 231, 20);
		panel_4.add(txtCiudadR);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblCiudad.setBounds(29, 340, 69, 28);
		panel_4.add(lblCiudad);

		JLabel lblRef = new JLabel("Ref");
		lblRef.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblRef.setBounds(29, 379, 46, 28);
		panel_4.add(lblRef);

		txtreferenciaR = new JTextField();
		txtreferenciaR.setColumns(10);
		txtreferenciaR.setBounds(108, 387, 231, 20);
		panel_4.add(txtreferenciaR);

		JLabel label_15 = new JLabel("Nombre ");
		label_15.setFont(new Font("Verdana", Font.PLAIN, 16));
		label_15.setBounds(387, 274, 69, 20);
		panel_4.add(label_15);

		txtNombreRef = new JTextField();
		txtNombreRef.setColumns(10);
		txtNombreRef.setBounds(486, 277, 148, 20);
		panel_4.add(txtNombreRef);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblUserName.setBounds(684, 274, 96, 20);
		panel_4.add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPassword.setBounds(684, 311, 96, 21);
		panel_4.add(lblPassword);

		txtApellidoRef = new JTextField();
		txtApellidoRef.setColumns(10);
		txtApellidoRef.setBounds(486, 311, 148, 20);
		panel_4.add(txtApellidoRef);

		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(786, 274, 138, 20);
		panel_4.add(txtUserName);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(786, 313, 138, 20);
		panel_4.add(txtPass);

		JLabel lblPriviledges = new JLabel("Priviledges");
		lblPriviledges.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPriviledges.setBounds(684, 345, 96, 20);
		panel_4.add(lblPriviledges);

		JLabel lblFuncion = new JLabel("Funcion ");
		lblFuncion.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblFuncion.setBounds(684, 383, 96, 21);
		panel_4.add(lblFuncion);

		txtTelRef = new JTextField();
		txtTelRef.setColumns(10);
		txtTelRef.setBounds(486, 348, 148, 20);
		panel_4.add(txtTelRef);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTelefono.setBounds(387, 344, 81, 22);
		panel_4.add(lblTelefono);

		JLabel lblNacional = new JLabel("Parentesco");
		lblNacional.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNacional.setBounds(387, 385, 90, 22);
		panel_4.add(lblNacional);

		txtParentescoR = new JTextField();
		txtParentescoR.setColumns(10);
		txtParentescoR.setBounds(486, 386, 148, 20);
		panel_4.add(txtParentescoR);

		JLabel label_23 = new JLabel("Apellido");
		label_23.setFont(new Font("Verdana", Font.PLAIN, 16));
		label_23.setBounds(387, 309, 69, 20);
		panel_4.add(label_23);

		comboCargo = new JComboBox<String>();
		comboCargo.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Cajero", "Gerente", "Tech Support" }));
		comboCargo.setBounds(786, 386, 138, 21);
		panel_4.add(comboCargo);

		comboPriviledge = new JComboBox<>();
		comboPriviledge.setModel(new DefaultComboBoxModel<String>(
				new String[] { "", "Usuario", "Administrador", "Tecnico Soft", "All Priviledges" }));
		comboPriviledge.setBounds(786, 348, 138, 20);
		panel_4.add(comboPriviledge);

		btnSubmitUser = new JButton("Enviar");
		btnSubmitUser.setBackground(new Color(204, 204, 204));
		btnSubmitUser.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSubmitUser.setForeground(new Color(0, 102, 51));
		btnSubmitUser.setFont(new Font("Verdana", Font.ITALIC, 12));
		btnSubmitUser.setBounds(732, 470, 81, 28);
		panel_4.add(btnSubmitUser);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(523, 146, 203, 20);
		panel_4.add(dateChooser);

		comboSexoR = new JComboBox<>();
		comboSexoR.setModel(new DefaultComboBoxModel<String>(new String[] { "", "Masculino", "Femenino" }));
		comboSexoR.setFont(new Font("Verdana", Font.ITALIC, 15));
		comboSexoR.setBounds(523, 113, 203, 20);
		panel_4.add(comboSexoR);

		JLabel label_2 = new JLabel("");
		label_2.setBorder(new LineBorder(new Color(0, 102, 51), 1, true));
		label_2.setBounds(16, 13, 930, 163);
		panel_4.add(label_2);

		JLabel lblAddressInformation = new JLabel("ADDRESS INFORMATION");
		lblAddressInformation.setForeground(new Color(0, 102, 102));
		lblAddressInformation.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblAddressInformation.setVerticalAlignment(SwingConstants.TOP);
		lblAddressInformation.setBorder(new LineBorder(new Color(0, 102, 51)));
		lblAddressInformation.setBounds(16, 187, 339, 250);
		panel_4.add(lblAddressInformation);

		JLabel lblReferenciaFamiliar = new JLabel("REFERENCIA FAMILIAR");
		lblReferenciaFamiliar.setVerticalAlignment(SwingConstants.TOP);
		lblReferenciaFamiliar.setForeground(new Color(0, 102, 102));
		lblReferenciaFamiliar.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblReferenciaFamiliar.setBorder(new LineBorder(new Color(0, 102, 51)));
		lblReferenciaFamiliar.setBounds(359, 187, 298, 250);
		panel_4.add(lblReferenciaFamiliar);

		JLabel lblUserLoginInfo = new JLabel("USER LOGIN INFO");
		lblUserLoginInfo.setVerticalAlignment(SwingConstants.TOP);
		lblUserLoginInfo.setForeground(new Color(0, 102, 102));
		lblUserLoginInfo.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblUserLoginInfo.setBorder(new LineBorder(new Color(0, 102, 51)));
		lblUserLoginInfo.setBounds(662, 187, 284, 250);
		panel_4.add(lblUserLoginInfo);

		lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Verdana", Font.ITALIC, 16));
		lblSalario.setBounds(751, 36, 62, 20);
		panel_4.add(lblSalario);

		txtSalarioR = new JTextField();
		txtSalarioR.setBounds(833, 39, 96, 20);
		panel_4.add(txtSalarioR);
		txtSalarioR.setColumns(10);

		btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(153, 0, 0));
		btnSalir.setFont(new Font("Verdana", Font.ITALIC, 12));
		btnSalir.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setBounds(853, 470, 81, 28);
		panel_4.add(btnSalir);

		JButton btnWorkSpace = new JButton("MY WORK SPACE");
		btnWorkSpace.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnWorkSpace.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnWorkSpace.setFont(new Font("Verdana", Font.ITALIC, 18));
		btnWorkSpace.setForeground(new Color(255, 255, 255));
		btnWorkSpace.setHorizontalAlignment(SwingConstants.LEFT);
		btnWorkSpace
				.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_25_evernote_353470.png"));
		btnWorkSpace.setBackground(Color.LIGHT_GRAY);
		btnWorkSpace.setBounds(10, 11, 370, 69);
		internalFrame_side.getContentPane().add(btnWorkSpace);

		JLabel lblTareas = new JLabel("TAREAS PENDIENTES");
		lblTareas.setForeground(new Color(255, 255, 255));
		lblTareas.setBorder(null);
		lblTareas.setIcon(
				new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_stock_task-recurring_24332.png"));
		lblTareas.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblTareas.setBounds(10, 206, 370, 69);
		internalFrame_side.getContentPane().add(lblTareas);

		lblRegistrarUser = new JLabel("REGISTRAR USUARIO");

		lblRegistrarUser.setForeground(new Color(255, 255, 255));
		lblRegistrarUser.setBackground(new Color(102, 153, 255));
		lblRegistrarUser.setBorder(null);
		lblRegistrarUser
				.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_add-user_46775.png"));
		lblRegistrarUser.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblRegistrarUser.setBounds(10, 115, 370, 69);
		internalFrame_side.getContentPane().add(lblRegistrarUser);

		lblCalculadoraDePrestamos = new JLabel("CALCULADORA DE PRESTAMOS");
		
		
		
		lblCalculadoraDePrestamos.setForeground(new Color(255, 255, 255));
		lblCalculadoraDePrestamos.setBorder(null);
		lblCalculadoraDePrestamos.setIcon(
				new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Money_Calculator_11000.png"));
		lblCalculadoraDePrestamos.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblCalculadoraDePrestamos.setBounds(10, 297, 370, 69);
		internalFrame_side.getContentPane().add(lblCalculadoraDePrestamos);

		lblEditarUnaCuenta = new JLabel("TROUBLESHOOT ACCOUNT");
		lblEditarUnaCuenta.setForeground(new Color(255, 255, 255));
		lblEditarUnaCuenta.setBorder(null);
		lblEditarUnaCuenta
				.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Settings-5_379393.png"));
		lblEditarUnaCuenta.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblEditarUnaCuenta.setBounds(10, 397, 370, 75);
		internalFrame_side.getContentPane().add(lblEditarUnaCuenta);

		lblListaDeSolicitudes = new JLabel("SOLICITUDES PENDIENTES");

		lblListaDeSolicitudes.setBorder(null);
		lblListaDeSolicitudes.setIcon(
				new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_hand-coins_532625 (2).png"));
		lblListaDeSolicitudes.setFont(new Font("Verdana", Font.ITALIC, 18));
		lblListaDeSolicitudes.setForeground(new Color(255, 255, 255));
		lblListaDeSolicitudes.setBounds(10, 499, 370, 69);
		internalFrame_side.getContentPane().add(lblListaDeSolicitudes);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBounds(0, 33, 1366, 57);
		panel.add(panel_1);
		panel_1.setBackground(new Color(153, 204, 204));
		panel_1.setLayout(null);

		lblTime = new JLabel("");
		lblTime.setForeground(new Color(0, 102, 102));
		lblTime.setFont(new Font("Verdana", Font.ITALIC, 20));
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setBounds(1014, 2, 342, 53);
		panel_1.add(lblTime);

		userNamelable = new JLabel("");
		
		userNamelable.setForeground(new Color(0, 102, 102));
		userNamelable.setFont(new Font("Verdana", Font.ITALIC, 20));
		userNamelable.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_User_22743.png"));
		userNamelable.setBounds(733, 0, 240, 57);
		panel_1.add(userNamelable);

		txtSearchForPeople = new JTextField();
		txtSearchForPeople.setMargin(new Insets(1, 1, 1, 1));

		txtSearchForPeople.setText("BUSCAR PERSONA");
		txtSearchForPeople.setFont(new Font("Verdana", Font.ITALIC, 18));
		txtSearchForPeople.setForeground(Color.WHITE);
		txtSearchForPeople.setBackground(new Color(153, 102, 255));
		txtSearchForPeople.setBorder(new LineBorder(new Color(153, 204, 204), 2, true));
		txtSearchForPeople.setBounds(335, 12, 374, 34);
		panel_1.add(txtSearchForPeople);
		txtSearchForPeople.setColumns(10);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_onebit_02_12576.png"));
		lblNewLabel_1.setBounds(277, 11, 48, 44);
		panel_1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("My Company SRL");
		lblNewLabel_2.setForeground(new Color(0, 102, 102));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Verdana", Font.ITALIC, 24));
		lblNewLabel_2.setBounds(10, 0, 253, 57);
		panel_1.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		separator.setBounds(1004, 2, 1, 55);
		panel_1.add(separator);

		label = new JLabel("");
		label.setBounds(0, 95, 21, 602);
		panel.add(label);

		this.userNamelable.setText(controller.getModelo().getEmpleado().getNombre_Persona() + " "+controller.getModelo().getEmpleado().getApellido());
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(51, 51, 51));
		//panel_5.setBounds(400, 101, 956, 585); //uncomment this to edit....
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel = new JLabel("Cantidad del Prestamo");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 49, 178, 28);
		panel_5.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY));
		textField.setForeground(new Color(0, 0, 51));
		textField.setBackground(Color.WHITE);
		textField.setBounds(213, 50, 189, 30);
		panel_5.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.getViewport().setBackground(Color.DARK_GRAY);
		scrollPane_2.setBounds(10, 292, 936, 282);
		panel_5.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setSelectionForeground(new Color(102, 51, 51));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No.", "Pago", "Fecha De Pago", "Cuota", "Intereses", "Amortizacion", "Amortizado", "Pendiente"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, true, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(76);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(5).setResizable(false);
		table_1.getColumnModel().getColumn(6).setResizable(false);
		table_1.setBackground(new Color(51, 51, 51));
		table_1.setGridColor(new Color(153, 204, 204));
		table_1.setForeground(new Color(102, 153, 255));
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane_2.setViewportView(table_1);
		
		JLabel lblTasaDeInteres = new JLabel("Tasa De Interes Anual");
		lblTasaDeInteres.setForeground(Color.WHITE);
		lblTasaDeInteres.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTasaDeInteres.setBounds(31, 82, 178, 28);
		panel_5.add(lblTasaDeInteres);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY));
		textField_1.setForeground(new Color(0, 0, 51));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(213, 80, 189, 30);
		panel_5.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY));
		textField_2.setForeground(new Color(0, 0, 51));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(213, 110, 189, 30);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.DARK_GRAY));
		textField_3.setForeground(new Color(0, 0, 51));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(213, 140, 189, 30);
		panel_5.add(textField_3);
		
		lblPlazoenMes = new JLabel("Plazo(En Mes)");
		lblPlazoenMes.setForeground(Color.WHITE);
		lblPlazoenMes.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPlazoenMes.setBounds(31, 110, 178, 28);
		panel_5.add(lblPlazoenMes);
		
		lblCuotasMensuales = new JLabel("Cuotas Mensuales");
		lblCuotasMensuales.setForeground(Color.WHITE);
		lblCuotasMensuales.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCuotasMensuales.setBounds(31, 142, 178, 28);
		panel_5.add(lblCuotasMensuales);
		
		JButton btnNewButton_1 = new JButton("Ver Calendario de Amortizacion Anual");
		btnNewButton_1.setBorder(UIManager.getBorder("RadioButton.border"));
		btnNewButton_1.setBounds(412, 51, 219, 28);
		panel_5.add(btnNewButton_1);
		
		JButton btnCrearOActualizar = new JButton("Crear o Actualizar Cronograma");
		btnCrearOActualizar.setBorder(UIManager.getBorder("RadioButton.border"));
		btnCrearOActualizar.setBounds(412, 98, 219, 28);
		panel_5.add(btnCrearOActualizar);
		
		JButton btnAgregarPrepagos = new JButton("Agregar Prepagos");
		btnAgregarPrepagos.setBorder(UIManager.getBorder("RadioButton.border"));
		btnAgregarPrepagos.setBounds(412, 142, 219, 28);
		panel_5.add(btnAgregarPrepagos);
		
		JLabel lblPrimerPago = new JLabel("Primer Pago");
		lblPrimerPago.setForeground(Color.WHITE);
		lblPrimerPago.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblPrimerPago.setBounds(31, 228, 102, 28);
		panel_5.add(lblPrimerPago);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBackground(new Color(204, 204, 255));
		dateChooser_1.setBounds(131, 228, 194, 28);
		panel_5.add(dateChooser_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(new Color(0, 0, 51));
		panel_6.setBounds(660, 49, 286, 121);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Rate (Per Periode)");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(23, 1, 114, 22);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNumberOfPayments = new JLabel("Number of Payments");
		lblNumberOfPayments.setForeground(new Color(255, 255, 255));
		lblNumberOfPayments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumberOfPayments.setBounds(10, 24, 127, 22);
		panel_6.add(lblNumberOfPayments);
		
		JLabel lblTotalPayments = new JLabel("Total Payments");
		lblTotalPayments.setForeground(new Color(255, 255, 255));
		lblTotalPayments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalPayments.setBounds(40, 47, 97, 22);
		panel_6.add(lblTotalPayments);
		
		JLabel lblTotalInterest = new JLabel("Total Interest");
		lblTotalInterest.setForeground(new Color(255, 255, 255));
		lblTotalInterest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTotalInterest.setBounds(53, 70, 84, 22);
		panel_6.add(lblTotalInterest);
		
		JLabel lblEstInterestSavings = new JLabel("Est. Interest Savings");
		lblEstInterestSavings.setForeground(new Color(255, 255, 255));
		lblEstInterestSavings.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstInterestSavings.setBounds(10, 93, 127, 22);
		panel_6.add(lblEstInterestSavings);
		
		label_5 = new JLabel("0.155%");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(192, 1, 84, 22);
		panel_6.add(label_5);
		
		label_6 = new JLabel("150");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(192, 24, 84, 22);
		panel_6.add(label_6);
		
		label_7 = new JLabel("157,785.59");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(192, 47, 84, 22);
		panel_6.add(label_7);
		
		label_8 = new JLabel("57,785.59");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_8.setBounds(192, 70, 84, 22);
		panel_6.add(label_8);
		
		label_9 = new JLabel("4,606.5");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_9.setBounds(192, 95, 84, 22);
		panel_6.add(label_9);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(153, 153, 204));
		textField_4.setBounds(412, 230, 219, 30);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		handleEvents();
		setVisible(true);
	}

	
	
	
	private void handleEvents() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				internalFrame_Cuenta.setBounds(0, 21, 353, 458);
				internalFrame_Informacion.setBounds(89, 33, 274, 427);
				internalFrame_Reportes.setBounds(205, 33, 247, 450);
				internalFrame_Navegar.setBounds(290, 33, 380, 567);
				internalFrame_Ayuda.setBounds(162, 32, 266, 314);
				internalFrame_side.setBounds(0, 91, 390, 606);
				registerUserFrame.setBounds(390, 91, 976, 606);
				internalFrame_Cuenta.setVisible(false);
				internalFrame_Informacion.setVisible(false);
				solicitudPendienteFrame.setVisible(false);
				internalFrame_Reportes.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_side.setVisible(false);
				registerUserFrame.setVisible(false);
				findUserFrame.setVisible(false);
				frameDesplegable.setVisible(false);
				panel_5.setVisible(false);
				setTime();
				lista = controller.getNames();
			}
		});

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				internalFrame_Cuenta.setVisible(false);
				internalFrame_Informacion.setVisible(false);
				internalFrame_Reportes.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_side.setVisible(false);
				
			}
		});

		mnSolicitudes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				internalFrame_Informacion.setVisible(false);
				internalFrame_Reportes.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_side.setVisible(false);
				internalFrame_Cuenta.setVisible(true);
			}
		});

		
		lblCalculadoraDePrestamos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panel_5.setVisible(true);
			}
		});
		
		
		
		
		mnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				internalFrame_Cuenta.setVisible(false);
				internalFrame_Reportes.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_Informacion.setVisible(true);
			}
		});

		mnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				internalFrame_Cuenta.setVisible(false);
				internalFrame_Informacion.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_Reportes.setVisible(true);

			}
		});

		mnNavegar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				internalFrame_Reportes.setVisible(false);
				internalFrame_Cuenta.setVisible(false);
				internalFrame_Informacion.setVisible(false);
				internalFrame_Ayuda.setVisible(false);
				internalFrame_Navegar.setVisible(true);
			}
		});

		mnAyuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {

				internalFrame_Reportes.setVisible(false);
				internalFrame_Cuenta.setVisible(false);
				internalFrame_Informacion.setVisible(false);
				internalFrame_Navegar.setVisible(false);
				internalFrame_Ayuda.setVisible(true);
			}
		});

		txtSearchForPeople.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				txtSearchForPeople.setText("buscar personas");
				//frameDesplegable.setVisible(false);
			}

			public void focusGained(FocusEvent e) {
				txtSearchForPeople.setText("");
				// findUserFrame.setVisible(true);
				frameDesplegable.setVisible(true);
			}

		});

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				internalFrame_side.setVisible(true);
			}
		});

		lblRegistrarUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registerUserFrame.setVisible(true);
				solicitudPendienteFrame.setVisible(false);
			}
		});

		btnSubmitUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (verifyInput()) {
					getData();
					error_lbl.setText("USUARIO REGISTRADO CORRECTAMENTE !!!");
					error_lbl.setForeground(Color.GREEN);
					clear("registerUserFrame");
				}
			}
		});

		lblListaDeSolicitudes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				solicitudPendienteFrame.setBounds(388, 101, 968, 596);
				solicitudPendienteFrame.setVisible(true);
				registerUserFrame.setVisible(false);
			}
		});

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Seguro de querer cancelar suscripcion?", "Confirmar",
						JOptionPane.YES_NO_OPTION);
				if (resp == 0) {
					clear("registerUserFrame");
					registerUserFrame.setVisible(false);
				}
			}
		});

		txtSearchForPeople.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void changedUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				update();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				update();
			}

			public void update() {

				lblFound.setText("searching..." + txtSearchForPeople.getText());
				
				for(String name: lista) {
					if(name.startsWith(txtSearchForPeople.getText())) {
						lblFound2.setText(name);
					}
					if(name.contains(txtSearchForPeople.getText())) {
						lblFound3.setText(name);
					}
					if(name.endsWith(txtSearchForPeople.getText())) {
						lblFound4.setText(name);
					}
					
				}
			}
		});

		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				frameDesplegable.setVisible(true);
			}
		});
		
		
		
		frameDesplegable.addMouseListener(new MouseAdapter() {
			
			public void mouseExited(MouseEvent e) {
				frameDesplegable.setVisible(false);
				panel_3.grabFocus();
				panel.grabFocus();
			}
			
			
			public void mouseEntered(MouseEvent em) {
				txtSearchForPeople.setText("");
			}
		});
		
		
		
		rdbtnOtroMonto.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnOtroMonto.isSelected())
					txt_montoAproved.setEditable(true);
				else
					txt_montoAproved.setEditable(false);
			}
		});

		btnAprobado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				double montoAprobado = 0.0;
				float interes = 0.0f;
				boolean valido = true;

				if (rdbtnOtroMonto.isSelected() && txt_montoAproved.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "Campo Monto Aprobado Esta Vacio", "Wrong input",
							JOptionPane.OK_OPTION);
					valido = false;
				} else if (rdbtnOtroMonto.isSelected() && !txt_montoAproved.getText().isEmpty()) {
					try {
						montoAprobado = Double.parseDouble(txt_montoAproved.getText());
					} catch (Exception ex) {
						valido = false;
						JOptionPane.showConfirmDialog(null, "Monto Invalido", "Wrong input", JOptionPane.OK_OPTION);
					}
				} else {
					try {
						montoAprobado = Double
								.parseDouble(montotxt.getText().substring(0, montotxt.getText().length() - 4));
					} catch (StringIndexOutOfBoundsException sex) {
						valido = false;
						JOptionPane.showConfirmDialog(null, "Monto Invalido", "Wrong input", JOptionPane.OK_OPTION);
					}

				}

				if (!otroInterestxt.getText().isEmpty()) {
					try {
						interes = Float.parseFloat(otroInterestxt.getText());
					} catch (NumberFormatException n) {
						valido = false;
						JOptionPane.showConfirmDialog(null, "Interes Invalido", "Wrong input", JOptionPane.OK_OPTION);
					}
				} else {
					String inter = (String) comboInteres.getSelectedItem();
					if (!inter.isEmpty())
						interes = Float.parseFloat(inter.substring(0, inter.length() - 1));
					else {
						valido = false;
						JOptionPane.showConfirmDialog(null, "Seleccion Una tasa de interes", "Wrong input",
								JOptionPane.OK_OPTION);
					}

				}

				Interes interestRate = new Interes();
				interestRate.setValor(interes);

				if (bg.isSelected(rdbtnMensual.getModel())) {
					interestRate.setPeriodo("Mensual");
				} else {
					interestRate.setPeriodo("Anual");
				}

				if (tipoInteresGroup.isSelected(rdbtnFijo.getModel())) {
					interestRate.setTipo_interes("Fijo");
				} else {
					interestRate.setTipo_interes("Variable");
				}

				Solicitud sol = controller.getModelo().getSolicitud();
				sol.setNum_solicitud(Integer.parseInt(txtNumeroSolicitud.getText()));
				sol.setEstatus("Aprobado");

				if (valido) {
					controller.procesarSolicitud(sol, montoAprobado, interestRate);
					eliminarFila(selectedRow);
					clear("panel_3");
				}

			}
		});
		
		
		
		chckbxAddComment.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if(chckbxAddComment.isSelected()) {
					textPaneReason.setEditable(true);
					textPaneReason.setBackground(Color.WHITE);
				    lblDeclineReason.setText("Reason for decline");
					
				}else {
					textPaneReason.setEditable(false);
					textPaneReason.setBackground(Color.LIGHT_GRAY);
					lblDeclineReason.setText("");
				}
			}
		});
		
		
		
		
	 
	 btnDeclinado.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String reason = textPaneReason.getText();
			if(reason.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Specify Reason For Declining The Request", "Provide reason",JOptionPane.OK_OPTION);
			}else {
				Solicitud sol = controller.getModelo().getSolicitud();
				sol.setNum_solicitud(Integer.parseInt(txtNumeroSolicitud.getText()));
				sol.setEstatus("Declinada");
				sol.setRazonDeclinacion(reason);
				controller.procesarSolicitud(sol,0.0,null);
				eliminarFila(selectedRow);
				clear("panel_3");	
				textPaneReason.setText("");
				textPaneReason.setEditable(false);
				chckbxAddComment.setSelected(false);
				lblDeclineReason.setText("");
			}
		  }
	 });
 }
	
	
	
	

	private void processTable(JTable table) {

		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		ArrayList<Modelo> lista = controller.getListaSolicitudes();
		int cantidad = lista.size();
		Object[] column = new Object[cantidad * 10];

		for (Modelo m : lista) {

			column[0] = m.getSolicitud().getNum_solicitud();
			column[1] = m.getSolicitud().getFecha_solicitud();
			column[2] = m.getPerson().getNombre_Persona() + " " + m.getPerson().getApellido();
			column[3] = m.getPerson().getCedula();
			column[4] = m.getPerson().getEmpleo().getNombreEmpresa();
			column[5] = m.getPerson().getEmpleo().getInicioEmpleo();
			column[6] = m.getPerson().getEmpleo().getSalario();

			DecimalFormat df = new DecimalFormat("#.00");
			column[7] = new String(df.format(m.getSolicitud().getMonto_solicitado()));
			column[8] = m.getSolicitud().getPlazo_en_meses();
			column[9] = m.getSolicitud().getTipo_prestamo();
			model.addRow(column);
		}

		addTableEvents(lista);
	}

	private void eliminarFila(int row) {
		((DefaultTableModel) table.getModel()).removeRow(row);
	}

	private void addTableEvents(ArrayList<Modelo> lista) {

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			private Persona p = null;
			private Solicitud s = null;

			public Solicitud searchSolicitud(Integer num) {

				for (Modelo m : lista) {

					s = m.getSolicitud();

					if (s.getNum_solicitud() == num) {
						return s;
					}
				}
				return null;
			}

			private Persona searchPersona(String cedula) {

				for (Modelo m : lista) {
					p = m.getPerson();
					if (p.getCedula().equals(cedula)) {
						return p;
					}
				}
				return null;
			}

			@Override
			public void valueChanged(ListSelectionEvent e) {

				int row = table.getSelectedRow();
				try {

					Solicitud sol = searchSolicitud(Integer.parseInt(table.getValueAt(row, 0).toString()));
					Persona p = searchPersona(table.getValueAt(row, 3).toString());

					nametxt.setText(p.getNombre_Persona() + " " + p.getApellido());
					txtNumeroSolicitud.setText(table.getValueAt(row, 0).toString());
					empresatxt.setText(p.getEmpleo().getNombreEmpresa());
					telEmpresatxt.setText(p.getEmpleo().getTelefonoEmpresa());
					fechatxt.setText(sol.getFecha_solicitud().toString());
					tiempotxt.setText(p.getEmpleo().getInicioEmpleo().toString());
					DecimalFormat df = new DecimalFormat("#.00");

					salariotxt.setText(df.format(p.getEmpleo().getSalario()) + " RD$");
					montotxt.setText(df.format(sol.getMonto_solicitado()) + " RD$");
					plazotxt.setText(
							sol.getPlazo_en_meses() / 12 + " años, " + sol.getPlazo_en_meses() % 12 + " Meses");
					prestamotxt.setText(sol.getTipo_prestamo());
					panel_3.setBounds(10, 207, 948, 358);

					selectedRow = row;

				} catch (ArrayIndexOutOfBoundsException ex) {

					// do nothing here...
				}
			}
		});
	}

	private void clear(String whatPane) {

		if (whatPane.equals("registerUserFrame")) {
			txt_nombreR.setText("");
			txt_apellidoR.setText("");
			txt_cedulaR.setText("");
			txtNacionalidad.setText("");
			txtApellidoRef.setText("");
			txtCiudadR.setText("");
			txtSectorR.setText("");
			txtCalleR.setText("");
			txtParentescoR.setText("");
			txtPass.setText("");
			txtTelefR.setText("");
			txtTelRef.setText("");
			txtApellidoRef.setText("");
			txtNombreRef.setText("");
			txtUserName.setText("");
			comboSexoR.setSelectedItem("");
			comboCargo.setSelectedItem("");
			comboPriviledge.setSelectedItem("");
			txt_emailR.setText("");
			txtSalarioR.setText("");
			dateChooser.setDate(null);

		} else if (whatPane.equals("panel_3")) {

			nametxt.setText("");
			txtNumeroSolicitud.setText("");
			empresatxt.setText("");
			telEmpresatxt.setText("");
			fechatxt.setText("");
			tiempotxt.setText("");
			salariotxt.setText("");
			montotxt.setText("");
			plazotxt.setText("");
			prestamotxt.setText("");
			comboInteres.setSelectedItem("");
			txt_montoAproved.setText("");
			otroInterestxt.setText("");

		}

	}

	private void setLookAndFeel() {

		try {

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {

				if ("Metal".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errors found");
		}

	}

	private void cancelInternalFrameMotion(JInternalFrame jif) {

		BasicInternalFrameUI obj = ((BasicInternalFrameUI) jif.getUI());
		for (MouseListener listener : obj.getNorthPane().getMouseListeners()) {
			obj.getNorthPane().removeMouseListener(listener);
		}

		obj.setNorthPane(null);
	}

	private void setTime() {

		runningTime = new Time(lblTime);
		Thread t = new Thread(runningTime);
		t.start();
	}

	private void getData() {

		String sexo = (String) comboSexoR.getSelectedItem();

		Empleado emp = new Empleado();

		emp.setNombre_Persona(txt_nombreR.getText());
		emp.setApellido(txt_apellidoR.getText());
		emp.setCategoria("Empleado");
		emp.setCedula(txt_cedulaR.getText());
		emp.setFecha_nac(dateChooser.getDate());
		emp.setNacionalidad(txtNacionalidad.getText());
		emp.setSexo(sexo.charAt(0));
		emp.setContacto(new Contacto(txt_emailR.getText(), txtTelefR.getText()));
		emp.setDireccion(new Direccion(txtCalleR.getText(), txtSectorR.getText(), txtCiudadR.getText()));
		emp.setEmpleo(new Empleo(new Date(), "Local", "Local", Double.parseDouble(txtSalarioR.getText())));
		emp.setUser(new User(txtUserName.getText(), txtPass.getText(), (String) comboPriviledge.getSelectedItem()));
		emp.setPosicion((String) comboCargo.getSelectedItem());

		Referencia ref = new Referencia();
		ref.setName(txtNombreRef.getText());
		ref.setApellido(txtApellidoRef.getText());
		ref.setTelef(txtTelRef.getText());
		ref.setParentesco(txtParentescoR.getText());
		emp.setRef(ref);
		controller.addToRegistro(emp);
	}

	private boolean verifyInput() {

		String sexo = (String) comboSexoR.getSelectedItem();
		String cargo = (String) comboCargo.getSelectedItem();
		String privilegio = (String) comboCargo.getSelectedItem();

		if (sexo.isEmpty() || cargo.isEmpty() || privilegio.isEmpty()) {
			error_lbl.setText("*TODOS LOS CAMPOS SON OBLIGATORIOS*");
			return false;
		}

		if (txtSalarioR.getText().isEmpty()) {
			error_lbl.setText("*TODOS LOS CAMPOS SON OBLIGATORIOS*");
			return false;
		} else {
			try {
				new Double(Double.parseDouble(txtSalarioR.getText()));
			} catch (NumberFormatException e) {
				error_lbl.setText("*FORMATO INCORRECTO PARA CAMPO **SALARIO**");
				return false;
			}
		}

		for (int i = 0; i < txt_emailR.getText().length(); i++) {
			if (!txt_emailR.getText().contains("@")) {
				error_lbl.setText("*Correo Electronico Invalido !!*");
				return false;
			}
		}

		if (txt_nombreR.getText().isEmpty() || txt_apellidoR.getText().isEmpty() || txt_cedulaR.getText().isEmpty()
				|| txtNacionalidad.getText().isEmpty() || txtApellidoRef.getText().isEmpty()
				|| txtCiudadR.getText().isEmpty() || txtSectorR.getText().isEmpty() || txtCalleR.getText().isEmpty()
				|| txtParentescoR.getText().isEmpty() || txtPass.getText().isEmpty() || txtTelefR.getText().isEmpty()
				|| txtTelRef.getText().isEmpty() || txtApellidoRef.getText().isEmpty()
				|| txtNombreRef.getText().isEmpty() || txtUserName.getText().isEmpty()) {

			error_lbl.setText("*Correo Electronico Invalido !!*");
			return false;
		}

		return true;

	}
}
