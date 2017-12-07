package com.sistemaDePrestamo.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import com.sistemaprestamo.controller.Controller;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;








public class Principal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JLabel imageLabel;
	private JPanel panel_bienvenido;
	private JPanel panel_1;
	private JSeparator separator;
	private JMenuItem mntmNuevoPrestamo;
	private JInternalFrame menuFrame;
	private JPanel panel;
	private JLabel labelPPersonal;
	private JMenu mnHelp;
	private JTextField nameF;
	private JTextField apellidoF;
	private JTextField cedF;
	private JTextField emailF;
	private JTextField telF;
	private JTextField ciudadaniaF;
	private JTextField calleF;
	private JTextField txtsueldo;
	private JDateChooser dateChooser;
	private JButton btnSubmit;
	private JButton btnCancel;
	private JLabel labelError;
	private JTextField ciudadF;
	private JTextField txtmonto;
	private JTextField txtempresa;
	private JTextField txtnsolicitud;
	private JLabel label_error2;
	private JInternalFrame dataEntryFrame;
	private JComboBox cbplazo;
	private JComboBox cbtipoPrestamo;
	
	
	
	
	
	
	  public Principal() {
	  	 
		 initiate();	
		 handleEvents();
		}
	  
	  
	  
	  
	  private void resetFields(){
		  
		  nameF.setText("");
		  apellidoF.setText("");
		  cedF.setText("");
		  ciudadaniaF.setText("");
		  emailF.setText("");
		  txtsueldo.setText("");
		  calleF.setText("");
		  dateChooser.setDate(null);
		  telF.setText("");
	  }
	  
	  
	  
	  private boolean validateEntry() {
		    
	    boolean valid = true;
	    
		if(nameF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,209);
		}
		
		if(apellidoF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,240);
		}
		
		if(cedF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,271);
		}
		
		if(emailF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,307);
		}
		
		if(telF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,333);
		}
		
		if(dateChooser.getDate()== null) {
			valid = false;
			label_error2.setLocation(287,364);
		}
		
		if(ciudadaniaF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(287,395);
		}
		
		
		if(calleF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(114,430);
		}
		
		
		
		//114, 461
		
		if(ciudadF.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(114,461);
		}
		
		//412,207
		
		if(cbplazo.getSelectedItem() == null) {
			valid = false;
			label_error2.setLocation(412,207);
			
		}
		
		//412,243
		
		if(cbtipoPrestamo.getSelectedItem()== null) {
			valid = false;
			label_error2.setLocation(412,243);
		}
		
		
		//412,278
		
		if(txtempresa.getText().isEmpty()) {
			valid = false;
			label_error2.setLocation(412,278);
		}
		
		if(txtsueldo.getText().isEmpty()) {
			valid = false;	
			label_error2.setLocation(412,314);
		}
	
		if(txtmonto.getText().isEmpty()) {
			valid = false;	
			label_error2.setLocation(412,349);
		}
		
		if(valid == false) {
			labelError.setText("*Campos Obligatorios*");
			label_error2.setText("*");
			
		}else {
			labelError.setText("");
			label_error2.setText("");
		}
		
		return valid;
	  }
	  
	  
	  
	  
	  
	  private void sendData() {
		  
		  String name = nameF.getText() + " " + apellidoF.getText();
		  String addr = calleF.getText() + " "+ txtsueldo.getText();
		  
		  if(validateEntry()) {
			 // Controller.receiveData(name,ciudadaniaF.getText() ,cedF.getText(), emailF.getText(), telF.getText(), dateChooser.getCalendar(), addr);
			  resetFields();
		  }
	
	  }
	  
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  private void handleEvents() {
		    
		  getContentPane().addComponentListener(new ComponentAdapter() {
				
				@Override
				public void componentResized(ComponentEvent e) {
					Component c = (Component)e.getSource();
					
					int difWidth = c.getWidth() - 1277;
					int difHeight = c.getHeight() - 668;
					
				    if(difWidth > 0 && difHeight > 0 || difWidth < 89 && difHeight < 14) {
				    	
				       panel_1.setSize(new Dimension(1277 + difWidth,670 + difHeight));
				       tabbedPane.setSize(1225+difWidth, 631+difHeight);
				       panel_bienvenido.setSize(1225+difWidth, 631+difHeight);
				       imageLabel.setSize(1220+difWidth, 603+difHeight);
				       separator.setSize(1344+difWidth, 5);
				    	
				    }else if(difWidth < 0 && difHeight < 0) {
				    	
				    	panel_1.setSize(new Dimension(1277+difWidth,670+difHeight));
					    tabbedPane.setSize(1225+difWidth, 631+difHeight);
					    panel_bienvenido.setSize(1225+difWidth, 631+difHeight);
					    imageLabel.setSize(1220+difWidth, 603+difHeight);
					    separator.setSize(1344+difWidth, 5);
				    }
								
				}

			});
		  
		//****************************************************************************************************************************  
		  
		  
		  mntmNuevoPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				
					
					if(tabbedPane.getTitleAt(0).equals("Bienvenido  ")) {
					  tabbedPane.remove(0);
					  menuFrame.setVisible(false);
					} 
				}
			});
			
		  
				
		  
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					menuFrame.setVisible(false);
				}
			});
			
			
			
			labelPPersonal.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.out.println("You chose Prestamos Personales");
				}
			});
			
			

			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sendData();
				}
			});
			
			
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetFields();
				}
			});
			
		  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  private void initiate() {
		  setForeground(Color.WHITE);
		  
		  setDefaultLookAndFeelDecorated(true);
		  setExtendedState(MAXIMIZED_BOTH);
		  
		  setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Finance_loan_money_1889199 (1).ico"));
			setTitle("~LOAN MANAGEMENT SYSTEM~  ( LMS )");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			setBounds(50, 15, 1291, 744);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			setJMenuBar(menuBar);
			
			JMenu mnFile = new JMenu("Archivo");
			menuBar.add(mnFile);
			
			mntmNuevoPrestamo = new JMenuItem("New Loan");
			
			
			
			mnFile.add(mntmNuevoPrestamo);
			
			JMenu mnEdit = new JMenu("Editar");
			menuBar.add(mnEdit);
			
			JMenu mnOpen = new JMenu("Open");
			menuBar.add(mnOpen);
			
			JMenu mnCase = new JMenu("Solicitar");
			menuBar.add(mnCase);
			
			JMenu mnSource = new JMenu("Source");
			menuBar.add(mnSource);
			
			JMenu mnNavigate = new JMenu("Navigate");
			menuBar.add(mnNavigate);
			
			JMenu mnSearch = new JMenu("Search");
			menuBar.add(mnSearch);
			
			JMenu mnProject = new JMenu("Project");
			menuBar.add(mnProject);
			
			JMenu mnRun = new JMenu("Run");
			menuBar.add(mnRun);
			
			JMenu mnWindow = new JMenu("Window");
			menuBar.add(mnWindow);
			
			mnHelp = new JMenu("Help");
			
			
			
			
			menuBar.add(mnHelp);
			
			
			
			
			
			contentPane = new JPanel();
			contentPane.setBackground(new Color(0, 102, 0));

			contentPane.setBorder(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
	
			separator = new JSeparator();
			separator.setBounds(10, 0, 1344, 2);
			contentPane.add(separator);
			
			panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBounds(0, 0, 1354, 684);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			tabbedPane.setForeground(new Color(51, 153, 153));
			tabbedPane.setBackground(Color.PINK);
			tabbedPane.setBounds(25, 11, 1319, 631);
			panel_1.add(tabbedPane);
			
			panel_bienvenido = new JPanel();
			panel_bienvenido.setBorder(null);
			//tabbedPane.addTab("Bienvenido  ", null, panel_bienvenido, null);
			panel_bienvenido.setLayout(null);
			imageLabel = new JLabel("");
			imageLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\welcome.png"));
			imageLabel.setBounds(226, 0, 1076, 603);
			panel_bienvenido.add(imageLabel);
			
			
			panel = new JPanel();
			
		
			
			panel.setBorder(null);
			
			tabbedPane.addTab("Prestamos Personales", null, panel, null);
			
			panel.setLayout(null);
			
			menuFrame = new JInternalFrame("");
			menuFrame.setBounds(0, 0, 216, 626);
			
			//panel.add(menuFrame);
			
			panel_bienvenido.add(menuFrame);
			
			
			
			menuFrame.getContentPane().setForeground(new Color(255, 255, 255));
			menuFrame.setBackground(new Color(255, 255, 255));
			menuFrame.setForeground(new Color(255, 255, 255));
			menuFrame.setFrameIcon(null);
			menuFrame.setBorder(null);
			menuFrame.getContentPane().setBackground(new Color(153, 153, 153));
			menuFrame.getContentPane().setLayout(null);
			
			JLabel lblPrestamosEducativos = new JLabel("Prestamos Educativos");
			lblPrestamosEducativos.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\cliente.png"));
			lblPrestamosEducativos.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblPrestamosEducativos.setBounds(10, 64, 187, 23);
			menuFrame.getContentPane().add(lblPrestamosEducativos);
			
			JLabel lblPrestamosHipotecarios = new JLabel("Prestamos Hipotecarios");
			lblPrestamosHipotecarios.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\cliente.png"));
			lblPrestamosHipotecarios.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblPrestamosHipotecarios.setBounds(10, 116, 187, 23);
			menuFrame.getContentPane().add(lblPrestamosHipotecarios);
			
			labelPPersonal = new JLabel("Prestamos Personales");
			
			
			
			
			
			
			
			
			labelPPersonal.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\cliente.png"));
			labelPPersonal.setFont(new Font("Verdana", Font.PLAIN, 14));
			labelPPersonal.setBounds(10, 11, 187, 23);
			menuFrame.getContentPane().add(labelPPersonal);
			
			JLabel label = new JLabel("Prestamos Hipotecarios");
			label.setFont(new Font("Verdana", Font.PLAIN, 14));
			label.setBounds(23, 175, 174, 23);
			menuFrame.getContentPane().add(label);
			
			JLabel label_1 = new JLabel("Prestamos Hipotecarios");
			label_1.setFont(new Font("Verdana", Font.PLAIN, 14));
			label_1.setBounds(10, 224, 187, 23);
			menuFrame.getContentPane().add(label_1);
			
			JLabel label_2 = new JLabel("Prestamos Hipotecarios");
			label_2.setFont(new Font("Verdana", Font.PLAIN, 14));
			label_2.setBounds(10, 290, 187, 23);
			menuFrame.getContentPane().add(label_2);
			
			JLabel label_3 = new JLabel("Prestamos Hipotecarios");
			label_3.setFont(new Font("Verdana", Font.PLAIN, 14));
			label_3.setBounds(10, 341, 187, 23);
			menuFrame.getContentPane().add(label_3);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(new Color(0, 153, 153));
			separator_1.setBounds(10, 45, 187, 2);
			menuFrame.getContentPane().add(separator_1);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setForeground(new Color(0, 153, 153));
			separator_2.setBounds(10, 103, 187, 2);
			menuFrame.getContentPane().add(separator_2);
			
			JSeparator separator_3 = new JSeparator();
			separator_3.setForeground(new Color(0, 153, 153));
			separator_3.setBounds(10, 150, 187, 2);
			menuFrame.getContentPane().add(separator_3);
			
			JSeparator separator_4 = new JSeparator();
			separator_4.setForeground(new Color(0, 153, 153));
			separator_4.setBounds(10, 209, 187, 2);
			menuFrame.getContentPane().add(separator_4);
			
			JSeparator separator_5 = new JSeparator();
			separator_5.setForeground(new Color(0, 153, 153));
			separator_5.setBounds(10, 268, 187, 2);
			menuFrame.getContentPane().add(separator_5);
			
			JLabel lblMenu = new JLabel("Menu");
			lblMenu.setFont(new Font("Verdana", Font.ITALIC, 25));
			lblMenu.setForeground(new Color(102, 153, 153));
			lblMenu.setBounds(0, 25, 232, 25);
			panel_bienvenido.add(lblMenu);
			
		    dataEntryFrame = new JInternalFrame("");
			dataEntryFrame.setFrameIcon(null);
			dataEntryFrame.setBorder(null);
			dataEntryFrame.setBounds(213, 11, 1089, 565);
			panel.add(dataEntryFrame);
			dataEntryFrame.getContentPane().setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(51, 153, 153));
			panel_2.setBounds(0, -28, 1001, 95);
			dataEntryFrame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblGestionDePrestamos = new JLabel("GESTION DE PRESTAMOS \" PERSONALES\"");
			lblGestionDePrestamos.setBounds(63, 35, 780, 49);
			panel_2.add(lblGestionDePrestamos);
			lblGestionDePrestamos.setForeground(new Color(51, 51, 51));
			lblGestionDePrestamos.setBackground(new Color(51, 51, 204));
			lblGestionDePrestamos.setFont(new Font("Verdana", Font.ITALIC, 30));
			lblGestionDePrestamos.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel.setBounds(33, 204, 59, 24);
			dataEntryFrame.getContentPane().add(lblNewLabel);
			
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblApellido.setBounds(33, 240, 59, 24);
			dataEntryFrame.getContentPane().add(lblApellido);
			
			JLabel lblEmail = new JLabel("Cedula");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmail.setBounds(33, 275, 59, 24);
			dataEntryFrame.getContentPane().add(lblEmail);
			
			JLabel lblDireccion = new JLabel("Correo");
			lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDireccion.setBounds(33, 304, 49, 24);
			dataEntryFrame.getContentPane().add(lblDireccion);
			
			JLabel lblTelefono = new JLabel("telefono");
			lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblTelefono.setBounds(33, 330, 59, 24);
			dataEntryFrame.getContentPane().add(lblTelefono);
			
			JLabel lblFNacimiento = new JLabel("Nacimiento");
			lblFNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblFNacimiento.setBounds(33, 365, 73, 24);
			dataEntryFrame.getContentPane().add(lblFNacimiento);
			
			nameF = new JTextField();
			nameF.setBounds(114, 209, 171, 20);
			dataEntryFrame.getContentPane().add(nameF);
			nameF.setColumns(10);
			
			apellidoF = new JTextField();
			apellidoF.setColumns(10);
			apellidoF.setBounds(114, 240, 171, 20);
			dataEntryFrame.getContentPane().add(apellidoF);
			
			cedF = new JTextField();
			cedF.setColumns(10);
			cedF.setBounds(114, 271, 171, 20);
			dataEntryFrame.getContentPane().add(cedF);
			
			emailF = new JTextField();
			emailF.setColumns(10);
			emailF.setBounds(114, 302, 171, 20);
			dataEntryFrame.getContentPane().add(emailF);
			
			ciudadaniaF = new JTextField();
			ciudadaniaF.setColumns(10);
			ciudadaniaF.setBounds(114, 395, 171, 20);
			dataEntryFrame.getContentPane().add(ciudadaniaF);
			
			dateChooser = new JDateChooser();
			dateChooser.setBounds(114, 364, 171, 20);
			dataEntryFrame.getContentPane().add(dateChooser);
			
			
			
			
			
			
			JLabel lblCiudadania = new JLabel("Ciudadania");
			lblCiudadania.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCiudadania.setBounds(33, 392, 73, 24);
			dataEntryFrame.getContentPane().add(lblCiudadania);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(51, 153, 153));
			panel_3.setBounds(0, 93, 494, 44);
			dataEntryFrame.getContentPane().add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblDatosDelSolicitante = new JLabel("DATOS DEL SOLICITANTE");
			lblDatosDelSolicitante.setHorizontalAlignment(SwingConstants.CENTER);
			lblDatosDelSolicitante.setVerticalAlignment(SwingConstants.TOP);
			lblDatosDelSolicitante.setFont(new Font("Verdana", Font.ITALIC, 18));
			lblDatosDelSolicitante.setBounds(28, 11, 466, 22);
			panel_3.add(lblDatosDelSolicitante);
			
			telF = new JTextField();
			telF.setColumns(10);
			telF.setBounds(114, 333, 171, 20);
			dataEntryFrame.getContentPane().add(telF);
			
			JLabel lblDirecciones = new JLabel("Calle");
			lblDirecciones.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDirecciones.setBounds(33, 427, 39, 24);
			dataEntryFrame.getContentPane().add(lblDirecciones);
			
			calleF = new JTextField();
			calleF.setColumns(10);
			calleF.setBounds(114, 430, 171, 20);
			dataEntryFrame.getContentPane().add(calleF);
			
			txtsueldo = new JTextField();
			txtsueldo.setColumns(10);
			txtsueldo.setBounds(412, 314, 115, 20);
			dataEntryFrame.getContentPane().add(txtsueldo);
			
			JLabel lblCiudad = new JLabel("ciudad");
			lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblCiudad.setBounds(33, 458, 59, 24);
			dataEntryFrame.getContentPane().add(lblCiudad);
			
			
			
			btnCancel = new JButton("Cancel");
			
			
		
			
			
			
			
			
			btnCancel.setBorder(UIManager.getBorder("RadioButton.border"));
			btnCancel.setForeground(new Color(255, 51, 51));
			btnCancel.setBounds(899, 504, 89, 23);
			dataEntryFrame.getContentPane().add(btnCancel);
			
			btnSubmit = new JButton("Submit");
			
			
			
			
			
			
			
			btnSubmit.setForeground(new Color(102, 153, 153));
			btnSubmit.setBorder(UIManager.getBorder("RadioButton.border"));
			btnSubmit.setBounds(800, 504, 89, 23);
			dataEntryFrame.getContentPane().add(btnSubmit);
			
			labelError = new JLabel("");
			labelError.setForeground(new Color(204, 0, 0));
			labelError.setBounds(33, 158, 159, 14);
			dataEntryFrame.getContentPane().add(labelError);
			
			JLabel lblPlazo = new JLabel("Plazo");
			lblPlazo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblPlazo.setBounds(343, 204, 59, 24);
			dataEntryFrame.getContentPane().add(lblPlazo);
			
			JLabel lblprestamo = new JLabel("sueldo");
			lblprestamo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblprestamo.setBounds(343, 311, 59, 24);
			dataEntryFrame.getContentPane().add(lblprestamo);
			
		    cbtipoPrestamo = new JComboBox();
			cbtipoPrestamo.setBounds(412, 243, 115, 20);
			dataEntryFrame.getContentPane().add(cbtipoPrestamo);
			
			cbplazo = new JComboBox();
			cbplazo.setBounds(412, 207, 118, 20);
			dataEntryFrame.getContentPane().add(cbplazo);
			
			JLabel lblSexo = new JLabel("sexo");
			lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblSexo.setBounds(43, 502, 42, 24);
			dataEntryFrame.getContentPane().add(lblSexo);
			
			JRadioButton rbmujer = new JRadioButton("Mujer");
			rbmujer.setBounds(114, 504, 73, 23);
			dataEntryFrame.getContentPane().add(rbmujer);
			
			
			
			
			JRadioButton rdhombre = new JRadioButton("Hombre");
			rdhombre.setBounds(201, 504, 73, 23);
			dataEntryFrame.getContentPane().add(rdhombre);
			
				ButtonGroup jb = new ButtonGroup();
				jb.add(rbmujer);
				jb.add(rdhombre);
			
			
			
			
			JLabel lblMeses = new JLabel("Meses ");
			lblMeses.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMeses.setBounds(552, 204, 49, 24);
			dataEntryFrame.getContentPane().add(lblMeses);
			
			ciudadF = new JTextField();
			ciudadF.setColumns(10);
			ciudadF.setBounds(114, 461, 171, 20);
			dataEntryFrame.getContentPane().add(ciudadF);
			
			JLabel label_5 = new JLabel("Prestamo");
			label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
			label_5.setBounds(343, 240, 59, 24);
			dataEntryFrame.getContentPane().add(label_5);
			
			JLabel lblMonto = new JLabel("monto");
			lblMonto.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMonto.setBounds(343, 346, 59, 24);
			dataEntryFrame.getContentPane().add(lblMonto);
			
			txtmonto = new JTextField();
			txtmonto.setColumns(10);
			txtmonto.setBounds(412, 349, 115, 20);
			dataEntryFrame.getContentPane().add(txtmonto);
			
			JLabel lblEmpresa = new JLabel("Empresa");
			lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblEmpresa.setBounds(343, 281, 59, 24);
			dataEntryFrame.getContentPane().add(lblEmpresa);
			
			txtempresa = new JTextField();
			txtempresa.setColumns(10);
			txtempresa.setBounds(412, 278, 115, 20);
			dataEntryFrame.getContentPane().add(txtempresa);
			
			txtnsolicitud = new JTextField();
			txtnsolicitud.setEditable(false);
			txtnsolicitud.setColumns(10);
			txtnsolicitud.setBounds(852, 93, 95, 20);
			dataEntryFrame.getContentPane().add(txtnsolicitud);
			
			JLabel lblNoSolicitud = new JLabel("No. Solicitud");
			lblNoSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNoSolicitud.setBounds(760, 90, 82, 24);
			dataEntryFrame.getContentPane().add(lblNoSolicitud);
			
			JSeparator separator_7 = new JSeparator();
			separator_7.setBounds(0, 148, 1029, 2);
			dataEntryFrame.getContentPane().add(separator_7);
			
			
			
			label_error2 = new JLabel("");
			label_error2.setForeground(Color.RED);
			label_error2.setBackground(Color.RED);
			label_error2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			label_error2.setBounds(284, 209, 23, 24);
			dataEntryFrame.getContentPane().add(label_error2);
			
			
			
			JSeparator separator_6 = new JSeparator();
			separator_6.setBorder(new LineBorder(new Color(102, 153, 204)));
			separator_6.setBounds(207, 11, 1, 620);
			panel.add(separator_6);
			
			JLabel label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\gray.jpg"));
			label_4.setBounds(0, 38, 208, 565);
			panel.add(label_4);
			
			
			dataEntryFrame.setVisible(true);
			menuFrame.setVisible(true);
			
			setVisible(true);
		   
	  }
	  
	  
}
		
	