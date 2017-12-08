package nueva_vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import com.sistemaprestamo.controller.Controller;
import com.sistemaprestamo.model.Contacto;
import com.sistemaprestamo.model.Direccion;
import com.sistemaprestamo.model.Modelo;
import com.sistemaprestamo.model.Modificable;
import com.sistemaprestamo.model.Observador;
import com.sistemaprestamo.model.Persona;
import com.sistemaprestamo.model.Solicitud;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;

public class Vista_Modificador extends JFrame implements Observador{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCedPanel;
	private JTextField textField_1;
	private JTextField txtApellidoPanel;
	private JTextField txtTelPanel;
	private JTextField txtEmailPanel;
	private JTextField txtDirPanel;
	private JTextField txtNamePanel;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPanel panel;
    private JButton btnSaveChanges;
    private String request;
    private JPanel panel_2;
    private JTextField txtBuscar;
    private JButton btnSearchCliente;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JTextField textField_12;
    private JTextField textField_13;
    private JInternalFrame internalFrame;
    private JRadioButton rdbtnIdCliente,rdbtnCedula;
    private JTextField txtName;
    private JTextField txtLastName;
    private JTextField txtPhoneNumber;
    private JTextField txtEmail;
    private JTextField txtStreet;
    private JTextField txtSector;
    private JTextField txtCity;
    private JTextField txtPlazoPrestamo;
    private JInternalFrame editSolicitudFrame;
    private JButton btnSaldar;
    private JLabel EditNameLabel;
    private JLabel editLastNameLabel;
    private JLabel editTelLabel;
    private JLabel editEmailLabel;
    private JLabel editDirLabel;
    private JTextField txtSalarioSolicitante;
    private JTextField txtMontoSolicitado;
    private JTextField txtNumSolicitud;
    private Controller controller;
    private JButton btnGuardarCambios;
    private JComboBox<String> plazoCombo;
    private Modelo modelo;
    private JTextField txtEstadoSolicitud;
    private JTextPane commentTextPane;
    
    


	public Vista_Modificador(String whatPane,Controller controlador) {
		controller = controlador;
		init(whatPane);
		handleEvents();
	}
	
	
	
	/*
	 * EditNameLabel;
    private JLabel editLastNameLabel;
    private JLabel editTelLabel;
    private JLabel editEmailLabel;
    private JLabel editDirLabel;
	 */
	
	
	private void handleEvents() {
		
		btnSearchCliente.addActionListener(new EventosBotonClick());
		btnSaveChanges.addActionListener(new EventosBotonClick());
		btnSaldar.addActionListener(new EventosBotonClick());
		btnGuardarCambios.addActionListener(new EventosBotonClick());
		editLastNameLabel.addMouseListener(new MouseClick());
		editTelLabel.addMouseListener(new MouseClick());
		editEmailLabel.addMouseListener(new MouseClick());
		editDirLabel.addMouseListener(new MouseClick());
		EditNameLabel.addMouseListener(new MouseClick());
		
		
		txtBuscar.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					if(getTitle().equals("Edicion de Solicitud"))
						procesar();
				}
				
			}
			
			
			
		});
		
		
		
	}
	
	
	
	
	private class EventosBotonClick implements ActionListener{

		
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			
			
			if(e.getSource() == btnSearchCliente) {
				
			  if(getTitle().equals("Amortizacion de Deuda")) {

				  if(txtBuscar.getText().equals("admin")) {
					  
				      btnSaldar.setBounds(515, 290, 89, 23);
				      internalFrame.setBounds(5, 92, 623, 318);
				  }
				  
			  }else if(getTitle().equals("Edicion de Solicitud")) {
				  
				  if ( txtBuscar.getText().isEmpty()) {
					  JOptionPane.showMessageDialog(null, "The Search Field has no value");
					  txtBuscar.grabFocus();
				  }
				  else {
					  procesar();
				  }
				   
				    
				    
			}else if(getTitle().equals("Estado de Solicitud")) {
				
		           procesar();
				   internalFrame.setVisible(false);
			   }
				
		     }else if(e.getSource() ==btnSaldar){
			           System.out.println("You clicked on saldar");
			  
		        }else if(e.getSource() == btnGuardarCambios) {
			       if(getTitle().equals("Edicion de Solicitud")) {
				       if(validateEntry()) {
					 
					            modelo.getPerson().setNombre_Persona(txtName.getText());
					            modelo.getPerson().setApellido(txtLastName.getText());
					            modelo.getPerson().setDireccion(new Direccion(txtStreet.getText(),txtSector.getText(),txtCity.getText()));
					            modelo.getPerson().setContacto(new Contacto(txtEmail.getText(),txtPhoneNumber.getText()));
					            double salario = Double.parseDouble(txtSalarioSolicitante.getText());
					            modelo.getPerson().getEmpleo().setSalario(salario);
					            double monto = Double.parseDouble(txtMontoSolicitado.getText());
					            modelo.getSolicitud().setMonto_solicitado(monto);
					            String pla = (String)plazoCombo.getSelectedItem();
					            modelo.getSolicitud().setPlazo_en_meses(Integer.parseInt(pla.substring(0,2)));
					            modelo.getSolicitud().setEstatus("Pendiente");
					            controller.updateSolicitud(modelo);
					            clearTextFields();
				               }
				  
			              }else if(e.getSource() == btnSaveChanges){  System.out.println("Clicked on bntSaveChanges");
			          }		  
		        
			    }
		}
		
}
	
	
	
	
	

	@SuppressWarnings("unused")
	private void procesar() {
        modelo = null;
		String cedula = txtBuscar.getText().trim();
		modelo = controller.getSolicitud(cedula);

	  if(modelo != null) {
		 
		internalFrame.setVisible(false);
		txtName.setText(modelo.getPerson().getNombre_Persona());
		txtLastName.setText(modelo.getPerson().getApellido());
		txtEmail.setText(modelo.getPerson().getContacto().getEmail());
		txtPhoneNumber.setText(modelo.getPerson().getContacto().getTelefono());
		txtStreet.setText(modelo.getPerson().getDireccion().getCalle());
		txtSector.setText(modelo.getPerson().getDireccion().getSector());
		txtCity.setText(modelo.getPerson().getDireccion().getCiudad());
		txtSalarioSolicitante.setText(""+modelo.getPerson().getEmpleo().getSalario());
		DecimalFormat round = new DecimalFormat("#.00");
	    txtMontoSolicitado.setText(round.format(modelo.getSolicitud().getMonto_solicitado()));
		String plazo = modelo.getSolicitud().getPlazo_en_meses() + " meses";
		plazoCombo.setSelectedItem(plazo);
		txtNumSolicitud.setText(modelo.getSolicitud().getNum_solicitud() + "");
		txtEstadoSolicitud.setText(modelo.getSolicitud().getEstatus());
	    commentTextPane.setText(modelo.getSolicitud().getRazonDeclinacion());

		editSolicitudFrame.setBounds(5, 79, 842, 385);
	 }else {
		 JOptionPane.showMessageDialog(null, "Esta Cedula No Tiene Ninguna Solicitud Registrada !");
	 }

 }
	
	
	
	
	

	private void clearTextFields() {
		
		this.txtBuscar.setText("");
		this.txtLastName.setText("");
		this.txtEmail.setText("");
		this.txtCity.setText("");
		this.txtName.setText("");
		this.txtMontoSolicitado.setText("");
		this.txtNumSolicitud.setText("");
		this.txtStreet.setText("");
		this.txtPlazoPrestamo.setText("");
		this.txtSector.setText("");
		this.txtSalarioSolicitante.setText("");
		this.plazoCombo.setSelectedItem(null);
		this.txtPhoneNumber.setText("");
	}
	
	
	  private boolean validateEntry(){
		  
		  boolean valid = true;
		  if(txtName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtEmail.getText().isEmpty() ||
				  txtStreet.getText().isEmpty() || txtCity.getText().isEmpty() || txtSalarioSolicitante.getText().isEmpty()
				  || txtMontoSolicitado.getText().isEmpty() || txtPhoneNumber.getText().isEmpty() ||
				    txtSector.getText().isEmpty()) {
			  JOptionPane.showMessageDialog(null, "Todos Los Campos Son Requeridos !");
			  valid = false;
		  }
		  
		  
		  int counter = 0;
		  
		  String monto = txtMontoSolicitado.getText();
		  String salario = txtSalarioSolicitante.getText();
		  
		  for(int i=0;i<monto.length();i++) {
			  if(monto.charAt(i) == '.') {
				  counter++;
				  if(counter == 2) {
					  valid = false;
					  JOptionPane.showConfirmDialog(null, "Formato Incorrecto Para Monto Solicitud", "Wrong Number Format",
							  JOptionPane.OK_OPTION);
					  break;
				  }
			  }
			  if(!Character.isDigit(monto.charAt(i)) && monto.charAt(i) != '.') {
				  valid = false;
				  JOptionPane.showConfirmDialog(null, "Formato Incorrecto Para Monto Solicitud", "Wrong Number Format",
						  JOptionPane.OK_OPTION);
				  break;
			  }
		  }
		  
		  counter = 0;
		  for(int i=0;i<salario.length();i++) {
			  if(salario.charAt(i) == '.') {
				  counter++;
				  if(counter == 2) {
					  valid = false;
					  
					  JOptionPane.showConfirmDialog(null, "Formato Incorrecto Para Salario", "Wrong Number Format",
							  JOptionPane.OK_OPTION);
					  break;
				  }  
			  }
			  if(!Character.isDigit(salario.charAt(i)) && salario.charAt(i) != '.') {
				  valid = false;
				  JOptionPane.showConfirmDialog(null, "Formato Incorrecto Para Salario", "Wrong Number Format",
						  JOptionPane.OK_OPTION);
				  break;
			  }
			  
		  }
		  
		  return valid;
	  }
	
	
	
	
	
	
	
	

	private class MouseClick extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			
			if(e.getSource()== EditNameLabel) {
				txtNamePanel.setEditable(true);
			}else if(e.getSource()==editLastNameLabel) {
				txtApellidoPanel.setEditable(true);
			}else if(e.getSource()==editTelLabel) {
				txtTelPanel.setEditable(true);
			}else if(e.getSource() ==  editEmailLabel) {
				txtEmailPanel.setEditable(true);
			}else if(e.getSource()== editDirLabel) {
				txtDirPanel.setEditable(true);
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private void init(String whatPane) {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if__67ui_2303172.png"));
		setTitle("Account Edition");
		
		this.request = whatPane;
		
	/*	
		
		try {
			
			for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
				
				if("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Errors found");
		}
		
		
		*/
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		//setBounds(100, 100, 649, 492);
		
		//setBounds(100, 100, 600, 470);
		
		
		
		setBounds(100, 100, 869, 551);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Editar Cuenta");
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Account_1891016.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenu mnRealizarTransacciones = new JMenu("Realizar Transacciones");
		mnRealizarTransacciones.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_Dialog-Apply-32_54904.png"));
		menuBar.add(mnRealizarTransacciones);
		
		JMenu mnNewMenu_1 = new JMenu("Saldar Prestamos");
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\if_icons-07_799759.png"));
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(153, 153, 153));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		
		//panel.setBounds(10, 11, 613, 397); // uncomment to edit this panel./
		contentPane.add(panel);  //uncomment to edit this panel
		
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 52, 25);
		panel.add(lblNewLabel);
		
		txtCedPanel = new JTextField();
		txtCedPanel.setBounds(62, 11, 164, 25);
		panel.add(txtCedPanel);
		txtCedPanel.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(236, 13, 75, 23);
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(353, 88, 250, 179);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID Cliente");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 27, 59, 27);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(88, 27, 138, 23);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDeuda = new JLabel("Deuda");
		lblDeuda.setForeground(Color.WHITE);
		lblDeuda.setBackground(Color.WHITE);
		lblDeuda.setBounds(10, 77, 59, 27);
		panel_1.add(lblDeuda);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(88, 77, 138, 23);
		panel_1.add(textField_7);
		
		JLabel lblNoPrestamo = new JLabel("No Prestamo");
		lblNoPrestamo.setForeground(Color.WHITE);
		lblNoPrestamo.setBackground(Color.WHITE);
		lblNoPrestamo.setBounds(10, 127, 68, 27);
		panel_1.add(lblNoPrestamo);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(88, 127, 138, 23);
		panel_1.add(textField_8);
		
		JLabel lblNombre = new JLabel("Apellido");
		lblNombre.setBounds(10, 126, 52, 27);
		panel.add(lblNombre);
		
		txtApellidoPanel = new JTextField();
		txtApellidoPanel.setEditable(false);
		txtApellidoPanel.setBorder(null);
		txtApellidoPanel.setBounds(62, 126, 164, 27);
		panel.add(txtApellidoPanel);
		txtApellidoPanel.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 164, 52, 27);
		panel.add(lblTelefono);
		
		txtTelPanel = new JTextField();
		txtTelPanel.setEditable(false);
		txtTelPanel.setBorder(null);
		txtTelPanel.setColumns(10);
		txtTelPanel.setBounds(62, 164, 164, 27);
		panel.add(txtTelPanel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 202, 52, 27);
		panel.add(lblEmail);
		
		txtEmailPanel = new JTextField();
		txtEmailPanel.setEditable(false);
		txtEmailPanel.setBorder(null);
		txtEmailPanel.setColumns(10);
		txtEmailPanel.setBounds(62, 202, 164, 27);
		panel.add(txtEmailPanel);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 240, 52, 27);
		panel.add(lblDireccion);
		
		txtDirPanel = new JTextField();
		txtDirPanel.setEditable(false);
		txtDirPanel.setBorder(null);
		txtDirPanel.setColumns(10);
		txtDirPanel.setBounds(62, 240, 164, 27);
		panel.add(txtDirPanel);
		
		JLabel label_3 = new JLabel("Nombre");
		label_3.setBounds(10, 88, 52, 27);
		panel.add(label_3);
		
		txtNamePanel = new JTextField();
		txtNamePanel.setEditable(false);
		txtNamePanel.setBorder(null);
		txtNamePanel.setColumns(10);
		txtNamePanel.setBounds(62, 88, 164, 27);
		panel.add(txtNamePanel);
		
		 EditNameLabel = new JLabel("");
		EditNameLabel.setBorder(new LineBorder(new Color(51, 51, 51), 1, true));
		EditNameLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		EditNameLabel.setBounds(229, 88, 39, 25);
		panel.add(EditNameLabel);
		
		editLastNameLabel = new JLabel("");
		editLastNameLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		editLastNameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		editLastNameLabel.setBounds(229, 126, 39, 27);
		panel.add(editLastNameLabel);
		
		editTelLabel = new JLabel("");
		editTelLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		editTelLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		editTelLabel.setBounds(229, 164, 39, 27);
		panel.add(editTelLabel);
		
		editEmailLabel = new JLabel("");
		editEmailLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		editEmailLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		editEmailLabel.setBounds(229, 202, 39, 27);
		panel.add(editEmailLabel);
		
		editDirLabel = new JLabel("");
		editDirLabel.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\editGood.png"));
		editDirLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		editDirLabel.setBounds(229, 240, 39, 27);
		panel.add(editDirLabel);
		
		btnSaveChanges = new JButton("Save");
		btnSaveChanges.setHorizontalAlignment(SwingConstants.LEFT);
		btnSaveChanges.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSaveChanges.setForeground(new Color(0, 51, 153));
		btnSaveChanges.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSaveChanges.setIcon(new ImageIcon("C:\\Users\\Maquendi\\workspace\\SistemaDePrestamo\\check.png"));
		btnSaveChanges.setBounds(453, 306, 101, 33);
		panel.add(btnSaveChanges);	
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_2.setBackground(new Color(204, 204, 255));  
		//panel_2.setBounds(0, 0, 633, 419); // uncomment this to edit
		
		panel_2.setBounds(0, 0, 853, 478);
		
		//panel_2.setBounds(10, 11, 564, 375);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(342, 11, 188, 31);
		panel_2.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnSearchCliente = new JButton("Search");
		btnSearchCliente.setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
		
		btnSearchCliente.setBounds(540, 13, 89, 27);
		panel_2.add(btnSearchCliente);
		
		rdbtnCedula = new JRadioButton("Cedula");
		rdbtnCedula.setBounds(342, 51, 89, 23);
		panel_2.add(rdbtnCedula);
		
		
		
		rdbtnIdCliente = new JRadioButton("ID Cliente");
		rdbtnIdCliente.setBounds(441, 51, 89, 23);
		panel_2.add(rdbtnIdCliente);
		
		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.getContentPane().setBackground(new Color(51, 153, 153));
		internalFrame.setBorder(null);
       // internalFrame.setBounds(10, 92, 544, 272);   // uncomment this to edi the pane
		panel_2.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		removeTitleBar(internalFrame);
		
		
		
		
		JLabel label_10 = new JLabel("Cliente");
		label_10.setFont(new Font("Serif", Font.PLAIN, 13));
		label_10.setBounds(10, 27, 54, 14);
		internalFrame.getContentPane().add(label_10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(74, 25, 137, 20);
		internalFrame.getContentPane().add(textField_9);
		
		JLabel label_11 = new JLabel("ID Cliente");
		label_11.setFont(new Font("Serif", Font.PLAIN, 13));
		label_11.setBounds(10, 59, 54, 14);
		internalFrame.getContentPane().add(label_11);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(74, 56, 137, 20);
		internalFrame.getContentPane().add(textField_10);
		
		JLabel label_12 = new JLabel("Cedula");
		label_12.setFont(new Font("Serif", Font.PLAIN, 13));
		label_12.setBounds(10, 84, 54, 14);
		internalFrame.getContentPane().add(label_12);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(74, 87, 137, 20);
		internalFrame.getContentPane().add(textField_11);
		
		JLabel label_13 = new JLabel("Deuda ");
		label_13.setFont(new Font("Serif", Font.PLAIN, 13));
		label_13.setBounds(10, 121, 54, 14);
		internalFrame.getContentPane().add(label_13);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(74, 118, 137, 20);
		internalFrame.getContentPane().add(textField_12);
		
		JLabel label_14 = new JLabel("Inicio");
		label_14.setFont(new Font("Serif", Font.PLAIN, 13));
		label_14.setBounds(10, 152, 54, 14);
		internalFrame.getContentPane().add(label_14);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(74, 149, 137, 20);
		internalFrame.getContentPane().add(textField_13);
		
		btnSaldar = new JButton("Saldar");
		btnSaldar.setBorder(UIManager.getBorder("RadioButton.border"));
		btnSaldar.setBounds(445, 222, 89, 23);
		internalFrame.getContentPane().add(btnSaldar);
		
		editSolicitudFrame = new JInternalFrame("");
		editSolicitudFrame.setBorder(null);
		
		//editSolicitudFrame.setBounds(0, 79, 853, 399); // uncomment this to edit the panel..**********************************
		
		removeTitleBar(editSolicitudFrame);
		
		panel_2.add(editSolicitudFrame);
		editSolicitudFrame.getContentPane().setLayout(null);
		
		JLabel lblSolicitante = new JLabel("Nombre");
		lblSolicitante.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSolicitante.setBounds(10, 11, 66, 21);
		editSolicitudFrame.getContentPane().add(lblSolicitante);
		
		txtName = new JTextField();
		txtName.setBounds(86, 12, 172, 20);
		editSolicitudFrame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(10, 63, 66, 21);
		editSolicitudFrame.getContentPane().add(lblApellido);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(86, 64, 172, 20);
		editSolicitudFrame.getContentPane().add(txtLastName);
		
		JLabel lblTelefono_1 = new JLabel("Telefono");
		lblTelefono_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefono_1.setBounds(10, 111, 66, 21);
		editSolicitudFrame.getContentPane().add(lblTelefono_1);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(86, 112, 172, 20);
		editSolicitudFrame.getContentPane().add(txtPhoneNumber);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCorreo.setBounds(10, 167, 66, 21);
		editSolicitudFrame.getContentPane().add(lblCorreo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(86, 168, 172, 20);
		editSolicitudFrame.getContentPane().add(txtEmail);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCalle.setBounds(10, 222, 66, 21);
		editSolicitudFrame.getContentPane().add(lblCalle);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(86, 223, 172, 20);
		editSolicitudFrame.getContentPane().add(txtStreet);
		
		JLabel lblSector = new JLabel("Sector");
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSector.setBounds(10, 271, 66, 21);
		editSolicitudFrame.getContentPane().add(lblSector);
		
		txtSector = new JTextField();
		txtSector.setBounds(86, 272, 172, 20);
		txtSector.setColumns(10);
		editSolicitudFrame.getContentPane().add(txtSector);
		
		
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCiudad.setBounds(10, 320, 66, 21);
		editSolicitudFrame.getContentPane().add(lblCiudad);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(86, 321, 172, 20);
		editSolicitudFrame.getContentPane().add(txtCity);
		
		JLabel lblPlazoPrestamo = new JLabel("Plazo Prestamo");
		lblPlazoPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPlazoPrestamo.setBounds(344, 111, 123, 21);
		editSolicitudFrame.getContentPane().add(lblPlazoPrestamo);
		
		txtPlazoPrestamo = new JTextField();
		txtPlazoPrestamo.setColumns(10);
		//txtPlazoPrestamo.setBounds(490, 112, 172, 20);
		//editSolicitudFrame.getContentPane().add(txtPlazoPrestamo);
		
		
		
		plazoCombo = new JComboBox<String>();
		plazoCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"12 meses","18 meses","30 meses","36 meses",
				"42 meses","48 meses","60 meses","72 meses"}));
		plazoCombo.setBounds(490, 112, 172, 20);
		editSolicitudFrame.getContentPane().add(plazoCombo);
		
		
		txtSalarioSolicitante = new JTextField();
		txtSalarioSolicitante.setColumns(10);
		txtSalarioSolicitante.setBounds(490, 12, 172, 20);
		editSolicitudFrame.getContentPane().add(txtSalarioSolicitante);
		
		JLabel lblMontoSolicitud = new JLabel("Salario Solicitante");
		lblMontoSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMontoSolicitud.setBounds(344, 11, 123, 21);
		editSolicitudFrame.getContentPane().add(lblMontoSolicitud);
		
		txtMontoSolicitado = new JTextField();
		txtMontoSolicitado.setColumns(10);
		txtMontoSolicitado.setBounds(490, 64, 172, 20);
		editSolicitudFrame.getContentPane().add(txtMontoSolicitado);
		
		JLabel lblMontoSolicitado = new JLabel("Monto Solicitado");
		lblMontoSolicitado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMontoSolicitado.setBounds(344, 63, 123, 21);
		editSolicitudFrame.getContentPane().add(lblMontoSolicitado);
		
		txtNumSolicitud = new JTextField();
		txtNumSolicitud.setEditable(false);
		txtNumSolicitud.setColumns(10);
		txtNumSolicitud.setBounds(490, 168, 172, 20);
		editSolicitudFrame.getContentPane().add(txtNumSolicitud);
		
		JLabel lblNoSolicitud = new JLabel("No Solicitud");
		lblNoSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNoSolicitud.setBounds(344, 167, 123, 21);
		editSolicitudFrame.getContentPane().add(lblNoSolicitud);
		
		btnGuardarCambios = new JButton("Guardar");
		btnGuardarCambios.setBorder(UIManager.getBorder("RadioButton.border"));
		btnGuardarCambios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardarCambios.setBounds(730, 353, 100, 30);
		
		editSolicitudFrame.getContentPane().add(btnGuardarCambios);
		
		JLabel lblEstadoSolicitud = new JLabel("Estado Solicitud");
		lblEstadoSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEstadoSolicitud.setBounds(344, 226, 123, 21);
		editSolicitudFrame.getContentPane().add(lblEstadoSolicitud);
		
		txtEstadoSolicitud = new JTextField();
		txtEstadoSolicitud.setEditable(false);
		txtEstadoSolicitud.setColumns(10);
		txtEstadoSolicitud.setBounds(490, 223, 172, 20);
		editSolicitudFrame.getContentPane().add(txtEstadoSolicitud);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(490, 271, 211, 75);
		editSolicitudFrame.getContentPane().add(scrollPane);
		
		commentTextPane = new JTextPane();
		commentTextPane.setBackground(SystemColor.menu);
		commentTextPane.setEditable(false);
		scrollPane.setViewportView(commentTextPane);
		
		JLabel lblComentario = new JLabel("Comentario");
		lblComentario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComentario.setBounds(344, 275, 123, 21);
		editSolicitudFrame.getContentPane().add(lblComentario);
		editSolicitudFrame.setVisible(true);
		internalFrame.setVisible(true);
		
		
		serve();
		setVisible(true);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void removeTitleBar(JInternalFrame jif) {
		BasicInternalFrameUI b = (BasicInternalFrameUI)jif.getUI();
		b.setNorthPane(null);
	}
	
	
	private void serve() {
		
		if(request.equals("btnEditCuenta")) {
			
			
			setBounds(100, 100, 649, 492);
			panel.setBounds(10, 11, 615, 397);
			contentPane.add(panel);
			
			
			
		}else if(request.equals("btnSaldarUnPrestamo")) {
			
			setTitle("Amortizacion de Deuda");
			setBounds(100, 100, 649, 492);
			panel_2.setBounds(0, 0, 633, 414);
			contentPane.add(panel_2);
			
			
			
		
			
			
			
		}else if(request.equals("btnEditSolicitud")) {
			
			setTitle("Edicion de Solicitud");
			setBounds(100, 100, 869, 551);
			panel_2.setBounds(0, 0, 853, 478);
			txtBuscar.setBounds(510, 11, 188, 31);
			btnSearchCliente.setBounds(708, 11, 89, 27);
			rdbtnCedula.setBounds(510, 49, 89, 23);
			rdbtnIdCliente.setBounds(609, 49, 95, 23);
			rdbtnIdCliente.setText("No. Solicitud");
			contentPane.add(panel_2);
		}else if(request.equals("bntVerStadoSolicitud")){
			
			setTitle("Estado de Solicitud");
			setBounds(100, 100, 869, 551);
			panel_2.setBounds(0, 0, 853, 478);
			txtBuscar.setBounds(510, 11, 188, 31);
			btnSearchCliente.setBounds(708, 11, 89, 27);
			rdbtnCedula.setBounds(510, 49, 89, 23);
			rdbtnIdCliente.setBounds(609, 49, 95, 23);
			rdbtnIdCliente.setText("No. Solicitud");
			contentPane.add(panel_2);
		}
		
		
	}



	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actualizar(Modificable obj) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actualizar(Modelo modelo) {
		// TODO Auto-generated method stub
		
	}
}
