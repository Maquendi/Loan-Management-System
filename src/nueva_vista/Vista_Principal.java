package nueva_vista;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import com.sistemaprestamo.controller.Controller;
import com.sistemaprestamo.model.Cliente;
import com.sistemaprestamo.model.Contacto;
import com.sistemaprestamo.model.Direccion;
import com.sistemaprestamo.model.Empleo;
import com.sistemaprestamo.model.Persona;
import com.sistemaprestamo.model.Solicitud;
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;



public class Vista_Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private int count;
	private JPanel contentPane;
	private int tipoP;
	private JInternalFrame menuInternalFrame;
	private JInternalFrame mainInternalFrame;
	private JDateChooser dateChooser;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCed;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtCiudadania;
	private JTextField txtCalle;
	private JTextField txtCiudad;
	private JTextField txtEmpresa;
	private JTextField txtSalario;
	private JLabel imageLabel2;
	private JLabel imageLabel;
    private JButton btnEducativoP;
    private JButton btnHipotecarioP;
    private JButton btnCasosPendiente;
    private JButton btnEditCuenta;
    private JButton btnRecibirPago;
    private JButton btnEditSolicitud;
    private JButton bntVerStadoSolicitud;
    private JButton btnSaldarUnPrestamo;
    private JButton btnVerTasasInteres;
    private JButton btnSalidCuenta;
    private JPanel mainDataPanel;
    private JPanel panelSolicitudes;
    private JRadioButton rdbtnMujer;
    private JRadioButton rdbtnHombre;
    private JButton btnEnviar;
    private JButton btnCancelar;
    private JMenu mnMenu;
    private JButton btnPersonaP;
    private JTextField txtMonto;
    private JComboBox<String> comboPlazo;
    private JLabel labelError;
    private JLabel currentUser;
    private JLabel lblNewLabel;
    private JTextField txtClientSearch;
    private JLabel lblNombre_1;
    private JTextField txtnombrecliente;
    private JLabel lblNoCliente;
    private JTextField txtBuscarcliente;
    private JLabel lblFechaUltimoPago;
    private JLabel lblFechaInicioPrestamo;
    private JTextField txtInicioPrestamo;
    private JTextField txtMontoPrestamo;
    private JLabel lblEstatusCliente;
    private JTextField txtbalance;
    private JLabel lblTelefono_1;
    private JLabel lblEmail_1;
    private JTextField txtultimoPago;
    private JLabel label;
    private JTextField txtPendiente;
    private JPanel panelDePagos;
    private JPanel panel;
    private JTextField txtmonto;
    private JTextField txtAmortizado;
    private JButton btnSearchClients;
    private JPanel panelSearchClient;
    private JTextField txtSector;
    private JLabel lableMensaje;
    private JLabel lblDatosDelSolicitante;
    private JPanel panel_1;
    private JPanel panelMensaje;
    private Controller controller;
    private JDateChooser datetiempoLab;
    private JTextField txtEmpresaTel;
    private JTextField txtIDCLiente;
    JButton btnBucar,btnSometerPago;
   
    
  
	
	public Vista_Principal(Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_dollar-exchange_532645 (3).png"));
		setTitle("Loan Management System (LMS)");
		
		init();
		this.controller = controller;
		handleEvents();
		authenticatedUser();  ///// update this...................
		
		
		
	}
	
	
	
	
	private void authenticatedUser() {
		currentUser.setText(controller.getModelo().getEmpleado().getNombre_Persona()+ " "+controller.getModelo().getEmpleado().getApellido());
	}
	
	
	private void handleEvents(){
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				if(count == 0) {
					mainInternalFrame.getContentPane().add(imageLabel);
				}
				count++;
				currentUser.setText("WelCome: " + currentUser.getText());
			}
		});
		
		
		
		mnMenu.addMouseListener(new EventosMouse());
		imageLabel2.addMouseListener(new EventosMouse());
		
		btnRecibirPago.addActionListener(new EventosBotonClick());
		btnPersonaP.addActionListener(new EventosBotonClick());
		btnEducativoP.addActionListener(new EventosBotonClick());
		btnHipotecarioP.addActionListener(new EventosBotonClick());
		btnEnviar.addActionListener(new EventosBotonClick());
		btnCancelar.addActionListener(new EventosBotonClick());
		btnSalidCuenta.addActionListener(new EventosBotonClick());
		btnEditCuenta.addActionListener(new EventosBotonClick());
		btnSaldarUnPrestamo.addActionListener(new EventosBotonClick());
		btnEditSolicitud.addActionListener(new EventosBotonClick());
		bntVerStadoSolicitud.addActionListener(new EventosBotonClick());
		
		
		btnBucar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("click BTNBUSCAR");
				String cedula = txtBuscarcliente.getText();
				
				if(!cedula.isEmpty()){
					
					try{
						Cliente client = controller.getCliente(cedula);
						
					    takePayments(client);
						
					}catch(NullPointerException e) {
						 JOptionPane.showMessageDialog(null,"Ningun Registro Con Categoria Cliente Exite Con esta Cedula");
					}
					
					
					
				    	  
					
				}else {
					JOptionPane.showMessageDialog(null,"Error, Campo De Busqueda Vacia !!");
				}
				
				
				
				
			}
		});
		
		
		
		btnSometerPago.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
						
			
			
			}
		
		});
		
	}
	
	

	
	
	
	private void takePayments(Cliente client) {
		
		
		txtIDCLiente.setText(client.getID() + "");
		this.txtnombrecliente.setText(client.getNombre_Persona() + " " + client.getApellido());
		txtMontoPrestamo.setText(client.getPrestamo().getMonto_prestamo() + " $DOP");
		this.txtInicioPrestamo.setText(client.getPrestamo().getFecha_inicio_prestamo().toString());
		
		
		/*
		txtbalance
		txtUltimoPago
		txtMonto
	
		txtAmortizado,
		txtPendiente*/
		
		
	}
	
	
	private boolean validateEntry() {
	    
	    boolean valid = true;
	    
		if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtCed.getText().isEmpty() || txtEmail.getText().isEmpty()
	       || txtTel.getText().isEmpty() || dateChooser.getDate() == null || txtCiudadania.getText().isEmpty() || txtCalle.getText().isEmpty()
	       || txtCiudad.getText().isEmpty() || comboPlazo.getSelectedItem() == null || txtEmpresa.getText().isEmpty()|| txtSalario.getText().isEmpty()
	       || txtMonto.getText().isEmpty()){valid = false;}
		
		  int counter = 0;
		  String monto = txtMonto.getText();
		  String salario = txtSalario.getText();
		  boolean salarioValid = true;
		  boolean montoValid = true;
		  
		  for(int i=0;i<monto.length();i++) {
			  if(monto.charAt(i) == '.') {
				  counter++;
				  if(counter == 2) {
					//  valid = false;
					  montoValid=false;
					  break;
				  }
			  }
			  if(!Character.isDigit(monto.charAt(i)) && monto.charAt(i) != '.') {
				  valid = false;
			  }
		  }
		  
		  counter = 0;
		  for(int i=0;i<salario.length();i++) {
			  if(salario.charAt(i) == '.') {
				  counter++;
				  if(counter == 2) {
					//  valid = false;
					  salarioValid = false;
					  break;
				  }  
			  }
			  if(!Character.isDigit(salario.charAt(i)) && salario.charAt(i) != '.') {
				  valid = false;
			  }
		  }
		 
		if(valid == false) { 
			labelError.setText("*Todos Los Campos Son Requeridos*");
		    labelError.setText("");
		 }else {
			 
			 if(montoValid == false) {
				 JOptionPane.showMessageDialog(null, "Formato Incorrecto, CAMPO MONTO SOLICITADO");
			 }else if(salarioValid == false) {
				 
				 JOptionPane.showMessageDialog(null, "Formato Incorrecto, CAMPA SALARIO");
			 }
			 
		 }
		
		
		
		
		
		
		  return valid;
	  }
	
	
	
	
	
	
	 private void sendData() {
		  
		  String name = txtNombre.getText();
		  String apellido = txtApellido.getText();
		  String calle = txtCalle.getText();
		  String ciudad = txtCiudad.getText();
		  String plazo = (String)comboPlazo.getSelectedItem();
		  
		  plazo = plazo.substring(0, 2);
		  int plazz = Integer.parseInt(plazo);
		  
		  String nacion = txtCiudadania.getText();
		  String ced = txtCed.getText();
		  String email = txtEmail.getText();
		  String tel = txtTel.getText();
		  Calendar cal = dateChooser.getCalendar();
		  String empleador = txtEmpresa.getText();
		  
		  String sector = txtSector.getText();
		  char sexo;
		  if(rdbtnMujer.isSelected()) {
			  sexo = 'M';
		  }else {
			  sexo = 'H';
		  }
		 
		  if(validateEntry()){
			  
			  double salario = Double.parseDouble(txtSalario.getText());
			  double montoSolic = Double.parseDouble(txtMonto.getText());
			  String cat = "Solicitante";
			 
			  
			  Persona p = new Persona();
			  p.setNombre_Persona(name);
			  p.setApellido(apellido);
			  p.setNacionalidad(nacion);
			  p.setCedula(ced);
			  p.setContacto(new Contacto(email,tel));
			  p.setCategoria(cat);
			  p.setFecha_nac(cal.getTime());
			  p.setDireccion(new Direccion(calle,sector,ciudad));
			  p.setSexo(sexo);			  
			  p.setEmpleo(new Empleo(datetiempoLab.getDate(),empleador,txtEmpresaTel.getText(),salario));
			  Solicitud sol = new Solicitud();
			  sol.setPlazo_en_meses(plazz);
			  sol.setMonto_solicitado(montoSolic);
			  sol.setTipoPrestamos(tipoP);
			  sol.setEstatus("Pendiente");
			  
			  if(controller.addSolicitud(p,sol)){
				  resetFields();  
			  }else {
				  JOptionPane.showMessageDialog(null, "Ocurrio Un Error!, Verificar los Datos Ingresado...");
			  }        
		  }
	  }
	  
	
	
	 
	
	
	 private void resetFields(){
		  
		  txtNombre.setText("");
		  txtApellido.setText("");
		  txtCed.setText("");
		  txtCiudadania.setText("");
		  txtEmail.setText("");
		  txtSalario.setText("");
		  txtCalle.setText("");
		  dateChooser.setDate(null);
		  txtTel.setText("");
		  txtEmpresa.setText("");
		  txtEmpresaTel.setText("");
		  datetiempoLab.setDate(null);
		  txtMonto.setText("");
		  comboPlazo.setSelectedItem(null);
		  txtCiudad.setText("");
		  txtSector.setText("");
		 
	  }
	  
	 
	 
	
	private void init() {
		
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Metal".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1260, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.RED);
		panel.setBounds(5, 0, 1355, 694);
		contentPane.add(panel);
		panel.setLayout(null);
		
		mainInternalFrame = new JInternalFrame("");
		mainInternalFrame.getContentPane().setBackground(SystemColor.control);
		mainInternalFrame.setBackground(Color.LIGHT_GRAY);
		mainInternalFrame.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		mainInternalFrame.setFrameIcon(null);
		mainInternalFrame.setBounds(0, 35, 1360, 660);
		panel.add(mainInternalFrame);   //*************************************************************///9*99***********************
		mainInternalFrame.getContentPane().setLayout(null);
		cancelInternalFrameMotion(mainInternalFrame);
	//	removeTitleBar(mainInternalFrame);
		
		/*
		mainInternalFrame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		mainInternalFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		*/
		
		
		

		
		menuInternalFrame = new JInternalFrame("");
		menuInternalFrame.getContentPane().setForeground(new Color(255, 255, 255));
		menuInternalFrame.setForeground(SystemColor.windowBorder);
		menuInternalFrame.setBackground(Color.ORANGE);
		menuInternalFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
		menuInternalFrame.setBorder(UIManager.getBorder("PopupMenu.border"));
		menuInternalFrame.setFrameIcon(null);
		//menuInternalFrame.setBounds(8, 0, 365, 630); // Uncomment to see edit frame.*********************************************\\\
		cancelInternalFrameMotion(menuInternalFrame);   // this makes the jinternal frame not moveable, and removes the northPane.
		//removeTitleBar(menuInternalFrame); this removes the northpane of the jinternalframe
		
		/*
		menuInternalFrame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		menuInternalFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		*/
		mainInternalFrame.getContentPane().add(menuInternalFrame);
		menuInternalFrame.getContentPane().setLayout(null);
		
		
		JLabel lblGestionarUnPrestamo = new JLabel("     My Dashboard");
		lblGestionarUnPrestamo.setForeground(new Color(102, 153, 153));
		lblGestionarUnPrestamo.setFont(new Font("Serif", Font.ITALIC, 25));
		lblGestionarUnPrestamo.setBounds(0, 37, 349, 33);
		menuInternalFrame.getContentPane().add(lblGestionarUnPrestamo);
		
		btnPersonaP = new JButton("Prestamos Personales           Ctrl+Shift+P");
		btnPersonaP.setHorizontalAlignment(SwingConstants.LEFT);
		btnPersonaP.setOpaque(false);
		btnPersonaP.setBackground(new Color(102, 153, 153));
		btnPersonaP.setBorder(null);
		btnPersonaP.setForeground(new Color(51, 0, 51));
		btnPersonaP.setFont(new Font("Serif", Font.PLAIN, 17));
		btnPersonaP.setBounds(0, 87, 359, 23);
		menuInternalFrame.getContentPane().add(btnPersonaP);
		
		btnEducativoP = new JButton("Prestamos Educativos           Ctrl+Shift+E");
		btnEducativoP.setHorizontalAlignment(SwingConstants.LEFT);
		btnEducativoP.setOpaque(false);
		btnEducativoP.setBackground(new Color(102, 153, 153));
		btnEducativoP.setBorder(null);
		btnEducativoP.setForeground(new Color(51, 0, 51));
		btnEducativoP.setFont(new Font("Serif", Font.PLAIN, 17));
		btnEducativoP.setBounds(0, 132, 359, 23);
		menuInternalFrame.getContentPane().add(btnEducativoP);
		
		btnHipotecarioP = new JButton("Prestamos Hipotecarios      Ctrl+Shift+H");
		btnHipotecarioP.setHorizontalAlignment(SwingConstants.LEFT);
		btnHipotecarioP.setOpaque(false);
		btnHipotecarioP.setBackground(new Color(102, 153, 153));
		btnHipotecarioP.setBorder(null);
		btnHipotecarioP.setForeground(new Color(51, 0, 51));
		btnHipotecarioP.setFont(new Font("Serif", Font.PLAIN, 17));
		btnHipotecarioP.setBounds(0, 177, 359, 23);
		menuInternalFrame.getContentPane().add(btnHipotecarioP);
		
		btnCasosPendiente = new JButton("Mis Casos Pendientes");
		btnCasosPendiente.setHorizontalAlignment(SwingConstants.LEFT);
		btnCasosPendiente.setOpaque(false);
		btnCasosPendiente.setBackground(new Color(102, 153, 153));
		btnCasosPendiente.setBorder(null);
		btnCasosPendiente.setForeground(new Color(51, 0, 51));
		btnCasosPendiente.setFont(new Font("Serif", Font.PLAIN, 17));
		btnCasosPendiente.setBounds(0, 222, 359, 23);
		menuInternalFrame.getContentPane().add(btnCasosPendiente);
		
		btnEditCuenta = new JButton("Editar Cuenta Cliente");
		
		
		
		
		
		
		btnEditCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditCuenta.setOpaque(false);
		btnEditCuenta.setBackground(new Color(102, 153, 153));
		btnEditCuenta.setFocusPainted(false);
		btnEditCuenta.setBorder(null);
		btnEditCuenta.setForeground(new Color(51, 0, 51));
		btnEditCuenta.setFont(new Font("Serif", Font.PLAIN, 17));
		btnEditCuenta.setBounds(1, 267, 358, 23);
		menuInternalFrame.getContentPane().add(btnEditCuenta);
		
		btnRecibirPago = new JButton("Recibir un Pago");
		
		
	
		
		
		
		btnRecibirPago.setHorizontalAlignment(SwingConstants.LEFT);
		btnRecibirPago.setOpaque(false);
		btnRecibirPago.setBackground(new Color(102, 153, 153));
		btnRecibirPago.setBorder(null);
		btnRecibirPago.setForeground(new Color(51, 0, 51));
		btnRecibirPago.setFont(new Font("Serif", Font.PLAIN, 17));
		btnRecibirPago.setBounds(0, 312, 359, 23);
		menuInternalFrame.getContentPane().add(btnRecibirPago);
		
		btnEditSolicitud = new JButton("Editar Solicitud");
		btnEditSolicitud.setHorizontalAlignment(SwingConstants.LEFT);
		btnEditSolicitud.setOpaque(false);
		btnEditSolicitud.setBackground(new Color(102, 153, 153));
		btnEditSolicitud.setBorder(null);
		btnEditSolicitud.setForeground(new Color(51, 0, 51));
		btnEditSolicitud.setFont(new Font("Serif", Font.PLAIN, 17));
		btnEditSolicitud.setBounds(1, 357, 358, 23);
		menuInternalFrame.getContentPane().add(btnEditSolicitud);
		
		bntVerStadoSolicitud = new JButton("Ver Estado de Solicitud");
		bntVerStadoSolicitud.setHorizontalAlignment(SwingConstants.LEFT);
		bntVerStadoSolicitud.setOpaque(false);
		bntVerStadoSolicitud.setBackground(new Color(102, 153, 153));
		bntVerStadoSolicitud.setBorder(null);
		bntVerStadoSolicitud.setForeground(new Color(51, 0, 51));
		bntVerStadoSolicitud.setFont(new Font("Serif", Font.PLAIN, 17));
		bntVerStadoSolicitud.setBounds(0, 402, 359, 23);
		menuInternalFrame.getContentPane().add(bntVerStadoSolicitud);
		
		btnSaldarUnPrestamo = new JButton("Saldar Un Prestamo");
		btnSaldarUnPrestamo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaldarUnPrestamo.setOpaque(false);
		btnSaldarUnPrestamo.setBackground(new Color(102, 153, 153));
		btnSaldarUnPrestamo.setBorder(null);
		btnSaldarUnPrestamo.setForeground(new Color(51, 0, 51));
		btnSaldarUnPrestamo.setFont(new Font("Serif", Font.PLAIN, 17));
		btnSaldarUnPrestamo.setBounds(0, 447, 359, 23);
		menuInternalFrame.getContentPane().add(btnSaldarUnPrestamo);
		
		btnVerTasasInteres = new JButton("Nuestras Tasas de Interes");
		btnVerTasasInteres.setHorizontalAlignment(SwingConstants.LEFT);
		btnVerTasasInteres.setOpaque(false);
		btnVerTasasInteres.setBackground(new Color(102, 153, 153));
		btnVerTasasInteres.setBorder(null);
		btnVerTasasInteres.setForeground(new Color(51, 0, 51));
		btnVerTasasInteres.setFont(new Font("Serif", Font.PLAIN, 17));
		btnVerTasasInteres.setBounds(0, 492, 359, 23);
		menuInternalFrame.getContentPane().add(btnVerTasasInteres);
		
		btnSalidCuenta = new JButton("Salir de mi Cuenta");
		
		
		
		
		
		
		
		btnSalidCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalidCuenta.setOpaque(false);
		btnSalidCuenta.setBackground(new Color(102, 153, 153));
		btnSalidCuenta.setBorder(null);
		btnSalidCuenta.setForeground(new Color(51, 0, 51));
		btnSalidCuenta.setFont(new Font("Serif", Font.PLAIN, 17));
		btnSalidCuenta.setBounds(0, 537, 359, 23);
		menuInternalFrame.getContentPane().add(btnSalidCuenta);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(0, 76, 359, 2);
		menuInternalFrame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(0, 211, 359, 2);
		menuInternalFrame.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.GRAY);
		separator_3.setBounds(0, 344, 359, 2);
		menuInternalFrame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.GRAY);
		separator_4.setBounds(0, 524, 359, 2);
		menuInternalFrame.getContentPane().add(separator_4);
		
		mainDataPanel = new JPanel();
		mainDataPanel.setBackground(Color.CYAN);
		mainDataPanel.setBorder(new LineBorder(Color.GRAY));
		
		mainDataPanel.setBounds(2, 0, 1350, 650); //UNCOMMENT THIS TO EDIT THE PANEL.********************************
		mainInternalFrame.getContentPane().add(mainDataPanel);
		mainDataPanel.setLayout(null);
		mainDataPanel.setVisible(false);
		
		
		panelDePagos = new JPanel();
		panelDePagos.setForeground(new Color(160, 82, 45));
		panelDePagos.setBounds(221, 149, 754, 426); // uncomment this to edit the panel **********************************************
		panelDePagos.setBackground(Color.DARK_GRAY);           
		panelDePagos.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 153, 153), new Color(102, 153, 153)));
		mainDataPanel.add(panelDePagos);
		
		
		
		panelSolicitudes = new JPanel();
		panelSolicitudes.setBackground(Color.DARK_GRAY);
		panelSolicitudes.setBorder(new LineBorder(new Color(0, 0, 51), 1, true));
	//	panelSolicitudes.setBounds(515, 159, 812, 466);
		mainDataPanel.add(panelSolicitudes);  // uncomment this to edit the panel *********************************************
		
		
		panelSolicitudes.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 102));
		lblNombre.setFont(new Font("Serif", Font.BOLD, 14));
		lblNombre.setBounds(10, 96, 71, 22);
		panelSolicitudes.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(new Color(255, 255, 255));
		txtNombre.setBounds(91, 99, 191, 20);
		panelSolicitudes.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(new Color(0, 0, 102));
		lblApellido.setFont(new Font("Serif", Font.BOLD, 14));
		lblApellido.setBounds(10, 129, 71, 22);
		panelSolicitudes.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(91, 132, 191, 20);
		panelSolicitudes.add(txtApellido);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setForeground(new Color(0, 0, 102));
		lblCedula.setFont(new Font("Serif", Font.BOLD, 14));
		lblCedula.setBounds(10, 162, 71, 22);
		panelSolicitudes.add(lblCedula);
		
		txtCed = new JTextField();
		txtCed.setColumns(10);
		txtCed.setBounds(91, 165, 191, 20);
		panelSolicitudes.add(txtCed);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(0, 0, 102));
		lblEmail.setFont(new Font("Serif", Font.BOLD, 14));
		lblEmail.setBounds(10, 195, 71, 22);
		panelSolicitudes.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(91, 198, 191, 20);
		panelSolicitudes.add(txtEmail);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(new Color(0, 0, 102));
		lblTelefono.setFont(new Font("Serif", Font.BOLD, 14));
		lblTelefono.setBounds(10, 228, 71, 22);
		panelSolicitudes.add(lblTelefono);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(91, 231, 191, 20);
		panelSolicitudes.add(txtTel);
		
		JLabel lblNacimiento = new JLabel("Nacimiento");
		lblNacimiento.setForeground(new Color(0, 0, 102));
		lblNacimiento.setFont(new Font("Serif", Font.BOLD, 14));
		lblNacimiento.setBounds(10, 261, 71, 22);
		panelSolicitudes.add(lblNacimiento);
		
		JLabel lblCiudadano = new JLabel("Ciudadano");
		lblCiudadano.setForeground(new Color(0, 0, 102));
		lblCiudadano.setFont(new Font("Serif", Font.BOLD, 14));
		lblCiudadano.setBounds(10, 294, 71, 22);
		panelSolicitudes.add(lblCiudadano);
		
		txtCiudadania = new JTextField();
		txtCiudadania.setColumns(10);
		txtCiudadania.setBounds(91, 297, 191, 20);
		panelSolicitudes.add(txtCiudadania);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setForeground(new Color(0, 0, 102));
		lblCalle.setFont(new Font("Serif", Font.BOLD, 14));
		lblCalle.setBounds(10, 327, 71, 22);
		panelSolicitudes.add(lblCalle);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(91, 330, 191, 20);
		panelSolicitudes.add(txtCalle);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setForeground(new Color(0, 0, 102));
		lblCiudad.setFont(new Font("Serif", Font.BOLD, 14));
		lblCiudad.setBounds(10, 400, 71, 22);
		panelSolicitudes.add(lblCiudad);
		
		txtCiudad = new JTextField();
		txtCiudad.setColumns(10);
		txtCiudad.setBounds(91, 403, 191, 20);
		panelSolicitudes.add(txtCiudad);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(0, 0, 102));
		lblSexo.setFont(new Font("Serif", Font.BOLD, 14));
		lblSexo.setBounds(10, 434, 59, 22);
		panelSolicitudes.add(lblSexo);
		
		JLabel lblPlazo = new JLabel("Empresa donde Trabaja");
		lblPlazo.setForeground(new Color(0, 0, 102));
		lblPlazo.setFont(new Font("Serif", Font.BOLD, 14));
		lblPlazo.setBounds(377, 96, 165, 22);
		panelSolicitudes.add(lblPlazo);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(552, 98, 140, 20);
		panelSolicitudes.add(txtEmpresa);
		
		JLabel lblMSolicita = new JLabel("Desde Cuando Trabaja");
		lblMSolicita.setForeground(new Color(0, 0, 102));
		lblMSolicita.setFont(new Font("Serif", Font.BOLD, 14));
		lblMSolicita.setBounds(377, 165, 165, 22);
		panelSolicitudes.add(lblMSolicita);
		
		JLabel lblTiempo = new JLabel("Salario Devengado");
		lblTiempo.setForeground(new Color(0, 0, 102));
		lblTiempo.setFont(new Font("Serif", Font.BOLD, 14));
		lblTiempo.setBounds(377, 199, 165, 22);
		panelSolicitudes.add(lblTiempo);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(552, 201, 140, 20);
		panelSolicitudes.add(txtSalario);
		
		JLabel lblMontoQueSolicita = new JLabel("Monto Que Solicita");
		lblMontoQueSolicita.setForeground(new Color(0, 0, 102));
		lblMontoQueSolicita.setFont(new Font("Serif", Font.BOLD, 14));
		lblMontoQueSolicita.setBounds(377, 232, 165, 22);
		panelSolicitudes.add(lblMontoQueSolicita);
		
		JLabel labelplazo = new JLabel("Plazo a Pagar Prestamo");
		labelplazo.setForeground(new Color(0, 0, 102));
		labelplazo.setFont(new Font("Serif", Font.BOLD, 14));
		labelplazo.setBounds(377, 265, 165, 22);
		panelSolicitudes.add(labelplazo);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setSelected(true);
		rdbtnMujer.setBounds(89, 436, 79, 23);
		panelSolicitudes.add(rdbtnMujer);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBounds(203, 436, 79, 23);
		panelSolicitudes.add(rdbtnHombre);
		
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(rdbtnMujer);
		bg.add(rdbtnHombre);
		
		
		comboPlazo = new JComboBox<>();
		comboPlazo.setModel(new DefaultComboBoxModel<String>(new String[] {"12 meses", "18 meses", "24 meses", "30 meses", "36 meses", "42 meses", "48 meses", "54 meses", "60 meses", "72 meses"}));
		comboPlazo.setBounds(552, 268, 140, 20);
		panelSolicitudes.add(comboPlazo);
		
		btnEnviar = new JButton("Enviar");
		
		btnEnviar.setForeground(new Color(102, 153, 153));
		btnEnviar.setBorder(UIManager.getBorder("RadioButton.border"));
		btnEnviar.setFont(new Font("Serif", Font.PLAIN, 13));
		btnEnviar.setBounds(598, 436, 89, 23);
		panelSolicitudes.add(btnEnviar);
		
		btnCancelar = new JButton("Cancelar");
		
		
		
		
		
		btnCancelar.setForeground(new Color(204, 0, 0));
		btnCancelar.setFont(new Font("Serif", Font.PLAIN, 13));
		btnCancelar.setBorder(UIManager.getBorder("RadioButton.border"));
		btnCancelar.setBounds(713, 436, 89, 23);
		panelSolicitudes.add(btnCancelar);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(91, 262, 191, 22);
		panelSolicitudes.add(dateChooser);
		
		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		txtMonto.setBounds(552, 235, 140, 20);
		panelSolicitudes.add(txtMonto);
		
		labelError = new JLabel("");
		labelError.setForeground(new Color(204, 0, 0));
		labelError.setFont(new Font("Serif", Font.ITALIC, 17));
		labelError.setBounds(451, 11, 313, 23);
		panelSolicitudes.add(labelError);
		
		txtSector = new JTextField();
		txtSector.setColumns(10);
		txtSector.setBounds(91, 369, 191, 20);
		panelSolicitudes.add(txtSector);
		
		JLabel labelSector = new JLabel("Sector");
		labelSector.setForeground(new Color(0, 0, 102));
		labelSector.setFont(new Font("Serif", Font.BOLD, 14));
		labelSector.setBounds(10, 366, 59, 22);
		panelSolicitudes.add(labelSector);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 51, 51), new Color(51, 51, 51)));
		panel_1.setBounds(10, 11, 272, 64);
		panelSolicitudes.add(panel_1);
		panel_1.setLayout(null);
		
		lblDatosDelSolicitante = new JLabel("Datos Del Solicitante");
		lblDatosDelSolicitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosDelSolicitante.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDatosDelSolicitante.setBackground(new Color(0, 51, 153));
		lblDatosDelSolicitante.setBounds(10, 11, 252, 42);
		panel_1.add(lblDatosDelSolicitante);
		lblDatosDelSolicitante.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 51, 51), new Color(51, 51, 51)));
		lblDatosDelSolicitante.setForeground(new Color(255, 255, 255));
		lblDatosDelSolicitante.setFont(new Font("Serif", Font.ITALIC, 25));
		
		datetiempoLab = new JDateChooser();
		datetiempoLab.setBounds(552, 168, 140, 22);
		panelSolicitudes.add(datetiempoLab);
		
		JLabel lblTelefonoEmpresa = new JLabel("Telefono de la Empresa");
		lblTelefonoEmpresa.setForeground(new Color(0, 0, 102));
		lblTelefonoEmpresa.setFont(new Font("Serif", Font.BOLD, 14));
		lblTelefonoEmpresa.setBounds(377, 129, 165, 22);
		panelSolicitudes.add(lblTelefonoEmpresa);
		
		txtEmpresaTel = new JTextField();
		txtEmpresaTel.setColumns(10);
		txtEmpresaTel.setBounds(552, 132, 140, 20);
		panelSolicitudes.add(txtEmpresaTel);
		
		currentUser = new JLabel("");
		currentUser.setBorder(new LineBorder(new Color(204, 204, 153), 1, true));
		currentUser.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
		currentUser.setForeground(new Color(30, 153, 51));
		currentUser.setBounds(1090, 11, 255, 31);
		mainInternalFrame.getContentPane().add(currentUser);
		
		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setForeground(Color.WHITE);
		lblNombre_1.setBounds(20, 175, 59, 27);
		lblNombre_1.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtnombrecliente = new JTextField();
		txtnombrecliente.setEnabled(false);
		txtnombrecliente.setSelectionColor(SystemColor.scrollbar);
		txtnombrecliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtnombrecliente.setForeground(Color.BLACK);
		txtnombrecliente.setFont(new Font("Serif", Font.PLAIN, 15));
		txtnombrecliente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtnombrecliente.setBackground(new Color(255, 255, 255));
		txtnombrecliente.setBounds(113, 179, 174, 20);
		txtnombrecliente.setColumns(10);
		
		lblNoCliente = new JLabel("ID Cliente");
		lblNoCliente.setForeground(Color.WHITE);
		lblNoCliente.setBounds(20, 126, 71, 27);
		lblNoCliente.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtBuscarcliente = new JTextField();
		txtBuscarcliente.setSelectionColor(SystemColor.scrollbar);
		txtBuscarcliente.setHorizontalAlignment(SwingConstants.CENTER);
		txtBuscarcliente.setForeground(new Color(51, 0, 51));
		txtBuscarcliente.setFont(new Font("Serif", Font.BOLD, 13));
		txtBuscarcliente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtBuscarcliente.setBackground(new Color(255, 255, 255));
		txtBuscarcliente.setBounds(445, 42, 148, 20);
		txtBuscarcliente.setColumns(10);
		
		lblFechaUltimoPago = new JLabel("Monto Prestamo");
		lblFechaUltimoPago.setForeground(Color.WHITE);
		lblFechaUltimoPago.setBounds(331, 176, 105, 24);
		lblFechaUltimoPago.setFont(new Font("Serif", Font.PLAIN, 16));
		
		lblFechaInicioPrestamo = new JLabel("Inicio Prestamo");
		lblFechaInicioPrestamo.setForeground(Color.WHITE);
		lblFechaInicioPrestamo.setBounds(331, 133, 96, 22);
		lblFechaInicioPrestamo.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtInicioPrestamo = new JTextField();
		txtInicioPrestamo.setEnabled(false);
		txtInicioPrestamo.setSelectionColor(SystemColor.scrollbar);
		txtInicioPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		txtInicioPrestamo.setForeground(Color.BLACK);
		txtInicioPrestamo.setFont(new Font("Serif", Font.PLAIN, 15));
		txtInicioPrestamo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtInicioPrestamo.setBackground(new Color(255, 255, 255));
		txtInicioPrestamo.setBounds(445, 135, 174, 20);
		txtInicioPrestamo.setColumns(10);
		
		txtMontoPrestamo = new JTextField();
		txtMontoPrestamo.setEnabled(false);
		txtMontoPrestamo.setSelectionColor(SystemColor.scrollbar);
		txtMontoPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		txtMontoPrestamo.setForeground(Color.BLACK);
		txtMontoPrestamo.setFont(new Font("Serif", Font.PLAIN, 15));
		txtMontoPrestamo.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtMontoPrestamo.setBackground(new Color(255, 255, 255));
		txtMontoPrestamo.setBounds(445, 179, 174, 20);
		txtMontoPrestamo.setColumns(10);
		
		lblEstatusCliente = new JLabel("Amortizado");
		lblEstatusCliente.setForeground(Color.WHITE);
		lblEstatusCliente.setBounds(331, 222, 105, 23);
		lblEstatusCliente.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtbalance = new JTextField();
		txtbalance.setEnabled(false);
		txtbalance.setSelectionColor(SystemColor.scrollbar);
		txtbalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtbalance.setForeground(Color.BLACK);
		txtbalance.setFont(new Font("Serif", Font.PLAIN, 15));
		txtbalance.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtbalance.setBackground(new Color(255, 255, 255));
		txtbalance.setBounds(113, 224, 174, 20);
		txtbalance.setColumns(10);
		
		lblTelefono_1 = new JLabel("Balance ");
		lblTelefono_1.setForeground(Color.WHITE);
		lblTelefono_1.setBounds(20, 221, 59, 22);
		lblTelefono_1.setFont(new Font("Serif", Font.PLAIN, 16));
		
		lblEmail_1 = new JLabel("Ultimo pago");
		lblEmail_1.setForeground(Color.WHITE);
		lblEmail_1.setBounds(20, 265, 79, 20);
		lblEmail_1.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtultimoPago = new JTextField();
		txtultimoPago.setEnabled(false);
		txtultimoPago.setSelectionColor(SystemColor.scrollbar);
		txtultimoPago.setHorizontalAlignment(SwingConstants.CENTER);
		txtultimoPago.setForeground(Color.BLACK);
		txtultimoPago.setFont(new Font("Serif", Font.PLAIN, 15));
		txtultimoPago.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtultimoPago.setBackground(new Color(255, 255, 255));
		txtultimoPago.setBounds(113, 267, 174, 20);
		txtultimoPago.setColumns(10);
		
		label = new JLabel("Estatus Cliente");
		label.setForeground(Color.WHITE);
		label.setBounds(331, 265, 96, 20);
		label.setFont(new Font("Serif", Font.PLAIN, 16));
		
		txtPendiente = new JTextField();
		txtPendiente.setEnabled(false);
		txtPendiente.setSelectionColor(SystemColor.scrollbar);
		txtPendiente.setHorizontalAlignment(SwingConstants.CENTER);
		txtPendiente.setForeground(Color.BLACK);
		txtPendiente.setFont(new Font("Serif", Font.PLAIN, 15));
		txtPendiente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtPendiente.setBackground(new Color(255, 255, 255));
		txtPendiente.setBounds(445, 267, 174, 20);
		txtPendiente.setColumns(10);
		panelDePagos.setLayout(null);
		panelDePagos.add(lblNoCliente);
		panelDePagos.add(txtBuscarcliente);
		panelDePagos.add(lblNombre_1);
		panelDePagos.add(txtnombrecliente);
		panelDePagos.add(lblEmail_1);
		panelDePagos.add(txtultimoPago);
		panelDePagos.add(lblTelefono_1);
		panelDePagos.add(txtbalance);
		panelDePagos.add(lblFechaInicioPrestamo);
		panelDePagos.add(lblFechaUltimoPago);
		panelDePagos.add(lblEstatusCliente);
		panelDePagos.add(label);
		panelDePagos.add(txtPendiente);
		panelDePagos.add(txtMontoPrestamo);
		panelDePagos.add(txtInicioPrestamo);
		
		btnSometerPago = new JButton("Enter");
	
		
		
		
		
		btnSometerPago.setFont(new Font("Serif", Font.PLAIN, 13));
		btnSometerPago.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSometerPago.setForeground(new Color(102, 51, 204));
		btnSometerPago.setBounds(673, 392, 71, 23);
		panelDePagos.add(btnSometerPago);
		
		JLabel lblMonto = new JLabel("Monto");
		lblMonto.setForeground(Color.WHITE);
		lblMonto.setFont(new Font("Serif", Font.PLAIN, 16));
		lblMonto.setBounds(20, 311, 59, 23);
		panelDePagos.add(lblMonto);
		
		txtmonto = new JTextField();
		txtmonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtmonto.setForeground(Color.BLACK);
		txtmonto.setColumns(10);
		txtmonto.setBounds(111, 314, 176, 22);
		panelDePagos.add(txtmonto);
		
		txtAmortizado = new JTextField();
		txtAmortizado.setEnabled(false);
		txtAmortizado.setSelectionColor(SystemColor.scrollbar);
		txtAmortizado.setHorizontalAlignment(SwingConstants.CENTER);
		txtAmortizado.setForeground(Color.BLACK);
		txtAmortizado.setFont(new Font("Serif", Font.PLAIN, 15));
		txtAmortizado.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtAmortizado.setBackground(new Color(255, 255, 255));
		txtAmortizado.setColumns(10);
		txtAmortizado.setBounds(445, 224, 174, 20);
		panelDePagos.add(txtAmortizado);
		
		JLabel lblrd = new JLabel("$RD");
		lblrd.setForeground(Color.WHITE);
		lblrd.setFont(new Font("Serif", Font.PLAIN, 12));
		lblrd.setBounds(294, 313, 26, 21);
		panelDePagos.add(lblrd);
		
		JLabel lblBuscarCliente = new JLabel("Buscar Cliente");
		lblBuscarCliente.setForeground(Color.WHITE);
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblBuscarCliente.setBounds(253, 40, 174, 22);
		panelDePagos.add(lblBuscarCliente);
		
		JRadioButton rdbCedula = new JRadioButton("Cedula");
		rdbCedula.setSelected(true);
		rdbCedula.setBounds(445, 69, 75, 23);
		panelDePagos.add(rdbCedula);
		JRadioButton rdbnombre = new JRadioButton("Nombre");
		rdbnombre.setBounds(522, 69, 71, 23);
		panelDePagos.add(rdbnombre);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbCedula);
		
		grupo.add(rdbnombre);
		
		
		txtIDCLiente = new JTextField();
		txtIDCLiente.setEnabled(false);
		txtIDCLiente.setEditable(false);
		txtIDCLiente.setSelectionColor(SystemColor.scrollbar);
		txtIDCLiente.setHorizontalAlignment(SwingConstants.CENTER);
		txtIDCLiente.setForeground(Color.BLACK);
		txtIDCLiente.setFont(new Font("Serif", Font.PLAIN, 15));
		txtIDCLiente.setColumns(10);
		txtIDCLiente.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtIDCLiente.setBackground(Color.WHITE);
		txtIDCLiente.setBounds(113, 130, 174, 20);
		panelDePagos.add(txtIDCLiente);
		
		btnBucar = new JButton("Bucar");
		
		btnBucar.setForeground(new Color(102, 51, 204));
		btnBucar.setFont(new Font("Serif", Font.PLAIN, 13));
		btnBucar.setBorder(UIManager.getBorder("RadioButton.border"));
		btnBucar.setBounds(599, 42, 64, 20);
		panelDePagos.add(btnBucar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(204, 0, 51));
		btnSalir.setFont(new Font("Serif", Font.PLAIN, 13));
		btnSalir.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSalir.setBounds(592, 393, 71, 23);
		panelDePagos.add(btnSalir);
		
		panelSearchClient = new JPanel();
		panelSearchClient.setBackground(SystemColor.controlHighlight);
		panelSearchClient.setBorder(new LineBorder(new Color(102, 153, 153), 2, true));
		//panelSearchClient.setBounds(1029, 11, 311, 90);  // uncomment this to edit the pane..********************************
		mainDataPanel.add(panelSearchClient);
		panelSearchClient.setLayout(null);
		
		txtClientSearch = new JTextField();
		txtClientSearch.setBounds(10, 11, 180, 25);
		panelSearchClient.add(txtClientSearch);
		txtClientSearch.setColumns(10);
			
		
		lblNewLabel = new JLabel("Busqueda Por");
		lblNewLabel.setBounds(10, 49, 92, 22);
		panelSearchClient.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(102, 153, 153));
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 16));
		
		JRadioButton porCedula = new JRadioButton("Cedula");
		porCedula.setSelected(true);
		porCedula.setFont(new Font("Serif", Font.PLAIN, 12));
		porCedula.setForeground(new Color(102, 153, 153));
		porCedula.setBounds(118, 51, 72, 23);
		panelSearchClient.add(porCedula);
		
		JRadioButton porIDCliente = new JRadioButton("ID Cliente");
		porIDCliente.setFont(new Font("Serif", Font.PLAIN, 12));
		porIDCliente.setForeground(new Color(102, 153, 153));
		porIDCliente.setBounds(200, 51, 101, 23);
		panelSearchClient.add(porIDCliente);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(porCedula);
		buttonGroup.add(porIDCliente);
		
		btnSearchClients = new JButton("Search");
		btnSearchClients.setForeground(new Color(102, 153, 153));
		btnSearchClients.setBorder(new LineBorder(new Color(102, 153, 153), 2, true));
		btnSearchClients.setBounds(200, 11, 101, 25);
		panelSearchClient.add(btnSearchClients);
		
		
		panelMensaje = new JPanel();
		panelMensaje.setBackground(Color.DARK_GRAY);
		panelMensaje.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 51), new Color(51, 51, 51)));
		panelMensaje.setBounds(0, 0, 1350, 119); // uncomment this to edit
		mainDataPanel.add(panelMensaje);
		panelMensaje.setLayout(null);
		
		
		JLabel fondoPrestamos = new JLabel("");
		fondoPrestamos.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\Educativos.jpg"));
		fondoPrestamos.setBounds(0, 0, 1350, 668);
		mainDataPanel.add(fondoPrestamos);
		
		
		
		
		lableMensaje = new JLabel("Gestion De Prestamos");
		lableMensaje.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 51, 51), new Color(51, 51, 51)));
		lableMensaje.setBounds(10, 24, 1330, 67);
		panelMensaje.add(lableMensaje);
		lableMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lableMensaje.setForeground(Color.WHITE);
		lableMensaje.setFont(new Font("Serif", Font.ITALIC, 38));
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 35);
		panel.add(menuBar);
		
		mnMenu = new JMenu("Menu");
		
		mnMenu.setForeground(new Color(51, 153, 153));
		mnMenu.setFont(new Font("Serif", Font.ITALIC, 20));
		menuBar.add(mnMenu);
		
		JMenu mnEditar = new JMenu("Edicion");
		mnEditar.setForeground(new Color(51, 153, 153));
		mnEditar.setFont(new Font("Serif", Font.ITALIC, 20));
		menuBar.add(mnEditar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setForeground(new Color(51, 153, 153));
		mnAyuda.setFont(new Font("Serif", Font.ITALIC, 20));
		menuBar.add(mnAyuda);
		
		loadImages();
		
		mainInternalFrame.setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		
	}
	
	
	private class EventosBotonClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == btnCancelar) {
				resetFields();
				 
				 labelError.setText("");	 
				 imageLabel.setVisible(true);	 
				 mainDataPanel.setVisible(false);
				 menuInternalFrame.setVisible(false);
				
			}else if(e.getSource() == btnEnviar) {
				
				sendData();
			}else if(e.getSource() == btnPersonaP) {
				lableMensaje.setText("Administracion de Prestamos Personales");
				procesarPrestamos();
				tipoP = 1;
				
			}else if(e.getSource() == btnEducativoP) {
				lableMensaje.setText("Administracion De Prestamos Educativos");
				procesarPrestamos();
				tipoP = 2;
			}else if(e.getSource() == btnHipotecarioP) {
				lableMensaje.setText("Administracion De Prestamos Hipotecarios");
				procesarPrestamos();
				tipoP = 3;
			}else if(e.getSource() == btnSalidCuenta) {
				
				int answer = JOptionPane.showConfirmDialog(null, "Desea Salir De Su Cuenta ?", "Confirmar", JOptionPane.YES_NO_OPTION);
				
				if(answer == 0) {
					new Vista_Login(controller);
					dispose();
				}
				
			}else if(e.getSource() == btnRecibirPago) {
				
				  mainInternalFrame.getContentPane().remove(imageLabel2);
				  currentUser.setText("Empleado: Maquendi Beltran");
				  menuInternalFrame.setVisible(false);
				  imageLabel.setVisible(false);
				  panelSolicitudes.setVisible(false);	 
				  lableMensaje.setBounds(10, 24, 1330, 67);
				  panelDePagos.setBounds(302, 160, 754, 426); 
				  panelMensaje.setBounds(0, 0, 1350, 119);
				 
				  panelSearchClient.setVisible(true);
				  mainDataPanel.setVisible(true);
				  panelDePagos.setVisible(true);
		          
			}else if(e.getSource() ==btnEditCuenta) {
				
				new Vista_Modificador("btnEditCuenta",controller);
				
			}else if(e.getSource() == btnSaldarUnPrestamo) {
				
				new Vista_Modificador("btnSaldarUnPrestamo",controller);
				
			}else if(e.getSource() == btnEditSolicitud) {
				
				new Vista_Modificador("btnEditSolicitud",controller);
				
			}else if(e.getSource() == bntVerStadoSolicitud) {
				
				new Vista_Modificador("bntVerStadoSolicitud",controller);
			}
			else if (e.getSource()== btnBucar) {
			
				
			}
			
		
		}
		
	}
		
	
	 private void  BuscarL()
	 {
		 
	 }
	private void loadImages() {
		
		imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\welcome3.png"));
		imageLabel.setBounds(2, -10, 1349, 650);
		imageLabel2 = new JLabel("");
		imageLabel2.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\welcomeCropped.png"));
		imageLabel2.setBounds(210, -12, 1139, 640);
		
	}

		
	
	
	
	private void procesarPrestamos() {
		mainInternalFrame.getContentPane().remove(imageLabel2);
		menuInternalFrame.setVisible(false);
		imageLabel.setVisible(false);
		panelDePagos.setVisible(false);
		panelSearchClient.setVisible(false);
		mainDataPanel.setVisible(true);
		panelMensaje.setBounds(515, 52, 812, 96);
		lableMensaje.setBounds(39, 18, 744, 67);
		panelSolicitudes.setBounds(515, 159, 812, 466);
		panelSolicitudes.setVisible(true);
	}
	

	private class EventosMouse extends MouseAdapter{
		
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == mnMenu) {
				
				
				mainInternalFrame.getContentPane().add(imageLabel2);
				imageLabel2.setVisible(true);
				menuInternalFrame.setBounds(3, -5, 365, 610);
				menuInternalFrame.setVisible(true);
				
			}else if(e.getSource() == imageLabel2) {
				
				menuInternalFrame.setVisible(false);	    
			    imageLabel.setVisible(true);
			    mainInternalFrame.getContentPane().remove(imageLabel2);
			    imageLabel2.setVisible(false);
			   
			}else if(e.getSource() == imageLabel) {
				menuInternalFrame.setVisible(false);
			}
			
			
		}
		
	}
	
	
	
	private void cancelInternalFrameMotion(JInternalFrame jif) {
		
		BasicInternalFrameUI obj = ((BasicInternalFrameUI)jif.getUI());
		for(MouseListener listener: obj.getNorthPane().getMouseListeners()) {
			obj.getNorthPane().removeMouseListener(listener);
		}	
		
		obj.setNorthPane(null);
	}
}
